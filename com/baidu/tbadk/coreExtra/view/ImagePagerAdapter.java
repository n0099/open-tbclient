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
/* loaded from: classes15.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private Map<String, ImageUrlData> eFT;
    private DragImageView.e eFX;
    private b eFY;
    private UrlDragImageView.b eFZ;
    private DragImageView.d eGa;
    private boolean eGi;
    private boolean eGj;
    private Context mContext;
    private ArrayList<String> eFU = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener eFV = null;
    private DragImageView.g eFW = null;
    private int mGifMaxUseableMem = 0;
    private boolean eGc = false;
    private String eGd = null;
    private int eGe = 0;
    private int eGf = 0;
    private boolean eGg = false;
    private boolean eGh = false;
    private int mPosition = -1;
    private List<a> eGb = new ArrayList();

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
        this.eFX = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.eFU = new ArrayList<>();
        } else {
            this.eFU = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.eFT = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.eGd = str;
    }

    public void setHasNext(boolean z) {
        this.eGc = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.eGb.add(aVar);
    }

    public boolean getHasNext() {
        return this.eGc;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.eFU != null) {
            i = this.eFU.size();
            if (this.eGc) {
                i++;
            }
        }
        return i + this.eGe + this.eGf;
    }

    public void setTempSize(int i) {
        this.eGe = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.eGf = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.eFV = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.eFW = gVar;
    }

    public void a(b bVar) {
        this.eFY = bVar;
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
        if (h == null && this.eGb != null && this.eGb.size() != 0) {
            Iterator<a> it = this.eGb.iterator();
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
            urlDragImageView.setAssistUrl(Bo(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData Bo(String str) {
        if (TextUtils.isEmpty(str) || this.eFT == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.eFT.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.eGi = z;
    }

    private UrlDragImageView h(ViewGroup viewGroup, int i) {
        String str = i < this.eFU.size() ? this.eFU.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.eFZ);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.eFV);
        urlDragImageView.setIsCanDrag(this.eGi);
        urlDragImageView.setIsCdn(this.eGg);
        urlDragImageView.setOnSizeChangedListener(this.eFW);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(Bp(str));
        urlDragImageView.setUrl(str, this.eGh);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.eFX);
        urlDragImageView.setHeadImage(this.eGj);
        urlDragImageView.setDragToExitListener(this.eGa);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.eGa = dVar;
    }

    private View i(ViewGroup viewGroup, int i) {
        if (this.eGc && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(ap.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.eGd);
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
            if (this.eFY != null) {
                this.eFY.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData Bp(String str) {
        if (TextUtils.isEmpty(str) || this.eFT == null) {
            return null;
        }
        return this.eFT.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.eGh = z;
    }

    public void setIsCdn(boolean z) {
        this.eGg = z;
    }

    public void setHeadImage(boolean z) {
        this.eGj = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.eFZ = bVar;
    }
}
