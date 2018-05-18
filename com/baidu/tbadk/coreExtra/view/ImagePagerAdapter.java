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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private Map<String, ImageUrlData> axW;
    private DragImageView.e aya;
    private List<a> ayg;
    private DragImageView.d ayh;
    private UrlDragImageView.b ayk;
    private boolean ayl;
    private GalleryViewPager aym;
    private boolean ayn;
    private Context mContext;
    private ArrayList<String> axV = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener axX = null;
    private View.OnTouchListener axY = null;
    private DragImageView.f axZ = null;
    private int ayb = 0;
    private boolean ayc = false;
    private String ayd = null;
    private int aye = 0;
    private int ayf = 0;
    private boolean ayi = false;
    private boolean ayj = false;
    private int mPosition = -1;

    /* loaded from: classes.dex */
    public interface a {
        View g(ViewGroup viewGroup, int i);
    }

    public ImagePagerAdapter(Context context, GalleryViewPager galleryViewPager, DragImageView.e eVar) {
        this.mContext = null;
        this.aya = null;
        this.ayg = null;
        this.mContext = context;
        this.aym = galleryViewPager;
        this.aya = eVar;
        this.ayg = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.axV = new ArrayList<>();
        } else {
            this.axV = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.axW = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.ayd = str;
    }

    public void setHasNext(boolean z) {
        this.ayc = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.ayg.add(aVar);
    }

    public boolean getHasNext() {
        return this.ayc;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.axV != null) {
            i = this.axV.size();
            if (this.ayc) {
                i++;
            }
        }
        return i + this.aye + this.ayf;
    }

    public void setTempSize(int i) {
        this.aye = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.ayf = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.axY = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axX = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.ayb = i;
    }

    public void a(DragImageView.f fVar) {
        this.axZ = fVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        return view2.equals(obj);
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
        if (e == null && this.ayg != null && this.ayg.size() != 0) {
            Iterator<a> it = this.ayg.iterator();
            while (it.hasNext() && (e = it.next().g(viewGroup, i)) == null) {
            }
        }
        if (e == null) {
            return f(viewGroup, i);
        }
        return e;
    }

    public void setIsCanDrag(boolean z) {
        this.ayl = z;
    }

    private UrlDragImageView e(ViewGroup viewGroup, int i) {
        String str = i < this.axV.size() ? this.axV.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.ayk);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.axX);
        urlDragImageView.setOuterOnTouchListener(this.axY);
        urlDragImageView.setIsCanDrag(this.ayl);
        urlDragImageView.setIsCdn(this.ayi);
        urlDragImageView.setOnSizeChangedListener(this.axZ);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(fB(str));
        urlDragImageView.setUrl(str, this.ayj);
        urlDragImageView.setGifMaxUseableMem(this.ayb);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.aya);
        urlDragImageView.setHeadImage(this.ayn);
        urlDragImageView.setDragToExitListener(this.ayh);
        return urlDragImageView;
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.ayh = dVar;
    }

    private View f(ViewGroup viewGroup, int i) {
        if (this.ayc && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.i.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.g.image)).setImageDrawable(ak.getDrawable(d.f.big_image_next_default));
            ((TextView) inflate.findViewById(d.g.thread_name)).setText(this.ayd);
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
                imageView.Ih();
                this.aym.setCurrentView(imageView);
                if (imageView.getImageType() == 1) {
                    this.aya.a(imageView);
                }
            }
            urlDragImageView.Cl();
            urlDragImageView.Ck();
            urlDragImageView.i(this.ayj, true);
        }
    }

    private ImageUrlData fB(String str) {
        if (TextUtils.isEmpty(str) || this.axW == null) {
            return null;
        }
        return this.axW.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.ayj = z;
    }

    public void setIsCdn(boolean z) {
        this.ayi = z;
    }

    public void setHeadImage(boolean z) {
        this.ayn = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.ayk = bVar;
    }
}
