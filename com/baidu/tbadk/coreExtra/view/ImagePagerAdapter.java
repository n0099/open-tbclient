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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes15.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private UrlDragImageView.b evA;
    private DragImageView.d evB;
    private boolean evJ;
    private boolean evK;
    private Map<String, ImageUrlData> evu;
    private DragImageView.e evy;
    private b evz;
    private Context mContext;
    private ArrayList<String> evv = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener evw = null;
    private DragImageView.g evx = null;
    private int mGifMaxUseableMem = 0;
    private boolean evD = false;
    private String evE = null;
    private int evF = 0;
    private int evG = 0;
    private boolean evH = false;
    private boolean evI = false;
    private int mPosition = -1;
    private List<a> evC = new ArrayList();

    /* loaded from: classes15.dex */
    public interface a {
        View j(ViewGroup viewGroup, int i);
    }

    /* loaded from: classes15.dex */
    public interface b {
        void g(int i, Object obj);
    }

    public ImagePagerAdapter(Context context, DragImageView.e eVar) {
        this.mContext = context;
        this.evy = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.evv = new ArrayList<>();
        } else {
            this.evv = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.evu = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.evE = str;
    }

    public void setHasNext(boolean z) {
        this.evD = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.evC.add(aVar);
    }

    public boolean getHasNext() {
        return this.evD;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.evv != null) {
            i = this.evv.size();
            if (this.evD) {
                i++;
            }
        }
        return i + this.evF + this.evG;
    }

    public void setTempSize(int i) {
        this.evF = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.evG = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.evw = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.evx = gVar;
    }

    public void a(b bVar) {
        this.evz = bVar;
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
        View h = h(viewGroup, i);
        if (h == null && this.evC != null && this.evC.size() != 0) {
            Iterator<a> it = this.evC.iterator();
            while (it.hasNext() && (h = it.next().j(viewGroup, i)) == null) {
            }
        }
        if (h == null) {
            return i(viewGroup, i);
        }
        return h;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        UrlDragImageView urlDragImageView;
        ImageUrlData imageUrlData;
        if ((obj instanceof UrlDragImageView) && (imageUrlData = (urlDragImageView = (UrlDragImageView) obj).getmAssistUrlData()) != null && !StringUtils.isNull(imageUrlData.imageUrl)) {
            urlDragImageView.setAssistUrl(yY(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData yY(String str) {
        if (TextUtils.isEmpty(str) || this.evu == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.evu.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.evJ = z;
    }

    private UrlDragImageView h(ViewGroup viewGroup, int i) {
        String str = i < this.evv.size() ? this.evv.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.evA);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.evw);
        urlDragImageView.setIsCanDrag(this.evJ);
        urlDragImageView.setIsCdn(this.evH);
        urlDragImageView.setOnSizeChangedListener(this.evx);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(yZ(str));
        urlDragImageView.setUrl(str, this.evI);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.evy);
        urlDragImageView.setHeadImage(this.evK);
        urlDragImageView.setDragToExitListener(this.evB);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.evB = dVar;
    }

    private View i(ViewGroup viewGroup, int i) {
        if (this.evD && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(ao.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.evE);
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
            if (this.evz != null) {
                this.evz.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData yZ(String str) {
        if (TextUtils.isEmpty(str) || this.evu == null) {
            return null;
        }
        return this.evu.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.evI = z;
    }

    public void setIsCdn(boolean z) {
        this.evH = z;
    }

    public void setHeadImage(boolean z) {
        this.evK = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.evA = bVar;
    }
}
