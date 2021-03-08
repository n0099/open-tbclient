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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private Map<String, ImageUrlData> fxV;
    private DragImageView.e fxZ;
    private b fya;
    private UrlDragImageView.b fyb;
    private DragImageView.d fyc;
    private boolean fyk;
    private boolean fyl;
    private Context mContext;
    private ArrayList<String> fxW = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener fxX = null;
    private DragImageView.g fxY = null;
    private int mGifMaxUseableMem = 0;
    private boolean fye = false;
    private String fyf = null;
    private int fyg = 0;
    private int fyh = 0;
    private boolean fyi = false;
    private boolean fyj = false;
    private int mPosition = -1;
    private List<a> fyd = new ArrayList();

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
        this.fxZ = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.fxW = new ArrayList<>();
        } else {
            this.fxW = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.fxV = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.fyf = str;
    }

    public void setHasNext(boolean z) {
        this.fye = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.fyd.add(aVar);
    }

    public boolean getHasNext() {
        return this.fye;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.fxW != null) {
            i = this.fxW.size();
            if (this.fye) {
                i++;
            }
        }
        return i + this.fyg + this.fyh;
    }

    public void setTempSize(int i) {
        this.fyg = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.fyh = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.fxX = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.fxY = gVar;
    }

    public void a(b bVar) {
        this.fya = bVar;
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
        if (n == null && this.fyd != null && this.fyd.size() != 0) {
            Iterator<a> it = this.fyd.iterator();
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
            urlDragImageView.setAssistUrl(Cv(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData Cv(String str) {
        if (TextUtils.isEmpty(str) || this.fxV == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.fxV.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.fyk = z;
    }

    private UrlDragImageView n(ViewGroup viewGroup, int i) {
        String str = i < this.fxW.size() ? this.fxW.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.fyb);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.fxX);
        urlDragImageView.setIsCanDrag(this.fyk);
        urlDragImageView.setIsCdn(this.fyi);
        urlDragImageView.setOnSizeChangedListener(this.fxY);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(Cw(str));
        urlDragImageView.setUrl(str, this.fyj);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.fxZ);
        urlDragImageView.setHeadImage(this.fyl);
        urlDragImageView.setDragToExitListener(this.fyc);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.fyc = dVar;
    }

    private View o(ViewGroup viewGroup, int i) {
        if (this.fye && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(ap.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.fyf);
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
            if (this.fya != null) {
                this.fya.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData Cw(String str) {
        if (TextUtils.isEmpty(str) || this.fxV == null) {
            return null;
        }
        return this.fxV.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.fyj = z;
    }

    public void setIsCdn(boolean z) {
        this.fyi = z;
    }

    public void setHeadImage(boolean z) {
        this.fyl = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.fyb = bVar;
    }
}
