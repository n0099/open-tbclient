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
    private Map<String, ImageUrlData> drV;
    private DragImageView.e drZ;
    private b dsa;
    private UrlDragImageView.b dsb;
    private DragImageView.d dsc;
    private boolean dsk;
    private boolean dsl;
    private Context mContext;
    private ArrayList<String> drW = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener drX = null;
    private DragImageView.g drY = null;
    private int mGifMaxUseableMem = 0;
    private boolean dse = false;
    private String dsf = null;
    private int dsg = 0;
    private int dsh = 0;
    private boolean dsi = false;
    private boolean dsj = false;
    private int mPosition = -1;
    private List<a> dsd = new ArrayList();

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
        this.drZ = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.drW = new ArrayList<>();
        } else {
            this.drW = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.drV = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.dsf = str;
    }

    public void setHasNext(boolean z) {
        this.dse = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.dsd.add(aVar);
    }

    public boolean getHasNext() {
        return this.dse;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.drW != null) {
            i = this.drW.size();
            if (this.dse) {
                i++;
            }
        }
        return i + this.dsg + this.dsh;
    }

    public void setTempSize(int i) {
        this.dsg = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.dsh = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.drX = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.drY = gVar;
    }

    public void a(b bVar) {
        this.dsa = bVar;
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
        if (i2 == null && this.dsd != null && this.dsd.size() != 0) {
            Iterator<a> it = this.dsd.iterator();
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
            urlDragImageView.setAssistUrl(uC(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData uC(String str) {
        if (TextUtils.isEmpty(str) || this.drV == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.drV.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.dsk = z;
    }

    private UrlDragImageView i(ViewGroup viewGroup, int i) {
        String str = i < this.drW.size() ? this.drW.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.dsb);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.drX);
        urlDragImageView.setIsCanDrag(this.dsk);
        urlDragImageView.setIsCdn(this.dsi);
        urlDragImageView.setOnSizeChangedListener(this.drY);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(uD(str));
        urlDragImageView.setUrl(str, this.dsj);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.drZ);
        urlDragImageView.setHeadImage(this.dsl);
        urlDragImageView.setDragToExitListener(this.dsc);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.dsc = dVar;
    }

    private View j(ViewGroup viewGroup, int i) {
        if (this.dse && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(am.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.dsf);
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
            if (this.dsa != null) {
                this.dsa.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData uD(String str) {
        if (TextUtils.isEmpty(str) || this.drV == null) {
            return null;
        }
        return this.drV.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.dsj = z;
    }

    public void setIsCdn(boolean z) {
        this.dsi = z;
    }

    public void setHeadImage(boolean z) {
        this.dsl = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.dsb = bVar;
    }
}
