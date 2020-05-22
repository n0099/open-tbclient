package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private b egA;
    private UrlDragImageView.b egB;
    private DragImageView.d egC;
    private boolean egK;
    private boolean egL;
    private Map<String, ImageUrlData> egv;
    private DragImageView.e egz;
    private Context mContext;
    private ArrayList<String> egw = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener egx = null;
    private DragImageView.g egy = null;
    private int mGifMaxUseableMem = 0;
    private boolean egE = false;
    private String egF = null;
    private int egG = 0;
    private int egH = 0;
    private boolean egI = false;
    private boolean egJ = false;
    private int mPosition = -1;
    private List<a> egD = new ArrayList();

    /* loaded from: classes8.dex */
    public interface a {
        View i(ViewGroup viewGroup, int i);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void g(int i, Object obj);
    }

    public ImagePagerAdapter(Context context, DragImageView.e eVar) {
        this.mContext = context;
        this.egz = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.egw = new ArrayList<>();
        } else {
            this.egw = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.egv = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.egF = str;
    }

    public void setHasNext(boolean z) {
        this.egE = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.egD.add(aVar);
    }

    public boolean getHasNext() {
        return this.egE;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.egw != null) {
            i = this.egw.size();
            if (this.egE) {
                i++;
            }
        }
        return i + this.egG + this.egH;
    }

    public void setTempSize(int i) {
        this.egG = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.egH = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.egx = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.egy = gVar;
    }

    public void a(b bVar) {
        this.egA = bVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        if (obj instanceof UrlDragImageView) {
            ((UrlDragImageView) obj).onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View g = g(viewGroup, i);
        if (g == null && this.egD != null && this.egD.size() != 0) {
            Iterator<a> it = this.egD.iterator();
            while (it.hasNext() && (g = it.next().i(viewGroup, i)) == null) {
            }
        }
        if (g == null) {
            return h(viewGroup, i);
        }
        return g;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        UrlDragImageView urlDragImageView;
        ImageUrlData imageUrlData;
        if ((obj instanceof UrlDragImageView) && (imageUrlData = (urlDragImageView = (UrlDragImageView) obj).getmAssistUrlData()) != null && !StringUtils.isNull(imageUrlData.imageUrl)) {
            urlDragImageView.setAssistUrl(xz(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData xz(String str) {
        if (TextUtils.isEmpty(str) || this.egv == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.egv.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.egK = z;
    }

    private UrlDragImageView g(ViewGroup viewGroup, int i) {
        String str = i < this.egw.size() ? this.egw.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.egB);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.egx);
        urlDragImageView.setIsCanDrag(this.egK);
        urlDragImageView.setIsCdn(this.egI);
        urlDragImageView.setOnSizeChangedListener(this.egy);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(xA(str));
        urlDragImageView.setUrl(str, this.egJ);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.egz);
        urlDragImageView.setHeadImage(this.egL);
        urlDragImageView.setDragToExitListener(this.egC);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.egC = dVar;
    }

    private View h(ViewGroup viewGroup, int i) {
        if (this.egE && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(am.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.egF);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.mPosition != i && obj != null) {
            if (this.egA != null) {
                this.egA.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData xA(String str) {
        if (TextUtils.isEmpty(str) || this.egv == null) {
            return null;
        }
        return this.egv.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.egJ = z;
    }

    public void setIsCdn(boolean z) {
        this.egI = z;
    }

    public void setHeadImage(boolean z) {
        this.egL = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.egB = bVar;
    }
}
