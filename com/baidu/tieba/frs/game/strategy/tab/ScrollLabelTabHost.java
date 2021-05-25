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
import d.a.c.j.e.n;
import d.a.n0.r0.s1.a.d.e;
import d.a.n0.r0.s1.a.e.f;
import java.util.List;
/* loaded from: classes4.dex */
public class ScrollLabelTabHost extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public ScrollHorizontalTabView f15417e;

    /* renamed from: f  reason: collision with root package name */
    public FoldedGridView f15418f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.r0.s1.a.d.d f15419g;

    /* renamed from: h  reason: collision with root package name */
    public CustomViewPager f15420h;

    /* renamed from: i  reason: collision with root package name */
    public FrsGameTabPagerAdapter f15421i;
    public View j;
    public View k;
    public List<e> l;
    public int m;
    public int n;
    public boolean o;
    public f p;
    public d.a.n0.r0.s1.a.d.a q;
    public d.a.n0.r0.s1.a.d.a r;
    public d.a.n0.r0.s1.a.d.c s;

    /* loaded from: classes4.dex */
    public class a implements d.a.n0.r0.s1.a.d.a {
        public a() {
        }

        @Override // d.a.n0.r0.s1.a.d.a
        public e a(int i2) {
            if (ScrollLabelTabHost.this.q != null) {
                return ScrollLabelTabHost.this.q.a(i2);
            }
            return null;
        }

        @Override // d.a.n0.r0.s1.a.d.a
        public void b(int i2, int i3) {
            if (ScrollLabelTabHost.this.q != null) {
                ScrollLabelTabHost.this.q.b(i2, i3);
            }
        }

        @Override // d.a.n0.r0.s1.a.d.a
        public void c(int i2, int i3) {
            if (ScrollLabelTabHost.this.q != null) {
                ScrollLabelTabHost.this.q.c(i2, i3);
            }
        }

        @Override // d.a.n0.r0.s1.a.d.a
        public boolean d(int i2, int i3) {
            if (ScrollLabelTabHost.this.q != null) {
                return ScrollLabelTabHost.this.q.d(i2, i3);
            }
            return false;
        }

        @Override // d.a.n0.r0.s1.a.d.a
        public String h() {
            if (ScrollLabelTabHost.this.q != null) {
                return ScrollLabelTabHost.this.q.h();
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.n0.r0.s1.a.d.c {
        public b() {
        }

        @Override // d.a.n0.r0.s1.a.d.c
        public e a(int i2) {
            return (e) ListUtils.getItem(ScrollLabelTabHost.this.l, i2);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ScrollHorizontalTabView.f {
        public c() {
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.f
        public boolean a(int i2, e eVar) {
            return true;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.f
        public void b(int i2, e eVar) {
            d.a.n0.r0.s1.a.a.a aVar;
            if (eVar == null) {
                return;
            }
            ScrollLabelTabHost.this.m = eVar.f59632a;
            Object obj = eVar.f59634c;
            if (obj instanceof LabelDataList) {
                LabelDataList labelDataList = (LabelDataList) obj;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    ScrollLabelTabHost.this.n = aVar.f59596a;
                }
            }
            if (ScrollLabelTabHost.this.o(eVar)) {
                ScrollLabelTabHost.this.f15418f.setVisibility(0);
            } else {
                ScrollLabelTabHost.this.f15418f.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements FoldedGridView.a {
        public d() {
        }

        @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
        public void a(int i2, Object obj) {
            if (obj instanceof d.a.n0.r0.s1.a.a.a) {
                ScrollLabelTabHost.this.n = ((d.a.n0.r0.s1.a.a.a) obj).f59596a;
                FrsGameStrategyItemListView b2 = ScrollLabelTabHost.this.f15421i.b();
                b2.o(ScrollLabelTabHost.this.m, ScrollLabelTabHost.this.n);
                if (ScrollLabelTabHost.this.r == null || ScrollLabelTabHost.this.r.d(ScrollLabelTabHost.this.m, ScrollLabelTabHost.this.n)) {
                    return;
                }
                b2.s();
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
        return this.f15421i.b();
    }

    public void j(int i2, int i3, List<n> list, List<e> list2, boolean z, boolean z2, int i4) {
        FrsGameStrategyItemListView c2 = this.f15421i.c(i2, i3);
        if (c2 != null) {
            c2.a(i2, i3, list, list2, z, z2, i4);
            if (i4 != -1) {
                q(i4);
            }
        }
    }

    public void k() {
        FrsGameStrategyItemListView b2 = this.f15421i.b();
        if (b2 != null) {
            b2.s();
        }
    }

    public final void l(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.f15421i = new FrsGameTabPagerAdapter(context, this.r, this.s);
        CustomViewPager customViewPager = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.f15420h = customViewPager;
        customViewPager.setAdapter(this.f15421i);
        ScrollHorizontalTabView scrollHorizontalTabView = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.f15417e = scrollHorizontalTabView;
        scrollHorizontalTabView.setViewPager(this.f15420h);
        this.f15417e.setScrollTabPageListener(new c());
        this.f15419g = new d.a.n0.r0.s1.a.d.d(getContext());
        FoldedGridView foldedGridView = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.f15418f = foldedGridView;
        foldedGridView.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.f15418f.setNumColumns(5);
        this.f15418f.setFoldAdapter(this.f15419g);
        this.f15418f.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.f15418f.setFoldGridViewOnItemClickListener(new d());
        this.j = findViewById(R.id.frs_game_tab_line);
        this.k = findViewById(R.id.frs_game_label_line);
    }

    public void m(int i2) {
        this.f15417e.onChangeSkinType(i2);
        this.f15418f.d(i2);
        this.f15421i.e(i2);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
    }

    public void n() {
        f fVar = this.p;
        if (fVar != null) {
            fVar.g();
        }
        this.f15421i.f();
    }

    public boolean o(e eVar) {
        if (eVar != null) {
            Object obj = eVar.f59634c;
            if (obj instanceof LabelDataList) {
                LabelDataList labelDataList = (LabelDataList) obj;
                if (labelDataList.isEmpty()) {
                    return false;
                }
                this.f15419g.n(labelDataList);
                return true;
            }
        }
        return false;
    }

    public void p(int i2, int i3, String str) {
        FrsGameStrategyItemListView c2 = this.f15421i.c(i2, i3);
        if (c2 != null) {
            c2.b(i2, i3, str);
        }
    }

    public void q(int i2) {
        f fVar = this.p;
        if (fVar != null && fVar.f()) {
            this.p.g();
        }
        this.p = new f(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView e2 = this.p.e();
        if (i2 == 0) {
            e2.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            e2.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2)));
        }
        addView(e2, layoutParams);
        this.p.d();
    }

    public void setDelegateFrsGameTabDataLoadListener(d.a.n0.r0.s1.a.d.a aVar) {
        this.q = aVar;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        FrsGameTabPagerAdapter frsGameTabPagerAdapter = this.f15421i;
        if (frsGameTabPagerAdapter != null) {
            frsGameTabPagerAdapter.h(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.o || this.l == null) {
            this.o = z;
            this.l = list;
            this.f15421i.g(list == null ? 0 : list.size());
            this.f15417e.setData(list);
            if (ListUtils.isEmpty(list)) {
                this.f15417e.setVisibility(8);
                this.j.setVisibility(8);
                return;
            }
            this.f15417e.setVisibility(0);
            this.j.setVisibility(0);
            this.f15417e.setCurrentIndex(0, false);
            if (o(list.get(0))) {
                this.f15418f.setVisibility(0);
                this.k.setVisibility(0);
                return;
            }
            this.f15418f.setVisibility(8);
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

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.r = new a();
        this.s = new b();
        l(context);
    }
}
