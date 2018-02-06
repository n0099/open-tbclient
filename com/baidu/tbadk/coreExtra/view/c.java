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
    private List<a> bmD;
    private a.d bmE;
    private f.b bmH;
    private boolean bmI;
    private b bmJ;
    private boolean bmK;
    private Map<String, ImageUrlData> bmt;
    private a.e bmx;
    private Context mContext;
    private ArrayList<String> bms = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener bmu = null;
    private View.OnTouchListener bmv = null;
    private a.f bmw = null;
    private int bmy = 0;
    private boolean bmz = false;
    private String bmA = null;
    private int bmB = 0;
    private int bmC = 0;
    private boolean bmF = false;
    private boolean bmG = false;
    private int mPosition = -1;

    /* loaded from: classes.dex */
    public interface a {
        View g(ViewGroup viewGroup, int i);
    }

    public c(Context context, b bVar, a.e eVar) {
        this.mContext = null;
        this.bmx = null;
        this.bmD = null;
        this.mContext = context;
        this.bmJ = bVar;
        this.bmx = eVar;
        this.bmD = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.bms = new ArrayList<>();
        } else {
            this.bms = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.bmt = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.bmA = str;
    }

    public void setHasNext(boolean z) {
        this.bmz = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.bmD.add(aVar);
    }

    public boolean getHasNext() {
        return this.bmz;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.bms != null) {
            i = this.bms.size();
            if (this.bmz) {
                i++;
            }
        }
        return i + this.bmB + this.bmC;
    }

    public void setTempSize(int i) {
        this.bmB = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.bmC = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.bmv = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmu = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.bmy = i;
    }

    public void a(a.f fVar) {
        this.bmw = fVar;
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
        View e = e(viewGroup, i);
        if (e == null && this.bmD != null && this.bmD.size() != 0) {
            Iterator<a> it = this.bmD.iterator();
            while (it.hasNext() && (e = it.next().g(viewGroup, i)) == null) {
            }
        }
        if (e == null) {
            return f(viewGroup, i);
        }
        return e;
    }

    public void setIsCanDrag(boolean z) {
        this.bmI = z;
    }

    private f e(ViewGroup viewGroup, int i) {
        String str = i < this.bms.size() ? this.bms.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        f fVar = new f(this.mContext);
        fVar.setOriImgSelectedCallback(this.bmH);
        fVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        fVar.setImageOnClickListener(this.mOnClickListener);
        fVar.setImageOnLongClickListener(this.bmu);
        fVar.setOuterOnTouchListener(this.bmv);
        fVar.setIsCanDrag(this.bmI);
        fVar.setIsCdn(this.bmF);
        fVar.setOnSizeChangedListener(this.bmw);
        viewGroup.addView(fVar, 0);
        fVar.setAssistUrl(fJ(str));
        fVar.n(str, this.bmG);
        fVar.setGifMaxUseableMem(this.bmy);
        fVar.setTag(String.valueOf(i));
        fVar.setGifSetListener(this.bmx);
        fVar.setHeadImage(this.bmK);
        fVar.setDragToExitListener(this.bmE);
        return fVar;
    }

    public void setDrageToExitListener(a.d dVar) {
        this.bmE = dVar;
    }

    private View f(ViewGroup viewGroup, int i) {
        if (this.bmz && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.g.image)).setImageDrawable(aj.getDrawable(d.f.big_image_next_default));
            ((TextView) inflate.findViewById(d.g.thread_name)).setText(this.bmA);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.mPosition != i && (obj instanceof f)) {
            this.mPosition = i;
            f fVar = (f) obj;
            com.baidu.tbadk.widget.a imageView = fVar.getImageView();
            if (imageView != null) {
                imageView.PI();
                this.bmJ.setCurrentView(imageView);
                if (imageView.getImageType() == 1) {
                    this.bmx.a(imageView);
                }
            }
            fVar.JH();
            fVar.JG();
            fVar.l(this.bmG, true);
        }
    }

    private ImageUrlData fJ(String str) {
        if (TextUtils.isEmpty(str) || this.bmt == null) {
            return null;
        }
        return this.bmt.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.bmG = z;
    }

    public void setIsCdn(boolean z) {
        this.bmF = z;
    }

    public void setHeadImage(boolean z) {
        this.bmK = z;
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        this.bmH = bVar;
    }
}
