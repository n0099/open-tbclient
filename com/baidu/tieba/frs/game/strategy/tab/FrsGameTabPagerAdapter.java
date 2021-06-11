package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import d.a.n0.r0.s1.a.d.a;
import d.a.n0.r0.s1.a.d.c;
import d.a.n0.r0.s1.a.d.e;
/* loaded from: classes4.dex */
public class FrsGameTabPagerAdapter extends PagerAdapter {

    /* renamed from: c  reason: collision with root package name */
    public Context f15462c;

    /* renamed from: d  reason: collision with root package name */
    public a f15463d;

    /* renamed from: e  reason: collision with root package name */
    public c f15464e;

    /* renamed from: f  reason: collision with root package name */
    public FrsGameStrategyItemListView f15465f;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f15467h;

    /* renamed from: a  reason: collision with root package name */
    public final FrsGameStrategyItemListView[] f15460a = new FrsGameStrategyItemListView[4];

    /* renamed from: b  reason: collision with root package name */
    public int f15461b = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f15466g = -1;

    public FrsGameTabPagerAdapter(Context context, a aVar, c cVar) {
        this.f15462c = context;
        this.f15463d = aVar;
        this.f15464e = cVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
    }

    public FrsGameStrategyItemListView e() {
        return this.f15465f;
    }

    public FrsGameStrategyItemListView f(int i2, int i3) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        if (i2 == 0 && i3 == 0) {
            return this.f15460a[0];
        }
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f15460a) {
            if (frsGameStrategyItemListView != null && i2 == frsGameStrategyItemListView.getTabId() && i3 == frsGameStrategyItemListView.getLabelId()) {
                return frsGameStrategyItemListView;
            }
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f15461b;
    }

    public final FrsGameStrategyItemListView i(int i2) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.f15460a;
        if (i2 >= frsGameStrategyItemListViewArr.length) {
            return null;
        }
        return frsGameStrategyItemListViewArr[i2];
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        e a2;
        int i3 = i2 % 3;
        FrsGameStrategyItemListView i4 = i(i3);
        if (i4 == null) {
            i4 = new FrsGameStrategyItemListView(this.f15462c, this.f15467h);
            i4.setFrsGameTabDataLoadListener(this.f15463d);
            n(i3, i4);
        } else if (i4 == e()) {
            i4 = i(3);
            if (i4 == null) {
                i4 = new FrsGameStrategyItemListView(this.f15462c, this.f15467h);
                i4.setFrsGameTabDataLoadListener(this.f15463d);
                n(3, i4);
            } else if (i4.getParent() != null) {
                viewGroup.removeView(i4);
            }
        } else if (i4.getParent() != null) {
            viewGroup.removeView(i4);
        }
        viewGroup.addView(i4);
        c cVar = this.f15464e;
        if (cVar != null && (a2 = cVar.a(i2)) != null) {
            Object obj = a2.f63325c;
            if (obj instanceof LabelDataList) {
                i4.o(a2.f63323a, ((LabelDataList) obj).getSelectedLabelId());
            }
        }
        return i4;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof FrsGameStrategyItemListView) && obj == view;
    }

    public void j(int i2) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f15460a) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.p(i2);
            }
        }
    }

    public void k() {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f15460a) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.q();
            }
        }
    }

    public void l(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.f15461b = i2;
        notifyDataSetChanged();
    }

    public void m(BdUniqueId bdUniqueId) {
        this.f15467h = bdUniqueId;
    }

    public final void n(int i2, FrsGameStrategyItemListView frsGameStrategyItemListView) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.f15460a;
        if (i2 >= frsGameStrategyItemListViewArr.length) {
            return;
        }
        frsGameStrategyItemListViewArr[i2] = frsGameStrategyItemListView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        if (!(obj instanceof FrsGameStrategyItemListView) || this.f15466g == i2) {
            return;
        }
        this.f15466g = i2;
        FrsGameStrategyItemListView frsGameStrategyItemListView = (FrsGameStrategyItemListView) obj;
        this.f15465f = frsGameStrategyItemListView;
        frsGameStrategyItemListView.r();
    }
}
