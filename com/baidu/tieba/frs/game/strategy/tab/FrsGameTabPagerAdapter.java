package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import d.b.i0.p0.s1.a.d.a;
import d.b.i0.p0.s1.a.d.c;
import d.b.i0.p0.s1.a.d.e;
/* loaded from: classes4.dex */
public class FrsGameTabPagerAdapter extends PagerAdapter {

    /* renamed from: c  reason: collision with root package name */
    public Context f16315c;

    /* renamed from: d  reason: collision with root package name */
    public a f16316d;

    /* renamed from: e  reason: collision with root package name */
    public c f16317e;

    /* renamed from: f  reason: collision with root package name */
    public FrsGameStrategyItemListView f16318f;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f16320h;

    /* renamed from: a  reason: collision with root package name */
    public final FrsGameStrategyItemListView[] f16313a = new FrsGameStrategyItemListView[4];

    /* renamed from: b  reason: collision with root package name */
    public int f16314b = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f16319g = -1;

    public FrsGameTabPagerAdapter(Context context, a aVar, c cVar) {
        this.f16315c = context;
        this.f16316d = aVar;
        this.f16317e = cVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public FrsGameStrategyItemListView e() {
        return this.f16318f;
    }

    public FrsGameStrategyItemListView f(int i, int i2) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        if (i == 0 && i2 == 0) {
            return this.f16313a[0];
        }
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f16313a) {
            if (frsGameStrategyItemListView != null && i == frsGameStrategyItemListView.getTabId() && i2 == frsGameStrategyItemListView.getLabelId()) {
                return frsGameStrategyItemListView;
            }
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f16314b;
    }

    public final FrsGameStrategyItemListView i(int i) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.f16313a;
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
            i3 = new FrsGameStrategyItemListView(this.f16315c, this.f16320h);
            i3.setFrsGameTabDataLoadListener(this.f16316d);
            n(i2, i3);
        } else if (i3 == e()) {
            i3 = i(3);
            if (i3 == null) {
                i3 = new FrsGameStrategyItemListView(this.f16315c, this.f16320h);
                i3.setFrsGameTabDataLoadListener(this.f16316d);
                n(3, i3);
            } else if (i3.getParent() != null) {
                viewGroup.removeView(i3);
            }
        } else if (i3.getParent() != null) {
            viewGroup.removeView(i3);
        }
        viewGroup.addView(i3);
        c cVar = this.f16317e;
        if (cVar != null && (a2 = cVar.a(i)) != null) {
            Object obj = a2.f58554c;
            if (obj instanceof LabelDataList) {
                i3.o(a2.f58552a, ((LabelDataList) obj).getSelectedLabelId());
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
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f16313a) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.p(i);
            }
        }
    }

    public void k() {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f16313a) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.q();
            }
        }
    }

    public void l(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f16314b = i;
        notifyDataSetChanged();
    }

    public void m(BdUniqueId bdUniqueId) {
        this.f16320h = bdUniqueId;
    }

    public final void n(int i, FrsGameStrategyItemListView frsGameStrategyItemListView) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.f16313a;
        if (i >= frsGameStrategyItemListViewArr.length) {
            return;
        }
        frsGameStrategyItemListViewArr[i] = frsGameStrategyItemListView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        if (!(obj instanceof FrsGameStrategyItemListView) || this.f16319g == i) {
            return;
        }
        this.f16319g = i;
        FrsGameStrategyItemListView frsGameStrategyItemListView = (FrsGameStrategyItemListView) obj;
        this.f16318f = frsGameStrategyItemListView;
        frsGameStrategyItemListView.r();
    }
}
