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
    private Map<String, ImageUrlData> cdd;
    private DragImageView.e cdi;
    private b cdj;
    private UrlDragImageView.b cdk;
    private DragImageView.d cdl;
    private boolean cdu;
    private boolean cdv;
    private boolean cdw;
    private Context mContext;
    private ArrayList<String> cde = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener cdf = null;
    private View.OnTouchListener cdg = null;
    private DragImageView.g cdh = null;
    private int cdn = 0;
    private boolean cdo = false;
    private String cdp = null;
    private int cdq = 0;
    private int cdr = 0;
    private boolean cds = false;
    private boolean cdt = false;
    private int mPosition = -1;
    private List<a> cdm = new ArrayList();

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
        this.cdi = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.cde = new ArrayList<>();
        } else {
            this.cde = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.cdd = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.cdp = str;
    }

    public void setHasNext(boolean z) {
        this.cdo = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.cdm.add(aVar);
    }

    public boolean getHasNext() {
        return this.cdo;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.cde != null) {
            i = this.cde.size();
            if (this.cdo) {
                i++;
            }
        }
        return i + this.cdq + this.cdr;
    }

    public void setTempSize(int i) {
        this.cdq = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.cdr = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.cdg = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdf = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.cdn = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.cdh = gVar;
    }

    public void a(b bVar) {
        this.cdj = bVar;
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
        if (e == null && this.cdm != null && this.cdm.size() != 0) {
            Iterator<a> it = this.cdm.iterator();
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
        if (TextUtils.isEmpty(str) || this.cdd == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.cdd.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.cdu = z;
    }

    public void setIsHotSort(boolean z) {
        this.cdv = z;
    }

    private UrlDragImageView e(ViewGroup viewGroup, int i) {
        String str = i < this.cde.size() ? this.cde.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.cdk);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.cdf);
        urlDragImageView.setOuterOnTouchListener(this.cdg);
        urlDragImageView.setIsCanDrag(this.cdu);
        urlDragImageView.setIsHotSort(this.cdv);
        urlDragImageView.setIsCdn(this.cds);
        urlDragImageView.setOnSizeChangedListener(this.cdh);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(oi(str));
        urlDragImageView.setUrl(str, this.cdt);
        urlDragImageView.setGifMaxUseableMem(this.cdn);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.cdi);
        urlDragImageView.setHeadImage(this.cdw);
        urlDragImageView.setDragToExitListener(this.cdl);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.cdl = dVar;
    }

    private View f(ViewGroup viewGroup, int i) {
        if (this.cdo && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.g.image)).setImageDrawable(al.getDrawable(d.f.big_image_next_default));
            ((TextView) inflate.findViewById(d.g.thread_name)).setText(this.cdp);
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
            if (this.cdj != null) {
                this.cdj.c(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData oi(String str) {
        if (TextUtils.isEmpty(str) || this.cdd == null) {
            return null;
        }
        return this.cdd.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.cdt = z;
    }

    public void setIsCdn(boolean z) {
        this.cds = z;
    }

    public void setHeadImage(boolean z) {
        this.cdw = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.cdk = bVar;
    }
}
