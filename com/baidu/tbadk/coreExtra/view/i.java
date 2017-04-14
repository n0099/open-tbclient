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
    private ArrayList<String> atj;
    private Map<String, ImageUrlData> atk;
    private a.d atn;
    private List<a> att;
    private u.b atw;
    private boolean aty;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener atl = null;
    private a.e atm = null;
    private int ato = 0;
    private boolean atp = false;
    private String atq = null;
    private int atr = 0;
    private int ats = 0;
    private boolean atu = false;
    private boolean atv = false;
    private int atx = -1;

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
        this.atj = null;
        this.atn = null;
        this.att = null;
        this.mContext = context;
        this.atj = arrayList;
        this.atn = dVar;
        this.att = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.atj = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.atk = map;
    }

    public void setNextTitle(String str) {
        this.atq = str;
    }

    public void setHasNext(boolean z) {
        this.atp = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.att.add(aVar);
    }

    public boolean getHasNext() {
        return this.atp;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.atj != null) {
            i = this.atj.size();
            if (this.atp) {
                i++;
            }
        }
        return i + this.atr + this.ats;
    }

    public void setTempSize(int i) {
        this.atr = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.ats = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atl = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.ato = i;
    }

    public void a(a.e eVar) {
        this.atm = eVar;
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
        if (this.att.size() != 0) {
            for (a aVar : this.att) {
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
        uVar.setOriImgSelectedCallback(this.atw);
        String str = null;
        if (i < this.atj.size()) {
            str = this.atj.get(i);
        }
        uVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        uVar.setImageOnClickListener(this.mOnClickListener);
        uVar.setImageOnLongClickListener(this.atl);
        uVar.setIsCdn(this.atu);
        uVar.setOnSizeChangedListener(this.atm);
        ((ViewPager) viewGroup).addView(uVar, 0);
        uVar.setAssistUrl(eG(str));
        uVar.q(str, this.atv);
        uVar.setGifMaxUseableMem(this.ato);
        uVar.setTag(String.valueOf(i));
        uVar.setGifSetListener(this.atn);
        uVar.setHeadImage(this.aty);
        return uVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.atp && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(w.j.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(w.h.image)).setImageDrawable(aq.getDrawable(w.g.big_image_next_default));
            ((TextView) inflate.findViewById(w.h.thread_name)).setText(this.atq);
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
            if (this.atx == i) {
                z = false;
            } else {
                this.atx = i;
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
            if (imageView != currentView || i == this.atj.size() - 1) {
                if (currentView != null) {
                    currentView.HK();
                }
                ((u) obj).BS();
                ((u) obj).g(this.atv, z);
                hVar.setCurrentView(imageView);
                if (((u) obj).getImageType() == 1) {
                    this.atn.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eG(String str) {
        if (TextUtils.isEmpty(str) || this.atk == null) {
            return null;
        }
        return this.atk.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.atv = z;
    }

    public void setIsCdn(boolean z) {
        this.atu = z;
    }

    public void setHeadImage(boolean z) {
        this.aty = z;
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        this.atw = bVar;
    }
}
