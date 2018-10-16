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
/* loaded from: classes6.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private Map<String, ImageUrlData> aOY;
    private DragImageView.e aPc;
    private List<a> aPi;
    private DragImageView.d aPj;
    private UrlDragImageView.b aPm;
    private boolean aPn;
    private boolean aPo;
    private GalleryViewPager aPp;
    private boolean aPq;
    private Context mContext;
    private ArrayList<String> aOX = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aOZ = null;
    private View.OnTouchListener aPa = null;
    private DragImageView.g aPb = null;
    private int aPd = 0;
    private boolean aPe = false;
    private String aPf = null;
    private int aPg = 0;
    private int aPh = 0;
    private boolean aPk = false;
    private boolean aPl = false;
    private int mPosition = -1;

    /* loaded from: classes6.dex */
    public interface a {
        View f(ViewGroup viewGroup, int i);
    }

    public ImagePagerAdapter(Context context, GalleryViewPager galleryViewPager, DragImageView.e eVar) {
        this.mContext = null;
        this.aPc = null;
        this.aPi = null;
        this.mContext = context;
        this.aPp = galleryViewPager;
        this.aPc = eVar;
        this.aPi = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.aOX = new ArrayList<>();
        } else {
            this.aOX = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aOY = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.aPf = str;
    }

    public void setHasNext(boolean z) {
        this.aPe = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.aPi.add(aVar);
    }

    public boolean getHasNext() {
        return this.aPe;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.aOX != null) {
            i = this.aOX.size();
            if (this.aPe) {
                i++;
            }
        }
        return i + this.aPg + this.aPh;
    }

    public void setTempSize(int i) {
        this.aPg = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aPh = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.aPa = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aOZ = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aPd = i;
    }

    public void a(DragImageView.g gVar) {
        this.aPb = gVar;
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
        if (d == null && this.aPi != null && this.aPi.size() != 0) {
            Iterator<a> it = this.aPi.iterator();
            while (it.hasNext() && (d = it.next().f(viewGroup, i)) == null) {
            }
        }
        if (d == null) {
            return e(viewGroup, i);
        }
        return d;
    }

    public void setIsCanDrag(boolean z) {
        this.aPn = z;
    }

    public void setIsHotSort(boolean z) {
        this.aPo = z;
    }

    private UrlDragImageView d(ViewGroup viewGroup, int i) {
        String str = i < this.aOX.size() ? this.aOX.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.aPm);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.aOZ);
        urlDragImageView.setOuterOnTouchListener(this.aPa);
        urlDragImageView.setIsCanDrag(this.aPn);
        urlDragImageView.setIsHotSort(this.aPo);
        urlDragImageView.setIsCdn(this.aPk);
        urlDragImageView.setOnSizeChangedListener(this.aPb);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(gM(str));
        urlDragImageView.setUrl(str, this.aPl);
        urlDragImageView.setGifMaxUseableMem(this.aPd);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.aPc);
        urlDragImageView.setHeadImage(this.aPq);
        urlDragImageView.setDragToExitListener(this.aPj);
        return urlDragImageView;
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aPj = dVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.aPe && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(e.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(e.g.image)).setImageDrawable(al.getDrawable(e.f.big_image_next_default));
            ((TextView) inflate.findViewById(e.g.thread_name)).setText(this.aPf);
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
                imageView.Pl();
                this.aPp.setCurrentView(imageView);
                if (imageView.getImageType() == 1) {
                    this.aPc.a(imageView);
                }
            }
            urlDragImageView.Jt();
            urlDragImageView.Js();
            urlDragImageView.k(this.aPl, true);
        }
    }

    private ImageUrlData gM(String str) {
        if (TextUtils.isEmpty(str) || this.aOY == null) {
            return null;
        }
        return this.aOY.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aPl = z;
    }

    public void setIsCdn(boolean z) {
        this.aPk = z;
    }

    public void setHeadImage(boolean z) {
        this.aPq = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.aPm = bVar;
    }
}
