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
    private Map<String, ImageUrlData> aTY;
    private DragImageView.e aUc;
    private List<a> aUi;
    private DragImageView.d aUj;
    private UrlDragImageView.b aUm;
    private boolean aUn;
    private boolean aUo;
    private GalleryViewPager aUp;
    private boolean aUq;
    private Context mContext;
    private ArrayList<String> aTX = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aTZ = null;
    private View.OnTouchListener aUa = null;
    private DragImageView.g aUb = null;
    private int aUd = 0;
    private boolean aUe = false;
    private String aUf = null;
    private int aUg = 0;
    private int aUh = 0;
    private boolean aUk = false;
    private boolean aUl = false;
    private int mPosition = -1;

    /* loaded from: classes6.dex */
    public interface a {
        View f(ViewGroup viewGroup, int i);
    }

    public ImagePagerAdapter(Context context, GalleryViewPager galleryViewPager, DragImageView.e eVar) {
        this.mContext = null;
        this.aUc = null;
        this.aUi = null;
        this.mContext = context;
        this.aUp = galleryViewPager;
        this.aUc = eVar;
        this.aUi = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.aTX = new ArrayList<>();
        } else {
            this.aTX = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aTY = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.aUf = str;
    }

    public void setHasNext(boolean z) {
        this.aUe = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.aUi.add(aVar);
    }

    public boolean getHasNext() {
        return this.aUe;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.aTX != null) {
            i = this.aTX.size();
            if (this.aUe) {
                i++;
            }
        }
        return i + this.aUg + this.aUh;
    }

    public void setTempSize(int i) {
        this.aUg = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aUh = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.aUa = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTZ = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aUd = i;
    }

    public void a(DragImageView.g gVar) {
        this.aUb = gVar;
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
        if (d == null && this.aUi != null && this.aUi.size() != 0) {
            Iterator<a> it = this.aUi.iterator();
            while (it.hasNext() && (d = it.next().f(viewGroup, i)) == null) {
            }
        }
        if (d == null) {
            return e(viewGroup, i);
        }
        return d;
    }

    public void setIsCanDrag(boolean z) {
        this.aUn = z;
    }

    public void setIsHotSort(boolean z) {
        this.aUo = z;
    }

    private UrlDragImageView d(ViewGroup viewGroup, int i) {
        String str = i < this.aTX.size() ? this.aTX.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.aUm);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.aTZ);
        urlDragImageView.setOuterOnTouchListener(this.aUa);
        urlDragImageView.setIsCanDrag(this.aUn);
        urlDragImageView.setIsHotSort(this.aUo);
        urlDragImageView.setIsCdn(this.aUk);
        urlDragImageView.setOnSizeChangedListener(this.aUb);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(hu(str));
        urlDragImageView.setUrl(str, this.aUl);
        urlDragImageView.setGifMaxUseableMem(this.aUd);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.aUc);
        urlDragImageView.setHeadImage(this.aUq);
        urlDragImageView.setDragToExitListener(this.aUj);
        return urlDragImageView;
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aUj = dVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.aUe && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(e.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(e.g.image)).setImageDrawable(al.getDrawable(e.f.big_image_next_default));
            ((TextView) inflate.findViewById(e.g.thread_name)).setText(this.aUf);
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
                imageView.QX();
                this.aUp.setCurrentView(imageView);
                if (imageView.getImageType() == 1) {
                    this.aUc.a(imageView);
                }
            }
            urlDragImageView.KZ();
            urlDragImageView.KY();
            urlDragImageView.k(this.aUl, true);
        }
    }

    private ImageUrlData hu(String str) {
        if (TextUtils.isEmpty(str) || this.aTY == null) {
            return null;
        }
        return this.aTY.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aUl = z;
    }

    public void setIsCdn(boolean z) {
        this.aUk = z;
    }

    public void setHeadImage(boolean z) {
        this.aUq = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.aUm = bVar;
    }
}
