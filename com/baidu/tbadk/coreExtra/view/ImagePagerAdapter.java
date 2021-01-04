package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private Map<String, ImageUrlData> fyO;
    private DragImageView.e fyS;
    private b fyT;
    private UrlDragImageView.b fyU;
    private DragImageView.d fyV;
    private boolean fzd;
    private boolean fze;
    private Context mContext;
    private ArrayList<String> fyP = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener fyQ = null;
    private DragImageView.g fyR = null;
    private int mGifMaxUseableMem = 0;
    private boolean fyX = false;
    private String fyY = null;
    private int fyZ = 0;
    private int fza = 0;
    private boolean fzb = false;
    private boolean fzc = false;
    private int mPosition = -1;
    private List<a> fyW = new ArrayList();

    /* loaded from: classes.dex */
    public interface a {
        View p(ViewGroup viewGroup, int i);
    }

    /* loaded from: classes.dex */
    public interface b {
        void g(int i, Object obj);
    }

    public ImagePagerAdapter(Context context, DragImageView.e eVar) {
        this.mContext = context;
        this.fyS = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.fyP = new ArrayList<>();
        } else {
            this.fyP = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.fyO = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.fyY = str;
    }

    public void setHasNext(boolean z) {
        this.fyX = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.fyW.add(aVar);
    }

    public boolean getHasNext() {
        return this.fyX;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.fyP != null) {
            i = this.fyP.size();
            if (this.fyX) {
                i++;
            }
        }
        return i + this.fyZ + this.fza;
    }

    public void setTempSize(int i) {
        this.fyZ = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.fza = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.fyQ = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.fyR = gVar;
    }

    public void a(b bVar) {
        this.fyT = bVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        if (obj instanceof UrlDragImageView) {
            ((UrlDragImageView) obj).onDestroy();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View n = n(viewGroup, i);
        if (n == null && this.fyW != null && this.fyW.size() != 0) {
            Iterator<a> it = this.fyW.iterator();
            while (it.hasNext() && (n = it.next().p(viewGroup, i)) == null) {
            }
        }
        if (n == null) {
            return o(viewGroup, i);
        }
        return n;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        UrlDragImageView urlDragImageView;
        ImageUrlData imageUrlData;
        if ((obj instanceof UrlDragImageView) && (imageUrlData = (urlDragImageView = (UrlDragImageView) obj).getmAssistUrlData()) != null && !StringUtils.isNull(imageUrlData.imageUrl)) {
            urlDragImageView.setAssistUrl(Dj(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData Dj(String str) {
        if (TextUtils.isEmpty(str) || this.fyO == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.fyO.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.fzd = z;
    }

    private UrlDragImageView n(ViewGroup viewGroup, int i) {
        String str = i < this.fyP.size() ? this.fyP.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.fyU);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.fyQ);
        urlDragImageView.setIsCanDrag(this.fzd);
        urlDragImageView.setIsCdn(this.fzb);
        urlDragImageView.setOnSizeChangedListener(this.fyR);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(Dk(str));
        urlDragImageView.setUrl(str, this.fzc);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.fyS);
        urlDragImageView.setHeadImage(this.fze);
        urlDragImageView.setDragToExitListener(this.fyV);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.fyV = dVar;
    }

    private View o(ViewGroup viewGroup, int i) {
        if (this.fyX && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(ao.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.fyY);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.mPosition != i && obj != null) {
            if (this.fyT != null) {
                this.fyT.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData Dk(String str) {
        if (TextUtils.isEmpty(str) || this.fyO == null) {
            return null;
        }
        return this.fyO.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.fzc = z;
    }

    public void setIsCdn(boolean z) {
        this.fzb = z;
    }

    public void setHeadImage(boolean z) {
        this.fze = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.fyU = bVar;
    }
}
