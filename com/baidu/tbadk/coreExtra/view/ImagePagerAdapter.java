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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private boolean clA;
    private boolean clB;
    private boolean clC;
    private Map<String, ImageUrlData> clj;
    private DragImageView.e clo;
    private b clp;
    private UrlDragImageView.b clq;
    private DragImageView.d clr;
    private Context mContext;
    private ArrayList<String> clk = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener cll = null;
    private View.OnTouchListener clm = null;
    private DragImageView.g cln = null;
    private int clt = 0;
    private boolean clu = false;
    private String clv = null;
    private int clw = 0;
    private int clx = 0;
    private boolean cly = false;
    private boolean clz = false;
    private int mPosition = -1;
    private List<a> cls = new ArrayList();

    /* loaded from: classes3.dex */
    public interface a {
        View h(ViewGroup viewGroup, int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void c(int i, Object obj);
    }

    public ImagePagerAdapter(Context context, DragImageView.e eVar) {
        this.mContext = context;
        this.clo = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.clk = new ArrayList<>();
        } else {
            this.clk = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.clj = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.clv = str;
    }

    public void setHasNext(boolean z) {
        this.clu = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.cls.add(aVar);
    }

    public boolean getHasNext() {
        return this.clu;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.clk != null) {
            i = this.clk.size();
            if (this.clu) {
                i++;
            }
        }
        return i + this.clw + this.clx;
    }

    public void setTempSize(int i) {
        this.clw = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.clx = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.clm = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cll = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.clt = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.cln = gVar;
    }

    public void a(b bVar) {
        this.clp = bVar;
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
        View f = f(viewGroup, i);
        if (f == null && this.cls != null && this.cls.size() != 0) {
            Iterator<a> it = this.cls.iterator();
            while (it.hasNext() && (f = it.next().h(viewGroup, i)) == null) {
            }
        }
        if (f == null) {
            return g(viewGroup, i);
        }
        return f;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        UrlDragImageView urlDragImageView;
        ImageUrlData imageUrlData;
        if ((obj instanceof UrlDragImageView) && (imageUrlData = (urlDragImageView = (UrlDragImageView) obj).getmAssistUrlData()) != null && !StringUtils.isNull(imageUrlData.imageUrl)) {
            urlDragImageView.setAssistUrl(pp(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData pp(String str) {
        if (TextUtils.isEmpty(str) || this.clj == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.clj.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.clA = z;
    }

    public void setIsHotSort(boolean z) {
        this.clB = z;
    }

    private UrlDragImageView f(ViewGroup viewGroup, int i) {
        String str = i < this.clk.size() ? this.clk.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.clq);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.cll);
        urlDragImageView.setOuterOnTouchListener(this.clm);
        urlDragImageView.setIsCanDrag(this.clA);
        urlDragImageView.setIsHotSort(this.clB);
        urlDragImageView.setIsCdn(this.cly);
        urlDragImageView.setOnSizeChangedListener(this.cln);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(pq(str));
        urlDragImageView.setUrl(str, this.clz);
        urlDragImageView.setGifMaxUseableMem(this.clt);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.clo);
        urlDragImageView.setHeadImage(this.clC);
        urlDragImageView.setDragToExitListener(this.clr);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.clr = dVar;
    }

    private View g(ViewGroup viewGroup, int i) {
        if (this.clu && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(al.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.clv);
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
            if (this.clp != null) {
                this.clp.c(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData pq(String str) {
        if (TextUtils.isEmpty(str) || this.clj == null) {
            return null;
        }
        return this.clj.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.clz = z;
    }

    public void setIsCdn(boolean z) {
        this.cly = z;
    }

    public void setHeadImage(boolean z) {
        this.clC = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.clq = bVar;
    }
}
