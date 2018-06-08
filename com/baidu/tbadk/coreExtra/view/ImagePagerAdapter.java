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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private List<a> aGB;
    private DragImageView.d aGC;
    private UrlDragImageView.b aGF;
    private boolean aGG;
    private GalleryViewPager aGH;
    private boolean aGI;
    private Map<String, ImageUrlData> aGr;
    private DragImageView.e aGv;
    private Context mContext;
    private ArrayList<String> aGq = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aGs = null;
    private View.OnTouchListener aGt = null;
    private DragImageView.f aGu = null;
    private int aGw = 0;
    private boolean aGx = false;
    private String aGy = null;
    private int aGz = 0;
    private int aGA = 0;
    private boolean aGD = false;
    private boolean aGE = false;
    private int mPosition = -1;

    /* loaded from: classes.dex */
    public interface a {
        View g(ViewGroup viewGroup, int i);
    }

    public ImagePagerAdapter(Context context, GalleryViewPager galleryViewPager, DragImageView.e eVar) {
        this.mContext = null;
        this.aGv = null;
        this.aGB = null;
        this.mContext = context;
        this.aGH = galleryViewPager;
        this.aGv = eVar;
        this.aGB = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.aGq = new ArrayList<>();
        } else {
            this.aGq = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aGr = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.aGy = str;
    }

    public void setHasNext(boolean z) {
        this.aGx = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.aGB.add(aVar);
    }

    public boolean getHasNext() {
        return this.aGx;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.aGq != null) {
            i = this.aGq.size();
            if (this.aGx) {
                i++;
            }
        }
        return i + this.aGz + this.aGA;
    }

    public void setTempSize(int i) {
        this.aGz = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aGA = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.aGt = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aGs = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aGw = i;
    }

    public void a(DragImageView.f fVar) {
        this.aGu = fVar;
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
        View e = e(viewGroup, i);
        if (e == null && this.aGB != null && this.aGB.size() != 0) {
            Iterator<a> it = this.aGB.iterator();
            while (it.hasNext() && (e = it.next().g(viewGroup, i)) == null) {
            }
        }
        if (e == null) {
            return f(viewGroup, i);
        }
        return e;
    }

    public void setIsCanDrag(boolean z) {
        this.aGG = z;
    }

    private UrlDragImageView e(ViewGroup viewGroup, int i) {
        String str = i < this.aGq.size() ? this.aGq.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.aGF);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.aGs);
        urlDragImageView.setOuterOnTouchListener(this.aGt);
        urlDragImageView.setIsCanDrag(this.aGG);
        urlDragImageView.setIsCdn(this.aGD);
        urlDragImageView.setOnSizeChangedListener(this.aGu);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(fZ(str));
        urlDragImageView.setUrl(str, this.aGE);
        urlDragImageView.setGifMaxUseableMem(this.aGw);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.aGv);
        urlDragImageView.setHeadImage(this.aGI);
        urlDragImageView.setDragToExitListener(this.aGC);
        return urlDragImageView;
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aGC = dVar;
    }

    private View f(ViewGroup viewGroup, int i) {
        if (this.aGx && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.i.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.g.image)).setImageDrawable(al.getDrawable(d.f.big_image_next_default));
            ((TextView) inflate.findViewById(d.g.thread_name)).setText(this.aGy);
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
                imageView.LD();
                this.aGH.setCurrentView(imageView);
                if (imageView.getImageType() == 1) {
                    this.aGv.a(imageView);
                }
            }
            urlDragImageView.FO();
            urlDragImageView.FN();
            urlDragImageView.i(this.aGE, true);
        }
    }

    private ImageUrlData fZ(String str) {
        if (TextUtils.isEmpty(str) || this.aGr == null) {
            return null;
        }
        return this.aGr.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aGE = z;
    }

    public void setIsCdn(boolean z) {
        this.aGD = z;
    }

    public void setHeadImage(boolean z) {
        this.aGI = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.aGF = bVar;
    }
}
