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
/* loaded from: classes20.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private Map<String, ImageUrlData> eIe;
    private DragImageView.e eIi;
    private b eIj;
    private UrlDragImageView.b eIk;
    private DragImageView.d eIl;
    private boolean eIt;
    private boolean eIu;
    private Context mContext;
    private ArrayList<String> eIf = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener eIg = null;
    private DragImageView.g eIh = null;
    private int mGifMaxUseableMem = 0;
    private boolean eIn = false;
    private String eIo = null;
    private int eIp = 0;
    private int eIq = 0;
    private boolean eIr = false;
    private boolean eIs = false;
    private int mPosition = -1;
    private List<a> eIm = new ArrayList();

    /* loaded from: classes20.dex */
    public interface a {
        View j(ViewGroup viewGroup, int i);
    }

    /* loaded from: classes20.dex */
    public interface b {
        void g(int i, Object obj);
    }

    public ImagePagerAdapter(Context context, DragImageView.e eVar) {
        this.mContext = context;
        this.eIi = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.eIf = new ArrayList<>();
        } else {
            this.eIf = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.eIe = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.eIo = str;
    }

    public void setHasNext(boolean z) {
        this.eIn = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.eIm.add(aVar);
    }

    public boolean getHasNext() {
        return this.eIn;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.eIf != null) {
            i = this.eIf.size();
            if (this.eIn) {
                i++;
            }
        }
        return i + this.eIp + this.eIq;
    }

    public void setTempSize(int i) {
        this.eIp = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.eIq = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.eIg = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.eIh = gVar;
    }

    public void a(b bVar) {
        this.eIj = bVar;
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
        if (h == null && this.eIm != null && this.eIm.size() != 0) {
            Iterator<a> it = this.eIm.iterator();
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
            urlDragImageView.setAssistUrl(BL(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData BL(String str) {
        if (TextUtils.isEmpty(str) || this.eIe == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.eIe.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.eIt = z;
    }

    private UrlDragImageView h(ViewGroup viewGroup, int i) {
        String str = i < this.eIf.size() ? this.eIf.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.eIk);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.eIg);
        urlDragImageView.setIsCanDrag(this.eIt);
        urlDragImageView.setIsCdn(this.eIr);
        urlDragImageView.setOnSizeChangedListener(this.eIh);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(BM(str));
        urlDragImageView.setUrl(str, this.eIs);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.eIi);
        urlDragImageView.setHeadImage(this.eIu);
        urlDragImageView.setDragToExitListener(this.eIl);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.eIl = dVar;
    }

    private View i(ViewGroup viewGroup, int i) {
        if (this.eIn && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(ap.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.eIo);
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
            if (this.eIj != null) {
                this.eIj.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData BM(String str) {
        if (TextUtils.isEmpty(str) || this.eIe == null) {
            return null;
        }
        return this.eIe.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.eIs = z;
    }

    public void setIsCdn(boolean z) {
        this.eIr = z;
    }

    public void setHeadImage(boolean z) {
        this.eIu = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.eIk = bVar;
    }
}
