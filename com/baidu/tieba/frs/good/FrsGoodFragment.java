package com.baidu.tieba.frs.good;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
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
import com.baidu.permissionhelper.app.ActivityCompat;
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
import d.b.c.j.e.n;
import d.b.c.j.e.q;
import d.b.c.j.e.w;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.w0;
import d.b.h0.r.q.z1;
import d.b.i0.d3.m;
import d.b.i0.d3.s;
import d.b.i0.q0.q0;
import d.b.i0.q0.r0;
import d.b.i0.q0.s0;
import d.b.i0.s2.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class FrsGoodFragment extends BaseFragment implements VoiceManager.j, d.b.i0.q0.d2.a, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, q0, ActivityCompat.OnRequestPermissionsResultCallback, t, r0, d.b.i0.e.e.b, s0 {
    public d.b.h0.d0.c A;
    public String B;
    public boolean E;

    /* renamed from: e  reason: collision with root package name */
    public String f16161e;
    public VoiceManager m;
    public long o;
    public FrsGoodModelController q;
    public FrsLoadMoreModel r;
    public d.b.i0.q0.x1.b y;

    /* renamed from: f  reason: collision with root package name */
    public String f16162f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f16163g = null;

    /* renamed from: h  reason: collision with root package name */
    public int f16164h = 0;
    public int i = 1;
    public boolean j = false;
    public String k = null;
    public FrsViewData l = new FrsViewData();
    public long n = -1;
    public long p = -1;
    public d.b.i0.q0.a2.a s = null;
    public int t = -1;
    public int u = 0;
    public int v = 3;
    public boolean w = false;
    public SparseArray<d.b.i0.e.e.a> x = new SparseArray<>();
    public boolean z = false;
    public int C = 0;
    public int D = 0;
    public CustomMessageListener F = new e(2921397, true);
    public Runnable G = new f();
    public CustomMessageListener H = new g(2004004);
    public CustomMessageListener I = new h(2001624);
    public final s J = new i();
    public final CustomMessageListener K = new j(2003003);
    public final RecyclerView.OnScrollListener L = new a();
    public final CustomMessageListener M = new b(0);
    public w N = new c();
    public CustomMessageListener O = new d(2921414);

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                d.b.i0.x.t.b().e(true);
                d.b.i0.c3.c.g().h(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.D += i2;
            if (FrsGoodFragment.this.D < FrsGoodFragment.this.C * 2 || i2 >= 0) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                FrsGoodFragment.this.f1(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements w {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f16168e;

            public a(c cVar, String str) {
                this.f16168e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetWork netWork = new NetWork(this.f16168e);
                netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                netWork.getNetData();
            }
        }

        public c() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            if (bdUniqueId == null || nVar == null || !(nVar instanceof z1)) {
                return;
            }
            a2 a2Var = ((z1) nVar).w;
            if (a2Var.O() == null || a2Var.O().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                if (a2Var.G() != 1 || ViewHelper.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    d.b.i0.d3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(a2Var.o0())) {
                        readThreadHistory.a(a2Var.o0());
                        d.b.i0.q0.a2.a aVar = FrsGoodFragment.this.s;
                        if (aVar != null) {
                            aVar.v();
                        }
                    }
                    String J = a2Var.J();
                    if (J == null || J.equals("")) {
                        z = false;
                    } else {
                        new Thread(new a(this, J)).start();
                        z = true;
                    }
                    String w1 = a2Var != null ? a2Var.w1() : null;
                    if (w1 == null) {
                        w1 = "";
                    }
                    if (a2Var.x0() == 2 && !w1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        UrlManager.getInstance().dealOneLink(FrsGoodFragment.this.getPageContext(), new String[]{w1, "", null});
                        return;
                    }
                    if (w1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && w1.length() > 3 && w1.length() > 3) {
                        a2Var.E3(w1.substring(3));
                    }
                    PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(a2Var, FrsGoodFragment.this.f16162f, "frs_page", 18003, true, false, z);
                    createFromThreadCfg.setForumId(String.valueOf(a2Var.c0()));
                    createFromThreadCfg.setStartFrom(3);
                    FrsGoodFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    if (FrsGoodFragment.this.l == null || FrsGoodFragment.this.l.getForum() == null) {
                        return;
                    }
                    d.b.i0.q0.j2.b bVar = new d.b.i0.q0.j2.b();
                    bVar.f59399a = FrsGoodFragment.this.l.needLog == 1;
                    bVar.f59401c = FrsGoodFragment.this.l.getForum().getId();
                    d.b.i0.q0.j2.b bVar2 = d.b.i0.q0.j2.d.J0;
                    if (bVar2 != null) {
                        bVar.f59402d = bVar2.f59402d;
                        bVar.f59403e = bVar2.f59403e;
                    }
                    d.b.i0.q0.j2.a.b(a2Var, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                }
            }
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
            d.b.i0.q0.a2.a aVar = FrsGoodFragment.this.s;
            if (aVar != null) {
                aVar.y();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i, boolean z) {
            super(i, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || FrsGoodFragment.this.A == null || !FrsGoodFragment.this.A.isViewAttached()) {
                return;
            }
            FrsGoodFragment.this.A.a(num.intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!d.b.c.e.p.j.z() || FrsGoodFragment.this.w) {
                FrsGoodFragment.this.z1(null);
            } else {
                FrsGoodFragment.this.p1(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public g(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof a2)) {
                return;
            }
            a2 a2Var = (a2) customResponsedMessage.getData();
            FrsGoodFragment.this.f16161e = a2Var.o0();
            if (TextUtils.isEmpty(FrsGoodFragment.this.f16161e) || a2Var.P0() == null) {
                return;
            }
            FrsGoodFragment.this.C1(a2Var.P0().getIsLike());
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public h(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                if (FrsGoodFragment.this.g1() != null) {
                    FrsGoodFragment.this.g1().setSelection(0);
                }
                if (FrsGoodFragment.this.A != null && FrsGoodFragment.this.A.isViewAttached()) {
                    FrsGoodFragment.this.p1(false);
                    return;
                }
                d.b.i0.q0.a2.a aVar = FrsGoodFragment.this.s;
                if (aVar != null) {
                    aVar.Z();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements s {

        /* renamed from: a  reason: collision with root package name */
        public long f16174a = 1;

        public i() {
        }

        @Override // d.b.i0.d3.s
        public void a(int i, boolean z, d.b.i0.d3.f fVar) {
            ArrayList<n> y;
            if (FrsGoodFragment.this.z) {
                if (FrsGoodFragment.this.j1().t() == null) {
                    FrsGoodFragment.this.z = false;
                    return;
                } else if (FrsGoodFragment.this.j1().t().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.z = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.f16174a = 1L;
            } else if (fVar.f54781b) {
                this.f16174a = 0L;
            } else {
                this.f16174a = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.r.J();
            }
            FrsGoodFragment.this.s.I(false);
            if (FrsGoodFragment.this.j1().t() != null) {
                FrsGoodFragment frsGoodFragment = FrsGoodFragment.this;
                frsGoodFragment.l = frsGoodFragment.j1().t();
            }
            FrsGoodFragment frsGoodFragment2 = FrsGoodFragment.this;
            frsGoodFragment2.t = frsGoodFragment2.l.getPage().b();
            if (FrsGoodFragment.this.t != 0 || (FrsGoodFragment.this.l.getThreadListIds() != null && FrsGoodFragment.this.l.getThreadListIds().size() != 0)) {
                if (ListUtils.getCount(FrsGoodFragment.this.l.getThreadList()) > 3) {
                    FrsGoodFragment.this.s.X();
                } else {
                    FrsGoodFragment.this.s.U();
                }
            } else if (FrsGoodFragment.this.l.getThreadList() != null && FrsGoodFragment.this.l.getThreadList().size() != 0) {
                FrsGoodFragment.this.s.Y();
            } else {
                FrsGoodFragment.this.s.p();
            }
            if (i == 4) {
                ArrayList<n> y2 = FrsGoodFragment.this.r.y(false, false, false, FrsGoodFragment.this.l.getThreadList(), null);
                if (y2 != null) {
                    FrsGoodFragment.this.l.setThreadList(y2);
                    FrsGoodFragment frsGoodFragment3 = FrsGoodFragment.this;
                    frsGoodFragment3.s.T(y2, frsGoodFragment3.i, FrsGoodFragment.this.l, FrsGoodFragment.this.t);
                    return;
                }
                return;
            }
            if (i == 1) {
                FrsGoodFragment.this.s.v();
            } else if (i != 2) {
                if (i == 3 && FrsGoodFragment.this.l.isShowRedTip()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.TRUE));
                }
            } else {
                FrsGoodFragment.this.s.v();
            }
            FrsGoodFragment.this.n();
            if (this.f16174a != 0) {
                FrsGoodFragment.this.z1(fVar);
            } else {
                if (FrsGoodFragment.this.l != null) {
                    FrsGoodFragment frsGoodFragment4 = FrsGoodFragment.this;
                    frsGoodFragment4.f16162f = frsGoodFragment4.l.getForum().getName();
                    FrsGoodFragment frsGoodFragment5 = FrsGoodFragment.this;
                    frsGoodFragment5.k = frsGoodFragment5.l.getForum().getId();
                    FrsGoodFragment frsGoodFragment6 = FrsGoodFragment.this;
                    frsGoodFragment6.s.z(frsGoodFragment6.l.getForum(), FrsGoodFragment.this.l.getUserData());
                }
                if (FrsGoodFragment.this.l != null) {
                    FrsGoodFragment.this.l.addNoticeThreadToThreadList();
                }
                FrsGoodFragment frsGoodFragment7 = FrsGoodFragment.this;
                frsGoodFragment7.s.O(frsGoodFragment7.l);
                if (FrsGoodFragment.this.l == null || FrsGoodFragment.this.l.getThreadList() == null || FrsGoodFragment.this.l.getThreadList().size() != 0 || FrsGoodFragment.this.j1().getType() != 4) {
                    if (FrsGoodFragment.this.l != null && (y = FrsGoodFragment.this.r.y(false, false, true, FrsGoodFragment.this.l.getThreadList(), null)) != null && y.size() > 0) {
                        FrsGoodFragment.this.l.setThreadList(y);
                    }
                    FrsGoodFragment.this.s1();
                } else {
                    FrsGoodFragment frsGoodFragment8 = FrsGoodFragment.this;
                    frsGoodFragment8.showToast(frsGoodFragment8.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.i > 1) {
                        FrsGoodFragment.L0(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.n > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        FrsGoodFragment frsGoodFragment9 = FrsGoodFragment.this;
                        long v = frsGoodFragment9.j1().v();
                        FrsGoodFragment frsGoodFragment10 = FrsGoodFragment.this;
                        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis2 - frsGoodFragment9.n, v - frsGoodFragment10.n, frsGoodFragment10.j1().x(), FrsGoodFragment.this.j1().w(), currentTimeMillis2 - FrsGoodFragment.this.j1().u());
                        FrsGoodFragment.this.n = -1L;
                    }
                    FrsGoodFragment.this.o = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.n > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                FrsGoodFragment frsGoodFragment11 = FrsGoodFragment.this;
                long v2 = frsGoodFragment11.j1().v();
                FrsGoodFragment frsGoodFragment12 = FrsGoodFragment.this;
                TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis3 - frsGoodFragment11.n, v2 - frsGoodFragment12.n, frsGoodFragment12.j1().x(), FrsGoodFragment.this.j1().w(), currentTimeMillis3 - FrsGoodFragment.this.j1().u());
                FrsGoodFragment.this.n = -1L;
            }
            FrsGoodFragment.this.o = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // d.b.i0.d3.s
        public void b(int i) {
            if (FrsGoodFragment.this.z) {
                return;
            }
            if (i == 1 || i == 2) {
                FrsGoodFragment.this.s.v();
            } else if (i != 3) {
            } else {
                FrsGoodFragment.this.s.I(true);
            }
        }

        @Override // d.b.i0.d3.s
        public void c() {
        }

        @Override // d.b.i0.d3.s
        public void d(m mVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public j(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.i0.q0.a2.a aVar;
            if (customResponsedMessage == null || (aVar = FrsGoodFragment.this.s) == null) {
                return;
            }
            aVar.Z();
        }
    }

    /* loaded from: classes4.dex */
    public class k implements View.OnTouchListener {
        public k() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsGoodFragment.this.y != null) {
                FrsGoodFragment.this.y.b(view, motionEvent);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.i0.d3.n0.a.o(FrsGoodFragment.this.f16162f);
        }
    }

    public static /* synthetic */ int L0(FrsGoodFragment frsGoodFragment) {
        int i2 = frsGoodFragment.i;
        frsGoodFragment.i = i2 - 1;
        return i2;
    }

    public void A1() {
        VoiceManager voiceManager = getVoiceManager();
        this.m = voiceManager;
        voiceManager.stopPlay();
    }

    @Override // d.b.i0.q0.q0
    public void B0() {
        d.b.i0.q0.a2.a aVar = this.s;
        if (aVar == null || aVar.n() == null) {
            return;
        }
        this.s.n().scrollToPosition(0);
    }

    public final void B1(a2 a2Var, int i2) {
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
                    a2Var.Y3(praiseData);
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

    public final void C1(int i2) {
        ArrayList<n> threadList = this.l.getThreadList();
        if (threadList != null) {
            Iterator<n> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if (next instanceof z1) {
                    a2 a2Var = ((z1) next).w;
                    if (a2Var.o0() != null && a2Var.o0().equals(this.f16161e)) {
                        B1(a2Var, i2);
                        this.f16161e = null;
                        break;
                    }
                }
            }
            this.s.m().w(threadList, this.l);
            this.s.m().p();
        }
    }

    @Override // d.b.i0.q0.q0
    public void E() {
        if (this.s != null) {
            B0();
            this.s.Z();
        }
    }

    @Override // d.b.i0.q0.r0
    public NavigationBar Q() {
        return null;
    }

    @Override // d.b.i0.q0.d2.a
    public FrsViewData S() {
        return this.l;
    }

    @Override // d.b.i0.s2.t
    public String V() {
        return this.k;
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void d(ArrayList<n> arrayList) {
        x1();
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList<n> y = this.r.y(false, false, false, arrayList, null);
        if (y != null) {
            this.l.setThreadList(y);
            this.s.T(y, this.i, this.l, 0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.l.getForum()));
    }

    @Override // d.b.i0.e.e.b
    public void dispatchInjectPluginMessage(d.b.i0.e.d dVar) {
    }

    public void e1(w0 w0Var) {
        if (w0Var == null || S() == null || S().getThreadList() == null) {
            return;
        }
        if (ListUtils.isEmpty(S().getThreadList())) {
            S().getThreadList().add(w0Var);
        } else {
            if (S().getThreadList().size() == 1 && (S().getThreadList().get(0) instanceof d.b.i0.q0.t)) {
                S().getThreadList().remove(0);
            }
            S().getThreadList().add(0, w0Var);
        }
        d.b.i0.q0.a2.a aVar = this.s;
        ArrayList<n> threadList = this.l.getThreadList();
        int i2 = this.i;
        FrsViewData frsViewData = this.l;
        aVar.T(threadList, i2, frsViewData, frsViewData.getPage().b());
        this.s.H();
        this.s.K(0);
    }

    public final void f1(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if (this.l == null || this.s == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
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
            this.s.v();
        }
    }

    public BdTypeRecyclerView g1() {
        d.b.i0.q0.a2.a aVar = this.s;
        if (aVar == null) {
            return null;
        }
        return aVar.n();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public d.b.c.e.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).getFrsCommonImageLayoutPool();
        }
        return null;
    }

    @Override // d.b.i0.e.e.b
    public d.b.i0.e.e.a getInjectPlugin(int i2) {
        return this.x.get(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.i0.q0.d2.a
    public /* bridge */ /* synthetic */ d.b.c.a.f getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        FrsViewData frsViewData = this.l;
        tbPageTag.sortType = d.b.i0.q0.n2.k.g(frsViewData != null ? frsViewData.getSortType() : -1);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public d.b.c.e.k.b<TbImageView> getUserIconPool() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).getUserIconPool();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        if (this.m == null) {
            this.m = VoiceManager.instance();
        }
        return this.m;
    }

    public final int h1(int i2, int i3) {
        if (i2 != 1) {
            return (i2 != 2 || i3 == 1) ? 0 : 3;
        }
        return 3;
    }

    @Override // d.b.i0.q0.d2.a, d.b.i0.q0.u0
    public String i() {
        return this.f16162f;
    }

    public FrsLoadMoreModel i1() {
        return this.r;
    }

    @Override // d.b.i0.s2.t
    public void j0(AdvertAppInfo advertAppInfo, String str) {
        d.b.h0.u.a.l().u(advertAppInfo, this.k, 0L, "FRS", str, this.i);
    }

    public FrsGoodModelController j1() {
        return this.q;
    }

    public final void k1() {
        d.b.i0.q0.a2.a aVar = this.s;
        if (aVar == null) {
            return;
        }
        aVar.J(true);
        this.s.N(true);
        d.b.h0.d0.c cVar = this.A;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.A.dettachView(this.s.o());
    }

    public final void l1() {
        registerListener(2001118, this.M);
    }

    @Override // d.b.i0.q0.s0
    public void m() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (d.b.c.e.p.j.z()) {
            d.b.i0.m.d.c().f("page_frs_good");
            p1(true);
            return;
        }
        this.s.I(false);
    }

    public final void m1(Bundle bundle) {
        l1();
        if (bundle != null) {
            this.f16162f = bundle.getString("name");
            this.f16163g = bundle.getString("from");
            this.f16164h = bundle.getInt("flag", 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f16162f = arguments.getString("name");
                this.f16163g = arguments.getString("from");
                this.f16164h = arguments.getInt("flag", 0);
            }
        }
        if (TextUtils.isEmpty(this.f16163g) || !FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.f16163g)) {
            return;
        }
        getBaseFragmentActivity().setSwipeBackEnabled(false);
    }

    public final void n() {
        d.b.i0.q0.a2.a aVar = this.s;
        if (aVar == null) {
            return;
        }
        aVar.J(true);
        hideLoadingView(this.s.o());
    }

    @Override // d.b.i0.s2.t
    public int n0() {
        return this.i;
    }

    public final void n1() {
        if (this.f16164h != 0) {
            this.f16164h = 1;
        }
        this.y = new d.b.i0.q0.x1.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.s.L(this.N);
        this.s.M(this.L);
        this.s.n().setOnTouchListener(new k());
    }

    @Override // d.b.i0.q0.s0
    public void o() {
        d.b.i0.c3.c.g().h(getUniqueId(), false);
    }

    public void o1(int i2) {
        this.u = i2;
        if (d.b.c.e.p.j.z()) {
            p1(false);
        } else {
            z1(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        a2 threadDataById;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 18003) {
            this.s.m().p();
            String stringExtra = intent.getStringExtra("tid");
            if (stringExtra == null || (threadDataById = this.l.getThreadDataById(stringExtra)) == null) {
                return;
            }
            int intExtra = intent.getIntExtra("type", -1);
            if (intExtra == 2) {
                threadDataById.L3(intent.getIntExtra("good_data", 0));
                threadDataById.V2();
                p1(false);
            } else if (intExtra == 0) {
                this.l.removeThreadData(threadDataById);
                ArrayList<n> threadList = this.l.getThreadList();
                if (threadList != null && threadList.size() <= 0) {
                    threadList.add(new d.b.i0.q0.t());
                }
                this.s.H();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        if (this.v == 3 && this.s == null) {
            return;
        }
        this.v = i2;
        super.onChangeSkinType(i2);
        d.b.i0.q0.a2.a aVar = this.s;
        if (aVar != null) {
            aVar.w(i2);
        }
        d.b.h0.d0.c cVar = this.A;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.A.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.n = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.n = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.B = arguments.getString("forum_id", "");
            this.E = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
        }
        this.p = System.currentTimeMillis();
        super.onCreate(bundle);
        d.b.i0.c3.c.g().i(getUniqueId());
        FrsGoodModelController frsGoodModelController = new FrsGoodModelController(this);
        this.q = frsGoodModelController;
        if (arguments != null) {
            frsGoodModelController.z(arguments);
            this.j = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            frsGoodModelController.z(bundle);
            this.j = bundle.getBoolean("is_game_frs", false);
        } else {
            frsGoodModelController.z(null);
        }
        VoiceManager voiceManager = getVoiceManager();
        this.m = voiceManager;
        voiceManager.onCreate(getPageContext());
        m1(bundle);
        registerListener(this.K);
        registerListener(this.H);
        registerListener(this.I);
        registerListener(this.O);
        registerListener(this.F);
        FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
        this.r = frsLoadMoreModel;
        frsLoadMoreModel.registerListener();
        this.r.O(2);
        this.r.L(true);
        this.r.K(d.b.i0.s0.a.a(this.E));
        System.currentTimeMillis();
        this.C = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        d.b.i0.q0.a2.a aVar = new d.b.i0.q0.a2.a(this, inflate, this.j);
        this.s = aVar;
        aVar.m().A();
        n1();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        d.b.i0.q0.a2.a aVar = this.s;
        if (aVar != null) {
            aVar.x();
        }
        MessageManager.getInstance().unRegisterListener(this.F);
        d.b.i0.c3.c.g().k(getUniqueId());
        d.b.i0.x.t.b().e(false);
        super.onDestroy();
        this.q.D();
        VoiceManager voiceManager = getVoiceManager();
        this.m = voiceManager;
        voiceManager.onDestory(getPageContext());
        d.b.c.e.m.e.a().removeCallbacks(this.G);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        x1();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public q onGetPreLoadListView() {
        if (g1() == null) {
            return null;
        }
        return g1().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (this.w) {
            return;
        }
        if (d.b.c.e.p.j.z()) {
            p1(false);
        } else {
            z1(null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new StatisticItem("c13008").param("fid", this.B).param("obj_type", "7").param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (d.b.c.e.p.j.z()) {
            p1(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        VoiceManager voiceManager = getVoiceManager();
        this.m = voiceManager;
        voiceManager.onPause(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.v == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (this.w) {
                return;
            }
            d.b.c.e.m.e.a().post(this.G);
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
        d.b.i0.q0.a2.a aVar = this.s;
        if (aVar != null) {
            aVar.v();
        }
        VoiceManager voiceManager = getVoiceManager();
        this.m = voiceManager;
        voiceManager.onResume(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.f16162f);
        bundle.putString("from", this.f16163g);
        bundle.putBoolean("is_game_frs", this.j);
        this.q.onSaveInstanceState(bundle);
        VoiceManager voiceManager = getVoiceManager();
        this.m = voiceManager;
        if (voiceManager != null) {
            voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        if (!d.b.c.e.p.l.C()) {
            this.s.p();
        } else if (!this.q.y()) {
            this.s.p();
        } else {
            x1();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (this.r.isLoading || this.q.A()) {
                return;
            }
            if (this.r.w(this.l.getThreadListIds())) {
                FrsViewData frsViewData = this.l;
                String e2 = d.b.i0.s2.a.e(frsViewData != null ? frsViewData.getThreadList() : null, false);
                this.s.T(this.r.H(), this.i, this.l, 0);
                this.r.I(d.b.c.e.m.b.f(this.k, 0L), this.l.getThreadListIds(), this.f16162f, this.i, this.l.isBrandForum, e2);
            } else if (this.t != 0) {
                FrsViewData frsViewData2 = this.l;
                String e3 = d.b.i0.s2.a.e(frsViewData2 != null ? frsViewData2.getThreadList() : null, false);
                this.s.T(this.r.H(), this.i, this.l, 0);
                int i2 = this.i + 1;
                this.i = i2;
                this.q.C(i2, e3);
                FrsLoadMoreModel frsLoadMoreModel = this.r;
                frsLoadMoreModel.loadingDone = false;
                frsLoadMoreModel.loadIndex = 0;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = getVoiceManager();
        this.m = voiceManager;
        voiceManager.onStart(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        d.b.i0.x.t.b().e(false);
        d.b.i0.c3.c.g().h(getUniqueId(), false);
        FrsViewData frsViewData = this.l;
        if (frsViewData != null && frsViewData.getForum() != null) {
            d.b.h0.u.a.l().A(getPageContext().getPageActivity(), "frs", this.l.getForum().getId(), 0L);
        }
        VoiceManager voiceManager = getVoiceManager();
        this.m = voiceManager;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
    }

    public final void p1(boolean z) {
        this.w = true;
        A1();
        k1();
        if (!z) {
            k1();
            y1();
        }
        FrsGoodModelController frsGoodModelController = this.q;
        if (frsGoodModelController != null) {
            frsGoodModelController.B(this.u);
        }
    }

    @Override // d.b.i0.s2.t
    public TbPageContext<?> q() {
        return getPageContext();
    }

    public final void q1() {
        if (this.f16164h == 1) {
            d.b.c.e.m.h.a().b(new l());
        }
        this.f16164h = 0;
    }

    public final void r1() {
        HashMap<Integer, a2> j2;
        d.b.i0.q0.a2.a aVar = this.s;
        if (aVar == null || aVar.m() == null || (j2 = this.s.m().j()) == null) {
            return;
        }
        ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, a2> entry : j2.entrySet()) {
            a2 value = entry.getValue();
            if (value != null && (value instanceof AdvertAppInfo)) {
                arrayList.add((AdvertAppInfo) value);
            }
        }
        d.b.h0.v.b.l().m(arrayList);
    }

    public final void s1() {
        A1();
        try {
            if (this.l == null) {
                return;
            }
            this.s.F();
            this.s.W();
            this.f16162f = this.l.getForum().getName();
            this.k = this.l.getForum().getId();
            if (this.l != null && this.l.getForum() != null) {
                this.s.S(this.l.getForum().getThemeColorInfo());
                this.s.O(this.l);
            }
            TbadkCoreApplication.getInst().setDefaultBubble(this.l.getUserData().getBimg_url());
            TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.l.getUserData().getBimg_end_time());
            q1();
            if (!this.s.m().o(a2.f3)) {
                this.l.removeAlaLiveThreadData();
            }
            ArrayList<n> threadList = this.l.getThreadList();
            if (threadList != null) {
                this.s.T(threadList, this.i, this.l, this.l.getPage().b());
                r1();
                this.s.H();
                if (this.l.getIsNewUrl() == 1) {
                    this.s.m().x(true);
                } else {
                    this.s.m().x(false);
                }
                this.s.K(h1(j1().getType(), this.i));
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setFrom(String str) {
        this.f16163g = str;
    }

    @Override // d.b.i0.e.e.b
    public void setInjectPlugin(int i2, d.b.i0.e.e.a aVar) {
        this.x.put(i2, aVar);
    }

    public void t1() {
        d.b.i0.q0.a2.a aVar = this.s;
        if (aVar != null) {
            aVar.A();
        }
    }

    @Override // d.b.i0.s2.t
    public void u0() {
        FrsGoodModelController frsGoodModelController = this.q;
        if (frsGoodModelController != null) {
            frsGoodModelController.H();
        }
    }

    public void u1(int i2) {
        this.f16164h = i2;
    }

    public void v1(String str) {
        this.f16162f = str;
    }

    public void w1(int i2) {
        this.i = i2;
    }

    public final void x1() {
        if (this.t == 0 && !this.r.w(this.l.getThreadListIds())) {
            if (this.l.getThreadList() != null && this.l.getThreadList().size() != 0) {
                this.s.Y();
            } else {
                this.s.p();
            }
        } else if (ListUtils.getCount(this.l.getThreadList()) > 3) {
            this.s.X();
        } else {
            this.s.U();
        }
    }

    public final void y1() {
        d.b.i0.q0.a2.a aVar = this.s;
        if (aVar == null) {
            return;
        }
        aVar.J(false);
        showLoadingView(this.s.o(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    public final void z1(d.b.i0.d3.f fVar) {
        d.b.i0.q0.a2.a aVar = this.s;
        if (aVar == null) {
            return;
        }
        aVar.J(false);
        this.s.N(false);
        this.s.p();
        this.s.n().getData().clear();
        this.s.v();
        if (this.A == null) {
            d.b.h0.d0.c cVar = new d.b.h0.d0.c(getPageContext().getContext(), getNetRefreshListener());
            this.A = cVar;
            cVar.e(null);
            this.A.c(null);
            this.A.f();
            this.A.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.A.d(getPageContext().getResources().getString(R.string.net_error_text, fVar.f54783d, Integer.valueOf(fVar.f54782c)));
        } else {
            this.A.d(null);
        }
        this.A.onChangeSkinType();
        this.A.attachView(this.s.o(), true);
        this.A.a(0);
    }
}
