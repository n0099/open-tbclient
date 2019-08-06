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
    private Map<String, ImageUrlData> cmD;
    private DragImageView.e cmI;
    private b cmJ;
    private UrlDragImageView.b cmK;
    private DragImageView.d cmL;
    private boolean cmU;
    private boolean cmV;
    private boolean cmW;
    private Context mContext;
    private ArrayList<String> cmE = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener cmF = null;
    private View.OnTouchListener cmG = null;
    private DragImageView.g cmH = null;
    private int cmN = 0;
    private boolean cmO = false;
    private String cmP = null;
    private int cmQ = 0;
    private int cmR = 0;
    private boolean cmS = false;
    private boolean cmT = false;
    private int mPosition = -1;
    private List<a> cmM = new ArrayList();

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
        this.cmI = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.cmE = new ArrayList<>();
        } else {
            this.cmE = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.cmD = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.cmP = str;
    }

    public void setHasNext(boolean z) {
        this.cmO = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.cmM.add(aVar);
    }

    public boolean getHasNext() {
        return this.cmO;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.cmE != null) {
            i = this.cmE.size();
            if (this.cmO) {
                i++;
            }
        }
        return i + this.cmQ + this.cmR;
    }

    public void setTempSize(int i) {
        this.cmQ = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.cmR = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.cmG = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cmF = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.cmN = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.cmH = gVar;
    }

    public void a(b bVar) {
        this.cmJ = bVar;
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
        if (f == null && this.cmM != null && this.cmM.size() != 0) {
            Iterator<a> it = this.cmM.iterator();
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
        if (TextUtils.isEmpty(str) || this.cmD == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.cmD.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.cmU = z;
    }

    public void setIsHotSort(boolean z) {
        this.cmV = z;
    }

    private UrlDragImageView f(ViewGroup viewGroup, int i) {
        String str = i < this.cmE.size() ? this.cmE.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.cmK);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.cmF);
        urlDragImageView.setOuterOnTouchListener(this.cmG);
        urlDragImageView.setIsCanDrag(this.cmU);
        urlDragImageView.setIsHotSort(this.cmV);
        urlDragImageView.setIsCdn(this.cmS);
        urlDragImageView.setOnSizeChangedListener(this.cmH);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(pH(str));
        urlDragImageView.setUrl(str, this.cmT);
        urlDragImageView.setGifMaxUseableMem(this.cmN);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.cmI);
        urlDragImageView.setHeadImage(this.cmW);
        urlDragImageView.setDragToExitListener(this.cmL);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.cmL = dVar;
    }

    private View g(ViewGroup viewGroup, int i) {
        if (this.cmO && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(am.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.cmP);
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
            if (this.cmJ != null) {
                this.cmJ.c(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData pH(String str) {
        if (TextUtils.isEmpty(str) || this.cmD == null) {
            return null;
        }
        return this.cmD.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.cmT = z;
    }

    public void setIsCdn(boolean z) {
        this.cmS = z;
    }

    public void setHeadImage(boolean z) {
        this.cmW = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.cmK = bVar;
    }
}
