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
    private boolean atA;
    private ArrayList<String> atl;
    private Map<String, ImageUrlData> atm;
    private a.d atp;
    private List<a> atv;
    private u.b aty;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener atn = null;
    private a.e ato = null;
    private int atq = 0;
    private boolean atr = false;
    private String ats = null;
    private int att = 0;
    private int atu = 0;
    private boolean atw = false;
    private boolean atx = false;
    private int atz = -1;

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
        this.atl = null;
        this.atp = null;
        this.atv = null;
        this.mContext = context;
        this.atl = arrayList;
        this.atp = dVar;
        this.atv = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.atl = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.atm = map;
    }

    public void setNextTitle(String str) {
        this.ats = str;
    }

    public void setHasNext(boolean z) {
        this.atr = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.atv.add(aVar);
    }

    public boolean getHasNext() {
        return this.atr;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.atl != null) {
            i = this.atl.size();
            if (this.atr) {
                i++;
            }
        }
        return i + this.att + this.atu;
    }

    public void setTempSize(int i) {
        this.att = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.atu = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atn = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.atq = i;
    }

    public void a(a.e eVar) {
        this.ato = eVar;
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
        if (this.atv.size() != 0) {
            for (a aVar : this.atv) {
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
        uVar.setOriImgSelectedCallback(this.aty);
        String str = null;
        if (i < this.atl.size()) {
            str = this.atl.get(i);
        }
        uVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        uVar.setImageOnClickListener(this.mOnClickListener);
        uVar.setImageOnLongClickListener(this.atn);
        uVar.setIsCdn(this.atw);
        uVar.setOnSizeChangedListener(this.ato);
        ((ViewPager) viewGroup).addView(uVar, 0);
        uVar.setAssistUrl(eG(str));
        uVar.q(str, this.atx);
        uVar.setGifMaxUseableMem(this.atq);
        uVar.setTag(String.valueOf(i));
        uVar.setGifSetListener(this.atp);
        uVar.setHeadImage(this.atA);
        return uVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.atr && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(w.j.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(w.h.image)).setImageDrawable(aq.getDrawable(w.g.big_image_next_default));
            ((TextView) inflate.findViewById(w.h.thread_name)).setText(this.ats);
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
            if (this.atz == i) {
                z = false;
            } else {
                this.atz = i;
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
            if (imageView != currentView || i == this.atl.size() - 1) {
                if (currentView != null) {
                    currentView.HK();
                }
                ((u) obj).BS();
                ((u) obj).g(this.atx, z);
                hVar.setCurrentView(imageView);
                if (((u) obj).getImageType() == 1) {
                    this.atp.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eG(String str) {
        if (TextUtils.isEmpty(str) || this.atm == null) {
            return null;
        }
        return this.atm.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.atx = z;
    }

    public void setIsCdn(boolean z) {
        this.atw = z;
    }

    public void setHeadImage(boolean z) {
        this.atA = z;
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        this.aty = bVar;
    }
}
