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
    private DragImageView.e cAA;
    private b cAB;
    private UrlDragImageView.b cAC;
    private DragImageView.d cAD;
    private boolean cAL;
    private boolean cAM;
    private boolean cAN;
    private Map<String, ImageUrlData> cAw;
    private Context mContext;
    private ArrayList<String> cAx = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener cAy = null;
    private DragImageView.g cAz = null;
    private int mGifMaxUseableMem = 0;
    private boolean cAF = false;
    private String cAG = null;
    private int cAH = 0;
    private int cAI = 0;
    private boolean cAJ = false;
    private boolean cAK = false;
    private int mPosition = -1;
    private List<a> cAE = new ArrayList();

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
        this.cAA = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.cAx = new ArrayList<>();
        } else {
            this.cAx = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.cAw = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.cAG = str;
    }

    public void setHasNext(boolean z) {
        this.cAF = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.cAE.add(aVar);
    }

    public boolean getHasNext() {
        return this.cAF;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.cAx != null) {
            i = this.cAx.size();
            if (this.cAF) {
                i++;
            }
        }
        return i + this.cAH + this.cAI;
    }

    public void setTempSize(int i) {
        this.cAH = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.cAI = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.cAy = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.cAz = gVar;
    }

    public void a(b bVar) {
        this.cAB = bVar;
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
        if (d == null && this.cAE != null && this.cAE.size() != 0) {
            Iterator<a> it = this.cAE.iterator();
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
        if (TextUtils.isEmpty(str) || this.cAw == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.cAw.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.cAL = z;
    }

    public void setIsHotSort(boolean z) {
        this.cAM = z;
    }

    private UrlDragImageView d(ViewGroup viewGroup, int i) {
        String str = i < this.cAx.size() ? this.cAx.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.cAC);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.cAy);
        urlDragImageView.setIsCanDrag(this.cAL);
        urlDragImageView.setIsHotSort(this.cAM);
        urlDragImageView.setIsCdn(this.cAJ);
        urlDragImageView.setOnSizeChangedListener(this.cAz);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(pc(str));
        urlDragImageView.setUrl(str, this.cAK);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.cAA);
        urlDragImageView.setHeadImage(this.cAN);
        urlDragImageView.setDragToExitListener(this.cAD);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.cAD = dVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.cAF && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(am.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.cAG);
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
            if (this.cAB != null) {
                this.cAB.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData pc(String str) {
        if (TextUtils.isEmpty(str) || this.cAw == null) {
            return null;
        }
        return this.cAw.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.cAK = z;
    }

    public void setIsCdn(boolean z) {
        this.cAJ = z;
    }

    public void setHeadImage(boolean z) {
        this.cAN = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.cAC = bVar;
    }
}
