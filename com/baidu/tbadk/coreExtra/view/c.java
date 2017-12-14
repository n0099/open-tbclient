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
    private f avC;
    private Map<String, ImageUrlData> avE;
    private a.e avI;
    private List<a> avO;
    private a.d avP;
    private f.b avS;
    private boolean avT;
    private b avU;
    private boolean avV;
    private Context mContext;
    private ArrayList<String> avD = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener avF = null;
    private View.OnTouchListener avG = null;
    private a.f avH = null;
    private int avJ = 0;
    private boolean avK = false;
    private String avL = null;
    private int avM = 0;
    private int avN = 0;
    private boolean avQ = false;
    private boolean avR = false;
    private int mPosition = -1;

    /* loaded from: classes.dex */
    public interface a {
        View e(ViewGroup viewGroup, int i);
    }

    public c(Context context, b bVar, a.e eVar) {
        this.mContext = null;
        this.avI = null;
        this.avO = null;
        this.mContext = context;
        this.avU = bVar;
        this.avI = eVar;
        this.avO = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.avD = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.avE = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.avL = str;
    }

    public void setHasNext(boolean z) {
        this.avK = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.avO.add(aVar);
    }

    public boolean getHasNext() {
        return this.avK;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.avD != null) {
            i = this.avD.size();
            if (this.avK) {
                i++;
            }
        }
        return i + this.avM + this.avN;
    }

    public void setTempSize(int i) {
        this.avM = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.avN = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.avG = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avF = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.avJ = i;
    }

    public void a(a.f fVar) {
        this.avH = fVar;
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
        if (c == null && this.avO != null && this.avO.size() != 0) {
            Iterator<a> it = this.avO.iterator();
            while (it.hasNext() && (c = it.next().e(viewGroup, i)) == null) {
            }
        }
        if (c == null) {
            return d(viewGroup, i);
        }
        return c;
    }

    public void setIsCanDrag(boolean z) {
        this.avT = z;
    }

    private f c(ViewGroup viewGroup, int i) {
        String str = i < this.avD.size() ? this.avD.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        f fVar = new f(this.mContext);
        fVar.setOriImgSelectedCallback(this.avS);
        fVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        fVar.setImageOnClickListener(this.mOnClickListener);
        fVar.setImageOnLongClickListener(this.avF);
        fVar.setOuterOnTouchListener(this.avG);
        fVar.setIsCanDrag(this.avT);
        fVar.setIsCdn(this.avQ);
        fVar.setOnSizeChangedListener(this.avH);
        viewGroup.addView(fVar, 0);
        fVar.setAssistUrl(fl(str));
        fVar.o(str, this.avR);
        fVar.setGifMaxUseableMem(this.avJ);
        fVar.setTag(String.valueOf(i));
        fVar.setGifSetListener(this.avI);
        fVar.setHeadImage(this.avV);
        fVar.setDragToExitListener(this.avP);
        return fVar;
    }

    public void setDrageToExitListener(a.d dVar) {
        this.avP = dVar;
    }

    private View d(ViewGroup viewGroup, int i) {
        if (this.avK && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.g.image)).setImageDrawable(aj.getDrawable(d.f.big_image_next_default));
            ((TextView) inflate.findViewById(d.g.thread_name)).setText(this.avL);
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
                    this.avU.setCurrentView(imageView);
                    if (imageView.getImageType() == 1) {
                        this.avI.a(imageView);
                    }
                }
                fVar.BH();
                fVar.BG();
                fVar.j(this.avR, true);
                this.mPosition = i;
                this.avC = fVar;
            }
        }
    }

    private ImageUrlData fl(String str) {
        if (TextUtils.isEmpty(str) || this.avE == null) {
            return null;
        }
        return this.avE.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.avR = z;
    }

    public void setIsCdn(boolean z) {
        this.avQ = z;
    }

    public void setHeadImage(boolean z) {
        this.avV = z;
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        this.avS = bVar;
    }
}
