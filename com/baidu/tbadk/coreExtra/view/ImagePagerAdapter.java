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
    private DragImageView.e fwA;
    private b fwB;
    private UrlDragImageView.b fwC;
    private DragImageView.d fwD;
    private boolean fwL;
    private boolean fwM;
    private Map<String, ImageUrlData> fww;
    private Context mContext;
    private ArrayList<String> fwx = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener fwy = null;
    private DragImageView.g fwz = null;
    private int mGifMaxUseableMem = 0;
    private boolean fwF = false;
    private String fwG = null;
    private int fwH = 0;
    private int fwI = 0;
    private boolean fwJ = false;
    private boolean fwK = false;
    private int mPosition = -1;
    private List<a> fwE = new ArrayList();

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
        this.fwA = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.fwx = new ArrayList<>();
        } else {
            this.fwx = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.fww = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.fwG = str;
    }

    public void setHasNext(boolean z) {
        this.fwF = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.fwE.add(aVar);
    }

    public boolean getHasNext() {
        return this.fwF;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.fwx != null) {
            i = this.fwx.size();
            if (this.fwF) {
                i++;
            }
        }
        return i + this.fwH + this.fwI;
    }

    public void setTempSize(int i) {
        this.fwH = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.fwI = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.fwy = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.fwz = gVar;
    }

    public void a(b bVar) {
        this.fwB = bVar;
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
        if (n == null && this.fwE != null && this.fwE.size() != 0) {
            Iterator<a> it = this.fwE.iterator();
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
            urlDragImageView.setAssistUrl(Co(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData Co(String str) {
        if (TextUtils.isEmpty(str) || this.fww == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.fww.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.fwL = z;
    }

    private UrlDragImageView n(ViewGroup viewGroup, int i) {
        String str = i < this.fwx.size() ? this.fwx.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.fwC);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.fwy);
        urlDragImageView.setIsCanDrag(this.fwL);
        urlDragImageView.setIsCdn(this.fwJ);
        urlDragImageView.setOnSizeChangedListener(this.fwz);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(Cp(str));
        urlDragImageView.setUrl(str, this.fwK);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.fwA);
        urlDragImageView.setHeadImage(this.fwM);
        urlDragImageView.setDragToExitListener(this.fwD);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.fwD = dVar;
    }

    private View o(ViewGroup viewGroup, int i) {
        if (this.fwF && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(ap.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.fwG);
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
            if (this.fwB != null) {
                this.fwB.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData Cp(String str) {
        if (TextUtils.isEmpty(str) || this.fww == null) {
            return null;
        }
        return this.fww.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.fwK = z;
    }

    public void setIsCdn(boolean z) {
        this.fwJ = z;
    }

    public void setHeadImage(boolean z) {
        this.fwM = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.fwC = bVar;
    }
}
