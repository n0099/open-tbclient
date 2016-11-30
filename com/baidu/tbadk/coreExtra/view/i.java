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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.view.u;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class i extends PagerAdapter {
    private ArrayList<String> aoQ;
    private Map<String, ImageUrlData> aoR;
    private a.d aoU;
    private List<a> apa;
    private u.b apd;
    private boolean apf;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aoS = null;
    private a.e aoT = null;
    private int aoV = 0;
    private boolean aoW = false;
    private String aoX = null;
    private int aoY = 0;
    private int aoZ = 0;
    private boolean apb = false;
    private boolean apc = false;
    private int ape = -1;

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
        this.aoQ = null;
        this.aoU = null;
        this.apa = null;
        this.mContext = context;
        this.aoQ = arrayList;
        this.aoU = dVar;
        this.apa = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.aoQ = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aoR = map;
    }

    public void setNextTitle(String str) {
        this.aoX = str;
    }

    public void setHasNext(boolean z) {
        this.aoW = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.apa.add(aVar);
    }

    public boolean getHasNext() {
        return this.aoW;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.aoQ != null) {
            i = this.aoQ.size();
            if (this.aoW) {
                i++;
            }
        }
        return i + this.aoY + this.aoZ;
    }

    public void setTempSize(int i) {
        this.aoY = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aoZ = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoS = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aoV = i;
    }

    public void a(a.e eVar) {
        this.aoT = eVar;
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
        if (this.apa.size() != 0) {
            for (a aVar : this.apa) {
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
        uVar.setOriImgSelectedCallback(this.apd);
        String str = null;
        if (i < this.aoQ.size()) {
            str = this.aoQ.get(i);
        }
        uVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        uVar.setImageOnClickListener(this.mOnClickListener);
        uVar.setImageOnLongClickListener(this.aoS);
        uVar.setIsCdn(this.apb);
        uVar.setOnSizeChangedListener(this.aoT);
        ((ViewPager) viewGroup).addView(uVar, 0);
        uVar.setAssistUrl(eS(str));
        uVar.q(str, this.apc);
        uVar.setGifMaxUseableMem(this.aoV);
        uVar.setTag(String.valueOf(i));
        uVar.setGifSetListener(this.aoU);
        uVar.setHeadImage(this.apf);
        return uVar;
    }

    private View f(ViewGroup viewGroup, int i) {
        if (this.aoW && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(r.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(r.g.image)).setImageDrawable(at.getDrawable(r.f.big_image_next_default));
            ((TextView) inflate.findViewById(r.g.thread_name)).setText(this.aoX);
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
            if (this.ape == i) {
                z = false;
            } else {
                this.ape = i;
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
            if (imageView != currentView || i == this.aoQ.size() - 1) {
                if (currentView != null) {
                    currentView.Hy();
                }
                ((u) obj).Bt();
                ((u) obj).g(this.apc, z);
                hVar.setCurrentView(imageView);
                if (((u) obj).getImageType() == 1) {
                    this.aoU.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eS(String str) {
        if (TextUtils.isEmpty(str) || this.aoR == null) {
            return null;
        }
        return this.aoR.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.apc = z;
    }

    public void setIsCdn(boolean z) {
        this.apb = z;
    }

    public void setHeadImage(boolean z) {
        this.apf = z;
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        this.apd = bVar;
    }
}
