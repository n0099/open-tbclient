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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.view.f;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c extends PagerAdapter {
    private a.e avD;
    private List<a> avJ;
    private a.d avK;
    private f.b avN;
    private boolean avO;
    private b avP;
    private boolean avQ;
    private f avx;
    private Map<String, ImageUrlData> avz;
    private Context mContext;
    private ArrayList<String> avy = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener avA = null;
    private View.OnTouchListener avB = null;
    private a.f avC = null;
    private int avE = 0;
    private boolean avF = false;
    private String avG = null;
    private int avH = 0;
    private int avI = 0;
    private boolean avL = false;
    private boolean avM = false;
    private int mPosition = -1;

    /* loaded from: classes.dex */
    public interface a {
        View e(ViewGroup viewGroup, int i);
    }

    public c(Context context, b bVar, a.e eVar) {
        this.mContext = null;
        this.avD = null;
        this.avJ = null;
        this.mContext = context;
        this.avP = bVar;
        this.avD = eVar;
        this.avJ = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.avy = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.avz = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.avG = str;
    }

    public void setHasNext(boolean z) {
        this.avF = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.avJ.add(aVar);
    }

    public boolean getHasNext() {
        return this.avF;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.avy != null) {
            i = this.avy.size();
            if (this.avF) {
                i++;
            }
        }
        return i + this.avH + this.avI;
    }

    public void setTempSize(int i) {
        this.avH = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.avI = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.avB = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avA = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.avE = i;
    }

    public void a(a.f fVar) {
        this.avC = fVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        if (obj instanceof f) {
            ((f) obj).onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View c = c(viewGroup, i);
        if (c == null && this.avJ != null && this.avJ.size() != 0) {
            Iterator<a> it = this.avJ.iterator();
            while (it.hasNext() && (c = it.next().e(viewGroup, i)) == null) {
            }
        }
        if (c == null) {
            return d(viewGroup, i);
        }
        return c;
    }

    public void setIsCanDrag(boolean z) {
        this.avO = z;
    }

    private f c(ViewGroup viewGroup, int i) {
        String str = i < this.avy.size() ? this.avy.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        f fVar = new f(this.mContext);
        fVar.setOriImgSelectedCallback(this.avN);
        fVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        fVar.setImageOnClickListener(this.mOnClickListener);
        fVar.setImageOnLongClickListener(this.avA);
        fVar.setOuterOnTouchListener(this.avB);
        fVar.setIsCanDrag(this.avO);
        fVar.setIsCdn(this.avL);
        fVar.setOnSizeChangedListener(this.avC);
        viewGroup.addView(fVar, 0);
        fVar.setAssistUrl(fm(str));
        fVar.n(str, this.avM);
        fVar.setGifMaxUseableMem(this.avE);
        fVar.setTag(String.valueOf(i));
        fVar.setGifSetListener(this.avD);
        fVar.setHeadImage(this.avQ);
        fVar.setDragToExitListener(this.avK);
        return fVar;
    }

    public void setDrageToExitListener(a.d dVar) {
        this.avK = dVar;
    }

    private View d(ViewGroup viewGroup, int i) {
        if (this.avF && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.g.image)).setImageDrawable(aj.getDrawable(d.f.big_image_next_default));
            ((TextView) inflate.findViewById(d.g.thread_name)).setText(this.avG);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.mPosition != i) {
                com.baidu.tbadk.widget.a imageView = fVar.getImageView();
                if (imageView != null) {
                    imageView.HN();
                    this.avP.setCurrentView(imageView);
                    if (imageView.getImageType() == 1) {
                        this.avD.a(imageView);
                    }
                }
                fVar.BG();
                fVar.BF();
                fVar.j(this.avM, true);
                this.mPosition = i;
                this.avx = fVar;
            }
        }
    }

    private ImageUrlData fm(String str) {
        if (TextUtils.isEmpty(str) || this.avz == null) {
            return null;
        }
        return this.avz.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.avM = z;
    }

    public void setIsCdn(boolean z) {
        this.avL = z;
    }

    public void setHeadImage(boolean z) {
        this.avQ = z;
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        this.avN = bVar;
    }
}
