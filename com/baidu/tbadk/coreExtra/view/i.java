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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class i extends PagerAdapter {
    private ArrayList<String> anW;
    private Map<String, ImageUrlData> anX;
    private a.d aoa;
    private List<a> aog;
    private u.b aoj;
    private boolean aol;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener anY = null;
    private a.e anZ = null;
    private int aob = 0;
    private boolean aoc = false;
    private String aod = null;
    private int aoe = 0;
    private int aof = 0;
    private boolean aoh = false;
    private boolean aoi = false;
    private int aok = -1;

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
        this.anW = null;
        this.aoa = null;
        this.aog = null;
        this.mContext = context;
        this.anW = arrayList;
        this.aoa = dVar;
        this.aog = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.anW = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.anX = map;
    }

    public void setNextTitle(String str) {
        this.aod = str;
    }

    public void setHasNext(boolean z) {
        this.aoc = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.aog.add(aVar);
    }

    public boolean getHasNext() {
        return this.aoc;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.anW != null) {
            i = this.anW.size();
            if (this.aoc) {
                i++;
            }
        }
        return i + this.aoe + this.aof;
    }

    public void setTempSize(int i) {
        this.aoe = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aof = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anY = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aob = i;
    }

    public void a(a.e eVar) {
        this.anZ = eVar;
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
        if (this.aog.size() != 0) {
            for (a aVar : this.aog) {
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
        uVar.setOriImgSelectedCallback(this.aoj);
        String str = null;
        if (i < this.anW.size()) {
            str = this.anW.get(i);
        }
        uVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        uVar.setImageOnClickListener(this.mOnClickListener);
        uVar.setImageOnLongClickListener(this.anY);
        uVar.setIsCdn(this.aoh);
        uVar.setOnSizeChangedListener(this.anZ);
        ((ViewPager) viewGroup).addView(uVar, 0);
        uVar.setAssistUrl(eQ(str));
        uVar.q(str, this.aoi);
        uVar.setGifMaxUseableMem(this.aob);
        uVar.setTag(String.valueOf(i));
        uVar.setGifSetListener(this.aoa);
        uVar.setHeadImage(this.aol);
        return uVar;
    }

    private View f(ViewGroup viewGroup, int i) {
        if (this.aoc && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(r.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(r.g.image)).setImageDrawable(av.getDrawable(r.f.big_image_next_default));
            ((TextView) inflate.findViewById(r.g.thread_name)).setText(this.aod);
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
            if (this.aok == i) {
                z = false;
            } else {
                this.aok = i;
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
            if (imageView != currentView || i == this.anW.size() - 1) {
                if (currentView != null) {
                    currentView.Hv();
                }
                ((u) obj).Bm();
                ((u) obj).h(this.aoi, z);
                hVar.setCurrentView(imageView);
                if (((u) obj).getImageType() == 1) {
                    this.aoa.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eQ(String str) {
        if (TextUtils.isEmpty(str) || this.anX == null) {
            return null;
        }
        return this.anX.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aoi = z;
    }

    public void setIsCdn(boolean z) {
        this.aoh = z;
    }

    public void setHeadImage(boolean z) {
        this.aol = z;
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        this.aoj = bVar;
    }
}
