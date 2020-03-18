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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private Map<String, ImageUrlData> dsi;
    private DragImageView.e dsm;
    private b dsn;
    private UrlDragImageView.b dso;
    private DragImageView.d dsp;
    private boolean dsy;
    private boolean dsz;
    private Context mContext;
    private ArrayList<String> dsj = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener dsk = null;
    private DragImageView.g dsl = null;
    private int mGifMaxUseableMem = 0;
    private boolean dsr = false;
    private String dss = null;
    private int dsu = 0;
    private int dsv = 0;
    private boolean dsw = false;
    private boolean dsx = false;
    private int mPosition = -1;
    private List<a> dsq = new ArrayList();

    /* loaded from: classes8.dex */
    public interface a {
        View k(ViewGroup viewGroup, int i);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void g(int i, Object obj);
    }

    public ImagePagerAdapter(Context context, DragImageView.e eVar) {
        this.mContext = context;
        this.dsm = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.dsj = new ArrayList<>();
        } else {
            this.dsj = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.dsi = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.dss = str;
    }

    public void setHasNext(boolean z) {
        this.dsr = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.dsq.add(aVar);
    }

    public boolean getHasNext() {
        return this.dsr;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.dsj != null) {
            i = this.dsj.size();
            if (this.dsr) {
                i++;
            }
        }
        return i + this.dsu + this.dsv;
    }

    public void setTempSize(int i) {
        this.dsu = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.dsv = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.dsk = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.dsl = gVar;
    }

    public void a(b bVar) {
        this.dsn = bVar;
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
        View i2 = i(viewGroup, i);
        if (i2 == null && this.dsq != null && this.dsq.size() != 0) {
            Iterator<a> it = this.dsq.iterator();
            while (it.hasNext() && (i2 = it.next().k(viewGroup, i)) == null) {
            }
        }
        if (i2 == null) {
            return j(viewGroup, i);
        }
        return i2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        UrlDragImageView urlDragImageView;
        ImageUrlData imageUrlData;
        if ((obj instanceof UrlDragImageView) && (imageUrlData = (urlDragImageView = (UrlDragImageView) obj).getmAssistUrlData()) != null && !StringUtils.isNull(imageUrlData.imageUrl)) {
            urlDragImageView.setAssistUrl(uB(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData uB(String str) {
        if (TextUtils.isEmpty(str) || this.dsi == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.dsi.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.dsy = z;
    }

    private UrlDragImageView i(ViewGroup viewGroup, int i) {
        String str = i < this.dsj.size() ? this.dsj.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.dso);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.dsk);
        urlDragImageView.setIsCanDrag(this.dsy);
        urlDragImageView.setIsCdn(this.dsw);
        urlDragImageView.setOnSizeChangedListener(this.dsl);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(uC(str));
        urlDragImageView.setUrl(str, this.dsx);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.dsm);
        urlDragImageView.setHeadImage(this.dsz);
        urlDragImageView.setDragToExitListener(this.dsp);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.dsp = dVar;
    }

    private View j(ViewGroup viewGroup, int i) {
        if (this.dsr && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(am.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.dss);
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
            if (this.dsn != null) {
                this.dsn.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData uC(String str) {
        if (TextUtils.isEmpty(str) || this.dsi == null) {
            return null;
        }
        return this.dsi.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.dsx = z;
    }

    public void setIsCdn(boolean z) {
        this.dsw = z;
    }

    public void setHeadImage(boolean z) {
        this.dsz = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.dso = bVar;
    }
}
