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
/* loaded from: classes3.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private Map<String, ImageUrlData> cde;
    private DragImageView.e cdj;
    private b cdk;
    private UrlDragImageView.b cdl;
    private DragImageView.d cdm;
    private boolean cdv;
    private boolean cdw;
    private boolean cdx;
    private Context mContext;
    private ArrayList<String> cdf = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener cdg = null;
    private View.OnTouchListener cdh = null;
    private DragImageView.g cdi = null;
    private int cdo = 0;
    private boolean cdp = false;
    private String cdq = null;
    private int cdr = 0;
    private int cds = 0;
    private boolean cdt = false;
    private boolean cdu = false;
    private int mPosition = -1;
    private List<a> cdn = new ArrayList();

    /* loaded from: classes3.dex */
    public interface a {
        View g(ViewGroup viewGroup, int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void c(int i, Object obj);
    }

    public ImagePagerAdapter(Context context, DragImageView.e eVar) {
        this.mContext = context;
        this.cdj = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.cdf = new ArrayList<>();
        } else {
            this.cdf = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.cde = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.cdq = str;
    }

    public void setHasNext(boolean z) {
        this.cdp = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.cdn.add(aVar);
    }

    public boolean getHasNext() {
        return this.cdp;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.cdf != null) {
            i = this.cdf.size();
            if (this.cdp) {
                i++;
            }
        }
        return i + this.cdr + this.cds;
    }

    public void setTempSize(int i) {
        this.cdr = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.cds = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.cdh = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdg = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.cdo = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.cdi = gVar;
    }

    public void a(b bVar) {
        this.cdk = bVar;
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
        if (e == null && this.cdn != null && this.cdn.size() != 0) {
            Iterator<a> it = this.cdn.iterator();
            while (it.hasNext() && (e = it.next().g(viewGroup, i)) == null) {
            }
        }
        if (e == null) {
            return f(viewGroup, i);
        }
        return e;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        UrlDragImageView urlDragImageView;
        ImageUrlData imageUrlData;
        if ((obj instanceof UrlDragImageView) && (imageUrlData = (urlDragImageView = (UrlDragImageView) obj).getmAssistUrlData()) != null && !StringUtils.isNull(imageUrlData.imageUrl)) {
            urlDragImageView.setAssistUrl(oh(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData oh(String str) {
        if (TextUtils.isEmpty(str) || this.cde == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.cde.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.cdv = z;
    }

    public void setIsHotSort(boolean z) {
        this.cdw = z;
    }

    private UrlDragImageView e(ViewGroup viewGroup, int i) {
        String str = i < this.cdf.size() ? this.cdf.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.cdl);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.cdg);
        urlDragImageView.setOuterOnTouchListener(this.cdh);
        urlDragImageView.setIsCanDrag(this.cdv);
        urlDragImageView.setIsHotSort(this.cdw);
        urlDragImageView.setIsCdn(this.cdt);
        urlDragImageView.setOnSizeChangedListener(this.cdi);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(oi(str));
        urlDragImageView.setUrl(str, this.cdu);
        urlDragImageView.setGifMaxUseableMem(this.cdo);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.cdj);
        urlDragImageView.setHeadImage(this.cdx);
        urlDragImageView.setDragToExitListener(this.cdm);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.cdm = dVar;
    }

    private View f(ViewGroup viewGroup, int i) {
        if (this.cdp && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.g.image)).setImageDrawable(al.getDrawable(d.f.big_image_next_default));
            ((TextView) inflate.findViewById(d.g.thread_name)).setText(this.cdq);
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
            if (this.cdk != null) {
                this.cdk.c(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData oi(String str) {
        if (TextUtils.isEmpty(str) || this.cde == null) {
            return null;
        }
        return this.cde.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.cdu = z;
    }

    public void setIsCdn(boolean z) {
        this.cdt = z;
    }

    public void setHeadImage(boolean z) {
        this.cdx = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.cdl = bVar;
    }
}
