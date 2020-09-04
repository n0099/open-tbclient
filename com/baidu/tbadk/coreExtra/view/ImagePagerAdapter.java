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
    private Map<String, ImageUrlData> eFX;
    private DragImageView.e eGb;
    private b eGc;
    private UrlDragImageView.b eGd;
    private DragImageView.d eGe;
    private boolean eGm;
    private boolean eGn;
    private Context mContext;
    private ArrayList<String> eFY = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener eFZ = null;
    private DragImageView.g eGa = null;
    private int mGifMaxUseableMem = 0;
    private boolean eGg = false;
    private String eGh = null;
    private int eGi = 0;
    private int eGj = 0;
    private boolean eGk = false;
    private boolean eGl = false;
    private int mPosition = -1;
    private List<a> eGf = new ArrayList();

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
        this.eGb = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.eFY = new ArrayList<>();
        } else {
            this.eFY = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.eFX = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.eGh = str;
    }

    public void setHasNext(boolean z) {
        this.eGg = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.eGf.add(aVar);
    }

    public boolean getHasNext() {
        return this.eGg;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.eFY != null) {
            i = this.eFY.size();
            if (this.eGg) {
                i++;
            }
        }
        return i + this.eGi + this.eGj;
    }

    public void setTempSize(int i) {
        this.eGi = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.eGj = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.eFZ = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.eGa = gVar;
    }

    public void a(b bVar) {
        this.eGc = bVar;
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
        if (h == null && this.eGf != null && this.eGf.size() != 0) {
            Iterator<a> it = this.eGf.iterator();
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
            urlDragImageView.setAssistUrl(Bp(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData Bp(String str) {
        if (TextUtils.isEmpty(str) || this.eFX == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.eFX.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.eGm = z;
    }

    private UrlDragImageView h(ViewGroup viewGroup, int i) {
        String str = i < this.eFY.size() ? this.eFY.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.eGd);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.eFZ);
        urlDragImageView.setIsCanDrag(this.eGm);
        urlDragImageView.setIsCdn(this.eGk);
        urlDragImageView.setOnSizeChangedListener(this.eGa);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(Bq(str));
        urlDragImageView.setUrl(str, this.eGl);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.eGb);
        urlDragImageView.setHeadImage(this.eGn);
        urlDragImageView.setDragToExitListener(this.eGe);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.eGe = dVar;
    }

    private View i(ViewGroup viewGroup, int i) {
        if (this.eGg && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(ap.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.eGh);
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
            if (this.eGc != null) {
                this.eGc.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData Bq(String str) {
        if (TextUtils.isEmpty(str) || this.eFX == null) {
            return null;
        }
        return this.eFX.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.eGl = z;
    }

    public void setIsCdn(boolean z) {
        this.eGk = z;
    }

    public void setHeadImage(boolean z) {
        this.eGn = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.eGd = bVar;
    }
}
