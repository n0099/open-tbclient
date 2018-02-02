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
    private Map<String, ImageUrlData> bke;
    private a.e bki;
    private List<a> bko;
    private a.d bkp;
    private f.b bks;
    private boolean bkt;
    private b bku;
    private boolean bkv;
    private Context mContext;
    private ArrayList<String> bkd = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener bkf = null;
    private View.OnTouchListener bkg = null;
    private a.f bkh = null;
    private int bkj = 0;
    private boolean bkk = false;
    private String bkl = null;
    private int bkm = 0;
    private int bkn = 0;
    private boolean bkq = false;
    private boolean bkr = false;
    private int mPosition = -1;

    /* loaded from: classes.dex */
    public interface a {
        View g(ViewGroup viewGroup, int i);
    }

    public c(Context context, b bVar, a.e eVar) {
        this.mContext = null;
        this.bki = null;
        this.bko = null;
        this.mContext = context;
        this.bku = bVar;
        this.bki = eVar;
        this.bko = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.bkd = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.bke = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.bkl = str;
    }

    public void setHasNext(boolean z) {
        this.bkk = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.bko.add(aVar);
    }

    public boolean getHasNext() {
        return this.bkk;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.bkd != null) {
            i = this.bkd.size();
            if (this.bkk) {
                i++;
            }
        }
        return i + this.bkm + this.bkn;
    }

    public void setTempSize(int i) {
        this.bkm = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.bkn = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.bkg = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bkf = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.bkj = i;
    }

    public void a(a.f fVar) {
        this.bkh = fVar;
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
        if (e == null && this.bko != null && this.bko.size() != 0) {
            Iterator<a> it = this.bko.iterator();
            while (it.hasNext() && (e = it.next().g(viewGroup, i)) == null) {
            }
        }
        if (e == null) {
            return f(viewGroup, i);
        }
        return e;
    }

    public void setIsCanDrag(boolean z) {
        this.bkt = z;
    }

    private f e(ViewGroup viewGroup, int i) {
        String str = i < this.bkd.size() ? this.bkd.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        f fVar = new f(this.mContext);
        fVar.setOriImgSelectedCallback(this.bks);
        fVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        fVar.setImageOnClickListener(this.mOnClickListener);
        fVar.setImageOnLongClickListener(this.bkf);
        fVar.setOuterOnTouchListener(this.bkg);
        fVar.setIsCanDrag(this.bkt);
        fVar.setIsCdn(this.bkq);
        fVar.setOnSizeChangedListener(this.bkh);
        viewGroup.addView(fVar, 0);
        fVar.setAssistUrl(fA(str));
        fVar.n(str, this.bkr);
        fVar.setGifMaxUseableMem(this.bkj);
        fVar.setTag(String.valueOf(i));
        fVar.setGifSetListener(this.bki);
        fVar.setHeadImage(this.bkv);
        fVar.setDragToExitListener(this.bkp);
        return fVar;
    }

    public void setDrageToExitListener(a.d dVar) {
        this.bkp = dVar;
    }

    private View f(ViewGroup viewGroup, int i) {
        if (this.bkk && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.g.image)).setImageDrawable(aj.getDrawable(d.f.big_image_next_default));
            ((TextView) inflate.findViewById(d.g.thread_name)).setText(this.bkl);
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
                imageView.Pd();
                this.bku.setCurrentView(imageView);
                if (imageView.getImageType() == 1) {
                    this.bki.a(imageView);
                }
            }
            fVar.Ja();
            fVar.IZ();
            fVar.l(this.bkr, true);
        }
    }

    private ImageUrlData fA(String str) {
        if (TextUtils.isEmpty(str) || this.bke == null) {
            return null;
        }
        return this.bke.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.bkr = z;
    }

    public void setIsCdn(boolean z) {
        this.bkq = z;
    }

    public void setHeadImage(boolean z) {
        this.bkv = z;
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        this.bks = bVar;
    }
}
