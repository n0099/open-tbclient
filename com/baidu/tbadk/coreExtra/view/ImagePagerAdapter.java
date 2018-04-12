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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private Map<String, ImageUrlData> axV;
    private DragImageView.e axZ;
    private List<a> ayf;
    private DragImageView.d ayg;
    private UrlDragImageView.b ayj;
    private boolean ayk;
    private GalleryViewPager ayl;
    private boolean aym;
    private Context mContext;
    private ArrayList<String> axU = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener axW = null;
    private View.OnTouchListener axX = null;
    private DragImageView.f axY = null;
    private int aya = 0;
    private boolean ayb = false;
    private String ayc = null;
    private int ayd = 0;
    private int aye = 0;
    private boolean ayh = false;
    private boolean ayi = false;
    private int mPosition = -1;

    /* loaded from: classes.dex */
    public interface a {
        View g(ViewGroup viewGroup, int i);
    }

    public ImagePagerAdapter(Context context, GalleryViewPager galleryViewPager, DragImageView.e eVar) {
        this.mContext = null;
        this.axZ = null;
        this.ayf = null;
        this.mContext = context;
        this.ayl = galleryViewPager;
        this.axZ = eVar;
        this.ayf = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.axU = new ArrayList<>();
        } else {
            this.axU = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.axV = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.ayc = str;
    }

    public void setHasNext(boolean z) {
        this.ayb = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.ayf.add(aVar);
    }

    public boolean getHasNext() {
        return this.ayb;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.axU != null) {
            i = this.axU.size();
            if (this.ayb) {
                i++;
            }
        }
        return i + this.ayd + this.aye;
    }

    public void setTempSize(int i) {
        this.ayd = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aye = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.axX = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axW = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aya = i;
    }

    public void a(DragImageView.f fVar) {
        this.axY = fVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        return view2.equals(obj);
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
        View e = e(viewGroup, i);
        if (e == null && this.ayf != null && this.ayf.size() != 0) {
            Iterator<a> it = this.ayf.iterator();
            while (it.hasNext() && (e = it.next().g(viewGroup, i)) == null) {
            }
        }
        if (e == null) {
            return f(viewGroup, i);
        }
        return e;
    }

    public void setIsCanDrag(boolean z) {
        this.ayk = z;
    }

    private UrlDragImageView e(ViewGroup viewGroup, int i) {
        String str = i < this.axU.size() ? this.axU.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.ayj);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.axW);
        urlDragImageView.setOuterOnTouchListener(this.axX);
        urlDragImageView.setIsCanDrag(this.ayk);
        urlDragImageView.setIsCdn(this.ayh);
        urlDragImageView.setOnSizeChangedListener(this.axY);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(fB(str));
        urlDragImageView.setUrl(str, this.ayi);
        urlDragImageView.setGifMaxUseableMem(this.aya);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.axZ);
        urlDragImageView.setHeadImage(this.aym);
        urlDragImageView.setDragToExitListener(this.ayg);
        return urlDragImageView;
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.ayg = dVar;
    }

    private View f(ViewGroup viewGroup, int i) {
        if (this.ayb && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.i.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.g.image)).setImageDrawable(ak.getDrawable(d.f.big_image_next_default));
            ((TextView) inflate.findViewById(d.g.thread_name)).setText(this.ayc);
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
                imageView.Ij();
                this.ayl.setCurrentView(imageView);
                if (imageView.getImageType() == 1) {
                    this.axZ.a(imageView);
                }
            }
            urlDragImageView.Cn();
            urlDragImageView.Cm();
            urlDragImageView.i(this.ayi, true);
        }
    }

    private ImageUrlData fB(String str) {
        if (TextUtils.isEmpty(str) || this.axV == null) {
            return null;
        }
        return this.axV.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.ayi = z;
    }

    public void setIsCdn(boolean z) {
        this.ayh = z;
    }

    public void setHeadImage(boolean z) {
        this.aym = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.ayj = bVar;
    }
}
