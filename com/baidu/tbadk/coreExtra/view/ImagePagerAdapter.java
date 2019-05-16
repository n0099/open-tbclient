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
    private Map<String, ImageUrlData> cli;
    private DragImageView.e cln;
    private b clo;
    private UrlDragImageView.b clp;
    private DragImageView.d clq;
    private boolean clz;
    private Context mContext;
    private ArrayList<String> clj = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener clk = null;
    private View.OnTouchListener cll = null;
    private DragImageView.g clm = null;
    private int cls = 0;
    private boolean clt = false;
    private String clu = null;
    private int clv = 0;
    private int clw = 0;
    private boolean clx = false;
    private boolean cly = false;
    private int mPosition = -1;
    private List<a> clr = new ArrayList();

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
        this.cln = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.clj = new ArrayList<>();
        } else {
            this.clj = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.cli = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.clu = str;
    }

    public void setHasNext(boolean z) {
        this.clt = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.clr.add(aVar);
    }

    public boolean getHasNext() {
        return this.clt;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.clj != null) {
            i = this.clj.size();
            if (this.clt) {
                i++;
            }
        }
        return i + this.clv + this.clw;
    }

    public void setTempSize(int i) {
        this.clv = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.clw = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.cll = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.clk = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.cls = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.clm = gVar;
    }

    public void a(b bVar) {
        this.clo = bVar;
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
        if (f == null && this.clr != null && this.clr.size() != 0) {
            Iterator<a> it = this.clr.iterator();
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
            urlDragImageView.setAssistUrl(pq(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData pq(String str) {
        if (TextUtils.isEmpty(str) || this.cli == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.cli.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.clz = z;
    }

    public void setIsHotSort(boolean z) {
        this.clA = z;
    }

    private UrlDragImageView f(ViewGroup viewGroup, int i) {
        String str = i < this.clj.size() ? this.clj.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.clp);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.clk);
        urlDragImageView.setOuterOnTouchListener(this.cll);
        urlDragImageView.setIsCanDrag(this.clz);
        urlDragImageView.setIsHotSort(this.clA);
        urlDragImageView.setIsCdn(this.clx);
        urlDragImageView.setOnSizeChangedListener(this.clm);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(pr(str));
        urlDragImageView.setUrl(str, this.cly);
        urlDragImageView.setGifMaxUseableMem(this.cls);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.cln);
        urlDragImageView.setHeadImage(this.clB);
        urlDragImageView.setDragToExitListener(this.clq);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.clq = dVar;
    }

    private View g(ViewGroup viewGroup, int i) {
        if (this.clt && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(al.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.clu);
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
            if (this.clo != null) {
                this.clo.c(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData pr(String str) {
        if (TextUtils.isEmpty(str) || this.cli == null) {
            return null;
        }
        return this.cli.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.cly = z;
    }

    public void setIsCdn(boolean z) {
        this.clx = z;
    }

    public void setHeadImage(boolean z) {
        this.clB = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.clp = bVar;
    }
}
