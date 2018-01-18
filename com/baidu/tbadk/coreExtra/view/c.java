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
    private Map<String, ImageUrlData> bjW;
    private a.e bka;
    private List<a> bkg;
    private a.d bkh;
    private f.b bkk;
    private boolean bkl;
    private b bkm;
    private boolean bkn;
    private Context mContext;
    private ArrayList<String> bjV = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener bjX = null;
    private View.OnTouchListener bjY = null;
    private a.f bjZ = null;
    private int bkb = 0;
    private boolean bkc = false;
    private String bkd = null;
    private int bke = 0;
    private int bkf = 0;
    private boolean bki = false;
    private boolean bkj = false;
    private int mPosition = -1;

    /* loaded from: classes.dex */
    public interface a {
        View g(ViewGroup viewGroup, int i);
    }

    public c(Context context, b bVar, a.e eVar) {
        this.mContext = null;
        this.bka = null;
        this.bkg = null;
        this.mContext = context;
        this.bkm = bVar;
        this.bka = eVar;
        this.bkg = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.bjV = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.bjW = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.bkd = str;
    }

    public void setHasNext(boolean z) {
        this.bkc = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.bkg.add(aVar);
    }

    public boolean getHasNext() {
        return this.bkc;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.bjV != null) {
            i = this.bjV.size();
            if (this.bkc) {
                i++;
            }
        }
        return i + this.bke + this.bkf;
    }

    public void setTempSize(int i) {
        this.bke = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.bkf = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.bjY = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bjX = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.bkb = i;
    }

    public void a(a.f fVar) {
        this.bjZ = fVar;
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
        if (e == null && this.bkg != null && this.bkg.size() != 0) {
            Iterator<a> it = this.bkg.iterator();
            while (it.hasNext() && (e = it.next().g(viewGroup, i)) == null) {
            }
        }
        if (e == null) {
            return f(viewGroup, i);
        }
        return e;
    }

    public void setIsCanDrag(boolean z) {
        this.bkl = z;
    }

    private f e(ViewGroup viewGroup, int i) {
        String str = i < this.bjV.size() ? this.bjV.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        f fVar = new f(this.mContext);
        fVar.setOriImgSelectedCallback(this.bkk);
        fVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        fVar.setImageOnClickListener(this.mOnClickListener);
        fVar.setImageOnLongClickListener(this.bjX);
        fVar.setOuterOnTouchListener(this.bjY);
        fVar.setIsCanDrag(this.bkl);
        fVar.setIsCdn(this.bki);
        fVar.setOnSizeChangedListener(this.bjZ);
        viewGroup.addView(fVar, 0);
        fVar.setAssistUrl(fs(str));
        fVar.n(str, this.bkj);
        fVar.setGifMaxUseableMem(this.bkb);
        fVar.setTag(String.valueOf(i));
        fVar.setGifSetListener(this.bka);
        fVar.setHeadImage(this.bkn);
        fVar.setDragToExitListener(this.bkh);
        return fVar;
    }

    public void setDrageToExitListener(a.d dVar) {
        this.bkh = dVar;
    }

    private View f(ViewGroup viewGroup, int i) {
        if (this.bkc && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.g.image)).setImageDrawable(aj.getDrawable(d.f.big_image_next_default));
            ((TextView) inflate.findViewById(d.g.thread_name)).setText(this.bkd);
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
                imageView.Pb();
                this.bkm.setCurrentView(imageView);
                if (imageView.getImageType() == 1) {
                    this.bka.a(imageView);
                }
            }
            fVar.IY();
            fVar.IX();
            fVar.l(this.bkj, true);
        }
    }

    private ImageUrlData fs(String str) {
        if (TextUtils.isEmpty(str) || this.bjW == null) {
            return null;
        }
        return this.bjW.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.bkj = z;
    }

    public void setIsCdn(boolean z) {
        this.bki = z;
    }

    public void setHeadImage(boolean z) {
        this.bkn = z;
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        this.bkk = bVar;
    }
}
