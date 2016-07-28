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
    private ArrayList<String> alh;
    private Map<String, ImageUrlData> ali;
    private a.d alm;
    private List<a> als;
    private u.b alv;
    private boolean alx;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener alj = null;
    private a.e alk = null;
    private int aln = 0;
    private boolean alo = false;
    private String alp = null;
    private int alq = 0;
    private int alr = 0;
    private boolean alt = false;
    private boolean alu = false;
    private int alw = -1;

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
        this.alh = null;
        this.alm = null;
        this.als = null;
        this.mContext = context;
        this.alh = arrayList;
        this.alm = dVar;
        this.als = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.alh = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.ali = map;
    }

    public void setNextTitle(String str) {
        this.alp = str;
    }

    public void setHasNext(boolean z) {
        this.alo = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.als.add(aVar);
    }

    public boolean getHasNext() {
        return this.alo;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.alh != null) {
            i = this.alh.size();
            if (this.alo) {
                i++;
            }
        }
        return i + this.alq + this.alr;
    }

    public void setTempSize(int i) {
        this.alq = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.alr = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alj = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aln = i;
    }

    public void a(a.e eVar) {
        this.alk = eVar;
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
        if (this.als.size() != 0) {
            for (a aVar : this.als) {
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
        uVar.setOriImgSelectedCallback(this.alv);
        String str = null;
        if (i < this.alh.size()) {
            str = this.alh.get(i);
        }
        uVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        uVar.setImageOnClickListener(this.mOnClickListener);
        uVar.setImageOnLongClickListener(this.alj);
        uVar.setIsCdn(this.alt);
        uVar.setOnSizeChangedListener(this.alk);
        ((ViewPager) viewGroup).addView(uVar, 0);
        uVar.setAssistUrl(eK(str));
        uVar.o(str, this.alu);
        uVar.setGifMaxUseableMem(this.aln);
        uVar.setTag(String.valueOf(i));
        uVar.setGifSetListener(this.alm);
        uVar.setHeadImage(this.alx);
        return uVar;
    }

    private View f(ViewGroup viewGroup, int i) {
        if (this.alo && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(u.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(u.g.image)).setImageDrawable(av.getDrawable(u.f.big_image_next_default));
            ((TextView) inflate.findViewById(u.g.thread_name)).setText(this.alp);
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
            if (this.alw == i) {
                z = false;
            } else {
                this.alw = i;
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
            if (imageView != currentView || i == this.alh.size() - 1) {
                if (currentView != null) {
                    currentView.Gc();
                }
                ((u) obj).zT();
                ((u) obj).f(this.alu, z);
                hVar.setCurrentView(imageView);
                if (((u) obj).getImageType() == 1) {
                    this.alm.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eK(String str) {
        if (TextUtils.isEmpty(str) || this.ali == null) {
            return null;
        }
        return this.ali.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.alu = z;
    }

    public void setIsCdn(boolean z) {
        this.alt = z;
    }

    public void setHeadImage(boolean z) {
        this.alx = z;
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        this.alv = bVar;
    }
}
