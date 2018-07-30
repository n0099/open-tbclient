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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private boolean aHA;
    private Map<String, ImageUrlData> aHj;
    private DragImageView.e aHn;
    private List<a> aHt;
    private DragImageView.d aHu;
    private UrlDragImageView.b aHx;
    private boolean aHy;
    private GalleryViewPager aHz;
    private Context mContext;
    private ArrayList<String> aHi = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aHk = null;
    private View.OnTouchListener aHl = null;
    private DragImageView.g aHm = null;
    private int aHo = 0;
    private boolean aHp = false;
    private String aHq = null;
    private int aHr = 0;
    private int aHs = 0;
    private boolean aHv = false;
    private boolean aHw = false;
    private int mPosition = -1;

    /* loaded from: classes2.dex */
    public interface a {
        View f(ViewGroup viewGroup, int i);
    }

    public ImagePagerAdapter(Context context, GalleryViewPager galleryViewPager, DragImageView.e eVar) {
        this.mContext = null;
        this.aHn = null;
        this.aHt = null;
        this.mContext = context;
        this.aHz = galleryViewPager;
        this.aHn = eVar;
        this.aHt = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.aHi = new ArrayList<>();
        } else {
            this.aHi = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aHj = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.aHq = str;
    }

    public void setHasNext(boolean z) {
        this.aHp = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.aHt.add(aVar);
    }

    public boolean getHasNext() {
        return this.aHp;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.aHi != null) {
            i = this.aHi.size();
            if (this.aHp) {
                i++;
            }
        }
        return i + this.aHr + this.aHs;
    }

    public void setTempSize(int i) {
        this.aHr = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aHs = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.aHl = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aHk = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aHo = i;
    }

    public void a(DragImageView.g gVar) {
        this.aHm = gVar;
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
        if (d == null && this.aHt != null && this.aHt.size() != 0) {
            Iterator<a> it = this.aHt.iterator();
            while (it.hasNext() && (d = it.next().f(viewGroup, i)) == null) {
            }
        }
        if (d == null) {
            return e(viewGroup, i);
        }
        return d;
    }

    public void setIsCanDrag(boolean z) {
        this.aHy = z;
    }

    private UrlDragImageView d(ViewGroup viewGroup, int i) {
        String str = i < this.aHi.size() ? this.aHi.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.aHx);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.aHk);
        urlDragImageView.setOuterOnTouchListener(this.aHl);
        urlDragImageView.setIsCanDrag(this.aHy);
        urlDragImageView.setIsCdn(this.aHv);
        urlDragImageView.setOnSizeChangedListener(this.aHm);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(gb(str));
        urlDragImageView.setUrl(str, this.aHw);
        urlDragImageView.setGifMaxUseableMem(this.aHo);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.aHn);
        urlDragImageView.setHeadImage(this.aHA);
        urlDragImageView.setDragToExitListener(this.aHu);
        return urlDragImageView;
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aHu = dVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.aHp && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.g.image)).setImageDrawable(am.getDrawable(d.f.big_image_next_default));
            ((TextView) inflate.findViewById(d.g.thread_name)).setText(this.aHq);
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
                imageView.LR();
                this.aHz.setCurrentView(imageView);
                if (imageView.getImageType() == 1) {
                    this.aHn.a(imageView);
                }
            }
            urlDragImageView.Gc();
            urlDragImageView.Gb();
            urlDragImageView.i(this.aHw, true);
        }
    }

    private ImageUrlData gb(String str) {
        if (TextUtils.isEmpty(str) || this.aHj == null) {
            return null;
        }
        return this.aHj.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aHw = z;
    }

    public void setIsCdn(boolean z) {
        this.aHv = z;
    }

    public void setHeadImage(boolean z) {
        this.aHA = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.aHx = bVar;
    }
}
