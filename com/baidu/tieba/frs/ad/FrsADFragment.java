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
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.k0.q0.q0;
import d.a.k0.q0.s0;
import d.a.k0.q0.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsADFragment extends BaseFragment implements q0, BdListView.p, s0 {

    /* renamed from: f  reason: collision with root package name */
    public ADRequestModel.b f15294f;

    /* renamed from: g  reason: collision with root package name */
    public ADRequestModel f15295g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f15296h;

    /* renamed from: i  reason: collision with root package name */
    public long f15297i;
    public d.a.k0.q0.h1.a l;
    public boolean m;
    public List<d.a.k0.q0.h1.c> n;
    public d.a.j0.d0.c p;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.q0.h1.e f15293e = null;
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
            if (aDSocketResponseMessage == null || FrsADFragment.this.f15293e == null) {
                return;
            }
            if (aDSocketResponseMessage.getError() == 0) {
                FrsADFragment.this.j = (int) aDSocketResponseMessage.getOffset();
                FrsADFragment.this.n = aDSocketResponseMessage.getList();
                FrsADFragment.this.m = aDSocketResponseMessage.getHas_more() == 1;
                FrsADFragment.this.p();
                return;
            }
            FrsADFragment.this.Y0();
        }

        @Override // com.baidu.tieba.frs.adModel.ADRequestModel.b
        public void b(ADHttpResponseMessage aDHttpResponseMessage) {
            if (aDHttpResponseMessage == null || FrsADFragment.this.f15293e == null) {
                return;
            }
            if (aDHttpResponseMessage.getError() == 0) {
                FrsADFragment.this.j = (int) aDHttpResponseMessage.getOffset();
                FrsADFragment.this.n = aDHttpResponseMessage.getList();
                FrsADFragment.this.m = aDHttpResponseMessage.getHas_more() == 1;
                FrsADFragment.this.p();
                return;
            }
            FrsADFragment.this.Y0();
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
                if (FrsADFragment.this.Q0() != null) {
                    FrsADFragment.this.Q0().setSelection(0);
                }
                if (FrsADFragment.this.p != null && FrsADFragment.this.p.isViewAttached()) {
                    FrsADFragment.this.T0(0);
                    return;
                }
                d.a.k0.q0.h1.e eVar = FrsADFragment.this.f15293e;
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
                if (FrsADFragment.this.Q0() != null) {
                    FrsADFragment.this.Q0().setSelection(0);
                }
                if (FrsADFragment.this.p != null && FrsADFragment.this.p.isViewAttached()) {
                    FrsADFragment.this.T0(0);
                    FrsADFragment.this.X0();
                    return;
                }
                d.a.k0.q0.h1.e eVar = FrsADFragment.this.f15293e;
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

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            d.a.k0.q0.h1.c cVar;
            if (nVar == null || !(nVar instanceof d.a.k0.q0.h1.c) || (cVar = (d.a.k0.q0.h1.c) nVar) == null || cVar.p() == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair(BaseWebViewActivity.KEY_SHOW_FRS_TAB_AD, "1"));
            UrlManager.getInstance().dealOneLink(FrsADFragment.this.f15296h, new String[]{d.a.j0.l.a.c(cVar.p(), arrayList)});
            if (k.isEmpty(cVar.l())) {
                return;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FRS_AD_LIST_ITEM_CLICK).param("obj_type", cVar.l()).param("fid", FrsADFragment.this.f15297i));
        }
    }

    @Override // d.a.k0.q0.q0
    public void B0() {
        d.a.k0.q0.h1.e eVar = this.f15293e;
        if (eVar == null || eVar.a() == null) {
            return;
        }
        this.f15293e.a().scrollToPosition(0);
    }

    public BdTypeRecyclerView Q0() {
        d.a.k0.q0.h1.e eVar = this.f15293e;
        if (eVar == null) {
            return null;
        }
        return eVar.a();
    }

    public final void R0() {
        this.f15293e.k(true);
        this.f15293e.m(true);
        d.a.j0.d0.c cVar = this.p;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.p.dettachView(this.f15293e.b());
    }

    public final void S0(Bundle bundle) {
        if (bundle != null) {
            bundle.getString("name");
            bundle.getString("from");
            this.f15297i = d.a.c.e.m.b.f(bundle.getString("forum_id"), 0L);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.getString("name");
            arguments.getString("from");
            this.f15297i = d.a.c.e.m.b.f(arguments.getString("forum_id"), 0L);
        }
    }

    public final void T0(int i2) {
        if (this.f15295g == null) {
            return;
        }
        R0();
        this.k = i2;
        if (i2 == 0 || i2 == 2) {
            this.f15295g.t(this.f15297i, 0, 20);
        } else if (i2 == 1) {
            this.f15295g.t(this.f15297i, this.j, 20);
        }
    }

    public final void U0() {
        if (this.o == null || this.f15293e == null) {
            return;
        }
        this.o.add(new t());
        this.f15293e.c().d(this.o);
        this.f15293e.c().b();
    }

    public final void V0(boolean z, boolean z2) {
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
                if (nVar instanceof d.a.k0.q0.h1.c) {
                    ((d.a.k0.q0.h1.c) nVar).w(false);
                }
            }
        }
        this.o.addAll(this.n);
        d.a.j0.b.f.a.d(this.o);
        this.f15293e.c().d(this.o);
        this.f15293e.c().b();
    }

    public final void W0() {
        if (!this.m) {
            if (ListUtils.isEmpty(this.n)) {
                this.f15293e.d();
                return;
            } else {
                this.f15293e.o();
                return;
            }
        }
        this.f15293e.n();
    }

    public final void X0() {
        this.f15293e.k(false);
        showLoadingView(this.f15293e.b(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    public final void Y0() {
        this.f15293e.k(false);
        this.f15293e.m(false);
        this.f15293e.d();
        this.f15293e.a().getData().clear();
        this.f15293e.f();
        if (this.p == null) {
            d.a.j0.d0.c cVar = new d.a.j0.d0.c(getPageContext().getContext(), getNetRefreshListener());
            this.p = cVar;
            cVar.e(null);
            this.p.d(null);
            this.p.c(null);
            this.p.f();
            this.p.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.p.onChangeSkinType();
        this.p.attachView(this.f15293e.b(), true);
        this.p.a(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = "a006";
        tbPageTag.tabId = 90;
        return tbPageTag;
    }

    @Override // d.a.k0.q0.s0
    public void k() {
    }

    @Override // d.a.k0.q0.s0
    public void m() {
        if (this.f15293e == null) {
            return;
        }
        if (j.z()) {
            T0(2);
            if (ListUtils.isEmpty(this.o)) {
                X0();
                return;
            }
            return;
        }
        this.f15293e.j(false);
    }

    public final void n() {
        this.f15293e.k(true);
        hideLoadingView(this.f15293e.b());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.k0.q0.h1.e eVar = this.f15293e;
        if (eVar != null) {
            eVar.g(i2);
        }
        d.a.j0.d0.c cVar = this.p;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.p.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15296h = getPageContext();
        S0(bundle);
        registerListener(this.u);
        registerListener(this.v);
        registerListener(this.s);
        if (this.f15295g == null) {
            this.f15295g = new ADRequestModel(this.f15296h);
        }
        this.q = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        d.a.k0.q0.h1.e eVar = new d.a.k0.q0.h1.e(this, inflate);
        this.f15293e = eVar;
        eVar.l(this.t);
        d.a.k0.q0.h1.a aVar = new d.a.k0.q0.h1.a(this, this.f15293e.a());
        this.l = aVar;
        aVar.f(this.w);
        if (this.f15294f == null) {
            this.f15294f = new b();
        }
        if (this.f15295g == null) {
            this.f15295g = new ADRequestModel(this.f15296h);
        }
        this.f15295g.u(this.f15294f);
        if (!j.z()) {
            Y0();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.s);
        d.a.k0.q0.h1.e eVar = this.f15293e;
        if (eVar != null) {
            eVar.h();
        }
        ADRequestModel aDRequestModel = this.f15295g;
        if (aDRequestModel != null) {
            aDRequestModel.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.z()) {
            T0(0);
            X0();
            return;
        }
        Y0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new StatisticItem("c13008").param("fid", this.f15297i).param("obj_type", 9).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.z()) {
            T0(0);
            X0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        d.a.k0.q0.h1.e eVar = this.f15293e;
        if (eVar == null) {
            return;
        }
        if (eVar != null && eVar.a() != null) {
            this.f15293e.a().stopScroll();
        }
        W0();
        if (l.D() && this.m) {
            T0(1);
        }
    }

    public final void p() {
        if (this.f15293e == null) {
            return;
        }
        n();
        this.f15293e.i();
        int i2 = this.k;
        if (i2 == 0) {
            if (!ListUtils.isEmpty(this.n)) {
                V0(true, false);
                this.f15293e.o();
                return;
            }
            U0();
        } else if (i2 == 2) {
            this.f15293e.j(false);
            if (!ListUtils.isEmpty(this.n)) {
                V0(true, false);
                this.f15293e.o();
                return;
            }
            U0();
        } else if (i2 == 1) {
            if (!ListUtils.isEmpty(this.n)) {
                V0(false, true);
            } else {
                this.f15293e.o();
            }
        }
    }

    @Override // d.a.k0.q0.q0
    public void t() {
        if (this.f15293e != null) {
            B0();
            this.f15293e.p();
        }
    }
}
