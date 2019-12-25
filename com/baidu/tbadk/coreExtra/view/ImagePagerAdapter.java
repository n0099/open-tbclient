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
/* loaded from: classes5.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private boolean dnC;
    private boolean dnD;
    private Map<String, ImageUrlData> dnm;
    private DragImageView.e dnq;
    private b dnr;
    private UrlDragImageView.b dnt;
    private DragImageView.d dnu;
    private Context mContext;
    private ArrayList<String> dnn = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener dno = null;
    private DragImageView.g dnp = null;
    private int mGifMaxUseableMem = 0;
    private boolean dnw = false;
    private String dnx = null;
    private int dny = 0;
    private int dnz = 0;
    private boolean dnA = false;
    private boolean dnB = false;
    private int mPosition = -1;
    private List<a> dnv = new ArrayList();

    /* loaded from: classes5.dex */
    public interface a {
        View k(ViewGroup viewGroup, int i);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void g(int i, Object obj);
    }

    public ImagePagerAdapter(Context context, DragImageView.e eVar) {
        this.mContext = context;
        this.dnq = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.dnn = new ArrayList<>();
        } else {
            this.dnn = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.dnm = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.dnx = str;
    }

    public void setHasNext(boolean z) {
        this.dnw = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.dnv.add(aVar);
    }

    public boolean getHasNext() {
        return this.dnw;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.dnn != null) {
            i = this.dnn.size();
            if (this.dnw) {
                i++;
            }
        }
        return i + this.dny + this.dnz;
    }

    public void setTempSize(int i) {
        this.dny = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.dnz = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.dno = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.dnp = gVar;
    }

    public void a(b bVar) {
        this.dnr = bVar;
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
        if (i2 == null && this.dnv != null && this.dnv.size() != 0) {
            Iterator<a> it = this.dnv.iterator();
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
            urlDragImageView.setAssistUrl(uf(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData uf(String str) {
        if (TextUtils.isEmpty(str) || this.dnm == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.dnm.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.dnC = z;
    }

    private UrlDragImageView i(ViewGroup viewGroup, int i) {
        String str = i < this.dnn.size() ? this.dnn.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.dnt);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.dno);
        urlDragImageView.setIsCanDrag(this.dnC);
        urlDragImageView.setIsCdn(this.dnA);
        urlDragImageView.setOnSizeChangedListener(this.dnp);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(ug(str));
        urlDragImageView.setUrl(str, this.dnB);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.dnq);
        urlDragImageView.setHeadImage(this.dnD);
        urlDragImageView.setDragToExitListener(this.dnu);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.dnu = dVar;
    }

    private View j(ViewGroup viewGroup, int i) {
        if (this.dnw && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(am.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.dnx);
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
            if (this.dnr != null) {
                this.dnr.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData ug(String str) {
        if (TextUtils.isEmpty(str) || this.dnm == null) {
            return null;
        }
        return this.dnm.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.dnB = z;
    }

    public void setIsCdn(boolean z) {
        this.dnA = z;
    }

    public void setHeadImage(boolean z) {
        this.dnD = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.dnt = bVar;
    }
}
