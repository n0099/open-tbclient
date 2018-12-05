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
    private UrlDragImageView.b aTB;
    private boolean aTC;
    private boolean aTD;
    private GalleryViewPager aTE;
    private boolean aTF;
    private Map<String, ImageUrlData> aTn;
    private DragImageView.e aTr;
    private List<a> aTx;
    private DragImageView.d aTy;
    private Context mContext;
    private ArrayList<String> aTm = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aTo = null;
    private View.OnTouchListener aTp = null;
    private DragImageView.g aTq = null;
    private int aTs = 0;
    private boolean aTt = false;
    private String aTu = null;
    private int aTv = 0;
    private int aTw = 0;
    private boolean aTz = false;
    private boolean aTA = false;
    private int mPosition = -1;

    /* loaded from: classes6.dex */
    public interface a {
        View f(ViewGroup viewGroup, int i);
    }

    public ImagePagerAdapter(Context context, GalleryViewPager galleryViewPager, DragImageView.e eVar) {
        this.mContext = null;
        this.aTr = null;
        this.aTx = null;
        this.mContext = context;
        this.aTE = galleryViewPager;
        this.aTr = eVar;
        this.aTx = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.aTm = new ArrayList<>();
        } else {
            this.aTm = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aTn = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.aTu = str;
    }

    public void setHasNext(boolean z) {
        this.aTt = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.aTx.add(aVar);
    }

    public boolean getHasNext() {
        return this.aTt;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.aTm != null) {
            i = this.aTm.size();
            if (this.aTt) {
                i++;
            }
        }
        return i + this.aTv + this.aTw;
    }

    public void setTempSize(int i) {
        this.aTv = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aTw = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.aTp = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTo = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aTs = i;
    }

    public void a(DragImageView.g gVar) {
        this.aTq = gVar;
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
        if (d == null && this.aTx != null && this.aTx.size() != 0) {
            Iterator<a> it = this.aTx.iterator();
            while (it.hasNext() && (d = it.next().f(viewGroup, i)) == null) {
            }
        }
        if (d == null) {
            return e(viewGroup, i);
        }
        return d;
    }

    public void setIsCanDrag(boolean z) {
        this.aTC = z;
    }

    public void setIsHotSort(boolean z) {
        this.aTD = z;
    }

    private UrlDragImageView d(ViewGroup viewGroup, int i) {
        String str = i < this.aTm.size() ? this.aTm.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.aTB);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.aTo);
        urlDragImageView.setOuterOnTouchListener(this.aTp);
        urlDragImageView.setIsCanDrag(this.aTC);
        urlDragImageView.setIsHotSort(this.aTD);
        urlDragImageView.setIsCdn(this.aTz);
        urlDragImageView.setOnSizeChangedListener(this.aTq);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(hf(str));
        urlDragImageView.setUrl(str, this.aTA);
        urlDragImageView.setGifMaxUseableMem(this.aTs);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.aTr);
        urlDragImageView.setHeadImage(this.aTF);
        urlDragImageView.setDragToExitListener(this.aTy);
        return urlDragImageView;
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aTy = dVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.aTt && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(e.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(e.g.image)).setImageDrawable(al.getDrawable(e.f.big_image_next_default));
            ((TextView) inflate.findViewById(e.g.thread_name)).setText(this.aTu);
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
                imageView.QA();
                this.aTE.setCurrentView(imageView);
                if (imageView.getImageType() == 1) {
                    this.aTr.a(imageView);
                }
            }
            urlDragImageView.KJ();
            urlDragImageView.KI();
            urlDragImageView.k(this.aTA, true);
        }
    }

    private ImageUrlData hf(String str) {
        if (TextUtils.isEmpty(str) || this.aTn == null) {
            return null;
        }
        return this.aTn.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aTA = z;
    }

    public void setIsCdn(boolean z) {
        this.aTz = z;
    }

    public void setHeadImage(boolean z) {
        this.aTF = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.aTB = bVar;
    }
}
