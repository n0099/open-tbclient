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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private DragImageView.e aKA;
    private List<a> aKG;
    private DragImageView.d aKH;
    private UrlDragImageView.b aKK;
    private boolean aKL;
    private boolean aKM;
    private GalleryViewPager aKN;
    private boolean aKO;
    private Map<String, ImageUrlData> aKw;
    private Context mContext;
    private ArrayList<String> aKv = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aKx = null;
    private View.OnTouchListener aKy = null;
    private DragImageView.g aKz = null;
    private int aKB = 0;
    private boolean aKC = false;
    private String aKD = null;
    private int aKE = 0;
    private int aKF = 0;
    private boolean aKI = false;
    private boolean aKJ = false;
    private int mPosition = -1;

    /* loaded from: classes2.dex */
    public interface a {
        View f(ViewGroup viewGroup, int i);
    }

    public ImagePagerAdapter(Context context, GalleryViewPager galleryViewPager, DragImageView.e eVar) {
        this.mContext = null;
        this.aKA = null;
        this.aKG = null;
        this.mContext = context;
        this.aKN = galleryViewPager;
        this.aKA = eVar;
        this.aKG = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.aKv = new ArrayList<>();
        } else {
            this.aKv = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aKw = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.aKD = str;
    }

    public void setHasNext(boolean z) {
        this.aKC = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.aKG.add(aVar);
    }

    public boolean getHasNext() {
        return this.aKC;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.aKv != null) {
            i = this.aKv.size();
            if (this.aKC) {
                i++;
            }
        }
        return i + this.aKE + this.aKF;
    }

    public void setTempSize(int i) {
        this.aKE = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aKF = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.aKy = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aKx = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aKB = i;
    }

    public void a(DragImageView.g gVar) {
        this.aKz = gVar;
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
        View d = d(viewGroup, i);
        if (d == null && this.aKG != null && this.aKG.size() != 0) {
            Iterator<a> it = this.aKG.iterator();
            while (it.hasNext() && (d = it.next().f(viewGroup, i)) == null) {
            }
        }
        if (d == null) {
            return e(viewGroup, i);
        }
        return d;
    }

    public void setIsCanDrag(boolean z) {
        this.aKL = z;
    }

    public void setIsHotSort(boolean z) {
        this.aKM = z;
    }

    private UrlDragImageView d(ViewGroup viewGroup, int i) {
        String str = i < this.aKv.size() ? this.aKv.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.aKK);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.aKx);
        urlDragImageView.setOuterOnTouchListener(this.aKy);
        urlDragImageView.setIsCanDrag(this.aKL);
        urlDragImageView.setIsHotSort(this.aKM);
        urlDragImageView.setIsCdn(this.aKI);
        urlDragImageView.setOnSizeChangedListener(this.aKz);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(gy(str));
        urlDragImageView.setUrl(str, this.aKJ);
        urlDragImageView.setGifMaxUseableMem(this.aKB);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.aKA);
        urlDragImageView.setHeadImage(this.aKO);
        urlDragImageView.setDragToExitListener(this.aKH);
        return urlDragImageView;
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aKH = dVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.aKC && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(e.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(e.g.image)).setImageDrawable(al.getDrawable(e.f.big_image_next_default));
            ((TextView) inflate.findViewById(e.g.thread_name)).setText(this.aKD);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.mPosition != i && (obj instanceof UrlDragImageView)) {
            this.mPosition = i;
            UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
            DragImageView imageView = urlDragImageView.getImageView();
            if (imageView != null) {
                imageView.Nn();
                this.aKN.setCurrentView(imageView);
                if (imageView.getImageType() == 1) {
                    this.aKA.a(imageView);
                }
            }
            urlDragImageView.Hs();
            urlDragImageView.Hr();
            urlDragImageView.k(this.aKJ, true);
        }
    }

    private ImageUrlData gy(String str) {
        if (TextUtils.isEmpty(str) || this.aKw == null) {
            return null;
        }
        return this.aKw.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aKJ = z;
    }

    public void setIsCdn(boolean z) {
        this.aKI = z;
    }

    public void setHeadImage(boolean z) {
        this.aKO = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.aKK = bVar;
    }
}
