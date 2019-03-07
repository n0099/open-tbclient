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
    private Map<String, ImageUrlData> cdb;
    private DragImageView.e cdg;
    private b cdh;
    private UrlDragImageView.b cdi;
    private DragImageView.d cdj;
    private boolean cds;
    private boolean cdt;
    private boolean cdu;
    private Context mContext;
    private ArrayList<String> cdc = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener cdd = null;
    private View.OnTouchListener cde = null;
    private DragImageView.g cdf = null;
    private int cdl = 0;
    private boolean cdm = false;
    private String cdn = null;
    private int cdo = 0;
    private int cdp = 0;
    private boolean cdq = false;
    private boolean cdr = false;
    private int mPosition = -1;
    private List<a> cdk = new ArrayList();

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
        this.cdg = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.cdc = new ArrayList<>();
        } else {
            this.cdc = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.cdb = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.cdn = str;
    }

    public void setHasNext(boolean z) {
        this.cdm = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.cdk.add(aVar);
    }

    public boolean getHasNext() {
        return this.cdm;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.cdc != null) {
            i = this.cdc.size();
            if (this.cdm) {
                i++;
            }
        }
        return i + this.cdo + this.cdp;
    }

    public void setTempSize(int i) {
        this.cdo = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.cdp = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.cde = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdd = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.cdl = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.cdf = gVar;
    }

    public void a(b bVar) {
        this.cdh = bVar;
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
        if (e == null && this.cdk != null && this.cdk.size() != 0) {
            Iterator<a> it = this.cdk.iterator();
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
            urlDragImageView.setAssistUrl(og(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData og(String str) {
        if (TextUtils.isEmpty(str) || this.cdb == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.cdb.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.cds = z;
    }

    public void setIsHotSort(boolean z) {
        this.cdt = z;
    }

    private UrlDragImageView e(ViewGroup viewGroup, int i) {
        String str = i < this.cdc.size() ? this.cdc.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.cdi);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.cdd);
        urlDragImageView.setOuterOnTouchListener(this.cde);
        urlDragImageView.setIsCanDrag(this.cds);
        urlDragImageView.setIsHotSort(this.cdt);
        urlDragImageView.setIsCdn(this.cdq);
        urlDragImageView.setOnSizeChangedListener(this.cdf);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(oh(str));
        urlDragImageView.setUrl(str, this.cdr);
        urlDragImageView.setGifMaxUseableMem(this.cdl);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.cdg);
        urlDragImageView.setHeadImage(this.cdu);
        urlDragImageView.setDragToExitListener(this.cdj);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.cdj = dVar;
    }

    private View f(ViewGroup viewGroup, int i) {
        if (this.cdm && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.g.image)).setImageDrawable(al.getDrawable(d.f.big_image_next_default));
            ((TextView) inflate.findViewById(d.g.thread_name)).setText(this.cdn);
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
            if (this.cdh != null) {
                this.cdh.c(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData oh(String str) {
        if (TextUtils.isEmpty(str) || this.cdb == null) {
            return null;
        }
        return this.cdb.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.cdr = z;
    }

    public void setIsCdn(boolean z) {
        this.cdq = z;
    }

    public void setHeadImage(boolean z) {
        this.cdu = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.cdi = bVar;
    }
}
