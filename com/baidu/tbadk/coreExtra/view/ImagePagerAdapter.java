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
/* loaded from: classes6.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private DragImageView.e dnC;
    private b dnD;
    private UrlDragImageView.b dnE;
    private DragImageView.d dnF;
    private boolean dnN;
    private boolean dnO;
    private Map<String, ImageUrlData> dny;
    private Context mContext;
    private ArrayList<String> dnz = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener dnA = null;
    private DragImageView.g dnB = null;
    private int mGifMaxUseableMem = 0;
    private boolean dnH = false;
    private String dnI = null;
    private int dnJ = 0;
    private int dnK = 0;
    private boolean dnL = false;
    private boolean dnM = false;
    private int mPosition = -1;
    private List<a> dnG = new ArrayList();

    /* loaded from: classes6.dex */
    public interface a {
        View k(ViewGroup viewGroup, int i);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void g(int i, Object obj);
    }

    public ImagePagerAdapter(Context context, DragImageView.e eVar) {
        this.mContext = context;
        this.dnC = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.dnz = new ArrayList<>();
        } else {
            this.dnz = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.dny = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.dnI = str;
    }

    public void setHasNext(boolean z) {
        this.dnH = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.dnG.add(aVar);
    }

    public boolean getHasNext() {
        return this.dnH;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.dnz != null) {
            i = this.dnz.size();
            if (this.dnH) {
                i++;
            }
        }
        return i + this.dnJ + this.dnK;
    }

    public void setTempSize(int i) {
        this.dnJ = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.dnK = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.dnA = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.dnB = gVar;
    }

    public void a(b bVar) {
        this.dnD = bVar;
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
        if (i2 == null && this.dnG != null && this.dnG.size() != 0) {
            Iterator<a> it = this.dnG.iterator();
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
            urlDragImageView.setAssistUrl(uk(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData uk(String str) {
        if (TextUtils.isEmpty(str) || this.dny == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.dny.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.dnN = z;
    }

    private UrlDragImageView i(ViewGroup viewGroup, int i) {
        String str = i < this.dnz.size() ? this.dnz.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.dnE);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.dnA);
        urlDragImageView.setIsCanDrag(this.dnN);
        urlDragImageView.setIsCdn(this.dnL);
        urlDragImageView.setOnSizeChangedListener(this.dnB);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(ul(str));
        urlDragImageView.setUrl(str, this.dnM);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.dnC);
        urlDragImageView.setHeadImage(this.dnO);
        urlDragImageView.setDragToExitListener(this.dnF);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.dnF = dVar;
    }

    private View j(ViewGroup viewGroup, int i) {
        if (this.dnH && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(am.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.dnI);
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
            if (this.dnD != null) {
                this.dnD.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData ul(String str) {
        if (TextUtils.isEmpty(str) || this.dny == null) {
            return null;
        }
        return this.dny.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.dnM = z;
    }

    public void setIsCdn(boolean z) {
        this.dnL = z;
    }

    public void setHeadImage(boolean z) {
        this.dnO = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.dnE = bVar;
    }
}
