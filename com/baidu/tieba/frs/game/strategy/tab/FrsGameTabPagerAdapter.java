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
    public Context f15400c;

    /* renamed from: d  reason: collision with root package name */
    public a f15401d;

    /* renamed from: e  reason: collision with root package name */
    public c f15402e;

    /* renamed from: f  reason: collision with root package name */
    public FrsGameStrategyItemListView f15403f;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f15405h;

    /* renamed from: a  reason: collision with root package name */
    public final FrsGameStrategyItemListView[] f15398a = new FrsGameStrategyItemListView[4];

    /* renamed from: b  reason: collision with root package name */
    public int f15399b = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f15404g = -1;

    public FrsGameTabPagerAdapter(Context context, a aVar, c cVar) {
        this.f15400c = context;
        this.f15401d = aVar;
        this.f15402e = cVar;
    }

    public FrsGameStrategyItemListView b() {
        return this.f15403f;
    }

    public FrsGameStrategyItemListView c(int i2, int i3) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        if (i2 == 0 && i3 == 0) {
            return this.f15398a[0];
        }
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f15398a) {
            if (frsGameStrategyItemListView != null && i2 == frsGameStrategyItemListView.getTabId() && i3 == frsGameStrategyItemListView.getLabelId()) {
                return frsGameStrategyItemListView;
            }
        }
        return null;
    }

    public final FrsGameStrategyItemListView d(int i2) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.f15398a;
        if (i2 >= frsGameStrategyItemListViewArr.length) {
            return null;
        }
        return frsGameStrategyItemListViewArr[i2];
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
    }

    public void e(int i2) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f15398a) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.p(i2);
            }
        }
    }

    public void f() {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f15398a) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.q();
            }
        }
    }

    public void g(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.f15399b = i2;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f15399b;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.f15405h = bdUniqueId;
    }

    public final void i(int i2, FrsGameStrategyItemListView frsGameStrategyItemListView) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.f15398a;
        if (i2 >= frsGameStrategyItemListViewArr.length) {
            return;
        }
        frsGameStrategyItemListViewArr[i2] = frsGameStrategyItemListView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        e a2;
        int i3 = i2 % 3;
        FrsGameStrategyItemListView d2 = d(i3);
        if (d2 == null) {
            d2 = new FrsGameStrategyItemListView(this.f15400c, this.f15405h);
            d2.setFrsGameTabDataLoadListener(this.f15401d);
            i(i3, d2);
        } else if (d2 == b()) {
            d2 = d(3);
            if (d2 == null) {
                d2 = new FrsGameStrategyItemListView(this.f15400c, this.f15405h);
                d2.setFrsGameTabDataLoadListener(this.f15401d);
                i(3, d2);
            } else if (d2.getParent() != null) {
                viewGroup.removeView(d2);
            }
        } else if (d2.getParent() != null) {
            viewGroup.removeView(d2);
        }
        viewGroup.addView(d2);
        c cVar = this.f15402e;
        if (cVar != null && (a2 = cVar.a(i2)) != null) {
            Object obj = a2.f59634c;
            if (obj instanceof LabelDataList) {
                d2.o(a2.f59632a, ((LabelDataList) obj).getSelectedLabelId());
            }
        }
        return d2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof FrsGameStrategyItemListView) && obj == view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        if (!(obj instanceof FrsGameStrategyItemListView) || this.f15404g == i2) {
            return;
        }
        this.f15404g = i2;
        FrsGameStrategyItemListView frsGameStrategyItemListView = (FrsGameStrategyItemListView) obj;
        this.f15403f = frsGameStrategyItemListView;
        frsGameStrategyItemListView.r();
    }
}
