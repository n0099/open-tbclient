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
    private boolean bmA;
    private Map<String, ImageUrlData> bmj;
    private a.e bmn;
    private List<a> bmt;
    private a.d bmu;
    private f.b bmx;
    private boolean bmy;
    private b bmz;
    private Context mContext;
    private ArrayList<String> bmi = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener bmk = null;
    private View.OnTouchListener bml = null;
    private a.f bmm = null;
    private int bmo = 0;
    private boolean bmp = false;
    private String bmq = null;
    private int bmr = 0;
    private int bms = 0;
    private boolean bmv = false;
    private boolean bmw = false;
    private int mPosition = -1;

    /* loaded from: classes.dex */
    public interface a {
        View g(ViewGroup viewGroup, int i);
    }

    public c(Context context, b bVar, a.e eVar) {
        this.mContext = null;
        this.bmn = null;
        this.bmt = null;
        this.mContext = context;
        this.bmz = bVar;
        this.bmn = eVar;
        this.bmt = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.bmi = new ArrayList<>();
        } else {
            this.bmi = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.bmj = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.bmq = str;
    }

    public void setHasNext(boolean z) {
        this.bmp = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.bmt.add(aVar);
    }

    public boolean getHasNext() {
        return this.bmp;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.bmi != null) {
            i = this.bmi.size();
            if (this.bmp) {
                i++;
            }
        }
        return i + this.bmr + this.bms;
    }

    public void setTempSize(int i) {
        this.bmr = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.bms = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.bml = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmk = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.bmo = i;
    }

    public void a(a.f fVar) {
        this.bmm = fVar;
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
        if (e == null && this.bmt != null && this.bmt.size() != 0) {
            Iterator<a> it = this.bmt.iterator();
            while (it.hasNext() && (e = it.next().g(viewGroup, i)) == null) {
            }
        }
        if (e == null) {
            return f(viewGroup, i);
        }
        return e;
    }

    public void setIsCanDrag(boolean z) {
        this.bmy = z;
    }

    private f e(ViewGroup viewGroup, int i) {
        String str = i < this.bmi.size() ? this.bmi.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        f fVar = new f(this.mContext);
        fVar.setOriImgSelectedCallback(this.bmx);
        fVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        fVar.setImageOnClickListener(this.mOnClickListener);
        fVar.setImageOnLongClickListener(this.bmk);
        fVar.setOuterOnTouchListener(this.bml);
        fVar.setIsCanDrag(this.bmy);
        fVar.setIsCdn(this.bmv);
        fVar.setOnSizeChangedListener(this.bmm);
        viewGroup.addView(fVar, 0);
        fVar.setAssistUrl(fJ(str));
        fVar.m(str, this.bmw);
        fVar.setGifMaxUseableMem(this.bmo);
        fVar.setTag(String.valueOf(i));
        fVar.setGifSetListener(this.bmn);
        fVar.setHeadImage(this.bmA);
        fVar.setDragToExitListener(this.bmu);
        return fVar;
    }

    public void setDrageToExitListener(a.d dVar) {
        this.bmu = dVar;
    }

    private View f(ViewGroup viewGroup, int i) {
        if (this.bmp && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.g.image)).setImageDrawable(aj.getDrawable(d.f.big_image_next_default));
            ((TextView) inflate.findViewById(d.g.thread_name)).setText(this.bmq);
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
                this.bmz.setCurrentView(imageView);
                if (imageView.getImageType() == 1) {
                    this.bmn.a(imageView);
                }
            }
            fVar.JH();
            fVar.JG();
            fVar.l(this.bmw, true);
        }
    }

    private ImageUrlData fJ(String str) {
        if (TextUtils.isEmpty(str) || this.bmj == null) {
            return null;
        }
        return this.bmj.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.bmw = z;
    }

    public void setIsCdn(boolean z) {
        this.bmv = z;
    }

    public void setHeadImage(boolean z) {
        this.bmA = z;
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        this.bmx = bVar;
    }
}
