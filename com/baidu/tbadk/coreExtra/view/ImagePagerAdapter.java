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
    private List<a> aTA;
    private DragImageView.d aTB;
    private UrlDragImageView.b aTE;
    private boolean aTF;
    private boolean aTG;
    private GalleryViewPager aTH;
    private boolean aTI;
    private Map<String, ImageUrlData> aTq;
    private DragImageView.e aTu;
    private Context mContext;
    private ArrayList<String> aTp = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aTr = null;
    private View.OnTouchListener aTs = null;
    private DragImageView.g aTt = null;
    private int aTv = 0;
    private boolean aTw = false;
    private String aTx = null;
    private int aTy = 0;
    private int aTz = 0;
    private boolean aTC = false;
    private boolean aTD = false;
    private int mPosition = -1;

    /* loaded from: classes6.dex */
    public interface a {
        View f(ViewGroup viewGroup, int i);
    }

    public ImagePagerAdapter(Context context, GalleryViewPager galleryViewPager, DragImageView.e eVar) {
        this.mContext = null;
        this.aTu = null;
        this.aTA = null;
        this.mContext = context;
        this.aTH = galleryViewPager;
        this.aTu = eVar;
        this.aTA = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.aTp = new ArrayList<>();
        } else {
            this.aTp = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aTq = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.aTx = str;
    }

    public void setHasNext(boolean z) {
        this.aTw = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.aTA.add(aVar);
    }

    public boolean getHasNext() {
        return this.aTw;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.aTp != null) {
            i = this.aTp.size();
            if (this.aTw) {
                i++;
            }
        }
        return i + this.aTy + this.aTz;
    }

    public void setTempSize(int i) {
        this.aTy = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aTz = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.aTs = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTr = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aTv = i;
    }

    public void a(DragImageView.g gVar) {
        this.aTt = gVar;
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
        if (d == null && this.aTA != null && this.aTA.size() != 0) {
            Iterator<a> it = this.aTA.iterator();
            while (it.hasNext() && (d = it.next().f(viewGroup, i)) == null) {
            }
        }
        if (d == null) {
            return e(viewGroup, i);
        }
        return d;
    }

    public void setIsCanDrag(boolean z) {
        this.aTF = z;
    }

    public void setIsHotSort(boolean z) {
        this.aTG = z;
    }

    private UrlDragImageView d(ViewGroup viewGroup, int i) {
        String str = i < this.aTp.size() ? this.aTp.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.aTE);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.aTr);
        urlDragImageView.setOuterOnTouchListener(this.aTs);
        urlDragImageView.setIsCanDrag(this.aTF);
        urlDragImageView.setIsHotSort(this.aTG);
        urlDragImageView.setIsCdn(this.aTC);
        urlDragImageView.setOnSizeChangedListener(this.aTt);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(hg(str));
        urlDragImageView.setUrl(str, this.aTD);
        urlDragImageView.setGifMaxUseableMem(this.aTv);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.aTu);
        urlDragImageView.setHeadImage(this.aTI);
        urlDragImageView.setDragToExitListener(this.aTB);
        return urlDragImageView;
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aTB = dVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.aTw && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(e.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(e.g.image)).setImageDrawable(al.getDrawable(e.f.big_image_next_default));
            ((TextView) inflate.findViewById(e.g.thread_name)).setText(this.aTx);
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
                imageView.QC();
                this.aTH.setCurrentView(imageView);
                if (imageView.getImageType() == 1) {
                    this.aTu.a(imageView);
                }
            }
            urlDragImageView.KK();
            urlDragImageView.KJ();
            urlDragImageView.k(this.aTD, true);
        }
    }

    private ImageUrlData hg(String str) {
        if (TextUtils.isEmpty(str) || this.aTq == null) {
            return null;
        }
        return this.aTq.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aTD = z;
    }

    public void setIsCdn(boolean z) {
        this.aTC = z;
    }

    public void setHeadImage(boolean z) {
        this.aTI = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.aTE = bVar;
    }
}
