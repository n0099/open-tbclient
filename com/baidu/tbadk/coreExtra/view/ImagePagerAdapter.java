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
    private Map<String, ImageUrlData> fiB;
    private DragImageView.e fiF;
    private b fiG;
    private UrlDragImageView.b fiH;
    private DragImageView.d fiI;
    private boolean fiQ;
    private boolean fiR;
    private Context mContext;
    private ArrayList<String> fiC = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnTouchListener fiD = null;
    private DragImageView.g fiE = null;
    private int mGifMaxUseableMem = 0;
    private boolean fiK = false;
    private String fiL = null;
    private int fiM = 0;
    private int fiN = 0;
    private boolean fiO = false;
    private boolean fiP = false;
    private int mPosition = -1;
    private List<a> fiJ = new ArrayList();

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
        this.fiF = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.fiC = new ArrayList<>();
        } else {
            this.fiC = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.fiB = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.fiL = str;
    }

    public void setHasNext(boolean z) {
        this.fiK = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.fiJ.add(aVar);
    }

    public boolean getHasNext() {
        return this.fiK;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.fiC != null) {
            i = this.fiC.size();
            if (this.fiK) {
                i++;
            }
        }
        return i + this.fiM + this.fiN;
    }

    public void setTempSize(int i) {
        this.fiM = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.fiN = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.fiD = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public void setOnSizeChangedListener(DragImageView.g gVar) {
        this.fiE = gVar;
    }

    public void a(b bVar) {
        this.fiG = bVar;
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
        if (j == null && this.fiJ != null && this.fiJ.size() != 0) {
            Iterator<a> it = this.fiJ.iterator();
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
            urlDragImageView.setAssistUrl(De(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    private ImageUrlData De(String str) {
        if (TextUtils.isEmpty(str) || this.fiB == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.fiB.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public void setIsCanDrag(boolean z) {
        this.fiQ = z;
    }

    private UrlDragImageView j(ViewGroup viewGroup, int i) {
        String str = i < this.fiC.size() ? this.fiC.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.mContext);
        urlDragImageView.setOriImgSelectedCallback(this.fiH);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.mOnClickListener);
        urlDragImageView.setImageOnLongClickListener(this.mOnLongClickListener);
        urlDragImageView.setOuterOnTouchListener(this.fiD);
        urlDragImageView.setIsCanDrag(this.fiQ);
        urlDragImageView.setIsCdn(this.fiO);
        urlDragImageView.setOnSizeChangedListener(this.fiE);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(Df(str));
        urlDragImageView.setUrl(str, this.fiP);
        urlDragImageView.setGifMaxUseableMem(this.mGifMaxUseableMem);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.fiF);
        urlDragImageView.setHeadImage(this.fiR);
        urlDragImageView.setDragToExitListener(this.fiI);
        return urlDragImageView;
    }

    public void a(DragImageView.d dVar) {
        this.fiI = dVar;
    }

    private View k(ViewGroup viewGroup, int i) {
        if (this.fiK && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(ap.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.fiL);
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
            if (this.fiG != null) {
                this.fiG.g(i, obj);
            }
            this.mPosition = i;
        }
    }

    private ImageUrlData Df(String str) {
        if (TextUtils.isEmpty(str) || this.fiB == null) {
            return null;
        }
        return this.fiB.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.fiP = z;
    }

    public void setIsCdn(boolean z) {
        this.fiO = z;
    }

    public void setHeadImage(boolean z) {
        this.fiR = z;
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        this.fiH = bVar;
    }
}
