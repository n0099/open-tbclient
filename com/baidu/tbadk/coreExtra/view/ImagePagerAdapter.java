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
    private boolean eUA;
    private boolean eUB;
    private Map<String, ImageUrlData> eUl;
    private DragImageView.e eUp;
    private b eUq;
    private UrlDragImageView.b eUr;
    private DragImageView.d eUs;
    private Context mContext;
    private ArrayList<String> eUm = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener eUn = null;
    private DragImageView.g eUo = null;
    private int mGifMaxUseableMem = 0;
    private boolean eUu = false;
    private String eUv = null;
    private int eUw = 0;
    private int eUx = 0;
    private boolean eUy = false;
    private boolean eUz = false;
    private int mPosition = -1;
    private List<a> eUt = new ArrayList();

    /* loaded from: classes21.dex */
    public interface a {
        View l(ViewGroup viewGroup, int i);
    }

    /* loaded from: classes21.dex */
    public interface b {
        void h(int i, Object obj);
    }

    public ImagePagerAdapter(Context context, DragImageView.e eVar) {
        this.mContext = context;
        this.eUp = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.eUm = new ArrayList<>();
        } else {
            this.eUm = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.eUl = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.eUv = str;
    }

    public void setHasNext(boolean z) {
        this.eUu = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.eUt.add(aVar);
    }

    public boolean getHasNext() {
        return this.eUu;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.eUm != null) {
            i = this.eUm.size();
            if (this.eUu) {
                i++;
            }
        }
        return i + this.eUw + this.eUx;
    }

    public void setTempSize(int i) {
        this.eUw = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.eUx = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.eUn = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.eUo = gVar;
    }

    public void a(b bVar) {
        this.eUq = bVar;
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
        if (j == null && this.eUt != null && this.eUt.size() != 0) {
            Iterator<a> it = this.eUt.iterator();
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
            urlDragImageView.setAssistUrl(Cx(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData Cx(String str) {
        if (TextUtils.isEmpty(str) || this.eUl == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.eUl.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.eUA = z;
    }

    private UrlDragImageView j(ViewGroup viewGroup, int i) {
        String str = i < this.eUm.size() ? this.eUm.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.eUr);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.eUn);
        urlDragImageView.setIsCanDrag(this.eUA);
        urlDragImageView.setIsCdn(this.eUy);
        urlDragImageView.setOnSizeChangedListener(this.eUo);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(Cy(str));
        urlDragImageView.setUrl(str, this.eUz);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.eUp);
        urlDragImageView.setHeadImage(this.eUB);
        urlDragImageView.setDragToExitListener(this.eUs);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.eUs = dVar;
    }

    private View k(ViewGroup viewGroup, int i) {
        if (this.eUu && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(ap.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.eUv);
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
            if (this.eUq != null) {
                this.eUq.h(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData Cy(String str) {
        if (TextUtils.isEmpty(str) || this.eUl == null) {
            return null;
        }
        return this.eUl.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.eUz = z;
    }

    public void setIsCdn(boolean z) {
        this.eUy = z;
    }

    public void setHeadImage(boolean z) {
        this.eUB = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.eUr = bVar;
    }
}
