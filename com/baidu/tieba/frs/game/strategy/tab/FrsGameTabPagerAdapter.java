package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import d.b.i0.q0.s1.a.d.a;
import d.b.i0.q0.s1.a.d.c;
import d.b.i0.q0.s1.a.d.e;
/* loaded from: classes4.dex */
public class FrsGameTabPagerAdapter extends PagerAdapter {

    /* renamed from: c  reason: collision with root package name */
    public Context f15977c;

    /* renamed from: d  reason: collision with root package name */
    public a f15978d;

    /* renamed from: e  reason: collision with root package name */
    public c f15979e;

    /* renamed from: f  reason: collision with root package name */
    public FrsGameStrategyItemListView f15980f;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f15982h;

    /* renamed from: a  reason: collision with root package name */
    public final FrsGameStrategyItemListView[] f15975a = new FrsGameStrategyItemListView[4];

    /* renamed from: b  reason: collision with root package name */
    public int f15976b = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f15981g = -1;

    public FrsGameTabPagerAdapter(Context context, a aVar, c cVar) {
        this.f15977c = context;
        this.f15978d = aVar;
        this.f15979e = cVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public FrsGameStrategyItemListView e() {
        return this.f15980f;
    }

    public FrsGameStrategyItemListView f(int i, int i2) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        if (i == 0 && i2 == 0) {
            return this.f15975a[0];
        }
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f15975a) {
            if (frsGameStrategyItemListView != null && i == frsGameStrategyItemListView.getTabId() && i2 == frsGameStrategyItemListView.getLabelId()) {
                return frsGameStrategyItemListView;
            }
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f15976b;
    }

    public final FrsGameStrategyItemListView i(int i) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.f15975a;
        if (i >= frsGameStrategyItemListViewArr.length) {
            return null;
        }
        return frsGameStrategyItemListViewArr[i];
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        e a2;
        int i2 = i % 3;
        FrsGameStrategyItemListView i3 = i(i2);
        if (i3 == null) {
            i3 = new FrsGameStrategyItemListView(this.f15977c, this.f15982h);
            i3.setFrsGameTabDataLoadListener(this.f15978d);
            n(i2, i3);
        } else if (i3 == e()) {
            i3 = i(3);
            if (i3 == null) {
                i3 = new FrsGameStrategyItemListView(this.f15977c, this.f15982h);
                i3.setFrsGameTabDataLoadListener(this.f15978d);
                n(3, i3);
            } else if (i3.getParent() != null) {
                viewGroup.removeView(i3);
            }
        } else if (i3.getParent() != null) {
            viewGroup.removeView(i3);
        }
        viewGroup.addView(i3);
        c cVar = this.f15979e;
        if (cVar != null && (a2 = cVar.a(i)) != null) {
            Object obj = a2.f60223c;
            if (obj instanceof LabelDataList) {
                i3.o(a2.f60221a, ((LabelDataList) obj).getSelectedLabelId());
            }
        }
        return i3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof FrsGameStrategyItemListView) && obj == view;
    }

    public void j(int i) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f15975a) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.p(i);
            }
        }
    }

    public void k() {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f15975a) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.q();
            }
        }
    }

    public void l(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f15976b = i;
        notifyDataSetChanged();
    }

    public void m(BdUniqueId bdUniqueId) {
        this.f15982h = bdUniqueId;
    }

    public final void n(int i, FrsGameStrategyItemListView frsGameStrategyItemListView) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.f15975a;
        if (i >= frsGameStrategyItemListViewArr.length) {
            return;
        }
        frsGameStrategyItemListViewArr[i] = frsGameStrategyItemListView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        if (!(obj instanceof FrsGameStrategyItemListView) || this.f15981g == i) {
            return;
        }
        this.f15981g = i;
        FrsGameStrategyItemListView frsGameStrategyItemListView = (FrsGameStrategyItemListView) obj;
        this.f15980f = frsGameStrategyItemListView;
        frsGameStrategyItemListView.r();
    }
}
