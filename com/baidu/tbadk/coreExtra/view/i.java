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
    private u.b atC;
    private boolean atE;
    private ArrayList<String> atp;
    private Map<String, ImageUrlData> atq;
    private b.d att;
    private List<a> atz;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener atr = null;
    private b.e ats = null;
    private int atu = 0;
    private boolean atv = false;
    private String atw = null;
    private int atx = 0;
    private int aty = 0;
    private boolean atA = false;
    private boolean atB = false;
    private int atD = -1;

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
        this.atp = null;
        this.att = null;
        this.atz = null;
        this.mContext = context;
        this.atp = arrayList;
        this.att = dVar;
        this.atz = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.atp = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.atq = map;
    }

    public void setNextTitle(String str) {
        this.atw = str;
    }

    public void setHasNext(boolean z) {
        this.atv = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.atz.add(aVar);
    }

    public boolean getHasNext() {
        return this.atv;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.atp != null) {
            i = this.atp.size();
            if (this.atv) {
                i++;
            }
        }
        return i + this.atx + this.aty;
    }

    public void setTempSize(int i) {
        this.atx = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aty = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atr = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.atu = i;
    }

    public void a(b.e eVar) {
        this.ats = eVar;
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
        if (this.atz.size() != 0) {
            for (a aVar : this.atz) {
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
        uVar.setOriImgSelectedCallback(this.atC);
        String str = null;
        if (i < this.atp.size()) {
            str = this.atp.get(i);
        }
        uVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        uVar.setImageOnClickListener(this.mOnClickListener);
        uVar.setImageOnLongClickListener(this.atr);
        uVar.setIsCdn(this.atA);
        uVar.setOnSizeChangedListener(this.ats);
        ((ViewPager) viewGroup).addView(uVar, 0);
        uVar.setAssistUrl(eF(str));
        uVar.q(str, this.atB);
        uVar.setGifMaxUseableMem(this.atu);
        uVar.setTag(String.valueOf(i));
        uVar.setGifSetListener(this.att);
        uVar.setHeadImage(this.atE);
        return uVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.atv && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(w.j.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(w.h.image)).setImageDrawable(aq.getDrawable(w.g.big_image_next_default));
            ((TextView) inflate.findViewById(w.h.thread_name)).setText(this.atw);
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
            if (this.atD == i) {
                z = false;
            } else {
                this.atD = i;
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
            if (imageView != currentView || i == this.atp.size() - 1) {
                if (currentView != null) {
                    currentView.GV();
                }
                ((u) obj).Bd();
                ((u) obj).g(this.atB, z);
                hVar.setCurrentView(imageView);
                if (((u) obj).getImageType() == 1) {
                    this.att.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eF(String str) {
        if (TextUtils.isEmpty(str) || this.atq == null) {
            return null;
        }
        return this.atq.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.atB = z;
    }

    public void setIsCdn(boolean z) {
        this.atA = z;
    }

    public void setHeadImage(boolean z) {
        this.atE = z;
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        this.atC = bVar;
    }
}
