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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes21.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private Map<String, ImageUrlData> fcI;
    private DragImageView.e fcM;
    private b fcN;
    private UrlDragImageView.b fcO;
    private DragImageView.d fcP;
    private boolean fcX;
    private boolean fcY;
    private Context mContext;
    private ArrayList<String> fcJ = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener fcK = null;
    private DragImageView.g fcL = null;
    private int mGifMaxUseableMem = 0;
    private boolean fcR = false;
    private String fcS = null;
    private int fcT = 0;
    private int fcU = 0;
    private boolean fcV = false;
    private boolean fcW = false;
    private int mPosition = -1;
    private List<a> fcQ = new ArrayList();

    /* loaded from: classes21.dex */
    public interface a {
        View l(ViewGroup viewGroup, int i);
    }

    /* loaded from: classes21.dex */
    public interface b {
        void h(int i, Object obj);
    }

    public ImagePagerAdapter(Context context, DragImageView.e eVar) {
        this.mContext = context;
        this.fcM = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.fcJ = new ArrayList<>();
        } else {
            this.fcJ = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.fcI = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.fcS = str;
    }

    public void setHasNext(boolean z) {
        this.fcR = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.fcQ.add(aVar);
    }

    public boolean getHasNext() {
        return this.fcR;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.fcJ != null) {
            i = this.fcJ.size();
            if (this.fcR) {
                i++;
            }
        }
        return i + this.fcT + this.fcU;
    }

    public void setTempSize(int i) {
        this.fcT = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.fcU = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.fcK = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.fcL = gVar;
    }

    public void a(b bVar) {
        this.fcN = bVar;
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
        View j = j(viewGroup, i);
        if (j == null && this.fcQ != null && this.fcQ.size() != 0) {
            Iterator<a> it = this.fcQ.iterator();
            while (it.hasNext() && (j = it.next().l(viewGroup, i)) == null) {
            }
        }
        if (j == null) {
            return k(viewGroup, i);
        }
        return j;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        UrlDragImageView urlDragImageView;
        ImageUrlData imageUrlData;
        if ((obj instanceof UrlDragImageView) && (imageUrlData = (urlDragImageView = (UrlDragImageView) obj).getmAssistUrlData()) != null && !StringUtils.isNull(imageUrlData.imageUrl)) {
            urlDragImageView.setAssistUrl(CQ(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData CQ(String str) {
        if (TextUtils.isEmpty(str) || this.fcI == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.fcI.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.fcX = z;
    }

    private UrlDragImageView j(ViewGroup viewGroup, int i) {
        String str = i < this.fcJ.size() ? this.fcJ.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.fcO);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.fcK);
        urlDragImageView.setIsCanDrag(this.fcX);
        urlDragImageView.setIsCdn(this.fcV);
        urlDragImageView.setOnSizeChangedListener(this.fcL);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(CR(str));
        urlDragImageView.setUrl(str, this.fcW);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.fcM);
        urlDragImageView.setHeadImage(this.fcY);
        urlDragImageView.setDragToExitListener(this.fcP);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.fcP = dVar;
    }

    private View k(ViewGroup viewGroup, int i) {
        if (this.fcR && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(ap.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.fcS);
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
            if (this.fcN != null) {
                this.fcN.h(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData CR(String str) {
        if (TextUtils.isEmpty(str) || this.fcI == null) {
            return null;
        }
        return this.fcI.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.fcW = z;
    }

    public void setIsCdn(boolean z) {
        this.fcV = z;
    }

    public void setHeadImage(boolean z) {
        this.fcY = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.fcO = bVar;
    }
}
