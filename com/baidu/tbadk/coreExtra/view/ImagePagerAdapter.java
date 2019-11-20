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
/* loaded from: classes3.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private Map<String, ImageUrlData> czF;
    private DragImageView.e czJ;
    private b czK;
    private UrlDragImageView.b czL;
    private DragImageView.d czM;
    private boolean czU;
    private boolean czV;
    private boolean czW;
    private Context mContext;
    private ArrayList<String> czG = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener czH = null;
    private DragImageView.g czI = null;
    private int mGifMaxUseableMem = 0;
    private boolean czO = false;
    private String czP = null;
    private int czQ = 0;
    private int czR = 0;
    private boolean czS = false;
    private boolean czT = false;
    private int mPosition = -1;
    private List<a> czN = new ArrayList();

    /* loaded from: classes3.dex */
    public interface a {
        View f(ViewGroup viewGroup, int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void g(int i, Object obj);
    }

    public ImagePagerAdapter(Context context, DragImageView.e eVar) {
        this.mContext = context;
        this.czJ = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.czG = new ArrayList<>();
        } else {
            this.czG = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.czF = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.czP = str;
    }

    public void setHasNext(boolean z) {
        this.czO = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.czN.add(aVar);
    }

    public boolean getHasNext() {
        return this.czO;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.czG != null) {
            i = this.czG.size();
            if (this.czO) {
                i++;
            }
        }
        return i + this.czQ + this.czR;
    }

    public void setTempSize(int i) {
        this.czQ = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.czR = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.czH = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.czI = gVar;
    }

    public void a(b bVar) {
        this.czK = bVar;
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
        View d = d(viewGroup, i);
        if (d == null && this.czN != null && this.czN.size() != 0) {
            Iterator<a> it = this.czN.iterator();
            while (it.hasNext() && (d = it.next().f(viewGroup, i)) == null) {
            }
        }
        if (d == null) {
            return e(viewGroup, i);
        }
        return d;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        UrlDragImageView urlDragImageView;
        ImageUrlData imageUrlData;
        if ((obj instanceof UrlDragImageView) && (imageUrlData = (urlDragImageView = (UrlDragImageView) obj).getmAssistUrlData()) != null && !StringUtils.isNull(imageUrlData.imageUrl)) {
            urlDragImageView.setAssistUrl(pb(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData pb(String str) {
        if (TextUtils.isEmpty(str) || this.czF == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.czF.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.czU = z;
    }

    public void setIsHotSort(boolean z) {
        this.czV = z;
    }

    private UrlDragImageView d(ViewGroup viewGroup, int i) {
        String str = i < this.czG.size() ? this.czG.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.czL);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.czH);
        urlDragImageView.setIsCanDrag(this.czU);
        urlDragImageView.setIsHotSort(this.czV);
        urlDragImageView.setIsCdn(this.czS);
        urlDragImageView.setOnSizeChangedListener(this.czI);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(pc(str));
        urlDragImageView.setUrl(str, this.czT);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.czJ);
        urlDragImageView.setHeadImage(this.czW);
        urlDragImageView.setDragToExitListener(this.czM);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.czM = dVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.czO && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(am.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.czP);
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
            if (this.czK != null) {
                this.czK.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData pc(String str) {
        if (TextUtils.isEmpty(str) || this.czF == null) {
            return null;
        }
        return this.czF.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.czT = z;
    }

    public void setIsCdn(boolean z) {
        this.czS = z;
    }

    public void setHeadImage(boolean z) {
        this.czW = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.czL = bVar;
    }
}
