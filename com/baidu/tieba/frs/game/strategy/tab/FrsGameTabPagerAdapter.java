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
    public Context f16316c;

    /* renamed from: d  reason: collision with root package name */
    public a f16317d;

    /* renamed from: e  reason: collision with root package name */
    public c f16318e;

    /* renamed from: f  reason: collision with root package name */
    public FrsGameStrategyItemListView f16319f;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f16321h;

    /* renamed from: a  reason: collision with root package name */
    public final FrsGameStrategyItemListView[] f16314a = new FrsGameStrategyItemListView[4];

    /* renamed from: b  reason: collision with root package name */
    public int f16315b = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f16320g = -1;

    public FrsGameTabPagerAdapter(Context context, a aVar, c cVar) {
        this.f16316c = context;
        this.f16317d = aVar;
        this.f16318e = cVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public FrsGameStrategyItemListView e() {
        return this.f16319f;
    }

    public FrsGameStrategyItemListView f(int i, int i2) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        if (i == 0 && i2 == 0) {
            return this.f16314a[0];
        }
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f16314a) {
            if (frsGameStrategyItemListView != null && i == frsGameStrategyItemListView.getTabId() && i2 == frsGameStrategyItemListView.getLabelId()) {
                return frsGameStrategyItemListView;
            }
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f16315b;
    }

    public final FrsGameStrategyItemListView i(int i) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.f16314a;
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
            i3 = new FrsGameStrategyItemListView(this.f16316c, this.f16321h);
            i3.setFrsGameTabDataLoadListener(this.f16317d);
            n(i2, i3);
        } else if (i3 == e()) {
            i3 = i(3);
            if (i3 == null) {
                i3 = new FrsGameStrategyItemListView(this.f16316c, this.f16321h);
                i3.setFrsGameTabDataLoadListener(this.f16317d);
                n(3, i3);
            } else if (i3.getParent() != null) {
                viewGroup.removeView(i3);
            }
        } else if (i3.getParent() != null) {
            viewGroup.removeView(i3);
        }
        viewGroup.addView(i3);
        c cVar = this.f16318e;
        if (cVar != null && (a2 = cVar.a(i)) != null) {
            Object obj = a2.f58555c;
            if (obj instanceof LabelDataList) {
                i3.o(a2.f58553a, ((LabelDataList) obj).getSelectedLabelId());
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
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f16314a) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.p(i);
            }
        }
    }

    public void k() {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f16314a) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.q();
            }
        }
    }

    public void l(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f16315b = i;
        notifyDataSetChanged();
    }

    public void m(BdUniqueId bdUniqueId) {
        this.f16321h = bdUniqueId;
    }

    public final void n(int i, FrsGameStrategyItemListView frsGameStrategyItemListView) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.f16314a;
        if (i >= frsGameStrategyItemListViewArr.length) {
            return;
        }
        frsGameStrategyItemListViewArr[i] = frsGameStrategyItemListView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        if (!(obj instanceof FrsGameStrategyItemListView) || this.f16320g == i) {
            return;
        }
        this.f16320g = i;
        FrsGameStrategyItemListView frsGameStrategyItemListView = (FrsGameStrategyItemListView) obj;
        this.f16319f = frsGameStrategyItemListView;
        frsGameStrategyItemListView.r();
    }
}
