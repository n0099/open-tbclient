package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.view.u;
import com.baidu.tbadk.widget.b;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class i extends PagerAdapter {
    private ArrayList<String> asZ;
    private Map<String, ImageUrlData> ata;
    private b.d atd;
    private List<a> atj;
    private u.b atm;
    private boolean ato;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener atb = null;
    private b.e atc = null;
    private int ate = 0;
    private boolean atf = false;
    private String atg = null;
    private int ath = 0;
    private int ati = 0;
    private boolean atk = false;
    private boolean atl = false;
    private int atn = -1;

    /* loaded from: classes.dex */
    public interface a {
        View f(ViewGroup viewGroup, int i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public i(Context context, ArrayList<String> arrayList, b.d dVar) {
        this.mContext = null;
        this.asZ = null;
        this.atd = null;
        this.atj = null;
        this.mContext = context;
        this.asZ = arrayList;
        this.atd = dVar;
        this.atj = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.asZ = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.ata = map;
    }

    public void setNextTitle(String str) {
        this.atg = str;
    }

    public void setHasNext(boolean z) {
        this.atf = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.atj.add(aVar);
    }

    public boolean getHasNext() {
        return this.atf;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.asZ != null) {
            i = this.asZ.size();
            if (this.atf) {
                i++;
            }
        }
        return i + this.ath + this.ati;
    }

    public void setTempSize(int i) {
        this.ath = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.ati = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atb = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.ate = i;
    }

    public void a(b.e eVar) {
        this.atc = eVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof u) {
            ((u) obj).onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.atj.size() != 0) {
            for (a aVar : this.atj) {
                View f = aVar.f(viewGroup, i);
                if (f != null) {
                    return f;
                }
            }
        }
        View e = e(viewGroup, i);
        if (e == null) {
            return d(viewGroup, i);
        }
        return e;
    }

    private u d(ViewGroup viewGroup, int i) {
        u uVar = new u(this.mContext);
        uVar.setOriImgSelectedCallback(this.atm);
        String str = null;
        if (i < this.asZ.size()) {
            str = this.asZ.get(i);
        }
        uVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        uVar.setImageOnClickListener(this.mOnClickListener);
        uVar.setImageOnLongClickListener(this.atb);
        uVar.setIsCdn(this.atk);
        uVar.setOnSizeChangedListener(this.atc);
        ((ViewPager) viewGroup).addView(uVar, 0);
        uVar.setAssistUrl(eD(str));
        uVar.n(str, this.atl);
        uVar.setGifMaxUseableMem(this.ate);
        uVar.setTag(String.valueOf(i));
        uVar.setGifSetListener(this.atd);
        uVar.setHeadImage(this.ato);
        return uVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.atf && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(w.j.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(w.h.image)).setImageDrawable(aq.getDrawable(w.g.big_image_next_default));
            ((TextView) inflate.findViewById(w.h.thread_name)).setText(this.atg);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        boolean z;
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof u) {
            if (this.atn == i) {
                z = false;
            } else {
                this.atn = i;
                z = true;
            }
            h hVar = (h) viewGroup;
            com.baidu.tbadk.widget.b imageView = ((u) obj).getImageView();
            if (hVar.getSelectedView() == null) {
                hVar.setSelectedView(imageView);
                ViewParent parent = hVar.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            com.baidu.tbadk.widget.b currentView = hVar.getCurrentView();
            if (imageView != currentView || i == this.asZ.size() - 1) {
                if (currentView != null) {
                    currentView.GP();
                }
                ((u) obj).AW();
                ((u) obj).g(this.atl, z);
                hVar.setCurrentView(imageView);
                if (((u) obj).getImageType() == 1) {
                    this.atd.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eD(String str) {
        if (TextUtils.isEmpty(str) || this.ata == null) {
            return null;
        }
        return this.ata.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.atl = z;
    }

    public void setIsCdn(boolean z) {
        this.atk = z;
    }

    public void setHeadImage(boolean z) {
        this.ato = z;
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        this.atm = bVar;
    }
}
