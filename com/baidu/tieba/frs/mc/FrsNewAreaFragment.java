package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.c.j.e.q;
import d.a.c.j.e.w;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.z1;
import d.a.k0.d3.m;
import d.a.k0.d3.s;
import d.a.k0.q0.q0;
import d.a.k0.q0.r0;
import d.a.k0.q0.s0;
import d.a.k0.s2.u;
import d.a.k0.x.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class FrsNewAreaFragment extends BaseFragment implements VoiceManager.j, d.a.k0.q0.d2.a, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, q0, ActivityCompat.OnRequestPermissionsResultCallback, u, r0, d.a.k0.e.e.b, s0 {
    public boolean A;

    /* renamed from: e  reason: collision with root package name */
    public String f15749e;
    public VoiceManager l;
    public long n;
    public FrsNewAreaModelController p;
    public FrsLoadMoreModel q;
    public d.a.j0.d0.c w;

    /* renamed from: f  reason: collision with root package name */
    public String f15750f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f15751g = null;

    /* renamed from: h  reason: collision with root package name */
    public int f15752h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f15753i = 1;
    public String j = null;
    public FrsViewData k = new FrsViewData();
    public long m = -1;
    public long o = -1;
    public d.a.k0.q0.e2.g r = null;
    public int s = -1;
    public int t = 3;
    public boolean u = false;
    public boolean v = false;
    public SparseArray<d.a.k0.e.e.a> x = new SparseArray<>();
    public int y = 0;
    public int z = 0;
    public CustomMessageListener B = new d(2921397, true);
    public Runnable C = new e();
    public CustomMessageListener D = new f(2004004);
    public CustomMessageListener E = new g(2001624);
    public final s F = new h();
    public final CustomMessageListener G = new i(2003003);
    public final RecyclerView.OnScrollListener H = new k();
    public final CustomMessageListener I = new b(0);
    public w J = new c();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.k0.q0.e2.g gVar = FrsNewAreaFragment.this.r;
            if (gVar == null || gVar.k() == null || FrsNewAreaFragment.this.r.k().isComputingLayout()) {
                return;
            }
            FrsNewAreaFragment.this.r.t();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                FrsNewAreaFragment.this.g1(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements w {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f15757e;

            public a(c cVar, String str) {
                this.f15757e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetWork netWork = new NetWork(this.f15757e);
                netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                netWork.getNetData();
            }
        }

        public c() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            boolean z;
            if (bdUniqueId == null || nVar == null || !(nVar instanceof z1)) {
                return;
            }
            a2 a2Var = ((z1) nVar).w;
            if (a2Var.O() == null || a2Var.O().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                if (a2Var.G() != 1 || ViewHelper.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    d.a.k0.d3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(a2Var.o0())) {
                        readThreadHistory.a(a2Var.o0());
                        d.a.k0.q0.e2.g gVar = FrsNewAreaFragment.this.r;
                        if (gVar != null) {
                            gVar.p();
                        }
                    }
                    String J = a2Var.J();
                    if (J == null || J.equals("")) {
                        z = false;
                    } else {
                        new Thread(new a(this, J)).start();
                        z = true;
                    }
                    String x1 = a2Var.x1();
                    if (x1 == null) {
                        x1 = "";
                    }
                    if (a2Var.x0() == 2 && !x1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        UrlManager.getInstance().dealOneLink(FrsNewAreaFragment.this.getPageContext(), new String[]{x1, "", null});
                        return;
                    }
                    if (x1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && x1.length() > 3) {
                        a2Var.G3(x1.substring(3));
                    }
                    PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(a2Var, FrsNewAreaFragment.this.f15750f, "frs_page", 18003, true, false, z);
                    createFromThreadCfg.setForumId(String.valueOf(a2Var.c0()));
                    createFromThreadCfg.setStartFrom(3);
                    FrsNewAreaFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    if (FrsNewAreaFragment.this.k == null || FrsNewAreaFragment.this.k.getForum() == null) {
                        return;
                    }
                    d.a.k0.q0.j2.b bVar = new d.a.k0.q0.j2.b();
                    bVar.f58633a = FrsNewAreaFragment.this.k.needLog == 1;
                    bVar.f58635c = FrsNewAreaFragment.this.k.getForum().getId();
                    bVar.f58634b = FrsNewAreaFragment.this.p.u();
                    d.a.k0.q0.j2.b bVar2 = d.a.k0.q0.j2.d.J0;
                    if (bVar2 != null) {
                        bVar.f58636d = bVar2.f58636d;
                        bVar.f58637e = bVar2.f58637e;
                    }
                    d.a.k0.q0.j2.a.c(a2Var, 1, FrsNewAreaFragment.this.getUniqueId(), bVar, FrsNewAreaFragment.this.getTbPageTag());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2, boolean z) {
            super(i2, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || FrsNewAreaFragment.this.w == null || !FrsNewAreaFragment.this.w.isViewAttached()) {
                return;
            }
            FrsNewAreaFragment.this.w.a(num.intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!d.a.c.e.p.j.z() || FrsNewAreaFragment.this.u) {
                FrsNewAreaFragment.this.D1(null);
            } else {
                FrsNewAreaFragment.this.r1(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof a2)) {
                return;
            }
            a2 a2Var = (a2) customResponsedMessage.getData();
            FrsNewAreaFragment.this.f15749e = a2Var.o0();
            if (TextUtils.isEmpty(FrsNewAreaFragment.this.f15749e) || a2Var.P0() == null) {
                return;
            }
            FrsNewAreaFragment.this.G1(a2Var.P0().getIsLike());
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                if (FrsNewAreaFragment.this.j1() != null) {
                    FrsNewAreaFragment.this.j1().setSelection(0);
                }
                if (FrsNewAreaFragment.this.w != null && FrsNewAreaFragment.this.w.isViewAttached()) {
                    FrsNewAreaFragment.this.r1(false);
                    return;
                }
                d.a.k0.q0.e2.g gVar = FrsNewAreaFragment.this.r;
                if (gVar != null) {
                    gVar.L();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements s {

        /* renamed from: a  reason: collision with root package name */
        public long f15762a = 1;

        public h() {
        }

        @Override // d.a.k0.d3.s
        public void a(int i2) {
            if (FrsNewAreaFragment.this.v) {
                return;
            }
            if (i2 == 1 || i2 == 2) {
                FrsNewAreaFragment.this.r.p();
            } else if (i2 != 3) {
            } else {
                FrsNewAreaFragment.this.r.A(true);
            }
        }

        @Override // d.a.k0.d3.s
        public void b() {
        }

        @Override // d.a.k0.d3.s
        public void c(m mVar) {
        }

        @Override // d.a.k0.d3.s
        public void d(int i2, boolean z, d.a.k0.d3.f fVar) {
            ArrayList<n> y;
            if (FrsNewAreaFragment.this.v) {
                if (FrsNewAreaFragment.this.m1().v() == null) {
                    FrsNewAreaFragment.this.v = false;
                    return;
                } else if (FrsNewAreaFragment.this.m1().v().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.v = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.f15762a = 1L;
            } else if (fVar.f53746b) {
                this.f15762a = 0L;
            } else {
                this.f15762a = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i2 == 3) {
                FrsNewAreaFragment.this.q.J();
            }
            FrsNewAreaFragment.this.r.A(false);
            if (FrsNewAreaFragment.this.m1().v() != null) {
                FrsNewAreaFragment frsNewAreaFragment = FrsNewAreaFragment.this;
                frsNewAreaFragment.k = frsNewAreaFragment.m1().v();
            }
            FrsNewAreaFragment frsNewAreaFragment2 = FrsNewAreaFragment.this;
            frsNewAreaFragment2.s = frsNewAreaFragment2.k.getPage().b();
            if (FrsNewAreaFragment.this.s == 0 && (FrsNewAreaFragment.this.k.getThreadListIds() == null || FrsNewAreaFragment.this.k.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.k.getThreadList() != null && FrsNewAreaFragment.this.k.getThreadList().size() != 0) {
                    FrsNewAreaFragment.this.r.K();
                } else {
                    FrsNewAreaFragment.this.r.m();
                }
            } else {
                FrsNewAreaFragment.this.r.J();
            }
            if (i2 == 4) {
                ArrayList<n> y2 = FrsNewAreaFragment.this.q.y(false, false, false, FrsNewAreaFragment.this.k.getThreadList(), null);
                if (y2 != null) {
                    FrsNewAreaFragment.this.k.setThreadList(y2);
                    FrsNewAreaFragment frsNewAreaFragment3 = FrsNewAreaFragment.this;
                    frsNewAreaFragment3.r.H(y2, frsNewAreaFragment3.f15753i, FrsNewAreaFragment.this.k, FrsNewAreaFragment.this.s);
                    return;
                }
                return;
            }
            if (i2 == 1) {
                FrsNewAreaFragment.this.r.p();
            } else if (i2 != 2) {
                if (i2 == 3 && FrsNewAreaFragment.this.k.isShowRedTip()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.TRUE));
                }
            } else {
                FrsNewAreaFragment.this.r.p();
            }
            FrsNewAreaFragment.this.n();
            if (this.f15762a != 0) {
                FrsNewAreaFragment.this.D1(fVar);
            } else {
                FrsNewAreaFragment.this.n1();
                if (FrsNewAreaFragment.this.k != null) {
                    FrsNewAreaFragment frsNewAreaFragment4 = FrsNewAreaFragment.this;
                    frsNewAreaFragment4.f15750f = frsNewAreaFragment4.k.getForum().getName();
                    FrsNewAreaFragment frsNewAreaFragment5 = FrsNewAreaFragment.this;
                    frsNewAreaFragment5.j = frsNewAreaFragment5.k.getForum().getId();
                    FrsNewAreaFragment frsNewAreaFragment6 = FrsNewAreaFragment.this;
                    frsNewAreaFragment6.r.s(frsNewAreaFragment6.k.getForum(), FrsNewAreaFragment.this.k.getUserData());
                }
                if (FrsNewAreaFragment.this.k != null) {
                    FrsNewAreaFragment.this.k.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.k == null || FrsNewAreaFragment.this.k.getThreadList() == null || FrsNewAreaFragment.this.k.getThreadList().size() != 0 || FrsNewAreaFragment.this.m1().getType() != 4) {
                    if (FrsNewAreaFragment.this.k != null && (y = FrsNewAreaFragment.this.q.y(false, false, true, FrsNewAreaFragment.this.k.getThreadList(), null)) != null && y.size() > 0) {
                        FrsNewAreaFragment.this.k.setThreadList(y);
                    }
                    FrsNewAreaFragment.this.w1();
                } else {
                    FrsNewAreaFragment frsNewAreaFragment7 = FrsNewAreaFragment.this;
                    frsNewAreaFragment7.showToast(frsNewAreaFragment7.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.f15753i > 1) {
                        FrsNewAreaFragment.I0(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.m > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        FrsNewAreaFragment frsNewAreaFragment8 = FrsNewAreaFragment.this;
                        long x = frsNewAreaFragment8.m1().x();
                        FrsNewAreaFragment frsNewAreaFragment9 = FrsNewAreaFragment.this;
                        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis2 - frsNewAreaFragment8.m, x - frsNewAreaFragment9.m, frsNewAreaFragment9.m1().z(), FrsNewAreaFragment.this.m1().y(), currentTimeMillis2 - FrsNewAreaFragment.this.m1().w());
                        FrsNewAreaFragment.this.m = -1L;
                    }
                    FrsNewAreaFragment.this.n = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.m > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                FrsNewAreaFragment frsNewAreaFragment10 = FrsNewAreaFragment.this;
                long x2 = frsNewAreaFragment10.m1().x();
                FrsNewAreaFragment frsNewAreaFragment11 = FrsNewAreaFragment.this;
                TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis3 - frsNewAreaFragment10.m, x2 - frsNewAreaFragment11.m, frsNewAreaFragment11.m1().z(), FrsNewAreaFragment.this.m1().y(), currentTimeMillis3 - FrsNewAreaFragment.this.m1().w());
                FrsNewAreaFragment.this.m = -1L;
            }
            FrsNewAreaFragment.this.n = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public i(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.k0.q0.e2.g gVar;
            if (customResponsedMessage == null || (gVar = FrsNewAreaFragment.this.r) == null) {
                return;
            }
            gVar.L();
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.k0.d3.n0.a.o(FrsNewAreaFragment.this.f15750f);
        }
    }

    /* loaded from: classes4.dex */
    public class k extends RecyclerView.OnScrollListener {
        public k() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                t.b().e(true);
                d.a.k0.c3.c.g().h(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            FrsNewAreaFragment.this.z += i3;
            if (FrsNewAreaFragment.this.z < FrsNewAreaFragment.this.y * 2 || i3 >= 0) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
        }
    }

    public static /* synthetic */ int I0(FrsNewAreaFragment frsNewAreaFragment) {
        int i2 = frsNewAreaFragment.f15753i;
        frsNewAreaFragment.f15753i = i2 - 1;
        return i2;
    }

    public void A1(int i2) {
        this.f15753i = i2;
    }

    @Override // d.a.k0.q0.q0
    public void B0() {
        d.a.k0.q0.e2.g gVar = this.r;
        if (gVar == null || gVar.k() == null) {
            return;
        }
        this.r.k().scrollToPosition(0);
    }

    public final void B1() {
        if (this.s == 0 && !this.q.w(this.k.getThreadListIds())) {
            if (this.k.getThreadList() != null && this.k.getThreadList().size() != 0) {
                this.r.K();
                return;
            } else {
                this.r.m();
                return;
            }
        }
        this.r.J();
    }

    public final void C1() {
        this.r.B(false);
        showLoadingView(this.r.l(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    public final void D1(d.a.k0.d3.f fVar) {
        this.r.B(false);
        this.r.G(false);
        this.r.m();
        this.r.k().getData().clear();
        this.r.p();
        if (this.w == null) {
            d.a.j0.d0.c cVar = new d.a.j0.d0.c(getPageContext().getContext(), getNetRefreshListener());
            this.w = cVar;
            cVar.e(null);
            this.w.c(null);
            this.w.f();
            this.w.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.w.d(getPageContext().getResources().getString(R.string.net_error_text, fVar.f53748d, Integer.valueOf(fVar.f53747c)));
        } else {
            this.w.d(null);
        }
        this.w.onChangeSkinType();
        this.w.attachView(this.r.l(), true);
        this.w.a(0);
    }

    public void E1() {
        VoiceManager voiceManager = getVoiceManager();
        this.l = voiceManager;
        voiceManager.stopPlay();
    }

    @Override // d.a.k0.s2.u
    public String F() {
        return this.j;
    }

    public final void F1(a2 a2Var, int i2) {
        if (i2 == 1) {
            PraiseData P0 = a2Var.P0();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (P0 == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i2);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    a2Var.a4(praiseData);
                    return;
                }
                a2Var.P0().getUser().add(0, metaData);
                a2Var.P0().setNum(a2Var.P0().getNum() + 1);
                a2Var.P0().setIsLike(i2);
            }
        } else if (a2Var.P0() != null) {
            a2Var.P0().setIsLike(i2);
            a2Var.P0().setNum(a2Var.P0().getNum() - 1);
            ArrayList<MetaData> user = a2Var.P0().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        a2Var.P0().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    public final void G1(int i2) {
        ArrayList<n> threadList = this.k.getThreadList();
        if (threadList != null) {
            Iterator<n> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if (next instanceof z1) {
                    a2 a2Var = ((z1) next).w;
                    if (a2Var.o0() != null && a2Var.o0().equals(this.f15749e)) {
                        F1(a2Var, i2);
                        this.f15749e = null;
                        break;
                    }
                }
            }
            this.r.j().q(threadList, this.k);
            this.r.j().l();
        }
    }

    @Override // d.a.k0.s2.u
    public void O() {
        FrsNewAreaModelController frsNewAreaModelController = this.p;
        if (frsNewAreaModelController != null) {
            frsNewAreaModelController.K();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void a(ArrayList<n> arrayList) {
        B1();
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList<n> y = this.q.y(false, false, false, arrayList, null);
        if (y != null) {
            this.k.setThreadList(y);
            this.r.H(y, this.f15753i, this.k, 0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.k.getForum()));
    }

    @Override // d.a.k0.e.e.b
    public void dispatchInjectPluginMessage(d.a.k0.e.d dVar) {
    }

    @Override // d.a.k0.q0.r0
    public NavigationBar e0() {
        return null;
    }

    public void e1(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        this.p.s(a2Var);
    }

    public final void f1(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<n> threadList = this.k.getThreadList();
        if (ListUtils.isEmpty(threadList) || this.r.k() == null || this.r.k().getData() == null) {
            return;
        }
        Iterator<n> it = threadList.iterator();
        List<n> data = this.r.k().getData();
        int i2 = 0;
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof z1) {
                a2 a2Var = ((z1) next).w;
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        break;
                    } else if (StringHelper.equals(list.get(i3), a2Var.o0())) {
                        it.remove();
                        data.remove(next);
                        this.q.G(next);
                        this.r.k().getAdapter().notifyItemRemoved(i2);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
    }

    @Override // d.a.k0.q0.d2.a, d.a.k0.q0.u0
    public String g() {
        return this.f15750f;
    }

    @Override // d.a.k0.q0.d2.a
    public FrsViewData g0() {
        return this.k;
    }

    public final void g1(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if (this.k == null || this.r == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
            return;
        }
        boolean z = false;
        Iterator<DownloadData> it = data.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().getStatus() == 0) {
                z = true;
                break;
            }
        }
        if (z) {
            this.r.p();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public d.a.c.e.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).getFrsCommonImageLayoutPool();
        }
        return null;
    }

    @Override // d.a.k0.e.e.b
    public d.a.k0.e.e.a getInjectPlugin(int i2) {
        return this.x.get(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.k0.q0.d2.a
    public /* bridge */ /* synthetic */ d.a.c.a.f getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        FrsViewData frsViewData = this.k;
        tbPageTag.sortType = d.a.k0.q0.n2.k.g(frsViewData != null ? frsViewData.getSortType() : -1);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public d.a.c.e.k.b<TbImageView> getUserIconPool() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).getUserIconPool();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        if (this.l == null) {
            this.l = VoiceManager.instance();
        }
        return this.l;
    }

    public final void h1() {
        StatisticItem statisticItem = new StatisticItem("c13008");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("fid", this.j);
        statisticItem.param("obj_type", 6);
        statisticItem.param("obj_locate", 2);
        statisticItem.eventStat();
    }

    public d.a.k0.q0.e2.g i1() {
        return this.r;
    }

    public BdTypeRecyclerView j1() {
        d.a.k0.q0.e2.g gVar = this.r;
        if (gVar == null) {
            return null;
        }
        return gVar.k();
    }

    @Override // d.a.k0.q0.s0
    public void k() {
        d.a.k0.c3.c.g().h(getUniqueId(), false);
    }

    public final int k1(int i2, int i3) {
        if (i2 != 1) {
            return (i2 != 2 || i3 == 1) ? 0 : 3;
        }
        return 3;
    }

    public FrsLoadMoreModel l1() {
        return this.q;
    }

    public void loadMore() {
        if (this.q.isLoading || this.p.C()) {
            return;
        }
        if (this.q.w(this.k.getThreadListIds())) {
            String e2 = this.p.v() != null ? d.a.k0.s2.a.e(this.p.v().getThreadList(), false) : "";
            this.r.H(this.q.H(), this.f15753i, this.k, 0);
            this.q.I(d.a.c.e.m.b.f(this.j, 0L), this.k.getThreadListIds(), this.f15750f, this.f15753i, this.k.isBrandForum, e2);
        } else if (this.s != 0) {
            this.r.H(this.q.H(), this.f15753i, this.k, 0);
            int i2 = this.f15753i + 1;
            this.f15753i = i2;
            this.p.E(i2);
            FrsLoadMoreModel frsLoadMoreModel = this.q;
            frsLoadMoreModel.loadingDone = false;
            frsLoadMoreModel.loadIndex = 0;
        }
    }

    @Override // d.a.k0.q0.s0
    public void m() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (d.a.c.e.p.j.z()) {
            d.a.k0.m.d.c().f("page_frs_good");
            r1(true);
            return;
        }
        this.r.A(false);
    }

    public FrsNewAreaModelController m1() {
        return this.p;
    }

    public final void n() {
        this.r.B(true);
        hideLoadingView(this.r.l());
    }

    public final void n1() {
        d.a.k0.q0.e2.g gVar = this.r;
        if (gVar != null) {
            gVar.B(true);
            this.r.G(true);
        }
        d.a.j0.d0.c cVar = this.w;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.w.dettachView(this.r.l());
    }

    @Override // d.a.k0.s2.u
    public TbPageContext<?> o() {
        return getPageContext();
    }

    public final void o1() {
        registerListener(2001118, this.I);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        a2 threadDataById;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 18003) {
            this.r.j().l();
            String stringExtra = intent.getStringExtra("tid");
            if (stringExtra == null || (threadDataById = this.k.getThreadDataById(stringExtra)) == null) {
                return;
            }
            int intExtra = intent.getIntExtra("type", -1);
            if (intExtra == 2) {
                threadDataById.N3(intent.getIntExtra("good_data", 0));
                threadDataById.X2();
                r1(false);
            } else if (intExtra == 0) {
                this.k.removeThreadData(threadDataById);
                ArrayList<n> threadList = this.k.getThreadList();
                if (threadList != null && threadList.size() <= 0) {
                    threadList.add(new d.a.k0.q0.t());
                }
                this.r.z();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        if (this.t == 3 && this.r == null) {
            return;
        }
        this.t = i2;
        super.onChangeSkinType(i2);
        d.a.k0.q0.e2.g gVar = this.r;
        if (gVar != null) {
            gVar.q(i2);
        }
        d.a.j0.d0.c cVar = this.w;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.w.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.m = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.m = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.j = arguments.getString("forum_id", "");
            this.A = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
        }
        this.o = System.currentTimeMillis();
        super.onCreate(bundle);
        d.a.k0.c3.c.g().i(getUniqueId());
        FrsNewAreaModelController frsNewAreaModelController = new FrsNewAreaModelController(this);
        this.p = frsNewAreaModelController;
        if (arguments != null) {
            frsNewAreaModelController.B(arguments);
        } else if (bundle != null) {
            frsNewAreaModelController.B(bundle);
        } else {
            frsNewAreaModelController.B(null);
        }
        VoiceManager voiceManager = getVoiceManager();
        this.l = voiceManager;
        voiceManager.onCreate(getPageContext());
        p1(bundle);
        registerListener(this.G);
        registerListener(this.D);
        registerListener(this.E);
        registerListener(this.B);
        FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
        this.q = frsLoadMoreModel;
        frsLoadMoreModel.registerListener();
        this.q.O(3);
        this.q.L(true);
        this.q.K(d.a.k0.s0.a.a(this.A));
        System.currentTimeMillis();
        this.y = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.r = new d.a.k0.q0.e2.g(this, inflate);
        q1();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        d.a.k0.q0.e2.g gVar = this.r;
        if (gVar != null) {
            gVar.r();
        }
        MessageManager.getInstance().unRegisterListener(this.B);
        d.a.k0.c3.c.g().k(getUniqueId());
        t.b().e(false);
        super.onDestroy();
        this.p.F();
        VoiceManager voiceManager = getVoiceManager();
        this.l = voiceManager;
        voiceManager.onDestory(getPageContext());
        d.a.c.e.m.e.a().removeCallbacks(this.C);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        B1();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public q onGetPreLoadListView() {
        if (j1() == null) {
            return null;
        }
        return j1().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (this.u) {
            return;
        }
        if (d.a.c.e.p.j.z()) {
            r1(false);
        } else {
            D1(null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        h1();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (d.a.c.e.p.j.z()) {
            r1(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        VoiceManager voiceManager = getVoiceManager();
        this.l = voiceManager;
        voiceManager.onPause(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.t == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (this.u) {
                return;
            }
            d.a.c.e.m.e.a().post(this.C);
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 1) {
            if (PermissionUtil.checkCamera(getActivity().getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (!transformPermissionResult.containsKey(StorageUtils.EXTERNAL_STORAGE_PERMISSION) || transformPermissionResult.get(StorageUtils.EXTERNAL_STORAGE_PERMISSION).booleanValue()) {
                return;
            }
            showToast(R.string.sdcard_permission_denied_advert_for_camera);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        d.a.k0.q0.e2.g gVar = this.r;
        if (gVar != null) {
            gVar.p();
        }
        VoiceManager voiceManager = getVoiceManager();
        this.l = voiceManager;
        voiceManager.onResume(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.f15750f);
        bundle.putString("from", this.f15751g);
        this.p.onSaveInstanceState(bundle);
        VoiceManager voiceManager = getVoiceManager();
        this.l = voiceManager;
        if (voiceManager != null) {
            voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        if (!l.D()) {
            this.r.m();
        } else if (this.r.x()) {
        } else {
            if (!this.p.A()) {
                this.r.m();
                return;
            }
            B1();
            loadMore();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = getVoiceManager();
        this.l = voiceManager;
        voiceManager.onStart(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        t.b().e(false);
        d.a.k0.c3.c.g().h(getUniqueId(), false);
        FrsViewData frsViewData = this.k;
        if (frsViewData != null && frsViewData.getForum() != null) {
            d.a.j0.u.a.k().y(getPageContext().getPageActivity(), "frs", this.k.getForum().getId(), 0L);
        }
        VoiceManager voiceManager = getVoiceManager();
        this.l = voiceManager;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
    }

    public final void p1(Bundle bundle) {
        o1();
        if (bundle != null) {
            this.f15750f = bundle.getString("name");
            this.f15751g = bundle.getString("from");
            this.f15752h = bundle.getInt("flag", 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f15750f = arguments.getString("name");
                this.f15751g = arguments.getString("from");
                this.f15752h = arguments.getInt("flag", 0);
            }
        }
        if (TextUtils.isEmpty(this.f15751g) || !FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.f15751g)) {
            return;
        }
        getBaseFragmentActivity().setSwipeBackEnabled(false);
    }

    public final void q1() {
        if (this.f15752h != 0) {
            this.f15752h = 1;
        }
        this.r.E(this.J);
        this.r.F(this.H);
    }

    public final void r1(boolean z) {
        this.u = true;
        E1();
        n1();
        if (!z) {
            n1();
            C1();
        }
        FrsNewAreaModelController frsNewAreaModelController = this.p;
        if (frsNewAreaModelController != null) {
            frsNewAreaModelController.D();
        }
    }

    public void s1(FrsViewData frsViewData) {
        if (frsViewData == null) {
            return;
        }
        this.k = frsViewData;
        hideLoadingView(this.r.l());
        d.a.k0.q0.e2.g gVar = this.r;
        if (gVar != null) {
            gVar.A(false);
            this.r.H(null, this.f15753i, this.k, this.s);
        }
    }

    public void setFrom(String str) {
        this.f15751g = str;
    }

    @Override // d.a.k0.e.e.b
    public void setInjectPlugin(int i2, d.a.k0.e.e.a aVar) {
        this.x.put(i2, aVar);
    }

    @Override // d.a.k0.q0.q0
    public void t() {
        if (this.r != null) {
            B0();
            this.r.L();
        }
    }

    @Override // d.a.k0.s2.u
    public int t0() {
        return this.f15753i;
    }

    public void t1(List<String> list) {
        f1(list);
        int i2 = 0;
        for (n nVar : this.k.getThreadList()) {
            if (nVar instanceof z1) {
                i2++;
                continue;
            }
            if (i2 >= 6) {
                break;
            }
        }
        if (i2 < 6) {
            loadMore();
        }
    }

    public final void u1() {
        if (this.f15752h == 1) {
            d.a.c.e.m.h.a().b(new j());
        }
        this.f15752h = 0;
    }

    public final void v1() {
        HashMap<Integer, a2> h2;
        d.a.k0.q0.e2.g gVar = this.r;
        if (gVar == null || gVar.j() == null || (h2 = this.r.j().h()) == null) {
            return;
        }
        ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, a2> entry : h2.entrySet()) {
            a2 value = entry.getValue();
            if (value != null && (value instanceof AdvertAppInfo)) {
                arrayList.add((AdvertAppInfo) value);
            }
        }
        d.a.j0.v.b.l().m(arrayList);
    }

    public final void w1() {
        E1();
        try {
            if (this.k == null) {
                return;
            }
            this.r.y();
            this.r.I();
            this.f15750f = this.k.getForum().getName();
            this.j = this.k.getForum().getId();
            TbadkCoreApplication.getInst().setDefaultBubble(this.k.getUserData().getBimg_url());
            TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.k.getUserData().getBimg_end_time());
            u1();
            ArrayList<n> threadList = this.k.getThreadList();
            if (threadList != null) {
                this.r.H(threadList, this.f15753i, this.k, this.k.getPage().b());
                v1();
                this.r.z();
                if (this.k.getIsNewUrl() == 1) {
                    this.r.j().r(true);
                } else {
                    this.r.j().r(false);
                }
                this.r.C(k1(m1().getType(), this.f15753i));
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void x1() {
        d.a.k0.q0.e2.g gVar = this.r;
        if (gVar == null || gVar.k() == null) {
            return;
        }
        this.r.k().post(new a());
    }

    public void y1(int i2) {
        this.f15752h = i2;
    }

    public void z1(String str) {
        this.f15750f = str;
    }
}
