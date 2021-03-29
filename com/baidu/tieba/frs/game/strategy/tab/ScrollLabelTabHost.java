package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView;
import com.baidu.tieba.frs.game.strategy.view.FoldedGridView;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import d.b.b.j.e.n;
import d.b.i0.p0.s1.a.d.e;
import d.b.i0.p0.s1.a.e.f;
import java.util.List;
/* loaded from: classes4.dex */
public class ScrollLabelTabHost extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public ScrollHorizontalTabView f16332e;

    /* renamed from: f  reason: collision with root package name */
    public FoldedGridView f16333f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.p0.s1.a.d.d f16334g;

    /* renamed from: h  reason: collision with root package name */
    public CustomViewPager f16335h;
    public FrsGameTabPagerAdapter i;
    public View j;
    public View k;
    public List<e> l;
    public int m;
    public int n;
    public boolean o;
    public f p;
    public d.b.i0.p0.s1.a.d.a q;
    public d.b.i0.p0.s1.a.d.a r;
    public d.b.i0.p0.s1.a.d.c s;

    /* loaded from: classes4.dex */
    public class a implements d.b.i0.p0.s1.a.d.a {
        public a() {
        }

        @Override // d.b.i0.p0.s1.a.d.a
        public e a(int i) {
            if (ScrollLabelTabHost.this.q != null) {
                return ScrollLabelTabHost.this.q.a(i);
            }
            return null;
        }

        @Override // d.b.i0.p0.s1.a.d.a
        public void b(int i, int i2) {
            if (ScrollLabelTabHost.this.q != null) {
                ScrollLabelTabHost.this.q.b(i, i2);
            }
        }

        @Override // d.b.i0.p0.s1.a.d.a
        public boolean c(int i, int i2) {
            if (ScrollLabelTabHost.this.q != null) {
                return ScrollLabelTabHost.this.q.c(i, i2);
            }
            return false;
        }

        @Override // d.b.i0.p0.s1.a.d.a
        public void d(int i, int i2) {
            if (ScrollLabelTabHost.this.q != null) {
                ScrollLabelTabHost.this.q.d(i, i2);
            }
        }

        @Override // d.b.i0.p0.s1.a.d.a
        public String h() {
            if (ScrollLabelTabHost.this.q != null) {
                return ScrollLabelTabHost.this.q.h();
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.i0.p0.s1.a.d.c {
        public b() {
        }

        @Override // d.b.i0.p0.s1.a.d.c
        public e a(int i) {
            return (e) ListUtils.getItem(ScrollLabelTabHost.this.l, i);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ScrollHorizontalTabView.f {
        public c() {
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.f
        public void a(int i, e eVar) {
            d.b.i0.p0.s1.a.a.a aVar;
            if (eVar == null) {
                return;
            }
            ScrollLabelTabHost.this.m = eVar.f58553a;
            Object obj = eVar.f58555c;
            if (obj instanceof LabelDataList) {
                LabelDataList labelDataList = (LabelDataList) obj;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    ScrollLabelTabHost.this.n = aVar.f58519a;
                }
            }
            if (ScrollLabelTabHost.this.o(eVar)) {
                ScrollLabelTabHost.this.f16333f.setVisibility(0);
            } else {
                ScrollLabelTabHost.this.f16333f.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.f
        public boolean b(int i, e eVar) {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements FoldedGridView.a {
        public d() {
        }

        @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
        public void a(int i, Object obj) {
            if (obj instanceof d.b.i0.p0.s1.a.a.a) {
                ScrollLabelTabHost.this.n = ((d.b.i0.p0.s1.a.a.a) obj).f58519a;
                FrsGameStrategyItemListView e2 = ScrollLabelTabHost.this.i.e();
                e2.o(ScrollLabelTabHost.this.m, ScrollLabelTabHost.this.n);
                if (ScrollLabelTabHost.this.r == null || ScrollLabelTabHost.this.r.c(ScrollLabelTabHost.this.m, ScrollLabelTabHost.this.n)) {
                    return;
                }
                e2.s();
            }
        }
    }

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.r = new a();
        this.s = new b();
        l(context);
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.i.e();
    }

    public void j(int i, int i2, List<n> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView f2 = this.i.f(i, i2);
        if (f2 != null) {
            f2.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                q(i3);
            }
        }
    }

    public void k() {
        FrsGameStrategyItemListView e2 = this.i.e();
        if (e2 != null) {
            e2.s();
        }
    }

    public final void l(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.i = new FrsGameTabPagerAdapter(context, this.r, this.s);
        CustomViewPager customViewPager = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.f16335h = customViewPager;
        customViewPager.setAdapter(this.i);
        ScrollHorizontalTabView scrollHorizontalTabView = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.f16332e = scrollHorizontalTabView;
        scrollHorizontalTabView.setViewPager(this.f16335h);
        this.f16332e.setScrollTabPageListener(new c());
        this.f16334g = new d.b.i0.p0.s1.a.d.d(getContext());
        FoldedGridView foldedGridView = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.f16333f = foldedGridView;
        foldedGridView.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.f16333f.setNumColumns(5);
        this.f16333f.setFoldAdapter(this.f16334g);
        this.f16333f.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.f16333f.setFoldGridViewOnItemClickListener(new d());
        this.j = findViewById(R.id.frs_game_tab_line);
        this.k = findViewById(R.id.frs_game_label_line);
    }

    public void m(int i) {
        this.f16332e.onChangeSkinType(i);
        this.f16333f.d(i);
        this.i.j(i);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
    }

    public void n() {
        f fVar = this.p;
        if (fVar != null) {
            fVar.g();
        }
        this.i.k();
    }

    public boolean o(e eVar) {
        if (eVar != null) {
            Object obj = eVar.f58555c;
            if (obj instanceof LabelDataList) {
                LabelDataList labelDataList = (LabelDataList) obj;
                if (labelDataList.isEmpty()) {
                    return false;
                }
                this.f16334g.n(labelDataList);
                return true;
            }
        }
        return false;
    }

    public void p(int i, int i2, String str) {
        FrsGameStrategyItemListView f2 = this.i.f(i, i2);
        if (f2 != null) {
            f2.b(i, i2, str);
        }
    }

    public void q(int i) {
        f fVar = this.p;
        if (fVar != null && fVar.f()) {
            this.p.g();
        }
        this.p = new f(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView e2 = this.p.e();
        if (i == 0) {
            e2.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            e2.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(e2, layoutParams);
        this.p.d();
    }

    public void setDelegateFrsGameTabDataLoadListener(d.b.i0.p0.s1.a.d.a aVar) {
        this.q = aVar;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        FrsGameTabPagerAdapter frsGameTabPagerAdapter = this.i;
        if (frsGameTabPagerAdapter != null) {
            frsGameTabPagerAdapter.m(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.o || this.l == null) {
            this.o = z;
            this.l = list;
            this.i.l(list == null ? 0 : list.size());
            this.f16332e.setData(list);
            if (ListUtils.isEmpty(list)) {
                this.f16332e.setVisibility(8);
                this.j.setVisibility(8);
                return;
            }
            this.f16332e.setVisibility(0);
            this.j.setVisibility(0);
            this.f16332e.setCurrentIndex(0, false);
            if (o(list.get(0))) {
                this.f16333f.setVisibility(0);
                this.k.setVisibility(0);
                return;
            }
            this.f16333f.setVisibility(8);
            this.k.setVisibility(8);
        }
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.r = new a();
        this.s = new b();
        l(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.r = new a();
        this.s = new b();
        l(context);
    }
}
