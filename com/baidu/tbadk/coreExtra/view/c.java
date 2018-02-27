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
    private Map<String, ImageUrlData> bmg;
    private a.e bmk;
    private List<a> bmq;
    private a.d bmr;
    private f.b bmu;
    private boolean bmv;
    private b bmw;
    private boolean bmx;
    private Context mContext;
    private ArrayList<String> bmf = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener bmh = null;
    private View.OnTouchListener bmi = null;
    private a.f bmj = null;
    private int bml = 0;
    private boolean bmm = false;
    private String bmn = null;
    private int bmo = 0;
    private int bmp = 0;
    private boolean bms = false;
    private boolean bmt = false;
    private int mPosition = -1;

    /* loaded from: classes.dex */
    public interface a {
        View g(ViewGroup viewGroup, int i);
    }

    public c(Context context, b bVar, a.e eVar) {
        this.mContext = null;
        this.bmk = null;
        this.bmq = null;
        this.mContext = context;
        this.bmw = bVar;
        this.bmk = eVar;
        this.bmq = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.bmf = new ArrayList<>();
        } else {
            this.bmf = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.bmg = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.bmn = str;
    }

    public void setHasNext(boolean z) {
        this.bmm = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.bmq.add(aVar);
    }

    public boolean getHasNext() {
        return this.bmm;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.bmf != null) {
            i = this.bmf.size();
            if (this.bmm) {
                i++;
            }
        }
        return i + this.bmo + this.bmp;
    }

    public void setTempSize(int i) {
        this.bmo = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.bmp = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.bmi = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmh = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.bml = i;
    }

    public void a(a.f fVar) {
        this.bmj = fVar;
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
        if (e == null && this.bmq != null && this.bmq.size() != 0) {
            Iterator<a> it = this.bmq.iterator();
            while (it.hasNext() && (e = it.next().g(viewGroup, i)) == null) {
            }
        }
        if (e == null) {
            return f(viewGroup, i);
        }
        return e;
    }

    public void setIsCanDrag(boolean z) {
        this.bmv = z;
    }

    private f e(ViewGroup viewGroup, int i) {
        String str = i < this.bmf.size() ? this.bmf.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        f fVar = new f(this.mContext);
        fVar.setOriImgSelectedCallback(this.bmu);
        fVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        fVar.setImageOnClickListener(this.mOnClickListener);
        fVar.setImageOnLongClickListener(this.bmh);
        fVar.setOuterOnTouchListener(this.bmi);
        fVar.setIsCanDrag(this.bmv);
        fVar.setIsCdn(this.bms);
        fVar.setOnSizeChangedListener(this.bmj);
        viewGroup.addView(fVar, 0);
        fVar.setAssistUrl(fJ(str));
        fVar.m(str, this.bmt);
        fVar.setGifMaxUseableMem(this.bml);
        fVar.setTag(String.valueOf(i));
        fVar.setGifSetListener(this.bmk);
        fVar.setHeadImage(this.bmx);
        fVar.setDragToExitListener(this.bmr);
        return fVar;
    }

    public void setDrageToExitListener(a.d dVar) {
        this.bmr = dVar;
    }

    private View f(ViewGroup viewGroup, int i) {
        if (this.bmm && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.g.image)).setImageDrawable(aj.getDrawable(d.f.big_image_next_default));
            ((TextView) inflate.findViewById(d.g.thread_name)).setText(this.bmn);
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
                imageView.PH();
                this.bmw.setCurrentView(imageView);
                if (imageView.getImageType() == 1) {
                    this.bmk.a(imageView);
                }
            }
            fVar.JG();
            fVar.JF();
            fVar.l(this.bmt, true);
        }
    }

    private ImageUrlData fJ(String str) {
        if (TextUtils.isEmpty(str) || this.bmg == null) {
            return null;
        }
        return this.bmg.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.bmt = z;
    }

    public void setIsCdn(boolean z) {
        this.bms = z;
    }

    public void setHeadImage(boolean z) {
        this.bmx = z;
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        this.bmu = bVar;
    }
}
