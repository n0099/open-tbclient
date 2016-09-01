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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class i extends PagerAdapter {
    private u.b aoB;
    private boolean aoD;
    private ArrayList<String> aoo;
    private Map<String, ImageUrlData> aop;
    private a.d aos;
    private List<a> aoy;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aoq = null;
    private a.e aor = null;
    private int aot = 0;
    private boolean aou = false;
    private String aov = null;
    private int aow = 0;
    private int aox = 0;
    private boolean aoz = false;
    private boolean aoA = false;
    private int aoC = -1;

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
        this.aoo = null;
        this.aos = null;
        this.aoy = null;
        this.mContext = context;
        this.aoo = arrayList;
        this.aos = dVar;
        this.aoy = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.aoo = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aop = map;
    }

    public void setNextTitle(String str) {
        this.aov = str;
    }

    public void setHasNext(boolean z) {
        this.aou = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.aoy.add(aVar);
    }

    public boolean getHasNext() {
        return this.aou;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.aoo != null) {
            i = this.aoo.size();
            if (this.aou) {
                i++;
            }
        }
        return i + this.aow + this.aox;
    }

    public void setTempSize(int i) {
        this.aow = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aox = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoq = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aot = i;
    }

    public void a(a.e eVar) {
        this.aor = eVar;
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
        if (this.aoy.size() != 0) {
            for (a aVar : this.aoy) {
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
        uVar.setOriImgSelectedCallback(this.aoB);
        String str = null;
        if (i < this.aoo.size()) {
            str = this.aoo.get(i);
        }
        uVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        uVar.setImageOnClickListener(this.mOnClickListener);
        uVar.setImageOnLongClickListener(this.aoq);
        uVar.setIsCdn(this.aoz);
        uVar.setOnSizeChangedListener(this.aor);
        ((ViewPager) viewGroup).addView(uVar, 0);
        uVar.setAssistUrl(eN(str));
        uVar.p(str, this.aoA);
        uVar.setGifMaxUseableMem(this.aot);
        uVar.setTag(String.valueOf(i));
        uVar.setGifSetListener(this.aos);
        uVar.setHeadImage(this.aoD);
        return uVar;
    }

    private View f(ViewGroup viewGroup, int i) {
        if (this.aou && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(t.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(t.g.image)).setImageDrawable(av.getDrawable(t.f.big_image_next_default));
            ((TextView) inflate.findViewById(t.g.thread_name)).setText(this.aov);
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
            if (this.aoC == i) {
                z = false;
            } else {
                this.aoC = i;
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
            if (imageView != currentView || i == this.aoo.size() - 1) {
                if (currentView != null) {
                    currentView.Hw();
                }
                ((u) obj).Bi();
                ((u) obj).h(this.aoA, z);
                hVar.setCurrentView(imageView);
                if (((u) obj).getImageType() == 1) {
                    this.aos.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eN(String str) {
        if (TextUtils.isEmpty(str) || this.aop == null) {
            return null;
        }
        return this.aop.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aoA = z;
    }

    public void setIsCdn(boolean z) {
        this.aoz = z;
    }

    public void setHeadImage(boolean z) {
        this.aoD = z;
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        this.aoB = bVar;
    }
}
