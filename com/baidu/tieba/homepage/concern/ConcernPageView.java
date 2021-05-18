package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import d.a.c.j.e.n;
import d.a.j0.r.f0.f;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.i1;
import d.a.j0.z0.b0;
import d.a.k0.a1.b.d;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class ConcernPageView extends FrameLayout {
    public CustomMessageListener A;
    public final CustomMessageListener B;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.a1.g.i.a f16233e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f16234f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f16235g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.k0.a1.b.a f16236h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f16237i;
    public l j;
    public d.a.k0.a1.b.d k;
    public ConcernNotLoginLayout l;
    public d.a.j0.d0.g m;
    public d.a.j0.d0.h n;
    public NoDataView o;
    public PublishProgressView p;
    public boolean q;
    public int r;
    public ScrollFragmentTabHost s;
    public int t;
    public RecyclerView.OnScrollListener u;
    public ScrollFragmentTabHost.q v;
    public BigdaySwipeRefreshLayout w;
    public d.o x;
    public View.OnClickListener y;
    public CustomMessageListener z;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof i1)) {
                return;
            }
            i1 i1Var = (i1) customResponsedMessage.getData();
            if (ConcernPageView.this.p != null) {
                ConcernPageView.this.p.c(i1Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ConcernPageView.this.f16236h != null) {
                ConcernPageView.this.f16236h.d();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (ConcernPageView.this.t == i2 || ConcernPageView.this.s == null) {
                return;
            }
            ConcernPageView.this.t = i2;
            if (ConcernPageView.this.t == 1) {
                ConcernPageView.this.s.T();
            } else if (ConcernPageView.this.I(recyclerView)) {
                ConcernPageView.this.s.w();
            } else {
                ConcernPageView.this.s.T();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends ScrollFragmentTabHost.q {
        public d() {
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.q
        public void a() {
            if (ConcernPageView.this.s != null) {
                ConcernPageView.this.t = -1;
                ConcernPageView concernPageView = ConcernPageView.this;
                if (concernPageView.I(concernPageView.f16235g)) {
                    ConcernPageView.this.s.w();
                } else {
                    ConcernPageView.this.s.T();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.o {
        public e() {
        }

        @Override // d.a.k0.a1.b.d.o
        public void a(d.a.j0.z0.c cVar) {
            ConcernPageView.this.u();
            ConcernPageView.this.v();
            ConcernPageView.this.f16235g.setSelection(0);
            if (ConcernPageView.this.f16235g.getCount() > 0) {
                ConcernPageView.this.t();
                ConcernPageView.this.L();
            } else {
                ConcernPageView.this.N(true);
            }
            if (ConcernPageView.this.j != null) {
                ConcernPageView.this.j.b(cVar);
            }
        }

        @Override // d.a.k0.a1.b.d.o
        public void b() {
            if (ConcernPageView.this.j != null) {
                ConcernPageView.this.j.a(true, false);
            }
            ConcernPageView.this.t();
            ConcernPageView.this.u();
            ConcernPageView.this.f16235g.setVisibility(8);
            ConcernPageView.this.P();
        }

        @Override // d.a.k0.a1.b.d.o
        public void c(boolean z, boolean z2) {
            if (ConcernPageView.this.j != null) {
                ConcernPageView.this.j.a(z, z2);
            }
            ConcernPageView.this.t();
            ConcernPageView.this.u();
            ConcernPageView.this.v();
            if (ConcernPageView.this.k.E()) {
                ConcernPageView.this.L();
            } else {
                ConcernPageView.this.M();
            }
        }

        @Override // d.a.k0.a1.b.d.o
        public void d(String str, d.a.j0.z0.c cVar) {
            ConcernPageView.this.u();
            ConcernPageView.this.v();
            ConcernPageView.this.t();
            ConcernPageView.this.M();
            if (ConcernPageView.this.j != null) {
                ConcernPageView.this.j.c(str, cVar);
            }
        }

        @Override // d.a.k0.a1.b.d.o
        public void onError(int i2, String str) {
            if (ConcernPageView.this.j != null) {
                ConcernPageView.this.j.a(false, false);
            }
            ConcernPageView.this.t();
            ConcernPageView.this.v();
            if (i2 != 1) {
                ConcernPageView.this.f16235g.setVisibility(8);
                ConcernPageView.this.O(true);
            } else if (d.a.c.e.p.j.z()) {
                ConcernPageView.this.f16237i.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements f.g {
        public f() {
        }

        @Override // d.a.j0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (TbadkCoreApplication.isLogin()) {
                d.a.k0.m.d.c().f("page_concern");
                ConcernPageView.this.k.d0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements BdListView.p {
        public g() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            ConcernPageView.this.B();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ConcernPageView.this.k != null && d.a.c.e.p.j.A() && TbadkCoreApplication.isLogin()) {
                ConcernPageView.this.k.d0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ConcernPageView.this.B();
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public j(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            ConcernPageView.this.q = true;
            ConcernPageView.this.K();
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public k(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (intValue == 1) {
                ConcernPageView.this.k.r();
            } else {
                ConcernPageView.this.k.S();
            }
            if (ConcernPageView.this.o == null) {
                return;
            }
            if (intValue == 1) {
                ConcernPageView.this.o.setTextOption(NoDataViewFactory.e.d(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
            } else {
                ConcernPageView.this.o.setTextOption(NoDataViewFactory.e.d(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface l {
        void a(boolean z, boolean z2);

        void b(d.a.j0.z0.c cVar);

        void c(String str, d.a.j0.z0.c cVar);
    }

    public ConcernPageView(Context context) {
        super(context);
        this.q = false;
        this.r = 3;
        this.t = -1;
        this.u = new c();
        this.v = new d();
        this.x = new e();
        this.y = new i();
        this.z = new j(2921058);
        this.A = new k(2921502);
        this.B = new a(2921526);
        w(context);
    }

    public final boolean A() {
        d.a.j0.d0.h hVar = this.n;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    public final void B() {
        d.a.k0.a1.b.d dVar = this.k;
        if (dVar == null) {
            return;
        }
        dVar.H();
    }

    public void C() {
        d.a.k0.a1.b.a aVar = this.f16236h;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void D(int i2) {
        if (this.r != i2) {
            ConcernNotLoginLayout concernNotLoginLayout = this.l;
            if (concernNotLoginLayout != null) {
                concernNotLoginLayout.b(i2);
            }
            d.a.j0.d0.g gVar = this.m;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            d.a.j0.d0.h hVar = this.n;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            d.a.k0.a1.g.i.a aVar = this.f16233e;
            if (aVar != null) {
                aVar.I(i2);
            }
            PbListView pbListView = this.f16234f;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.f16234f.d(i2);
            }
            NoDataView noDataView = this.o;
            if (noDataView != null && noDataView.getVisibility() == 0) {
                this.o.f(this.f16237i, i2);
                this.o.setSubTitleTextColor(R.color.CAM_X0105);
            }
            PublishProgressView publishProgressView = this.p;
            if (publishProgressView != null) {
                publishProgressView.b();
            }
            this.f16236h.e(i2);
        }
        this.r = i2;
    }

    public void E() {
        ScrollFragmentTabHost scrollFragmentTabHost = this.s;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.Q(this.v);
        }
        this.f16235g.removeOnScrollListener(this.u);
        MessageManager.getInstance().unRegisterListener(this.B);
        this.k.Z(null);
        this.f16233e.a(null);
        this.f16233e.b(null);
        this.f16235g.setOnSrollToBottomListener(null);
        this.f16233e.l(null);
        this.f16233e.X();
        this.f16235g.setRecyclerListener(null);
        this.k.M();
    }

    public void F() {
        setTabInForeBackgroundState(false);
        C();
    }

    public void G() {
        a2 a2Var;
        d.a.k0.a1.b.a aVar = this.f16236h;
        if (aVar == null) {
            return;
        }
        List<n> a2 = aVar.a();
        if (ListUtils.isEmpty(a2)) {
            return;
        }
        for (n nVar : a2) {
            if (nVar instanceof d.a.k0.x.e0.k) {
                d.a.k0.x.e0.k kVar = (d.a.k0.x.e0.k) nVar;
                if (kVar.o != 0 && (a2Var = kVar.f63179e) != null) {
                    int[] p0 = a2Var.p0();
                    kVar.o = p0[0];
                    kVar.p = p0[1];
                }
            }
        }
        d.a.c.e.m.e.a().postDelayed(new b(), 500L);
    }

    public void H() {
        d.a.k0.a1.b.d dVar = this.k;
        if (dVar != null) {
            dVar.K(true);
        }
    }

    public boolean I(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void J() {
        if (!TbadkCoreApplication.isLogin()) {
            Q();
            return;
        }
        d.a.k0.a1.b.d dVar = this.k;
        if (dVar != null) {
            dVar.R();
        }
    }

    public void K() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f16235g;
        if (bdTypeRecyclerView == null || this.w == null) {
            return;
        }
        if (this.q && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
            this.q = false;
            return;
        }
        this.f16235g.setSelection(0);
        if (!this.w.t()) {
            NoDataView noDataView = this.o;
            if (noDataView != null && noDataView.getVisibility() == 0) {
                if (TbadkCoreApplication.isLogin()) {
                    this.k.d0();
                }
            } else {
                this.w.setRefreshing(true);
            }
        }
        if (!this.w.t()) {
            this.w.setRefreshing(true);
        }
        ScrollFragmentTabHost.q qVar = this.v;
        if (qVar != null) {
            qVar.a();
        }
    }

    public void L() {
        this.w.setVisibility(0);
        this.f16235g.setVisibility(0);
        this.f16234f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f16234f.r(0);
    }

    public void M() {
        this.w.setVisibility(0);
        this.f16235g.setVisibility(0);
        if (this.k.A()) {
            this.f16234f.O();
        } else {
            this.f16234f.g();
        }
        this.f16234f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f16234f.r(d.a.c.e.p.l.g(getContext(), R.dimen.tbds150));
    }

    public final void N(boolean z) {
        if (z()) {
            return;
        }
        if (this.m == null) {
            this.m = new d.a.j0.d0.g(getContext());
            this.m.o(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + d.a.c.e.p.l.g(getContext(), R.dimen.tbds60));
            this.m.h();
            this.m.setWrapStyle(true);
        }
        this.m.onChangeSkinType();
        this.m.attachView(this, z);
    }

    public void O(boolean z) {
        if (A()) {
            return;
        }
        if (this.n == null) {
            this.n = new d.a.j0.d0.h(getContext(), new h());
        }
        this.n.attachView(this, z);
        this.n.o();
    }

    public final void P() {
        int k2 = d.a.j0.r.d0.b.j().k("key_home_concern_all_status", 0);
        if (this.o == null) {
            this.o = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.e.d(null, getContext().getString(R.string.concern_no_data_title)), null);
        }
        if (k2 == 1) {
            this.o.setTextOption(NoDataViewFactory.e.d(null, getContext().getString(R.string.concern_person_no_data_title)));
            this.o.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.GIFT));
        } else {
            this.o.setTextOption(NoDataViewFactory.e.d(null, getContext().getString(R.string.concern_no_data_title)));
            this.o.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.SINGALL));
        }
        this.o.f(this.f16237i, TbadkCoreApplication.getInst().getSkinType());
        this.o.setVisibility(0);
        this.o.bringToFront();
    }

    public final void Q() {
        if (this.l == null) {
            ConcernNotLoginLayout concernNotLoginLayout = new ConcernNotLoginLayout(getContext());
            this.l = concernNotLoginLayout;
            concernNotLoginLayout.b(this.r);
        }
        if (this.l.getParent() != null) {
            return;
        }
        this.w.setVisibility(8);
        this.l.setVisibility(0);
        addView(this.l);
    }

    public void R(DataRes dataRes, boolean z) {
        this.k.N(z, dataRes, 0, null);
    }

    public void S(String str, int i2) {
        this.k.N(true, null, i2, str);
    }

    public void r() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.w;
        if (bigdaySwipeRefreshLayout != null) {
            bigdaySwipeRefreshLayout.r();
        }
    }

    public void s() {
        if (!TbadkCoreApplication.isLogin()) {
            Q();
            return;
        }
        d.a.k0.a1.b.d dVar = this.k;
        if (dVar != null) {
            dVar.d0();
            N(true);
        }
    }

    public void setCallback(l lVar) {
        this.j = lVar;
    }

    public void setHeaderViewHeight(int i2) {
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        d.a.k0.a1.b.a aVar = this.f16236h;
        if (aVar != null) {
            aVar.h(bdUniqueId);
        }
        d.a.k0.a1.b.d dVar = this.k;
        if (dVar != null) {
            dVar.c0(bdUniqueId);
        }
        d.a.k0.a1.g.i.a aVar2 = this.f16233e;
        if (aVar2 != null) {
            aVar2.Z(bdUniqueId);
        }
        CustomMessageListener customMessageListener = this.z;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.z);
        }
        CustomMessageListener customMessageListener2 = this.A;
        if (customMessageListener2 != null) {
            customMessageListener2.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.A);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(b0 b0Var) {
        d.a.k0.a1.b.d dVar = this.k;
        if (dVar != null) {
            dVar.a0(b0Var);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.s = scrollFragmentTabHost;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.Q(this.v);
            this.s.u(this.v);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        d.a.k0.a1.b.d dVar = this.k;
        if (dVar != null) {
            dVar.b0(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        d.a.k0.a1.b.d dVar = this.k;
        if (dVar != null) {
            dVar.K(false);
        }
    }

    public final void t() {
        d.a.j0.d0.g gVar = this.m;
        if (gVar != null) {
            gVar.dettachView(this);
            this.m = null;
        }
    }

    public final void u() {
        d.a.j0.d0.h hVar = this.n;
        if (hVar != null) {
            hVar.dettachView(this);
            this.n = null;
        }
    }

    public final void v() {
        NoDataView noDataView = this.o;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void w(Context context) {
        BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
        this.f16235g = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.f16235g.setFadingEdgeLength(0);
        this.f16235g.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f16235g.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
        this.w = bigdaySwipeRefreshLayout;
        bigdaySwipeRefreshLayout.addView(this.f16235g);
        PbListView pbListView = new PbListView(context);
        this.f16234f = pbListView;
        pbListView.a();
        this.f16234f.o(R.color.transparent);
        this.f16234f.v();
        this.f16234f.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f16234f.E(R.dimen.tbfontsize33);
        this.f16234f.y(R.color.CAM_X0110);
        this.f16234f.z(this.y);
        this.f16235g.setNextPage(this.f16234f);
        d.a.c.a.f<?> a2 = d.a.c.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f16237i = (TbPageContext) a2;
        }
        addView(this.w);
        d.a.k0.a1.g.i.a aVar = new d.a.k0.a1.g.i.a(this.f16237i);
        this.f16233e = aVar;
        aVar.B(true);
        this.w.setProgressView(this.f16233e);
        int i2 = (int) (getResources().getDisplayMetrics().density * 86.0f);
        this.w.setCustomDistances(i2, i2, i2 * 2);
        d.a.k0.a1.b.a aVar2 = new d.a.k0.a1.b.a(context, this.f16235g);
        this.f16236h = aVar2;
        this.k = new d.a.k0.a1.b.d(this.f16237i, this.f16235g, aVar2, this.w);
        this.w.setVisibility(8);
        PublishProgressView publishProgressView = new PublishProgressView(context);
        this.p = publishProgressView;
        addView(publishProgressView, new FrameLayout.LayoutParams(-1, d.a.c.e.p.l.g(getContext(), R.dimen.tbds83)));
        this.p.setVisibility(8);
        D(TbadkCoreApplication.getInst().getSkinType());
    }

    public void x() {
        this.k.Z(this.x);
        this.f16233e.a(new f());
        this.f16235g.setOnSrollToBottomListener(new g());
        this.f16235g.removeOnScrollListener(this.u);
        this.f16235g.addOnScrollListener(this.u);
        MessageManager.getInstance().registerListener(this.B);
    }

    public void y(a2 a2Var) {
        v();
        this.k.B(a2Var);
    }

    public boolean z() {
        d.a.j0.d0.g gVar = this.m;
        if (gVar != null) {
            return gVar.isViewAttached();
        }
        return false;
    }

    public void setViewForeground(boolean z) {
        d.a.k0.a1.b.d dVar = this.k;
        if (dVar != null) {
            dVar.O(z);
        }
        ScrollFragmentTabHost scrollFragmentTabHost = this.s;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.Q(this.v);
            this.s.u(this.v);
            this.v.a();
        }
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = false;
        this.r = 3;
        this.t = -1;
        this.u = new c();
        this.v = new d();
        this.x = new e();
        this.y = new i();
        this.z = new j(2921058);
        this.A = new k(2921502);
        this.B = new a(2921526);
        w(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.q = false;
        this.r = 3;
        this.t = -1;
        this.u = new c();
        this.v = new d();
        this.x = new e();
        this.y = new i();
        this.z = new j(2921058);
        this.A = new k(2921502);
        this.B = new a(2921526);
        w(context);
    }
}
