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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.view.u;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class i extends PagerAdapter {
    private List<a> akC;
    private u.b akF;
    private boolean akH;
    private ArrayList<String> aks;
    private Map<String, ImageUrlData> akt;
    private a.d akw;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aku = null;
    private a.e akv = null;
    private int akx = 0;
    private boolean aky = false;
    private String akz = null;
    private int akA = 0;
    private int akB = 0;
    private boolean akD = false;
    private boolean akE = false;
    private int akG = -1;

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
        this.aks = null;
        this.akw = null;
        this.akC = null;
        this.mContext = context;
        this.aks = arrayList;
        this.akw = dVar;
        this.akC = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.aks = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.akt = map;
    }

    public void setNextTitle(String str) {
        this.akz = str;
    }

    public void setHasNext(boolean z) {
        this.aky = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.akC.add(aVar);
    }

    public boolean getHasNext() {
        return this.aky;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.aks != null) {
            i = this.aks.size();
            if (this.aky) {
                i++;
            }
        }
        return i + this.akA + this.akB;
    }

    public void setTempSize(int i) {
        this.akA = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.akB = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aku = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.akx = i;
    }

    public void a(a.e eVar) {
        this.akv = eVar;
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
        if (this.akC.size() != 0) {
            for (a aVar : this.akC) {
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
        uVar.setOriImgSelectedCallback(this.akF);
        String str = null;
        if (i < this.aks.size()) {
            str = this.aks.get(i);
        }
        uVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        uVar.setImageOnClickListener(this.mOnClickListener);
        uVar.setImageOnLongClickListener(this.aku);
        uVar.setIsCdn(this.akD);
        uVar.setOnSizeChangedListener(this.akv);
        ((ViewPager) viewGroup).addView(uVar, 0);
        uVar.setAssistUrl(eM(str));
        uVar.o(str, this.akE);
        uVar.setGifMaxUseableMem(this.akx);
        uVar.setTag(String.valueOf(i));
        uVar.setGifSetListener(this.akw);
        uVar.setHeadImage(this.akH);
        return uVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.aky && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(u.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(u.g.image)).setImageDrawable(av.getDrawable(u.f.big_image_next_default));
            ((TextView) inflate.findViewById(u.g.thread_name)).setText(this.akz);
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
            if (this.akG == i) {
                z = false;
            } else {
                this.akG = i;
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
            if (imageView != currentView || i == this.aks.size() - 1) {
                if (currentView != null) {
                    currentView.FZ();
                }
                ((u) obj).zT();
                ((u) obj).f(this.akE, z);
                hVar.setCurrentView(imageView);
                if (((u) obj).getImageType() == 1) {
                    this.akw.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eM(String str) {
        if (TextUtils.isEmpty(str) || this.akt == null) {
            return null;
        }
        return this.akt.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.akE = z;
    }

    public void setIsCdn(boolean z) {
        this.akD = z;
    }

    public void setHeadImage(boolean z) {
        this.akH = z;
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        this.akF = bVar;
    }
}
