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
    private Map<String, ImageUrlData> dSj;
    private DragImageView.e dSn;
    private b dSo;
    private UrlDragImageView.b dSp;
    private DragImageView.d dSq;
    private boolean dSy;
    private boolean dSz;
    private Context mContext;
    private ArrayList<String> dSk = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener dSl = null;
    private DragImageView.g dSm = null;
    private int mGifMaxUseableMem = 0;
    private boolean dSs = false;
    private String dSt = null;
    private int dSu = 0;
    private int dSv = 0;
    private boolean dSw = false;
    private boolean dSx = false;
    private int mPosition = -1;
    private List<a> dSr = new ArrayList();

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
        this.dSn = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.dSk = new ArrayList<>();
        } else {
            this.dSk = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.dSj = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.dSt = str;
    }

    public void setHasNext(boolean z) {
        this.dSs = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.dSr.add(aVar);
    }

    public boolean getHasNext() {
        return this.dSs;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.dSk != null) {
            i = this.dSk.size();
            if (this.dSs) {
                i++;
            }
        }
        return i + this.dSu + this.dSv;
    }

    public void setTempSize(int i) {
        this.dSu = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.dSv = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.dSl = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.dSm = gVar;
    }

    public void a(b bVar) {
        this.dSo = bVar;
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
        if (i2 == null && this.dSr != null && this.dSr.size() != 0) {
            Iterator<a> it = this.dSr.iterator();
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
            urlDragImageView.setAssistUrl(vT(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData vT(String str) {
        if (TextUtils.isEmpty(str) || this.dSj == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.dSj.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.dSy = z;
    }

    private UrlDragImageView i(ViewGroup viewGroup, int i) {
        String str = i < this.dSk.size() ? this.dSk.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.dSp);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.dSl);
        urlDragImageView.setIsCanDrag(this.dSy);
        urlDragImageView.setIsCdn(this.dSw);
        urlDragImageView.setOnSizeChangedListener(this.dSm);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(vU(str));
        urlDragImageView.setUrl(str, this.dSx);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.dSn);
        urlDragImageView.setHeadImage(this.dSz);
        urlDragImageView.setDragToExitListener(this.dSq);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.dSq = dVar;
    }

    private View j(ViewGroup viewGroup, int i) {
        if (this.dSs && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(am.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.dSt);
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
            if (this.dSo != null) {
                this.dSo.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData vU(String str) {
        if (TextUtils.isEmpty(str) || this.dSj == null) {
            return null;
        }
        return this.dSj.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.dSx = z;
    }

    public void setIsCdn(boolean z) {
        this.dSw = z;
    }

    public void setHeadImage(boolean z) {
        this.dSz = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.dSp = bVar;
    }
}
