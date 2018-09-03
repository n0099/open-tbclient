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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private Map<String, ImageUrlData> aHi;
    private DragImageView.e aHm;
    private List<a> aHs;
    private DragImageView.d aHt;
    private UrlDragImageView.b aHw;
    private boolean aHx;
    private GalleryViewPager aHy;
    private boolean aHz;
    private Context mContext;
    private ArrayList<String> aHh = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aHj = null;
    private View.OnTouchListener aHk = null;
    private DragImageView.g aHl = null;
    private int aHn = 0;
    private boolean aHo = false;
    private String aHp = null;
    private int aHq = 0;
    private int aHr = 0;
    private boolean aHu = false;
    private boolean aHv = false;
    private int mPosition = -1;

    /* loaded from: classes2.dex */
    public interface a {
        View f(ViewGroup viewGroup, int i);
    }

    public ImagePagerAdapter(Context context, GalleryViewPager galleryViewPager, DragImageView.e eVar) {
        this.mContext = null;
        this.aHm = null;
        this.aHs = null;
        this.mContext = context;
        this.aHy = galleryViewPager;
        this.aHm = eVar;
        this.aHs = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.aHh = new ArrayList<>();
        } else {
            this.aHh = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aHi = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.aHp = str;
    }

    public void setHasNext(boolean z) {
        this.aHo = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.aHs.add(aVar);
    }

    public boolean getHasNext() {
        return this.aHo;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.aHh != null) {
            i = this.aHh.size();
            if (this.aHo) {
                i++;
            }
        }
        return i + this.aHq + this.aHr;
    }

    public void setTempSize(int i) {
        this.aHq = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aHr = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.aHk = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aHj = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aHn = i;
    }

    public void a(DragImageView.g gVar) {
        this.aHl = gVar;
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
        if (d == null && this.aHs != null && this.aHs.size() != 0) {
            Iterator<a> it = this.aHs.iterator();
            while (it.hasNext() && (d = it.next().f(viewGroup, i)) == null) {
            }
        }
        if (d == null) {
            return e(viewGroup, i);
        }
        return d;
    }

    public void setIsCanDrag(boolean z) {
        this.aHx = z;
    }

    private UrlDragImageView d(ViewGroup viewGroup, int i) {
        String str = i < this.aHh.size() ? this.aHh.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.aHw);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.aHj);
        urlDragImageView.setOuterOnTouchListener(this.aHk);
        urlDragImageView.setIsCanDrag(this.aHx);
        urlDragImageView.setIsCdn(this.aHu);
        urlDragImageView.setOnSizeChangedListener(this.aHl);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(gb(str));
        urlDragImageView.setUrl(str, this.aHv);
        urlDragImageView.setGifMaxUseableMem(this.aHn);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.aHm);
        urlDragImageView.setHeadImage(this.aHz);
        urlDragImageView.setDragToExitListener(this.aHt);
        return urlDragImageView;
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aHt = dVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.aHo && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(f.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(f.g.image)).setImageDrawable(am.getDrawable(f.C0146f.big_image_next_default));
            ((TextView) inflate.findViewById(f.g.thread_name)).setText(this.aHp);
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
                imageView.LV();
                this.aHy.setCurrentView(imageView);
                if (imageView.getImageType() == 1) {
                    this.aHm.a(imageView);
                }
            }
            urlDragImageView.Gc();
            urlDragImageView.Gb();
            urlDragImageView.i(this.aHv, true);
        }
    }

    private ImageUrlData gb(String str) {
        if (TextUtils.isEmpty(str) || this.aHi == null) {
            return null;
        }
        return this.aHi.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aHv = z;
    }

    public void setIsCdn(boolean z) {
        this.aHu = z;
    }

    public void setHeadImage(boolean z) {
        this.aHz = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.aHw = bVar;
    }
}
