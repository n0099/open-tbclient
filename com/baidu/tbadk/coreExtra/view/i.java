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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.view.u;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class i extends PagerAdapter {
    private List<a> aoC;
    private u.b aoF;
    private boolean aoH;
    private ArrayList<String> aos;
    private Map<String, ImageUrlData> aot;
    private a.d aow;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aou = null;
    private a.e aov = null;
    private int aox = 0;
    private boolean aoy = false;
    private String aoz = null;
    private int aoA = 0;
    private int aoB = 0;
    private boolean aoD = false;
    private boolean aoE = false;
    private int aoG = -1;

    /* loaded from: classes.dex */
    public interface a {
        View g(ViewGroup viewGroup, int i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public i(Context context, ArrayList<String> arrayList, a.d dVar) {
        this.mContext = null;
        this.aos = null;
        this.aow = null;
        this.aoC = null;
        this.mContext = context;
        this.aos = arrayList;
        this.aow = dVar;
        this.aoC = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.aos = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aot = map;
    }

    public void setNextTitle(String str) {
        this.aoz = str;
    }

    public void setHasNext(boolean z) {
        this.aoy = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.aoC.add(aVar);
    }

    public boolean getHasNext() {
        return this.aoy;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.aos != null) {
            i = this.aos.size();
            if (this.aoy) {
                i++;
            }
        }
        return i + this.aoA + this.aoB;
    }

    public void setTempSize(int i) {
        this.aoA = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aoB = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aou = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aox = i;
    }

    public void a(a.e eVar) {
        this.aov = eVar;
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
        if (this.aoC.size() != 0) {
            for (a aVar : this.aoC) {
                View g = aVar.g(viewGroup, i);
                if (g != null) {
                    return g;
                }
            }
        }
        View f = f(viewGroup, i);
        if (f == null) {
            return e(viewGroup, i);
        }
        return f;
    }

    private u e(ViewGroup viewGroup, int i) {
        u uVar = new u(this.mContext);
        uVar.setOriImgSelectedCallback(this.aoF);
        String str = null;
        if (i < this.aos.size()) {
            str = this.aos.get(i);
        }
        uVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        uVar.setImageOnClickListener(this.mOnClickListener);
        uVar.setImageOnLongClickListener(this.aou);
        uVar.setIsCdn(this.aoD);
        uVar.setOnSizeChangedListener(this.aov);
        ((ViewPager) viewGroup).addView(uVar, 0);
        uVar.setAssistUrl(eO(str));
        uVar.q(str, this.aoE);
        uVar.setGifMaxUseableMem(this.aox);
        uVar.setTag(String.valueOf(i));
        uVar.setGifSetListener(this.aow);
        uVar.setHeadImage(this.aoH);
        return uVar;
    }

    private View f(ViewGroup viewGroup, int i) {
        if (this.aoy && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(r.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(r.g.image)).setImageDrawable(ar.getDrawable(r.f.big_image_next_default));
            ((TextView) inflate.findViewById(r.g.thread_name)).setText(this.aoz);
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
            if (this.aoG == i) {
                z = false;
            } else {
                this.aoG = i;
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
            if (imageView != currentView || i == this.aos.size() - 1) {
                if (currentView != null) {
                    currentView.GU();
                }
                ((u) obj).Bg();
                ((u) obj).g(this.aoE, z);
                hVar.setCurrentView(imageView);
                if (((u) obj).getImageType() == 1) {
                    this.aow.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eO(String str) {
        if (TextUtils.isEmpty(str) || this.aot == null) {
            return null;
        }
        return this.aot.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aoE = z;
    }

    public void setIsCdn(boolean z) {
        this.aoD = z;
    }

    public void setHeadImage(boolean z) {
        this.aoH = z;
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        this.aoF = bVar;
    }
}
