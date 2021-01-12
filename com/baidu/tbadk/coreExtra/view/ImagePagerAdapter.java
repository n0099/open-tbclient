package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private Map<String, ImageUrlData> fug;
    private DragImageView.e fuk;
    private b ful;
    private UrlDragImageView.b fum;
    private DragImageView.d fun;
    private boolean fuv;
    private boolean fuw;
    private Context mContext;
    private ArrayList<String> fuh = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener fui = null;
    private DragImageView.g fuj = null;
    private int mGifMaxUseableMem = 0;
    private boolean fup = false;
    private String fuq = null;
    private int fur = 0;
    private int fus = 0;
    private boolean fut = false;
    private boolean fuu = false;
    private int mPosition = -1;
    private List<a> fuo = new ArrayList();

    /* loaded from: classes.dex */
    public interface a {
        View p(ViewGroup viewGroup, int i);
    }

    /* loaded from: classes.dex */
    public interface b {
        void g(int i, Object obj);
    }

    public ImagePagerAdapter(Context context, DragImageView.e eVar) {
        this.mContext = context;
        this.fuk = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.fuh = new ArrayList<>();
        } else {
            this.fuh = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.fug = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.fuq = str;
    }

    public void setHasNext(boolean z) {
        this.fup = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.fuo.add(aVar);
    }

    public boolean getHasNext() {
        return this.fup;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.fuh != null) {
            i = this.fuh.size();
            if (this.fup) {
                i++;
            }
        }
        return i + this.fur + this.fus;
    }

    public void setTempSize(int i) {
        this.fur = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.fus = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.fui = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.fuj = gVar;
    }

    public void a(b bVar) {
        this.ful = bVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        if (obj instanceof UrlDragImageView) {
            ((UrlDragImageView) obj).onDestroy();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View n = n(viewGroup, i);
        if (n == null && this.fuo != null && this.fuo.size() != 0) {
            Iterator<a> it = this.fuo.iterator();
            while (it.hasNext() && (n = it.next().p(viewGroup, i)) == null) {
            }
        }
        if (n == null) {
            return o(viewGroup, i);
        }
        return n;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        UrlDragImageView urlDragImageView;
        ImageUrlData imageUrlData;
        if ((obj instanceof UrlDragImageView) && (imageUrlData = (urlDragImageView = (UrlDragImageView) obj).getmAssistUrlData()) != null && !StringUtils.isNull(imageUrlData.imageUrl)) {
            urlDragImageView.setAssistUrl(BX(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData BX(String str) {
        if (TextUtils.isEmpty(str) || this.fug == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.fug.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.fuv = z;
    }

    private UrlDragImageView n(ViewGroup viewGroup, int i) {
        String str = i < this.fuh.size() ? this.fuh.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.fum);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.fui);
        urlDragImageView.setIsCanDrag(this.fuv);
        urlDragImageView.setIsCdn(this.fut);
        urlDragImageView.setOnSizeChangedListener(this.fuj);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(BY(str));
        urlDragImageView.setUrl(str, this.fuu);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.fuk);
        urlDragImageView.setHeadImage(this.fuw);
        urlDragImageView.setDragToExitListener(this.fun);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.fun = dVar;
    }

    private View o(ViewGroup viewGroup, int i) {
        if (this.fup && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(ao.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.fuq);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.mPosition != i && obj != null) {
            if (this.ful != null) {
                this.ful.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData BY(String str) {
        if (TextUtils.isEmpty(str) || this.fug == null) {
            return null;
        }
        return this.fug.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.fuu = z;
    }

    public void setIsCdn(boolean z) {
        this.fut = z;
    }

    public void setHeadImage(boolean z) {
        this.fuw = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.fum = bVar;
    }
}
