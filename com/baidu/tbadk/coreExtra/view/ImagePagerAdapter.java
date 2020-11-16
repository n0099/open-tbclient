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
    private Map<String, ImageUrlData> fhG;
    private DragImageView.e fhK;
    private b fhL;
    private UrlDragImageView.b fhM;
    private DragImageView.d fhN;
    private boolean fhV;
    private boolean fhW;
    private Context mContext;
    private ArrayList<String> fhH = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener fhI = null;
    private DragImageView.g fhJ = null;
    private int mGifMaxUseableMem = 0;
    private boolean fhP = false;
    private String fhQ = null;
    private int fhR = 0;
    private int fhS = 0;
    private boolean fhT = false;
    private boolean fhU = false;
    private int mPosition = -1;
    private List<a> fhO = new ArrayList();

    /* loaded from: classes20.dex */
    public interface a {
        View l(ViewGroup viewGroup, int i);
    }

    /* loaded from: classes20.dex */
    public interface b {
        void g(int i, Object obj);
    }

    public ImagePagerAdapter(Context context, DragImageView.e eVar) {
        this.mContext = context;
        this.fhK = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.fhH = new ArrayList<>();
        } else {
            this.fhH = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.fhG = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.fhQ = str;
    }

    public void setHasNext(boolean z) {
        this.fhP = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.fhO.add(aVar);
    }

    public boolean getHasNext() {
        return this.fhP;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.fhH != null) {
            i = this.fhH.size();
            if (this.fhP) {
                i++;
            }
        }
        return i + this.fhR + this.fhS;
    }

    public void setTempSize(int i) {
        this.fhR = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.fhS = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.fhI = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.fhJ = gVar;
    }

    public void a(b bVar) {
        this.fhL = bVar;
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
        if (j == null && this.fhO != null && this.fhO.size() != 0) {
            Iterator<a> it = this.fhO.iterator();
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
            urlDragImageView.setAssistUrl(CD(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData CD(String str) {
        if (TextUtils.isEmpty(str) || this.fhG == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.fhG.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.fhV = z;
    }

    private UrlDragImageView j(ViewGroup viewGroup, int i) {
        String str = i < this.fhH.size() ? this.fhH.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.fhM);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.fhI);
        urlDragImageView.setIsCanDrag(this.fhV);
        urlDragImageView.setIsCdn(this.fhT);
        urlDragImageView.setOnSizeChangedListener(this.fhJ);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(CE(str));
        urlDragImageView.setUrl(str, this.fhU);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.fhK);
        urlDragImageView.setHeadImage(this.fhW);
        urlDragImageView.setDragToExitListener(this.fhN);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.fhN = dVar;
    }

    private View k(ViewGroup viewGroup, int i) {
        if (this.fhP && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(ap.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.fhQ);
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
            if (this.fhL != null) {
                this.fhL.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData CE(String str) {
        if (TextUtils.isEmpty(str) || this.fhG == null) {
            return null;
        }
        return this.fhG.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.fhU = z;
    }

    public void setIsCdn(boolean z) {
        this.fhT = z;
    }

    public void setHeadImage(boolean z) {
        this.fhW = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.fhM = bVar;
    }
}
