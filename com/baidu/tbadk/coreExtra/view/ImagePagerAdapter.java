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
    private Map<String, ImageUrlData> drI;
    private DragImageView.e drM;
    private b drN;
    private UrlDragImageView.b drO;
    private DragImageView.d drP;
    private boolean drX;
    private boolean drY;
    private Context mContext;
    private ArrayList<String> drJ = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener drK = null;
    private DragImageView.g drL = null;
    private int mGifMaxUseableMem = 0;
    private boolean drR = false;
    private String drS = null;
    private int drT = 0;
    private int drU = 0;
    private boolean drV = false;
    private boolean drW = false;
    private int mPosition = -1;
    private List<a> drQ = new ArrayList();

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
        this.drM = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.drJ = new ArrayList<>();
        } else {
            this.drJ = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.drI = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.drS = str;
    }

    public void setHasNext(boolean z) {
        this.drR = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.drQ.add(aVar);
    }

    public boolean getHasNext() {
        return this.drR;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.drJ != null) {
            i = this.drJ.size();
            if (this.drR) {
                i++;
            }
        }
        return i + this.drT + this.drU;
    }

    public void setTempSize(int i) {
        this.drT = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.drU = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.drK = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.drL = gVar;
    }

    public void a(b bVar) {
        this.drN = bVar;
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
        if (i2 == null && this.drQ != null && this.drQ.size() != 0) {
            Iterator<a> it = this.drQ.iterator();
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
        if (TextUtils.isEmpty(str) || this.drI == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.drI.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.drX = z;
    }

    private UrlDragImageView i(ViewGroup viewGroup, int i) {
        String str = i < this.drJ.size() ? this.drJ.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.drO);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.drK);
        urlDragImageView.setIsCanDrag(this.drX);
        urlDragImageView.setIsCdn(this.drV);
        urlDragImageView.setOnSizeChangedListener(this.drL);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(uC(str));
        urlDragImageView.setUrl(str, this.drW);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.drM);
        urlDragImageView.setHeadImage(this.drY);
        urlDragImageView.setDragToExitListener(this.drP);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.drP = dVar;
    }

    private View j(ViewGroup viewGroup, int i) {
        if (this.drR && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(am.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.drS);
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
            if (this.drN != null) {
                this.drN.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData uC(String str) {
        if (TextUtils.isEmpty(str) || this.drI == null) {
            return null;
        }
        return this.drI.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.drW = z;
    }

    public void setIsCdn(boolean z) {
        this.drV = z;
    }

    public void setHeadImage(boolean z) {
        this.drY = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.drO = bVar;
    }
}
