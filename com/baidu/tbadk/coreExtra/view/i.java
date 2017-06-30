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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.view.u;
import com.baidu.tbadk.widget.b;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class i extends PagerAdapter {
    private ArrayList<String> auc;
    private Map<String, ImageUrlData> aud;
    private b.d aug;
    private List<a> aum;
    private u.b aup;
    private boolean aur;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aue = null;
    private b.e auf = null;
    private int auh = 0;
    private boolean aui = false;
    private String auj = null;
    private int auk = 0;
    private int aul = 0;
    private boolean aun = false;
    private boolean auo = false;
    private int auq = -1;

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
        this.auc = null;
        this.aug = null;
        this.aum = null;
        this.mContext = context;
        this.auc = arrayList;
        this.aug = dVar;
        this.aum = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.auc = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aud = map;
    }

    public void setNextTitle(String str) {
        this.auj = str;
    }

    public void setHasNext(boolean z) {
        this.aui = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.aum.add(aVar);
    }

    public boolean getHasNext() {
        return this.aui;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.auc != null) {
            i = this.auc.size();
            if (this.aui) {
                i++;
            }
        }
        return i + this.auk + this.aul;
    }

    public void setTempSize(int i) {
        this.auk = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aul = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aue = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.auh = i;
    }

    public void a(b.e eVar) {
        this.auf = eVar;
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
        if (this.aum.size() != 0) {
            for (a aVar : this.aum) {
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
        uVar.setOriImgSelectedCallback(this.aup);
        String str = null;
        if (i < this.auc.size()) {
            str = this.auc.get(i);
        }
        uVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        uVar.setImageOnClickListener(this.mOnClickListener);
        uVar.setImageOnLongClickListener(this.aue);
        uVar.setIsCdn(this.aun);
        uVar.setOnSizeChangedListener(this.auf);
        ((ViewPager) viewGroup).addView(uVar, 0);
        uVar.setAssistUrl(eX(str));
        uVar.o(str, this.auo);
        uVar.setGifMaxUseableMem(this.auh);
        uVar.setTag(String.valueOf(i));
        uVar.setGifSetListener(this.aug);
        uVar.setHeadImage(this.aur);
        return uVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.aui && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(w.j.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(w.h.image)).setImageDrawable(as.getDrawable(w.g.big_image_next_default));
            ((TextView) inflate.findViewById(w.h.thread_name)).setText(this.auj);
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
            if (this.auq == i) {
                z = false;
            } else {
                this.auq = i;
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
            if (imageView != currentView || i == this.auc.size() - 1) {
                if (currentView != null) {
                    currentView.Hm();
                }
                ((u) obj).Br();
                ((u) obj).h(this.auo, z);
                hVar.setCurrentView(imageView);
                if (((u) obj).getImageType() == 1) {
                    this.aug.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eX(String str) {
        if (TextUtils.isEmpty(str) || this.aud == null) {
            return null;
        }
        return this.aud.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.auo = z;
    }

    public void setIsCdn(boolean z) {
        this.aun = z;
    }

    public void setHeadImage(boolean z) {
        this.aur = z;
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        this.aup = bVar;
    }
}
