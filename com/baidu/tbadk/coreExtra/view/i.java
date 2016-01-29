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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class i extends PagerAdapter {
    private ArrayList<String> anH;
    private Map<String, ImageUrlData> anI;
    private a.d anL;
    private List<a> anR;
    private u.b anU;
    private boolean anW;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener anJ = null;
    private a.e anK = null;
    private int anM = 0;
    private boolean anN = false;
    private String anO = null;
    private int anP = 0;
    private int anQ = 0;
    private boolean anS = false;
    private boolean anT = false;
    private int anV = -1;

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
        this.anH = null;
        this.anL = null;
        this.anR = null;
        this.mContext = context;
        this.anH = arrayList;
        this.anL = dVar;
        this.anR = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.anH = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.anI = map;
    }

    public void setNextTitle(String str) {
        this.anO = str;
    }

    public void setHasNext(boolean z) {
        this.anN = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.anR.add(aVar);
    }

    public boolean getHasNext() {
        return this.anN;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.anH != null) {
            i = this.anH.size();
            if (this.anN) {
                i++;
            }
        }
        return i + this.anP + this.anQ;
    }

    public void setTempSize(int i) {
        this.anP = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.anQ = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anJ = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.anM = i;
    }

    public void a(a.e eVar) {
        this.anK = eVar;
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
        if (this.anR.size() != 0) {
            for (a aVar : this.anR) {
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
        uVar.setOriImgSelectedCallback(this.anU);
        String str = null;
        if (i < this.anH.size()) {
            str = this.anH.get(i);
        }
        uVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        uVar.setImageOnClickListener(this.mOnClickListener);
        uVar.setImageOnLongClickListener(this.anJ);
        uVar.setIsCdn(this.anS);
        uVar.setOnSizeChangedListener(this.anK);
        ((ViewPager) viewGroup).addView(uVar, 0);
        uVar.setAssistUrl(eE(str));
        uVar.p(str, this.anT);
        uVar.setGifMaxUseableMem(this.anM);
        uVar.setTag(String.valueOf(i));
        uVar.setGifSetListener(this.anL);
        uVar.setHeadImage(this.anW);
        return uVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.anN && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(t.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(t.g.image)).setImageDrawable(ar.getDrawable(t.f.big_image_next_default));
            ((TextView) inflate.findViewById(t.g.thread_name)).setText(this.anO);
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
            if (this.anV == i) {
                z = false;
            } else {
                this.anV = i;
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
            if (imageView != currentView || i == this.anH.size() - 1) {
                if (currentView != null) {
                    currentView.restoreSize();
                }
                ((u) obj).Bq();
                ((u) obj).f(this.anT, z);
                hVar.setCurrentView(imageView);
                if (((u) obj).getImageType() == 1) {
                    this.anL.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eE(String str) {
        if (TextUtils.isEmpty(str) || this.anI == null) {
            return null;
        }
        return this.anI.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.anT = z;
    }

    public void setIsCdn(boolean z) {
        this.anS = z;
    }

    public void setHeadImage(boolean z) {
        this.anW = z;
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        this.anU = bVar;
    }
}
