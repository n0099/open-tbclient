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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class i extends PagerAdapter {
    private ArrayList<String> anY;
    private Map<String, ImageUrlData> anZ;
    private a.d aoc;
    private List<a> aoi;
    private u.b aol;
    private boolean aon;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aoa = null;
    private a.e aob = null;
    private int aod = 0;
    private boolean aoe = false;
    private String aof = null;
    private int aog = 0;
    private int aoh = 0;
    private boolean aoj = false;
    private boolean aok = false;
    private int aom = -1;

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
        this.anY = null;
        this.aoc = null;
        this.aoi = null;
        this.mContext = context;
        this.anY = arrayList;
        this.aoc = dVar;
        this.aoi = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.anY = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.anZ = map;
    }

    public void setNextTitle(String str) {
        this.aof = str;
    }

    public void setHasNext(boolean z) {
        this.aoe = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.aoi.add(aVar);
    }

    public boolean getHasNext() {
        return this.aoe;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.anY != null) {
            i = this.anY.size();
            if (this.aoe) {
                i++;
            }
        }
        return i + this.aog + this.aoh;
    }

    public void setTempSize(int i) {
        this.aog = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aoh = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoa = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aod = i;
    }

    public void a(a.e eVar) {
        this.aob = eVar;
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
        if (this.aoi.size() != 0) {
            for (a aVar : this.aoi) {
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
        uVar.setOriImgSelectedCallback(this.aol);
        String str = null;
        if (i < this.anY.size()) {
            str = this.anY.get(i);
        }
        uVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        uVar.setImageOnClickListener(this.mOnClickListener);
        uVar.setImageOnLongClickListener(this.aoa);
        uVar.setIsCdn(this.aoj);
        uVar.setOnSizeChangedListener(this.aob);
        ((ViewPager) viewGroup).addView(uVar, 0);
        uVar.setAssistUrl(eL(str));
        uVar.o(str, this.aok);
        uVar.setGifMaxUseableMem(this.aod);
        uVar.setTag(String.valueOf(i));
        uVar.setGifSetListener(this.aoc);
        uVar.setHeadImage(this.aon);
        return uVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.aoe && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(t.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(t.g.image)).setImageDrawable(at.getDrawable(t.f.big_image_next_default));
            ((TextView) inflate.findViewById(t.g.thread_name)).setText(this.aof);
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
            if (this.aom == i) {
                z = false;
            } else {
                this.aom = i;
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
            if (imageView != currentView || i == this.anY.size() - 1) {
                if (currentView != null) {
                    currentView.restoreSize();
                }
                ((u) obj).BT();
                ((u) obj).e(this.aok, z);
                hVar.setCurrentView(imageView);
                if (((u) obj).getImageType() == 1) {
                    this.aoc.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eL(String str) {
        if (TextUtils.isEmpty(str) || this.anZ == null) {
            return null;
        }
        return this.anZ.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aok = z;
    }

    public void setIsCdn(boolean z) {
        this.aoj = z;
    }

    public void setHeadImage(boolean z) {
        this.aon = z;
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        this.aol = bVar;
    }
}
