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
    private f avF;
    private Map<String, ImageUrlData> avH;
    private a.e avL;
    private List<a> avR;
    private a.d avS;
    private f.b avV;
    private boolean avW;
    private b avX;
    private boolean avY;
    private Context mContext;
    private ArrayList<String> avG = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener avI = null;
    private View.OnTouchListener avJ = null;
    private a.f avK = null;
    private int avM = 0;
    private boolean avN = false;
    private String avO = null;
    private int avP = 0;
    private int avQ = 0;
    private boolean avT = false;
    private boolean avU = false;
    private int mPosition = -1;

    /* loaded from: classes.dex */
    public interface a {
        View e(ViewGroup viewGroup, int i);
    }

    public c(Context context, b bVar, a.e eVar) {
        this.mContext = null;
        this.avL = null;
        this.avR = null;
        this.mContext = context;
        this.avX = bVar;
        this.avL = eVar;
        this.avR = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.avG = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.avH = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.avO = str;
    }

    public void setHasNext(boolean z) {
        this.avN = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.avR.add(aVar);
    }

    public boolean getHasNext() {
        return this.avN;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.avG != null) {
            i = this.avG.size();
            if (this.avN) {
                i++;
            }
        }
        return i + this.avP + this.avQ;
    }

    public void setTempSize(int i) {
        this.avP = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.avQ = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.avJ = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avI = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.avM = i;
    }

    public void a(a.f fVar) {
        this.avK = fVar;
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
        if (c == null && this.avR != null && this.avR.size() != 0) {
            Iterator<a> it = this.avR.iterator();
            while (it.hasNext() && (c = it.next().e(viewGroup, i)) == null) {
            }
        }
        if (c == null) {
            return d(viewGroup, i);
        }
        return c;
    }

    public void setIsCanDrag(boolean z) {
        this.avW = z;
    }

    private f c(ViewGroup viewGroup, int i) {
        String str = i < this.avG.size() ? this.avG.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        f fVar = new f(this.mContext);
        fVar.setOriImgSelectedCallback(this.avV);
        fVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        fVar.setImageOnClickListener(this.mOnClickListener);
        fVar.setImageOnLongClickListener(this.avI);
        fVar.setOuterOnTouchListener(this.avJ);
        fVar.setIsCanDrag(this.avW);
        fVar.setIsCdn(this.avT);
        fVar.setOnSizeChangedListener(this.avK);
        viewGroup.addView(fVar, 0);
        fVar.setAssistUrl(fl(str));
        fVar.o(str, this.avU);
        fVar.setGifMaxUseableMem(this.avM);
        fVar.setTag(String.valueOf(i));
        fVar.setGifSetListener(this.avL);
        fVar.setHeadImage(this.avY);
        fVar.setDragToExitListener(this.avS);
        return fVar;
    }

    public void setDrageToExitListener(a.d dVar) {
        this.avS = dVar;
    }

    private View d(ViewGroup viewGroup, int i) {
        if (this.avN && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.g.image)).setImageDrawable(aj.getDrawable(d.f.big_image_next_default));
            ((TextView) inflate.findViewById(d.g.thread_name)).setText(this.avO);
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
                    imageView.HO();
                    this.avX.setCurrentView(imageView);
                    if (imageView.getImageType() == 1) {
                        this.avL.a(imageView);
                    }
                }
                fVar.BH();
                fVar.BG();
                fVar.j(this.avU, true);
                this.mPosition = i;
                this.avF = fVar;
            }
        }
    }

    private ImageUrlData fl(String str) {
        if (TextUtils.isEmpty(str) || this.avH == null) {
            return null;
        }
        return this.avH.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.avU = z;
    }

    public void setIsCdn(boolean z) {
        this.avT = z;
    }

    public void setHeadImage(boolean z) {
        this.avY = z;
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        this.avV = bVar;
    }
}
