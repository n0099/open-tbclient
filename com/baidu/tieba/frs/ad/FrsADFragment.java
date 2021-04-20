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
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.c.j.e.w;
import d.b.i0.q0.q0;
import d.b.i0.q0.s0;
import d.b.i0.q0.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsADFragment extends BaseFragment implements q0, BdListView.p, s0 {

    /* renamed from: f  reason: collision with root package name */
    public ADRequestModel.b f15791f;

    /* renamed from: g  reason: collision with root package name */
    public ADRequestModel f15792g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f15793h;
    public long i;
    public d.b.i0.q0.h1.a l;
    public boolean m;
    public List<d.b.i0.q0.h1.c> n;
    public d.b.h0.d0.c p;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.q0.h1.e f15790e = null;
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
        public a(int i, boolean z) {
            super(i, z);
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
        public void a(ADHttpResponseMessage aDHttpResponseMessage) {
            if (aDHttpResponseMessage == null || FrsADFragment.this.f15790e == null) {
                return;
            }
            if (aDHttpResponseMessage.getError() == 0) {
                FrsADFragment.this.j = (int) aDHttpResponseMessage.getOffset();
                FrsADFragment.this.n = aDHttpResponseMessage.getList();
                FrsADFragment.this.m = aDHttpResponseMessage.getHas_more() == 1;
                FrsADFragment.this.w();
                return;
            }
            FrsADFragment.this.Z0();
        }

        @Override // com.baidu.tieba.frs.adModel.ADRequestModel.b
        public void b(ADSocketResponseMessage aDSocketResponseMessage) {
            if (aDSocketResponseMessage == null || FrsADFragment.this.f15790e == null) {
                return;
            }
            if (aDSocketResponseMessage.getError() == 0) {
                FrsADFragment.this.j = (int) aDSocketResponseMessage.getOffset();
                FrsADFragment.this.n = aDSocketResponseMessage.getList();
                FrsADFragment.this.m = aDSocketResponseMessage.getHas_more() == 1;
                FrsADFragment.this.w();
                return;
            }
            FrsADFragment.this.Z0();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.r += i2;
            if (FrsADFragment.this.r < FrsADFragment.this.q * 2 || i2 >= 0) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                if (FrsADFragment.this.R0() != null) {
                    FrsADFragment.this.R0().setSelection(0);
                }
                if (FrsADFragment.this.p != null && FrsADFragment.this.p.isViewAttached()) {
                    FrsADFragment.this.U0(0);
                    return;
                }
                d.b.i0.q0.h1.e eVar = FrsADFragment.this.f15790e;
                if (eVar != null) {
                    eVar.p();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                if (FrsADFragment.this.R0() != null) {
                    FrsADFragment.this.R0().setSelection(0);
                }
                if (FrsADFragment.this.p != null && FrsADFragment.this.p.isViewAttached()) {
                    FrsADFragment.this.U0(0);
                    FrsADFragment.this.Y0();
                    return;
                }
                d.b.i0.q0.h1.e eVar = FrsADFragment.this.f15790e;
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

        @Override // d.b.c.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            d.b.i0.q0.h1.c cVar;
            if (nVar == null || !(nVar instanceof d.b.i0.q0.h1.c) || (cVar = (d.b.i0.q0.h1.c) nVar) == null || cVar.o() == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair(BaseWebViewActivity.KEY_SHOW_FRS_TAB_AD, "1"));
            UrlManager.getInstance().dealOneLink(FrsADFragment.this.f15793h, new String[]{d.b.h0.l.a.c(cVar.o(), arrayList)});
            if (k.isEmpty(cVar.j())) {
                return;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FRS_AD_LIST_ITEM_CLICK).param("obj_type", cVar.j()).param("fid", FrsADFragment.this.i));
        }
    }

    @Override // d.b.i0.q0.q0
    public void B0() {
        d.b.i0.q0.h1.e eVar = this.f15790e;
        if (eVar == null || eVar.a() == null) {
            return;
        }
        this.f15790e.a().scrollToPosition(0);
    }

    @Override // d.b.i0.q0.q0
    public void E() {
        if (this.f15790e != null) {
            B0();
            this.f15790e.p();
        }
    }

    public BdTypeRecyclerView R0() {
        d.b.i0.q0.h1.e eVar = this.f15790e;
        if (eVar == null) {
            return null;
        }
        return eVar.a();
    }

    public final void S0() {
        this.f15790e.k(true);
        this.f15790e.m(true);
        d.b.h0.d0.c cVar = this.p;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.p.dettachView(this.f15790e.b());
    }

    public final void T0(Bundle bundle) {
        if (bundle != null) {
            bundle.getString("name");
            bundle.getString("from");
            this.i = d.b.c.e.m.b.f(bundle.getString("forum_id"), 0L);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.getString("name");
            arguments.getString("from");
            this.i = d.b.c.e.m.b.f(arguments.getString("forum_id"), 0L);
        }
    }

    public final void U0(int i) {
        if (this.f15792g == null) {
            return;
        }
        S0();
        this.k = i;
        if (i == 0 || i == 2) {
            this.f15792g.t(this.i, 0, 20);
        } else if (i == 1) {
            this.f15792g.t(this.i, this.j, 20);
        }
    }

    public final void V0() {
        if (this.o == null || this.f15790e == null) {
            return;
        }
        this.o.add(new t());
        this.f15790e.c().d(this.o);
        this.f15790e.c().b();
    }

    public final void W0(boolean z, boolean z2) {
        ArrayList<n> arrayList = this.o;
        if (arrayList == null) {
            return;
        }
        if (z) {
            arrayList.clear();
        }
        if (z2) {
            for (int i = 0; i < this.o.size(); i++) {
                n nVar = (n) ListUtils.getItem(this.o, i);
                if (nVar instanceof d.b.i0.q0.h1.c) {
                    ((d.b.i0.q0.h1.c) nVar).w(false);
                }
            }
        }
        this.o.addAll(this.n);
        d.b.h0.b.f.a.d(this.o);
        this.f15790e.c().d(this.o);
        this.f15790e.c().b();
    }

    public final void X0() {
        if (!this.m) {
            if (ListUtils.isEmpty(this.n)) {
                this.f15790e.d();
                return;
            } else {
                this.f15790e.o();
                return;
            }
        }
        this.f15790e.n();
    }

    public final void Y0() {
        this.f15790e.k(false);
        showLoadingView(this.f15790e.b(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    public final void Z0() {
        this.f15790e.k(false);
        this.f15790e.m(false);
        this.f15790e.d();
        this.f15790e.a().getData().clear();
        this.f15790e.f();
        if (this.p == null) {
            d.b.h0.d0.c cVar = new d.b.h0.d0.c(getPageContext().getContext(), getNetRefreshListener());
            this.p = cVar;
            cVar.e(null);
            this.p.d(null);
            this.p.c(null);
            this.p.f();
            this.p.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.p.onChangeSkinType();
        this.p.attachView(this.f15790e.b(), true);
        this.p.a(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = "a006";
        tbPageTag.tabId = 90;
        return tbPageTag;
    }

    @Override // d.b.i0.q0.s0
    public void m() {
        if (this.f15790e == null) {
            return;
        }
        if (j.z()) {
            U0(2);
            if (ListUtils.isEmpty(this.o)) {
                Y0();
                return;
            }
            return;
        }
        this.f15790e.j(false);
    }

    public final void n() {
        this.f15790e.k(true);
        hideLoadingView(this.f15790e.b());
    }

    @Override // d.b.i0.q0.s0
    public void o() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.i0.q0.h1.e eVar = this.f15790e;
        if (eVar != null) {
            eVar.g(i);
        }
        d.b.h0.d0.c cVar = this.p;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.p.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15793h = getPageContext();
        T0(bundle);
        registerListener(this.u);
        registerListener(this.v);
        registerListener(this.s);
        if (this.f15792g == null) {
            this.f15792g = new ADRequestModel(this.f15793h);
        }
        this.q = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        d.b.i0.q0.h1.e eVar = new d.b.i0.q0.h1.e(this, inflate);
        this.f15790e = eVar;
        eVar.l(this.t);
        d.b.i0.q0.h1.a aVar = new d.b.i0.q0.h1.a(this, this.f15790e.a());
        this.l = aVar;
        aVar.f(this.w);
        if (this.f15791f == null) {
            this.f15791f = new b();
        }
        if (this.f15792g == null) {
            this.f15792g = new ADRequestModel(this.f15793h);
        }
        this.f15792g.u(this.f15791f);
        if (!j.z()) {
            Z0();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.s);
        d.b.i0.q0.h1.e eVar = this.f15790e;
        if (eVar != null) {
            eVar.h();
        }
        ADRequestModel aDRequestModel = this.f15792g;
        if (aDRequestModel != null) {
            aDRequestModel.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.z()) {
            U0(0);
            Y0();
            return;
        }
        Z0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new StatisticItem("c13008").param("fid", this.i).param("obj_type", 9).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.z()) {
            U0(0);
            Y0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        d.b.i0.q0.h1.e eVar = this.f15790e;
        if (eVar == null) {
            return;
        }
        if (eVar != null && eVar.a() != null) {
            this.f15790e.a().stopScroll();
        }
        X0();
        if (l.C() && this.m) {
            U0(1);
        }
    }

    public final void w() {
        if (this.f15790e == null) {
            return;
        }
        n();
        this.f15790e.i();
        int i = this.k;
        if (i == 0) {
            if (!ListUtils.isEmpty(this.n)) {
                W0(true, false);
                this.f15790e.o();
                return;
            }
            V0();
        } else if (i == 2) {
            this.f15790e.j(false);
            if (!ListUtils.isEmpty(this.n)) {
                W0(true, false);
                this.f15790e.o();
                return;
            }
            V0();
        } else if (i == 1) {
            if (!ListUtils.isEmpty(this.n)) {
                W0(false, true);
            } else {
                this.f15790e.o();
            }
        }
    }
}
