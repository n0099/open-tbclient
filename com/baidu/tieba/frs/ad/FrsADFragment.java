package com.baidu.tieba.frs.ad;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.o0.r0.q0;
import d.a.o0.r0.s0;
import d.a.o0.r0.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsADFragment extends BaseFragment implements q0, BdListView.p, s0 {

    /* renamed from: f  reason: collision with root package name */
    public ADRequestModel.b f15341f;

    /* renamed from: g  reason: collision with root package name */
    public ADRequestModel f15342g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f15343h;

    /* renamed from: i  reason: collision with root package name */
    public long f15344i;
    public d.a.o0.r0.h1.a l;
    public boolean m;
    public List<d.a.o0.r0.h1.c> n;
    public d.a.n0.d0.c p;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.r0.h1.e f15340e = null;
    public int j = 0;
    public int k = 0;
    public ArrayList<n> o = new ArrayList<>();
    public int q = 0;
    public int r = 0;
    public CustomMessageListener s = new a(2921397, true);
    public final RecyclerView.OnScrollListener t = new c();
    public CustomMessageListener u = new d(2001625);
    public CustomMessageListener v = new e(2001624);
    public w w = new f();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2, boolean z) {
            super(i2, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || FrsADFragment.this.p == null || !FrsADFragment.this.p.isViewAttached()) {
                return;
            }
            FrsADFragment.this.p.a(num.intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ADRequestModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.frs.adModel.ADRequestModel.b
        public void a(ADSocketResponseMessage aDSocketResponseMessage) {
            if (aDSocketResponseMessage == null || FrsADFragment.this.f15340e == null) {
                return;
            }
            if (aDSocketResponseMessage.getError() == 0) {
                FrsADFragment.this.j = (int) aDSocketResponseMessage.getOffset();
                FrsADFragment.this.n = aDSocketResponseMessage.getList();
                FrsADFragment.this.m = aDSocketResponseMessage.getHas_more() == 1;
                FrsADFragment.this.r();
                return;
            }
            FrsADFragment.this.b1();
        }

        @Override // com.baidu.tieba.frs.adModel.ADRequestModel.b
        public void b(ADHttpResponseMessage aDHttpResponseMessage) {
            if (aDHttpResponseMessage == null || FrsADFragment.this.f15340e == null) {
                return;
            }
            if (aDHttpResponseMessage.getError() == 0) {
                FrsADFragment.this.j = (int) aDHttpResponseMessage.getOffset();
                FrsADFragment.this.n = aDHttpResponseMessage.getList();
                FrsADFragment.this.m = aDHttpResponseMessage.getHas_more() == 1;
                FrsADFragment.this.r();
                return;
            }
            FrsADFragment.this.b1();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            FrsADFragment.this.r += i3;
            if (FrsADFragment.this.r < FrsADFragment.this.q * 2 || i3 >= 0) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                if (FrsADFragment.this.T0() != null) {
                    FrsADFragment.this.T0().setSelection(0);
                }
                if (FrsADFragment.this.p != null && FrsADFragment.this.p.isViewAttached()) {
                    FrsADFragment.this.W0(0);
                    return;
                }
                d.a.o0.r0.h1.e eVar = FrsADFragment.this.f15340e;
                if (eVar != null) {
                    eVar.p();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                if (FrsADFragment.this.T0() != null) {
                    FrsADFragment.this.T0().setSelection(0);
                }
                if (FrsADFragment.this.p != null && FrsADFragment.this.p.isViewAttached()) {
                    FrsADFragment.this.W0(0);
                    FrsADFragment.this.a1();
                    return;
                }
                d.a.o0.r0.h1.e eVar = FrsADFragment.this.f15340e;
                if (eVar != null) {
                    eVar.p();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements w {
        public f() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            d.a.o0.r0.h1.c cVar;
            if (nVar == null || !(nVar instanceof d.a.o0.r0.h1.c) || (cVar = (d.a.o0.r0.h1.c) nVar) == null || cVar.k() == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair(BaseWebViewActivity.KEY_SHOW_FRS_TAB_AD, "1"));
            UrlManager.getInstance().dealOneLink(FrsADFragment.this.f15343h, new String[]{d.a.n0.l.a.c(cVar.k(), arrayList)});
            if (k.isEmpty(cVar.g())) {
                return;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FRS_AD_LIST_ITEM_CLICK).param("obj_type", cVar.g()).param("fid", FrsADFragment.this.f15344i));
        }
    }

    @Override // d.a.o0.r0.q0
    public void E0() {
        d.a.o0.r0.h1.e eVar = this.f15340e;
        if (eVar == null || eVar.a() == null) {
            return;
        }
        this.f15340e.a().scrollToPosition(0);
    }

    public BdTypeRecyclerView T0() {
        d.a.o0.r0.h1.e eVar = this.f15340e;
        if (eVar == null) {
            return null;
        }
        return eVar.a();
    }

    public final void U0() {
        this.f15340e.k(true);
        this.f15340e.m(true);
        d.a.n0.d0.c cVar = this.p;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.p.dettachView(this.f15340e.b());
    }

    public final void V0(Bundle bundle) {
        if (bundle != null) {
            bundle.getString("name");
            bundle.getString("from");
            this.f15344i = d.a.c.e.m.b.f(bundle.getString("forum_id"), 0L);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.getString("name");
            arguments.getString("from");
            this.f15344i = d.a.c.e.m.b.f(arguments.getString("forum_id"), 0L);
        }
    }

    public final void W0(int i2) {
        if (this.f15342g == null) {
            return;
        }
        U0();
        this.k = i2;
        if (i2 == 0 || i2 == 2) {
            this.f15342g.x(this.f15344i, 0, 20);
        } else if (i2 == 1) {
            this.f15342g.x(this.f15344i, this.j, 20);
        }
    }

    public final void X0() {
        if (this.o == null || this.f15340e == null) {
            return;
        }
        this.o.add(new t());
        this.f15340e.c().d(this.o);
        this.f15340e.c().b();
    }

    public final void Y0(boolean z, boolean z2) {
        ArrayList<n> arrayList = this.o;
        if (arrayList == null) {
            return;
        }
        if (z) {
            arrayList.clear();
        }
        if (z2) {
            for (int i2 = 0; i2 < this.o.size(); i2++) {
                n nVar = (n) ListUtils.getItem(this.o, i2);
                if (nVar instanceof d.a.o0.r0.h1.c) {
                    ((d.a.o0.r0.h1.c) nVar).w(false);
                }
            }
        }
        this.o.addAll(this.n);
        d.a.n0.b.f.a.d(this.o);
        this.f15340e.c().d(this.o);
        this.f15340e.c().b();
    }

    public final void Z0() {
        if (!this.m) {
            if (ListUtils.isEmpty(this.n)) {
                this.f15340e.d();
                return;
            } else {
                this.f15340e.o();
                return;
            }
        }
        this.f15340e.n();
    }

    public final void a1() {
        this.f15340e.k(false);
        showLoadingView(this.f15340e.b(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    public final void b1() {
        this.f15340e.k(false);
        this.f15340e.m(false);
        this.f15340e.d();
        this.f15340e.a().getData().clear();
        this.f15340e.f();
        if (this.p == null) {
            d.a.n0.d0.c cVar = new d.a.n0.d0.c(getPageContext().getContext(), getNetRefreshListener());
            this.p = cVar;
            cVar.e(null);
            this.p.d(null);
            this.p.c(null);
            this.p.f();
            this.p.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.p.onChangeSkinType();
        this.p.attachView(this.f15340e.b(), true);
        this.p.a(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = "a006";
        tbPageTag.tabId = 90;
        return tbPageTag;
    }

    @Override // d.a.o0.r0.s0
    public void l() {
    }

    @Override // d.a.o0.r0.s0
    public void n() {
        if (this.f15340e == null) {
            return;
        }
        if (j.z()) {
            W0(2);
            if (ListUtils.isEmpty(this.o)) {
                a1();
                return;
            }
            return;
        }
        this.f15340e.j(false);
    }

    public final void o() {
        this.f15340e.k(true);
        hideLoadingView(this.f15340e.b());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.o0.r0.h1.e eVar = this.f15340e;
        if (eVar != null) {
            eVar.g(i2);
        }
        d.a.n0.d0.c cVar = this.p;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.p.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15343h = getPageContext();
        V0(bundle);
        registerListener(this.u);
        registerListener(this.v);
        registerListener(this.s);
        if (this.f15342g == null) {
            this.f15342g = new ADRequestModel(this.f15343h);
        }
        this.q = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        d.a.o0.r0.h1.e eVar = new d.a.o0.r0.h1.e(this, inflate);
        this.f15340e = eVar;
        eVar.l(this.t);
        d.a.o0.r0.h1.a aVar = new d.a.o0.r0.h1.a(this, this.f15340e.a());
        this.l = aVar;
        aVar.f(this.w);
        if (this.f15341f == null) {
            this.f15341f = new b();
        }
        if (this.f15342g == null) {
            this.f15342g = new ADRequestModel(this.f15343h);
        }
        this.f15342g.y(this.f15341f);
        if (!j.z()) {
            b1();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.s);
        d.a.o0.r0.h1.e eVar = this.f15340e;
        if (eVar != null) {
            eVar.h();
        }
        ADRequestModel aDRequestModel = this.f15342g;
        if (aDRequestModel != null) {
            aDRequestModel.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.z()) {
            W0(0);
            a1();
            return;
        }
        b1();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new StatisticItem("c13008").param("fid", this.f15344i).param("obj_type", 9).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.z()) {
            W0(0);
            a1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        d.a.o0.r0.h1.e eVar = this.f15340e;
        if (eVar == null) {
            return;
        }
        if (eVar != null && eVar.a() != null) {
            this.f15340e.a().stopScroll();
        }
        Z0();
        if (l.D() && this.m) {
            W0(1);
        }
    }

    public final void r() {
        if (this.f15340e == null) {
            return;
        }
        o();
        this.f15340e.i();
        int i2 = this.k;
        if (i2 == 0) {
            if (!ListUtils.isEmpty(this.n)) {
                Y0(true, false);
                this.f15340e.o();
                return;
            }
            X0();
        } else if (i2 == 2) {
            this.f15340e.j(false);
            if (!ListUtils.isEmpty(this.n)) {
                Y0(true, false);
                this.f15340e.o();
                return;
            }
            X0();
        } else if (i2 == 1) {
            if (!ListUtils.isEmpty(this.n)) {
                Y0(false, true);
            } else {
                this.f15340e.o();
            }
        }
    }

    @Override // d.a.o0.r0.q0
    public void u() {
        if (this.f15340e != null) {
            E0();
            this.f15340e.p();
        }
    }
}
