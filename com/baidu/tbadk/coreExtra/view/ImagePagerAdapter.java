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
    private DragImageView.e cmB;
    private b cmC;
    private UrlDragImageView.b cmD;
    private DragImageView.d cmE;
    private boolean cmN;
    private boolean cmO;
    private boolean cmP;
    private Map<String, ImageUrlData> cmw;
    private Context mContext;
    private ArrayList<String> cmx = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener cmy = null;
    private View.OnTouchListener cmz = null;
    private DragImageView.g cmA = null;
    private int cmG = 0;
    private boolean cmH = false;
    private String cmI = null;
    private int cmJ = 0;
    private int cmK = 0;
    private boolean cmL = false;
    private boolean cmM = false;
    private int mPosition = -1;
    private List<a> cmF = new ArrayList();

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
        this.cmB = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.cmx = new ArrayList<>();
        } else {
            this.cmx = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.cmw = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.cmI = str;
    }

    public void setHasNext(boolean z) {
        this.cmH = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.cmF.add(aVar);
    }

    public boolean getHasNext() {
        return this.cmH;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.cmx != null) {
            i = this.cmx.size();
            if (this.cmH) {
                i++;
            }
        }
        return i + this.cmJ + this.cmK;
    }

    public void setTempSize(int i) {
        this.cmJ = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.cmK = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.cmz = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cmy = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.cmG = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.cmA = gVar;
    }

    public void a(b bVar) {
        this.cmC = bVar;
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
        if (f == null && this.cmF != null && this.cmF.size() != 0) {
            Iterator<a> it = this.cmF.iterator();
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
            urlDragImageView.setAssistUrl(pG(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData pG(String str) {
        if (TextUtils.isEmpty(str) || this.cmw == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.cmw.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.cmN = z;
    }

    public void setIsHotSort(boolean z) {
        this.cmO = z;
    }

    private UrlDragImageView f(ViewGroup viewGroup, int i) {
        String str = i < this.cmx.size() ? this.cmx.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.cmD);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.cmy);
        urlDragImageView.setOuterOnTouchListener(this.cmz);
        urlDragImageView.setIsCanDrag(this.cmN);
        urlDragImageView.setIsHotSort(this.cmO);
        urlDragImageView.setIsCdn(this.cmL);
        urlDragImageView.setOnSizeChangedListener(this.cmA);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(pH(str));
        urlDragImageView.setUrl(str, this.cmM);
        urlDragImageView.setGifMaxUseableMem(this.cmG);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.cmB);
        urlDragImageView.setHeadImage(this.cmP);
        urlDragImageView.setDragToExitListener(this.cmE);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.cmE = dVar;
    }

    private View g(ViewGroup viewGroup, int i) {
        if (this.cmH && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(am.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.cmI);
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
            if (this.cmC != null) {
                this.cmC.c(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData pH(String str) {
        if (TextUtils.isEmpty(str) || this.cmw == null) {
            return null;
        }
        return this.cmw.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.cmM = z;
    }

    public void setIsCdn(boolean z) {
        this.cmL = z;
    }

    public void setHeadImage(boolean z) {
        this.cmP = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.cmD = bVar;
    }
}
