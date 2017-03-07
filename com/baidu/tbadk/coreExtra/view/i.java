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
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class i extends PagerAdapter {
    private ArrayList<String> asT;
    private Map<String, ImageUrlData> asU;
    private a.d asX;
    private List<a> atd;
    private u.b atg;
    private boolean ati;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener asV = null;
    private a.e asW = null;
    private int asY = 0;
    private boolean asZ = false;
    private String ata = null;
    private int atb = 0;
    private int atc = 0;
    private boolean ate = false;
    private boolean atf = false;
    private int ath = -1;

    /* loaded from: classes.dex */
    public interface a {
        View f(ViewGroup viewGroup, int i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public i(Context context, ArrayList<String> arrayList, a.d dVar) {
        this.mContext = null;
        this.asT = null;
        this.asX = null;
        this.atd = null;
        this.mContext = context;
        this.asT = arrayList;
        this.asX = dVar;
        this.atd = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.asT = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.asU = map;
    }

    public void setNextTitle(String str) {
        this.ata = str;
    }

    public void setHasNext(boolean z) {
        this.asZ = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.atd.add(aVar);
    }

    public boolean getHasNext() {
        return this.asZ;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.asT != null) {
            i = this.asT.size();
            if (this.asZ) {
                i++;
            }
        }
        return i + this.atb + this.atc;
    }

    public void setTempSize(int i) {
        this.atb = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.atc = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.asV = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.asY = i;
    }

    public void a(a.e eVar) {
        this.asW = eVar;
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
        if (this.atd.size() != 0) {
            for (a aVar : this.atd) {
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
        uVar.setOriImgSelectedCallback(this.atg);
        String str = null;
        if (i < this.asT.size()) {
            str = this.asT.get(i);
        }
        uVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        uVar.setImageOnClickListener(this.mOnClickListener);
        uVar.setImageOnLongClickListener(this.asV);
        uVar.setIsCdn(this.ate);
        uVar.setOnSizeChangedListener(this.asW);
        ((ViewPager) viewGroup).addView(uVar, 0);
        uVar.setAssistUrl(eA(str));
        uVar.q(str, this.atf);
        uVar.setGifMaxUseableMem(this.asY);
        uVar.setTag(String.valueOf(i));
        uVar.setGifSetListener(this.asX);
        uVar.setHeadImage(this.ati);
        return uVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.asZ && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(w.j.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(w.h.image)).setImageDrawable(aq.getDrawable(w.g.big_image_next_default));
            ((TextView) inflate.findViewById(w.h.thread_name)).setText(this.ata);
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
            if (this.ath == i) {
                z = false;
            } else {
                this.ath = i;
                z = true;
            }
            h hVar = (h) viewGroup;
            com.baidu.tbadk.widget.a imageView = ((u) obj).getImageView();
            if (hVar.getSelectedView() == null) {
                hVar.setSelectedView(imageView);
                ViewParent parent = hVar.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            com.baidu.tbadk.widget.a currentView = hVar.getCurrentView();
            if (imageView != currentView || i == this.asT.size() - 1) {
                if (currentView != null) {
                    currentView.Hl();
                }
                ((u) obj).Bu();
                ((u) obj).g(this.atf, z);
                hVar.setCurrentView(imageView);
                if (((u) obj).getImageType() == 1) {
                    this.asX.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eA(String str) {
        if (TextUtils.isEmpty(str) || this.asU == null) {
            return null;
        }
        return this.asU.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.atf = z;
    }

    public void setIsCdn(boolean z) {
        this.ate = z;
    }

    public void setHeadImage(boolean z) {
        this.ati = z;
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        this.atg = bVar;
    }
}
