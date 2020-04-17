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
    private Map<String, ImageUrlData> dSe;
    private DragImageView.e dSi;
    private b dSj;
    private UrlDragImageView.b dSk;
    private DragImageView.d dSl;
    private boolean dSt;
    private boolean dSu;
    private Context mContext;
    private ArrayList<String> dSf = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener dSg = null;
    private DragImageView.g dSh = null;
    private int mGifMaxUseableMem = 0;
    private boolean dSn = false;
    private String dSo = null;
    private int dSp = 0;
    private int dSq = 0;
    private boolean dSr = false;
    private boolean dSs = false;
    private int mPosition = -1;
    private List<a> dSm = new ArrayList();

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
        this.dSi = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.dSf = new ArrayList<>();
        } else {
            this.dSf = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.dSe = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.dSo = str;
    }

    public void setHasNext(boolean z) {
        this.dSn = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.dSm.add(aVar);
    }

    public boolean getHasNext() {
        return this.dSn;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.dSf != null) {
            i = this.dSf.size();
            if (this.dSn) {
                i++;
            }
        }
        return i + this.dSp + this.dSq;
    }

    public void setTempSize(int i) {
        this.dSp = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.dSq = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.dSg = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.dSh = gVar;
    }

    public void a(b bVar) {
        this.dSj = bVar;
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
        if (i2 == null && this.dSm != null && this.dSm.size() != 0) {
            Iterator<a> it = this.dSm.iterator();
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
            urlDragImageView.setAssistUrl(vQ(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData vQ(String str) {
        if (TextUtils.isEmpty(str) || this.dSe == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.dSe.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.dSt = z;
    }

    private UrlDragImageView i(ViewGroup viewGroup, int i) {
        String str = i < this.dSf.size() ? this.dSf.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.dSk);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.dSg);
        urlDragImageView.setIsCanDrag(this.dSt);
        urlDragImageView.setIsCdn(this.dSr);
        urlDragImageView.setOnSizeChangedListener(this.dSh);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(vR(str));
        urlDragImageView.setUrl(str, this.dSs);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.dSi);
        urlDragImageView.setHeadImage(this.dSu);
        urlDragImageView.setDragToExitListener(this.dSl);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.dSl = dVar;
    }

    private View j(ViewGroup viewGroup, int i) {
        if (this.dSn && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(am.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.dSo);
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
            if (this.dSj != null) {
                this.dSj.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData vR(String str) {
        if (TextUtils.isEmpty(str) || this.dSe == null) {
            return null;
        }
        return this.dSe.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.dSs = z;
    }

    public void setIsCdn(boolean z) {
        this.dSr = z;
    }

    public void setHeadImage(boolean z) {
        this.dSu = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.dSk = bVar;
    }
}
