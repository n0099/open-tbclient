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
    private Map<String, ImageUrlData> aTZ;
    private DragImageView.e aUd;
    private List<a> aUj;
    private DragImageView.d aUk;
    private UrlDragImageView.b aUn;
    private boolean aUo;
    private boolean aUp;
    private GalleryViewPager aUq;
    private boolean aUr;
    private Context mContext;
    private ArrayList<String> aTY = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aUa = null;
    private View.OnTouchListener aUb = null;
    private DragImageView.g aUc = null;
    private int aUe = 0;
    private boolean aUf = false;
    private String aUg = null;
    private int aUh = 0;
    private int aUi = 0;
    private boolean aUl = false;
    private boolean aUm = false;
    private int mPosition = -1;

    /* loaded from: classes6.dex */
    public interface a {
        View f(ViewGroup viewGroup, int i);
    }

    public ImagePagerAdapter(Context context, GalleryViewPager galleryViewPager, DragImageView.e eVar) {
        this.mContext = null;
        this.aUd = null;
        this.aUj = null;
        this.mContext = context;
        this.aUq = galleryViewPager;
        this.aUd = eVar;
        this.aUj = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.aTY = new ArrayList<>();
        } else {
            this.aTY = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aTZ = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.aUg = str;
    }

    public void setHasNext(boolean z) {
        this.aUf = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.aUj.add(aVar);
    }

    public boolean getHasNext() {
        return this.aUf;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.aTY != null) {
            i = this.aTY.size();
            if (this.aUf) {
                i++;
            }
        }
        return i + this.aUh + this.aUi;
    }

    public void setTempSize(int i) {
        this.aUh = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aUi = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.aUb = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aUa = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aUe = i;
    }

    public void a(DragImageView.g gVar) {
        this.aUc = gVar;
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
        if (d == null && this.aUj != null && this.aUj.size() != 0) {
            Iterator<a> it = this.aUj.iterator();
            while (it.hasNext() && (d = it.next().f(viewGroup, i)) == null) {
            }
        }
        if (d == null) {
            return e(viewGroup, i);
        }
        return d;
    }

    public void setIsCanDrag(boolean z) {
        this.aUo = z;
    }

    public void setIsHotSort(boolean z) {
        this.aUp = z;
    }

    private UrlDragImageView d(ViewGroup viewGroup, int i) {
        String str = i < this.aTY.size() ? this.aTY.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.aUn);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.aUa);
        urlDragImageView.setOuterOnTouchListener(this.aUb);
        urlDragImageView.setIsCanDrag(this.aUo);
        urlDragImageView.setIsHotSort(this.aUp);
        urlDragImageView.setIsCdn(this.aUl);
        urlDragImageView.setOnSizeChangedListener(this.aUc);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(hu(str));
        urlDragImageView.setUrl(str, this.aUm);
        urlDragImageView.setGifMaxUseableMem(this.aUe);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.aUd);
        urlDragImageView.setHeadImage(this.aUr);
        urlDragImageView.setDragToExitListener(this.aUk);
        return urlDragImageView;
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aUk = dVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.aUf && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(e.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(e.g.image)).setImageDrawable(al.getDrawable(e.f.big_image_next_default));
            ((TextView) inflate.findViewById(e.g.thread_name)).setText(this.aUg);
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
                this.aUq.setCurrentView(imageView);
                if (imageView.getImageType() == 1) {
                    this.aUd.a(imageView);
                }
            }
            urlDragImageView.KZ();
            urlDragImageView.KY();
            urlDragImageView.k(this.aUm, true);
        }
    }

    private ImageUrlData hu(String str) {
        if (TextUtils.isEmpty(str) || this.aTZ == null) {
            return null;
        }
        return this.aTZ.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aUm = z;
    }

    public void setIsCdn(boolean z) {
        this.aUl = z;
    }

    public void setHeadImage(boolean z) {
        this.aUr = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.aUn = bVar;
    }
}
