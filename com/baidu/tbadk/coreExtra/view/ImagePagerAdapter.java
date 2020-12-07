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
/* loaded from: classes21.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private Map<String, ImageUrlData> fpg;
    private DragImageView.e fpk;
    private b fpl;
    private UrlDragImageView.b fpm;
    private DragImageView.d fpn;
    private boolean fpw;
    private boolean fpx;
    private Context mContext;
    private ArrayList<String> fph = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener fpi = null;
    private DragImageView.g fpj = null;
    private int mGifMaxUseableMem = 0;
    private boolean fpp = false;
    private String fpq = null;
    private int fpr = 0;
    private int fpt = 0;
    private boolean fpu = false;
    private boolean fpv = false;
    private int mPosition = -1;
    private List<a> fpo = new ArrayList();

    /* loaded from: classes21.dex */
    public interface a {
        View l(ViewGroup viewGroup, int i);
    }

    /* loaded from: classes21.dex */
    public interface b {
        void g(int i, Object obj);
    }

    public ImagePagerAdapter(Context context, DragImageView.e eVar) {
        this.mContext = context;
        this.fpk = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.fph = new ArrayList<>();
        } else {
            this.fph = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.fpg = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.fpq = str;
    }

    public void setHasNext(boolean z) {
        this.fpp = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.fpo.add(aVar);
    }

    public boolean getHasNext() {
        return this.fpp;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.fph != null) {
            i = this.fph.size();
            if (this.fpp) {
                i++;
            }
        }
        return i + this.fpr + this.fpt;
    }

    public void setTempSize(int i) {
        this.fpr = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.fpt = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.fpi = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.fpj = gVar;
    }

    public void a(b bVar) {
        this.fpl = bVar;
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
        View j = j(viewGroup, i);
        if (j == null && this.fpo != null && this.fpo.size() != 0) {
            Iterator<a> it = this.fpo.iterator();
            while (it.hasNext() && (j = it.next().l(viewGroup, i)) == null) {
            }
        }
        if (j == null) {
            return k(viewGroup, i);
        }
        return j;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        UrlDragImageView urlDragImageView;
        ImageUrlData imageUrlData;
        if ((obj instanceof UrlDragImageView) && (imageUrlData = (urlDragImageView = (UrlDragImageView) obj).getmAssistUrlData()) != null && !StringUtils.isNull(imageUrlData.imageUrl)) {
            urlDragImageView.setAssistUrl(Dl(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData Dl(String str) {
        if (TextUtils.isEmpty(str) || this.fpg == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.fpg.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.fpw = z;
    }

    private UrlDragImageView j(ViewGroup viewGroup, int i) {
        String str = i < this.fph.size() ? this.fph.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.fpm);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.fpi);
        urlDragImageView.setIsCanDrag(this.fpw);
        urlDragImageView.setIsCdn(this.fpu);
        urlDragImageView.setOnSizeChangedListener(this.fpj);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(Dm(str));
        urlDragImageView.setUrl(str, this.fpv);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.fpk);
        urlDragImageView.setHeadImage(this.fpx);
        urlDragImageView.setDragToExitListener(this.fpn);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.fpn = dVar;
    }

    private View k(ViewGroup viewGroup, int i) {
        if (this.fpp && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(ap.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.fpq);
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
            if (this.fpl != null) {
                this.fpl.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData Dm(String str) {
        if (TextUtils.isEmpty(str) || this.fpg == null) {
            return null;
        }
        return this.fpg.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.fpv = z;
    }

    public void setIsCdn(boolean z) {
        this.fpu = z;
    }

    public void setHeadImage(boolean z) {
        this.fpx = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.fpm = bVar;
    }
}
