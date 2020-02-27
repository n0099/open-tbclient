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
    private Map<String, ImageUrlData> drH;
    private DragImageView.e drL;
    private b drM;
    private UrlDragImageView.b drN;
    private DragImageView.d drO;
    private boolean drW;
    private boolean drX;
    private Context mContext;
    private ArrayList<String> drI = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener drJ = null;
    private DragImageView.g drK = null;
    private int mGifMaxUseableMem = 0;
    private boolean drQ = false;
    private String drR = null;
    private int drS = 0;
    private int drT = 0;
    private boolean drU = false;
    private boolean drV = false;
    private int mPosition = -1;
    private List<a> drP = new ArrayList();

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
        this.drL = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.drI = new ArrayList<>();
        } else {
            this.drI = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.drH = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.drR = str;
    }

    public void setHasNext(boolean z) {
        this.drQ = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.drP.add(aVar);
    }

    public boolean getHasNext() {
        return this.drQ;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.drI != null) {
            i = this.drI.size();
            if (this.drQ) {
                i++;
            }
        }
        return i + this.drS + this.drT;
    }

    public void setTempSize(int i) {
        this.drS = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.drT = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.drJ = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.drK = gVar;
    }

    public void a(b bVar) {
        this.drM = bVar;
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
        if (i2 == null && this.drP != null && this.drP.size() != 0) {
            Iterator<a> it = this.drP.iterator();
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
            urlDragImageView.setAssistUrl(uB(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData uB(String str) {
        if (TextUtils.isEmpty(str) || this.drH == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.drH.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.drW = z;
    }

    private UrlDragImageView i(ViewGroup viewGroup, int i) {
        String str = i < this.drI.size() ? this.drI.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.drN);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.drJ);
        urlDragImageView.setIsCanDrag(this.drW);
        urlDragImageView.setIsCdn(this.drU);
        urlDragImageView.setOnSizeChangedListener(this.drK);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(uC(str));
        urlDragImageView.setUrl(str, this.drV);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.drL);
        urlDragImageView.setHeadImage(this.drX);
        urlDragImageView.setDragToExitListener(this.drO);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.drO = dVar;
    }

    private View j(ViewGroup viewGroup, int i) {
        if (this.drQ && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(am.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.drR);
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
            if (this.drM != null) {
                this.drM.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData uC(String str) {
        if (TextUtils.isEmpty(str) || this.drH == null) {
            return null;
        }
        return this.drH.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.drV = z;
    }

    public void setIsCdn(boolean z) {
        this.drU = z;
    }

    public void setHeadImage(boolean z) {
        this.drX = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.drN = bVar;
    }
}
