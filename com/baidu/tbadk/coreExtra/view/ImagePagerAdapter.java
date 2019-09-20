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
    private DragImageView.e cnE;
    private b cnF;
    private UrlDragImageView.b cnG;
    private DragImageView.d cnH;
    private boolean cnQ;
    private boolean cnR;
    private boolean cnS;
    private Map<String, ImageUrlData> cnz;
    private Context mContext;
    private ArrayList<String> cnA = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener cnB = null;
    private View.OnTouchListener cnC = null;
    private DragImageView.g cnD = null;
    private int cnJ = 0;
    private boolean cnK = false;
    private String cnL = null;
    private int cnM = 0;
    private int cnN = 0;
    private boolean cnO = false;
    private boolean cnP = false;
    private int mPosition = -1;
    private List<a> cnI = new ArrayList();

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
        this.cnE = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.cnA = new ArrayList<>();
        } else {
            this.cnA = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.cnz = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.cnL = str;
    }

    public void setHasNext(boolean z) {
        this.cnK = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.cnI.add(aVar);
    }

    public boolean getHasNext() {
        return this.cnK;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.cnA != null) {
            i = this.cnA.size();
            if (this.cnK) {
                i++;
            }
        }
        return i + this.cnM + this.cnN;
    }

    public void setTempSize(int i) {
        this.cnM = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.cnN = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.cnC = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cnB = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.cnJ = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.cnD = gVar;
    }

    public void a(b bVar) {
        this.cnF = bVar;
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
        if (f == null && this.cnI != null && this.cnI.size() != 0) {
            Iterator<a> it = this.cnI.iterator();
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
            urlDragImageView.setAssistUrl(pR(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData pR(String str) {
        if (TextUtils.isEmpty(str) || this.cnz == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.cnz.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.cnQ = z;
    }

    public void setIsHotSort(boolean z) {
        this.cnR = z;
    }

    private UrlDragImageView f(ViewGroup viewGroup, int i) {
        String str = i < this.cnA.size() ? this.cnA.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.cnG);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.cnB);
        urlDragImageView.setOuterOnTouchListener(this.cnC);
        urlDragImageView.setIsCanDrag(this.cnQ);
        urlDragImageView.setIsHotSort(this.cnR);
        urlDragImageView.setIsCdn(this.cnO);
        urlDragImageView.setOnSizeChangedListener(this.cnD);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(pS(str));
        urlDragImageView.setUrl(str, this.cnP);
        urlDragImageView.setGifMaxUseableMem(this.cnJ);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.cnE);
        urlDragImageView.setHeadImage(this.cnS);
        urlDragImageView.setDragToExitListener(this.cnH);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.cnH = dVar;
    }

    private View g(ViewGroup viewGroup, int i) {
        if (this.cnK && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(am.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.cnL);
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
            if (this.cnF != null) {
                this.cnF.c(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData pS(String str) {
        if (TextUtils.isEmpty(str) || this.cnz == null) {
            return null;
        }
        return this.cnz.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.cnP = z;
    }

    public void setIsCdn(boolean z) {
        this.cnO = z;
    }

    public void setHeadImage(boolean z) {
        this.cnS = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.cnG = bVar;
    }
}
