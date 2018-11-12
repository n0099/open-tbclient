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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private Map<String, ImageUrlData> aPO;
    private DragImageView.e aPS;
    private List<a> aPY;
    private DragImageView.d aPZ;
    private UrlDragImageView.b aQc;
    private boolean aQd;
    private boolean aQe;
    private GalleryViewPager aQf;
    private boolean aQg;
    private Context mContext;
    private ArrayList<String> aPN = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aPP = null;
    private View.OnTouchListener aPQ = null;
    private DragImageView.g aPR = null;
    private int aPT = 0;
    private boolean aPU = false;
    private String aPV = null;
    private int aPW = 0;
    private int aPX = 0;
    private boolean aQa = false;
    private boolean aQb = false;
    private int mPosition = -1;

    /* loaded from: classes6.dex */
    public interface a {
        View f(ViewGroup viewGroup, int i);
    }

    public ImagePagerAdapter(Context context, GalleryViewPager galleryViewPager, DragImageView.e eVar) {
        this.mContext = null;
        this.aPS = null;
        this.aPY = null;
        this.mContext = context;
        this.aQf = galleryViewPager;
        this.aPS = eVar;
        this.aPY = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.aPN = new ArrayList<>();
        } else {
            this.aPN = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aPO = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.aPV = str;
    }

    public void setHasNext(boolean z) {
        this.aPU = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.aPY.add(aVar);
    }

    public boolean getHasNext() {
        return this.aPU;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.aPN != null) {
            i = this.aPN.size();
            if (this.aPU) {
                i++;
            }
        }
        return i + this.aPW + this.aPX;
    }

    public void setTempSize(int i) {
        this.aPW = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aPX = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.aPQ = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aPP = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aPT = i;
    }

    public void a(DragImageView.g gVar) {
        this.aPR = gVar;
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
        View d = d(viewGroup, i);
        if (d == null && this.aPY != null && this.aPY.size() != 0) {
            Iterator<a> it = this.aPY.iterator();
            while (it.hasNext() && (d = it.next().f(viewGroup, i)) == null) {
            }
        }
        if (d == null) {
            return e(viewGroup, i);
        }
        return d;
    }

    public void setIsCanDrag(boolean z) {
        this.aQd = z;
    }

    public void setIsHotSort(boolean z) {
        this.aQe = z;
    }

    private UrlDragImageView d(ViewGroup viewGroup, int i) {
        String str = i < this.aPN.size() ? this.aPN.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.aQc);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.aPP);
        urlDragImageView.setOuterOnTouchListener(this.aPQ);
        urlDragImageView.setIsCanDrag(this.aQd);
        urlDragImageView.setIsHotSort(this.aQe);
        urlDragImageView.setIsCdn(this.aQa);
        urlDragImageView.setOnSizeChangedListener(this.aPR);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(gN(str));
        urlDragImageView.setUrl(str, this.aQb);
        urlDragImageView.setGifMaxUseableMem(this.aPT);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.aPS);
        urlDragImageView.setHeadImage(this.aQg);
        urlDragImageView.setDragToExitListener(this.aPZ);
        return urlDragImageView;
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aPZ = dVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.aPU && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(e.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(e.g.image)).setImageDrawable(al.getDrawable(e.f.big_image_next_default));
            ((TextView) inflate.findViewById(e.g.thread_name)).setText(this.aPV);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.mPosition != i && (obj instanceof UrlDragImageView)) {
            this.mPosition = i;
            UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
            DragImageView imageView = urlDragImageView.getImageView();
            if (imageView != null) {
                imageView.Pu();
                this.aQf.setCurrentView(imageView);
                if (imageView.getImageType() == 1) {
                    this.aPS.a(imageView);
                }
            }
            urlDragImageView.JF();
            urlDragImageView.JE();
            urlDragImageView.k(this.aQb, true);
        }
    }

    private ImageUrlData gN(String str) {
        if (TextUtils.isEmpty(str) || this.aPO == null) {
            return null;
        }
        return this.aPO.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aQb = z;
    }

    public void setIsCdn(boolean z) {
        this.aQa = z;
    }

    public void setHeadImage(boolean z) {
        this.aQg = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.aQc = bVar;
    }
}
