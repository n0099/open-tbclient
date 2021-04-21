package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.xiaomi.mipush.sdk.Constants;
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.w0;
import d.b.i0.r.q.z1;
import d.b.i0.z0.c0;
import d.b.i0.z0.h0;
import d.b.j0.d3.f;
import d.b.j0.d3.m;
import d.b.j0.d3.s;
import d.b.j0.q0.b0;
import d.b.j0.q0.c1;
import d.b.j0.q0.d0;
import d.b.j0.q0.f0;
import d.b.j0.q0.o2.h;
import d.b.j0.q0.p0;
import d.b.j0.q0.t;
import d.b.j0.q0.t0;
import d.b.j0.q0.z0;
import d.b.j0.s2.v;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements p0, NetModel.k<FrsRequestData, m> {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    public SparseArray<z0> A;
    public f0 B;
    public t0 C;
    public ArrayList<n> D;
    public long E;
    public boolean F;
    public String G;
    public int H;
    public int I;
    public int J;
    public boolean K;
    public f L;
    public String M;
    public final SparseArray<Boolean> N;
    public boolean O;
    public d.b.j0.q0.e2.n P;
    public d.b.j0.q0.e2.m Q;
    public t0 R;
    public long S;
    public long T;
    public long U;
    public long V;

    /* renamed from: e  reason: collision with root package name */
    public final FrsFragment f16207e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f16208f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f16209g;

    /* renamed from: h  reason: collision with root package name */
    public FrsRequestData f16210h;
    public FrsNetModel i;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    public final s j;
    public String k;
    public int l;
    public int m;
    public String n;
    public int o;
    public String p;
    public boolean q;
    public String r;
    public String s;
    public String t;
    public long u;
    public int v;
    public int w;
    public int x;
    public z0 y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a implements t0 {
        public a() {
        }

        @Override // d.b.j0.q0.t0
        public void a(int i, int i2, c1 c1Var, ArrayList<n> arrayList) {
            FrsModelController.this.z = false;
            if (i != FrsModelController.this.v || FrsModelController.this.C == null) {
                return;
            }
            FrsModelController.this.y = c1Var;
            FrsModelController.this.O0(i, i2, c1Var);
            ArrayList<n> arrayList2 = new ArrayList<>();
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
            }
            FrsModelController.this.f16208f.setThreadList(arrayList2);
            FrsModelController.this.C.a(i, i2, c1Var, arrayList);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.b.i0.z0.f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f16212a;

        public b(String str) {
            this.f16212a = str;
        }

        @Override // d.b.i0.z0.f0
        public Object doInBackground() {
            d.b.j0.d3.e.i().c(FrsModelController.this.M, this.f16212a);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.b.i0.z0.f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f16214a;

        public c(String str) {
            this.f16214a = str;
        }

        @Override // d.b.i0.z0.f0
        public Object doInBackground() {
            d.b.j0.d3.e.i().d(FrsModelController.this.M, this.f16214a);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.b.i0.z0.f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f16216a;

        public d(String str) {
            this.f16216a = str;
        }

        @Override // d.b.i0.z0.f0
        public Object doInBackground() {
            d.b.j0.d3.e.i().b(FrsModelController.this.M, this.f16216a);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends BdAsyncTask<Object, m, Void> {

        /* renamed from: a  reason: collision with root package name */
        public String f16218a;

        /* renamed from: b  reason: collision with root package name */
        public FrsModelController f16219b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f16220c;

        public e(FrsModelController frsModelController, boolean z, String str) {
            this.f16218a = null;
            this.f16218a = str;
            this.f16219b = frsModelController;
            this.f16220c = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            int d2;
            CustomResponsedMessage runTask;
            if (this.f16220c && d.b.j0.d3.e.i().e(this.f16218a)) {
                if (!d.b.j0.d3.e.i().l(TbadkCoreApplication.getCurrentAccount() + this.f16218a)) {
                    d.b.j0.d3.e.i().j().getForum().getSignData().is_signed = 0;
                }
                m j = d.b.j0.d3.e.i().j();
                j.setIsShowRedTip(false);
                if (j.getBookInfo() != null && !StringUtils.isNull(j.getBookInfo().a(), true) && !j.getBookInfo().a().equals("0") && j.getBookInfo().b() == 3 && (d2 = d.b.c.e.m.b.d(j.getBookInfo().a(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(d2))) != null) {
                    j.setMangaReadRecordChapterId(Integer.valueOf(((Integer) runTask.getData()).intValue()));
                }
                publishProgress(j);
            } else {
                publishProgress(null);
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(m... mVarArr) {
            super.onProgressUpdate(mVarArr);
            FrsModelController frsModelController = this.f16219b;
            if (frsModelController != null && mVarArr != null) {
                frsModelController.A0(mVarArr.length > 0 ? mVarArr[0] : null);
                FrsModelController frsModelController2 = this.f16219b;
                frsModelController2.G0(frsModelController2.H, true);
                return;
            }
            FrsModelController frsModelController3 = this.f16219b;
            if (frsModelController3 == null || frsModelController3.i.Z()) {
                return;
            }
            if (this.f16219b.i.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                FrsModelController frsModelController4 = this.f16219b;
                frsModelController4.f((MvcHttpResponsedMessage) frsModelController4.i.getResponsedMessage(), (MvcHttpMessage) this.f16219b.i.W(), this.f16219b.i.X());
            }
            if (this.f16219b.i.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                FrsModelController frsModelController5 = this.f16219b;
                frsModelController5.n((MvcSocketResponsedMessage) frsModelController5.i.getResponsedMessage(), (MvcSocketMessage) this.f16219b.i.W(), this.f16219b.i.X());
            }
        }
    }

    public FrsModelController(FrsFragment frsFragment, s sVar) {
        super(frsFragment.getPageContext());
        this.k = null;
        this.l = 3;
        this.m = 1;
        this.n = null;
        this.o = 0;
        this.p = "normal_page";
        this.r = "";
        this.s = null;
        this.t = null;
        this.u = 0L;
        this.v = 1;
        this.w = 0;
        this.x = 0;
        this.z = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.A = new SparseArray<>();
        this.E = 0L;
        this.F = false;
        this.H = -1;
        this.I = -1;
        this.J = -1;
        this.M = null;
        this.N = new SparseArray<>();
        this.P = new d.b.j0.q0.e2.n();
        this.Q = new d.b.j0.q0.e2.m();
        this.R = new a();
        this.S = 0L;
        this.T = 0L;
        this.U = 0L;
        this.V = 0L;
        if (sVar != null) {
            this.f16207e = frsFragment;
            this.j = sVar;
            if (frsFragment.getActivity() instanceof FrsActivity) {
                this.i = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.f16207e.getActivity()).getUniqueId().getId());
            }
            FrsNetModel frsNetModel = this.i;
            if (frsNetModel != null) {
                if (frsNetModel.getResponsedMessage() == null) {
                    this.i.V(this);
                }
                this.f16210h = this.i.Y();
            }
            k0(this.f16207e);
            return;
        }
        throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
    }

    public final void A0(m mVar) {
        this.isCacheFirstLoad = false;
        this.f16208f.receiveData(mVar);
        E0(this.f16208f);
        this.f16209g = new ArrayList<>();
        if (this.f16208f.getThreadList() != null) {
            this.f16209g.addAll(this.f16208f.getThreadList());
        }
        this.j.d(mVar);
    }

    public boolean B0(FrsRequestData frsRequestData, m mVar) {
        if (mVar == null || mVar.getForum() == null || (k.isEmpty(mVar.getForum().getName()) && 340001 != mVar.mErrorNo)) {
            return false;
        }
        if (mVar.getDataParseTime() > 0) {
            this.f16207e.L = mVar.getDataParseTime();
        }
        F0(d.b.j0.q0.n2.k.f(mVar.getSortType()));
        G0(d.b.j0.q0.n2.k.f(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.v = mVar.getFrsDefaultTabId();
        }
        this.f16208f.receiveData(mVar);
        E0(this.f16208f);
        this.f16209g = new ArrayList<>();
        if (frsRequestData != null) {
            this.f16210h = frsRequestData;
            this.m = frsRequestData.getPn();
            String v = this.f16210h.v();
            this.k = v;
            this.f16207e.g3(v);
            this.f16207e.setFrom(this.n);
            this.f16207e.o3(this.m);
            this.f16207e.f3(this.o);
        }
        if (this.f16208f.getThreadList() != null) {
            this.f16209g.addAll(this.f16208f.getThreadList());
        }
        if (this.v != 1 && this.isNetFirstLoad) {
            this.j.a(7, false, this.L);
        } else {
            this.j.a(this.l, false, this.L);
        }
        this.s = null;
        if (d.b.j0.q0.h2.b.b(this.f16210h)) {
            D0();
        }
        if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.f16208f.getForum()));
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() != null && !TextUtils.isEmpty(mVar.getForum().getName()) && frsRequestData != null && v.p().b() != null) {
            v.p().b().g(mVar.getForum().getName(), frsRequestData.w(), false);
        }
        if (!StringUtils.isNull(mVar.getUserData().getAppealThreadPopover())) {
            this.f16207e.A3(TbadkCoreApplication.getCurrentAccount(), mVar.getForum().getId(), mVar.getUserData().getAppealThreadPopover());
        }
        return true;
    }

    public void C(w0 w0Var) {
        if (w0Var == null || StringUtils.isNull(w0Var.o0()) || ListUtils.isEmpty(this.f16209g)) {
            return;
        }
        if (this.v == 1) {
            this.f16208f.addMyNewThread(w0Var);
        }
        int Y = Y();
        Iterator<n> it = this.f16209g.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if ((next instanceof z1) && w0Var.o0().equals(((z1) next).w.o0())) {
                return;
            }
        }
        this.f16209g.add(Y, w0Var);
    }

    public void C0(int i, boolean z) {
        if (this.f16210h == null) {
            return;
        }
        this.f16207e.M = System.currentTimeMillis();
        FrsViewData frsViewData = this.f16208f;
        if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
            this.f16208f.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f16210h), FrsRequestData.class);
        frsRequestData.setPn(1);
        int K = K(this.v, frsRequestData);
        this.v = K;
        if (K == 1) {
            if (this.i.M()) {
                return;
            }
            frsRequestData.setCallFrom(0);
            H(frsRequestData, i, !z);
            return;
        }
        if (this.y == null) {
            z0 z0Var = new z0();
            this.y = z0Var;
            z0Var.f60870c = 1;
            z0Var.f60868a = this.k;
            FrsViewData frsViewData2 = this.f16208f;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                this.y.f60869b = this.f16208f.getForum().getId();
            }
        }
        u0(i);
    }

    public final void D(String str, FrsRequestData frsRequestData) {
        if (a2.u3.get() && v.p().b() != null) {
            int d2 = v.p().b().d(str, false);
            int e2 = v.p().b().e(str, false);
            if (frsRequestData.w() == 1) {
                d2++;
            } else if (frsRequestData.w() == 2) {
                e2++;
            }
            frsRequestData.Q(d2);
            frsRequestData.L(e2);
        }
    }

    public void D0() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        FrsViewData frsViewData = this.f16208f;
        if (frsViewData != null && frsViewData.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(d.b.c.e.m.b.f(this.f16208f.getForum().getId(), 0L));
        }
        this.f16207e.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void E(String str) {
        h0.b(new d(str), null);
    }

    public final void E0(FrsViewData frsViewData) {
        if (h.G(frsViewData)) {
            this.p = "book_page";
        } else if (frsViewData.getIsBrandForum()) {
            this.p = "brand_page";
        } else if (h.I(frsViewData)) {
            this.p = "frs_page";
        } else {
            this.p = "normal_page";
        }
    }

    public void F(String str) {
        h0.b(new b(str), null);
    }

    public void F0(int i) {
        AccountData currentAccountObj;
        String str;
        this.H = i;
        if (i != -1) {
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            } else {
                str = "";
            }
            d.b.j0.q0.n2.k.i("1~" + str + this.k, this.H);
        }
        if (7 == i) {
            d.b.j0.d3.n0.e.b();
        } else {
            d.b.j0.d3.n0.e.a();
        }
    }

    public void G(String str) {
        h0.b(new c(str), null);
    }

    public void G0(int i, boolean z) {
        this.N.put(i, Boolean.valueOf(z));
    }

    public final void H(FrsRequestData frsRequestData, int i, boolean z) {
        boolean z2;
        this.l = i;
        this.f16207e.c3(z);
        this.j.b(i);
        this.i.a0(frsRequestData);
        frsRequestData.O(this.f16207e.L2() ? "1" : "2");
        if (this.K) {
            frsRequestData.P(String.valueOf(d.b.j0.q0.n2.k.d(this.I)));
        } else {
            frsRequestData.P("-2");
        }
        this.K = false;
        frsRequestData.I(this.k);
        frsRequestData.V(1);
        frsRequestData.A(0);
        int k = l.k(TbadkCoreApplication.getInst());
        int i2 = l.i(TbadkCoreApplication.getInst());
        float h2 = l.h(TbadkCoreApplication.getInst());
        int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
        frsRequestData.U(k);
        frsRequestData.T(i2);
        frsRequestData.S(h2);
        frsRequestData.X(i3);
        frsRequestData.R(this.r);
        frsRequestData.K(this.t);
        frsRequestData.W(this.G);
        frsRequestData.J(d.b.c.e.m.b.f(c0.a(), 0L));
        String str = this.s;
        if (str != null) {
            frsRequestData.setStType(str);
            if ("sidebar".equalsIgnoreCase(this.s)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.F(m0());
        if (FrsFragment.W1 != 0) {
            frsRequestData.B((int) FrsFragment.W1);
        }
        if (FrsFragment.X1 != 0) {
            frsRequestData.C((int) FrsFragment.X1);
        }
        if (FrsFragment.Y1 != 0) {
            frsRequestData.N(FrsFragment.Y1);
        }
        if (frsRequestData.getPn() != 1 && this.l != 3) {
            FrsViewData frsViewData = this.f16208f;
            frsRequestData.y(d.b.j0.s2.a.e(frsViewData != null ? frsViewData.getThreadList() : null, false));
            z2 = false;
        } else {
            FrsViewData frsViewData2 = this.f16208f;
            frsRequestData.y(d.b.j0.s2.a.e(frsViewData2 != null ? frsViewData2.getThreadList() : null, true));
            z2 = true;
        }
        frsRequestData.setNeedCache(z2);
        frsRequestData.setUpdateType(this.l);
        frsRequestData.E(this.u);
        d.b.j0.q0.n2.k.e(this.H, frsRequestData);
        int d2 = d.b.j0.q0.n2.k.d(this.J);
        J(i, frsRequestData);
        D(this.k, frsRequestData);
        if (!f0(this.J) && !this.f16207e.m && !this.O) {
            d.b.j0.d3.e i4 = d.b.j0.d3.e.i();
            String g2 = i4.g("1~" + this.k, d2, frsRequestData.u(), this.f16210h.t());
            this.M = g2;
            new e(this, true, g2).execute(new Object[0]);
        }
        M0();
        this.O = false;
    }

    public void H0(boolean z) {
        this.K = z;
    }

    public final void I(FrsRequestData frsRequestData, int i, boolean z) {
        this.l = i;
        this.f16207e.c3(z);
        this.j.b(i);
        if (this.i.Z() && (this.i.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
            f((MvcHttpResponsedMessage) this.i.getResponsedMessage(), (MvcHttpMessage) this.i.W(), this.i.X());
        } else if (this.i.Z() && (this.i.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
            n((MvcSocketResponsedMessage) this.i.getResponsedMessage(), (MvcSocketMessage) this.i.W(), this.i.X());
        } else {
            int d2 = d.b.j0.q0.n2.k.d(this.J);
            if (!f0(this.J) && !this.f16207e.m && !this.O) {
                d.b.j0.d3.e i2 = d.b.j0.d3.e.i();
                String g2 = i2.g("1~" + this.k, d2, frsRequestData.u(), this.f16210h.t());
                this.M = g2;
                new e(this, true, g2).execute(new Object[0]);
            }
            this.O = false;
        }
        this.i.V(this);
    }

    public void I0(boolean z) {
        this.O = z;
    }

    public final void J(int i, FrsRequestData frsRequestData) {
        if (frsRequestData == null) {
            return;
        }
        if (i == 3) {
            frsRequestData.M(1);
        } else if (i != 4) {
        } else {
            frsRequestData.M(2);
        }
    }

    public void J0(int i) {
        this.I = i;
    }

    public final int K(int i, FrsRequestData frsRequestData) {
        return (i != 1 || this.f16207e.n2() == null) ? i : this.f16207e.n2().c(this.H, frsRequestData);
    }

    public void K0() {
        t tVar = new t();
        if (this.x == 0) {
            tVar.e(this.H);
        }
        if (this.f16208f.getThreadList() != null) {
            this.f16208f.getThreadList().clear();
            this.f16208f.getThreadList().add(tVar);
        }
        ArrayList<n> arrayList = this.f16209g;
        if (arrayList != null) {
            arrayList.clear();
            this.f16209g.add(tVar);
        }
    }

    public void L(int i, boolean z) {
        this.f16207e.M = System.currentTimeMillis();
        FrsViewData frsViewData = this.f16208f;
        if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
            this.f16208f.getLikeFeedForumDataList().clear();
        }
        this.v = K(this.v, this.f16210h);
        FrsRequestData frsRequestData = this.f16210h;
        FrsViewData frsViewData2 = this.f16208f;
        frsRequestData.y(d.b.j0.s2.a.e(frsViewData2 == null ? null : frsViewData2.getThreadList(), true));
        if (this.v == 1) {
            I(this.f16210h, i, !z);
            return;
        }
        if (this.y == null) {
            z0 z0Var = new z0();
            this.y = z0Var;
            z0Var.f60870c = 1;
            z0Var.f60868a = this.k;
            FrsViewData frsViewData3 = this.f16208f;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                this.y.f60869b = this.f16208f.getForum().getId();
            }
        }
        u0(i);
    }

    public void L0(String str) {
        this.r = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public int M() {
        return this.J;
    }

    public final boolean M0() {
        this.S = System.currentTimeMillis();
        return this.i.N();
    }

    public int N() {
        return this.H;
    }

    public void N0() {
        FrsViewData frsViewData = this.f16208f;
        if (frsViewData == null || frsViewData.getForum() == null || this.f16208f.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.f16208f.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.t = lastIds;
    }

    public f O() {
        return this.L;
    }

    public final void O0(int i, int i2, z0 z0Var) {
        this.A.put(U(i, i2), z0Var);
    }

    public FrsRequestData P() {
        return this.f16210h;
    }

    public boolean Q() {
        return 1 == this.v;
    }

    public int R() {
        return this.x;
    }

    public ArrayList<n> S() {
        return this.f16209g;
    }

    public z0 T(int i, int i2) {
        return this.A.get(U(i, i2));
    }

    public final int U(int i, int i2) {
        return (i * 10) + i2;
    }

    public String V() {
        return this.p;
    }

    public int W() {
        return d.b.j0.q0.n2.k.d(this.H);
    }

    public int X() {
        return this.v;
    }

    public int Y() {
        ArrayList<n> arrayList = this.f16209g;
        int i = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<n> it = this.f16209g.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof z1) {
                    if (((z1) next).w.x0() == 0) {
                        break;
                    }
                    i++;
                }
            }
        }
        return i;
    }

    public FrsViewData Z() {
        return this.f16208f;
    }

    public long a0() {
        return this.V;
    }

    public long b0() {
        return this.S;
    }

    public long c0() {
        return this.U;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public long d0() {
        return this.T;
    }

    public boolean e0() {
        z0 z0Var = this.y;
        if ((z0Var instanceof c1) && ((c1) z0Var).f59483e == 0) {
            return ((c1) z0Var).f59485g;
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void f(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, m> mvcHttpMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        m mVar;
        if (mvcHttpResponsedMessage == null) {
            return;
        }
        this.Q.a(this);
        this.Q.e(mvcHttpResponsedMessage);
        this.Q.c(mvcHttpMessage);
        this.Q.d(mvcNetMessage);
        this.Q.b(this.j);
        Looper.myQueue().addIdleHandler(this.Q);
        f fVar = new f();
        fVar.f55201a = j.z() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        fVar.f55202b = !mvcHttpResponsedMessage.hasError();
        fVar.f55203c = mvcHttpResponsedMessage.getError();
        fVar.f55204d = mvcHttpResponsedMessage.getErrorString();
        fVar.f55205e = mvcHttpResponsedMessage.getDownSize();
        this.L = fVar;
        if (mvcHttpResponsedMessage.hasError()) {
            mVar = null;
        } else {
            mVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        }
        if (r1 == null || mVar == null || !B0(r1, mVar)) {
            ErrorData errorData = new ErrorData();
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.f16207e.onServerError(errorData);
        }
    }

    public boolean f0(int i) {
        return this.N.get(i, Boolean.FALSE).booleanValue();
    }

    @Override // d.b.j0.q0.p0
    public void g(int i, int i2, z0 z0Var) {
        this.v = K(i, null);
        if (z0Var == null && (z0Var = T(i, i2)) == null) {
            if (i != 1 && l.C() && this.C != null) {
                c1 c1Var = new c1();
                c1Var.f59485g = false;
                c1Var.f60870c = 1;
                c1Var.f60868a = this.k;
                c1Var.i = false;
                FrsViewData frsViewData = this.f16208f;
                if (frsViewData != null && frsViewData.getForum() != null) {
                    c1Var.f60869b = this.f16208f.getForum().getId();
                }
                i0();
                this.f16208f.setThreadList(this.D);
                this.C.a(i, i2, c1Var, this.D);
            }
            z0Var = new z0();
            z0Var.f60870c = -1;
        }
        FrsViewData frsViewData2 = this.f16208f;
        if (frsViewData2 != null && frsViewData2.getForum() != null) {
            z0Var.f60869b = this.f16208f.getForum().getId();
        }
        z0Var.f60868a = this.k;
        if (d0.a().b(1) != null && this.v == 1) {
            this.f16210h.z(i2);
        }
        this.w = i2;
        this.y = z0Var;
        O0(i, i2, z0Var);
        u0(5);
    }

    public void g0(Bundle bundle) {
        FrsRequestData frsRequestData;
        if (bundle != null) {
            this.k = bundle.getString("name");
            this.n = bundle.getString("from");
            this.o = bundle.getInt("flag", 0);
            this.G = bundle.getString("yuelaou_locate");
            this.q = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.f16207e.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.k)) {
            this.k = "";
        }
        if (TextUtils.isEmpty(this.n)) {
            this.n = "";
        }
        if (TextUtils.isEmpty(this.G)) {
            this.G = "";
        }
        this.s = this.n;
        j0();
        if (this.f16208f == null) {
            this.f16208f = new FrsViewData();
        }
        if (this.i == null || (frsRequestData = this.f16210h) == null || frsRequestData.p() == null || this.f16210h.p().isEmpty() || this.f16210h.p().containsKey(null) || this.f16210h.p().containsValue(null)) {
            h0(bundle);
        }
        String str = this.k;
        if (str == null || str.length() <= 0) {
            return;
        }
        String str2 = this.n;
        if (str2 == null || str2.length() <= 0) {
            this.n = "tb_forumlist";
        }
    }

    public int getPn() {
        return this.m;
    }

    public int getType() {
        return this.l;
    }

    public final void h0(Bundle bundle) {
        FrsRequestData frsRequestData = new FrsRequestData();
        this.f16210h = frsRequestData;
        frsRequestData.setSortType(d.b.j0.q0.n2.k.d(this.H));
        if (this.H == 5) {
            this.f16210h.G(1);
        } else {
            this.f16210h.G(0);
        }
        this.f16210h.s("forum_name", k.getUrlEncode(this.k));
        this.f16210h.s("client_type", "2");
        this.f16210h.setPn(1);
        if (bundle != null) {
            this.f16210h.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
            this.f16210h.E(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
        }
        this.f16210h.O("2");
        this.f16210h.P("-2");
        this.f16210h.I(this.k);
        this.f16210h.V(1);
        this.f16210h.A(0);
        this.f16210h.U(l.k(TbadkCoreApplication.getInst()));
        this.f16210h.T(l.i(TbadkCoreApplication.getInst()));
        this.f16210h.S(l.h(TbadkCoreApplication.getInst()));
        this.f16210h.X(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1);
        this.f16210h.R(this.r);
        this.f16210h.K(null);
        this.f16210h.W(this.G);
        this.f16210h.J(d.b.c.e.m.b.f(c0.a(), 0L));
        this.f16210h.setStType(this.n);
        this.f16210h.F(1);
        this.f16210h.setNeedCache(true);
        this.f16210h.setUpdateType(3);
        FrsRequestData frsRequestData2 = this.f16210h;
        FrsViewData frsViewData = this.f16208f;
        frsRequestData2.y(d.b.j0.s2.a.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
        d.b.j0.q0.n2.k.e(this.H, this.f16210h);
        this.f16210h.M(1);
        if (a2.u3.get() && v.p().b() != null) {
            int d2 = v.p().b().d(this.k, false);
            int e2 = v.p().b().e(this.k, false);
            if (this.f16210h.w() == 1) {
                d2++;
            } else if (this.f16210h.w() == 2) {
                e2++;
            }
            this.f16210h.Q(d2);
            this.f16210h.L(e2);
        }
        FrsNetModel frsNetModel = new FrsNetModel(null, this.f16210h);
        this.i = frsNetModel;
        frsNetModel.setUniqueId(((FrsActivity) this.f16207e.getActivity()).getUniqueId());
        this.i.V(this);
        this.i.N();
    }

    public final void i0() {
        if (this.D == null) {
            this.D = new ArrayList<>();
        }
        if (this.D.size() == 0) {
            this.D.add(new b0());
        }
    }

    @Override // d.b.j0.q0.p0
    public void init() {
        this.B.d();
    }

    @Override // d.b.j0.q0.p0
    public void j() {
        this.B.b();
        this.B.clear();
    }

    public final void j0() {
        AccountData currentAccountObj;
        String str;
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.s)) {
            F0(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.s)) {
            F0(6);
        } else {
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            } else {
                str = "";
            }
            this.J = d.b.j0.q0.n2.k.h("1~" + str + this.k);
            F0(this.H);
        }
    }

    public final void k0(FrsFragment frsFragment) {
        f0 f0Var = new f0();
        this.B = f0Var;
        f0Var.f59614e = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.B));
        this.B.e(this.R);
    }

    public boolean l0() {
        return this.q;
    }

    public final int m0() {
        FrsFragment frsFragment = this.f16207e;
        if (frsFragment != null) {
            int i = frsFragment.P0;
            return (i == -1 || i == this.v) ? 1 : 0;
        }
        return 0;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, m> mvcSocketMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        m data;
        if (mvcSocketResponsedMessage == null) {
            return;
        }
        this.P.a(this);
        this.P.e(mvcSocketResponsedMessage);
        this.P.c(mvcSocketMessage);
        this.P.d(mvcNetMessage);
        this.P.b(this.j);
        Looper.myQueue().addIdleHandler(this.P);
        f fVar = new f();
        fVar.f55201a = j.z() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        fVar.f55202b = !mvcSocketResponsedMessage.hasError();
        fVar.f55203c = mvcSocketResponsedMessage.getError();
        fVar.f55204d = mvcSocketResponsedMessage.getErrorString();
        fVar.f55205e = mvcSocketResponsedMessage.getDownSize();
        this.L = fVar;
        if (!mvcSocketResponsedMessage.hasError() || 340001 == mvcSocketResponsedMessage.getError()) {
            data = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            data = null;
        }
        if (r1 == null || data == null || !B0(r1, data)) {
            ErrorData errorData = new ErrorData();
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.f16207e.onServerError(errorData);
        }
    }

    public boolean n0() {
        return this.H == 5;
    }

    @Override // d.b.j0.q0.p0
    public void o(t0 t0Var) {
        this.C = t0Var;
        this.B.e(this.R);
    }

    public boolean o0() {
        return this.i.M();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.k);
        bundle.putString("from", this.n);
        bundle.putInt("flag", this.o);
    }

    public boolean p0() {
        FrsRequestData frsRequestData = this.f16210h;
        return frsRequestData != null && frsRequestData.w() == 1;
    }

    public boolean q0() {
        return this.H == 7 || (!this.i.Z() && this.J == 7);
    }

    public boolean r0() {
        return this.z;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, d.b.c.c.g.a aVar) {
        super.registerListener(i, aVar);
    }

    public boolean s0() {
        if (this.v != 1) {
            u0(1);
            return true;
        } else if (this.i.M()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f16210h), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(W());
            H(frsRequestData, 1, false);
            return true;
        }
    }

    public void t0(int i) {
        if (this.v != 1) {
            u0(4);
        } else if (this.i.M()) {
        } else {
            FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f16210h), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(W());
            H(frsRequestData, 4, false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x000c, code lost:
        if (r5 != 4) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void u0(int i) {
        int i2;
        this.l = i;
        if (i != 1) {
            if (i == 2) {
                z0 z0Var = this.y;
                if (z0Var != null) {
                    z0Var.f60870c--;
                }
            } else if (i == 3) {
                z0 z0Var2 = this.y;
                if (z0Var2 != null) {
                    z0Var2.f60870c = -1;
                }
            }
            i2 = this.v;
            if (i2 != 1) {
                if (this.x == this.w) {
                    ArrayList<n> arrayList = new ArrayList<>();
                    ArrayList<n> arrayList2 = this.f16209g;
                    if (arrayList2 != null) {
                        arrayList.addAll(arrayList2);
                    }
                    this.f16208f.setThreadList(arrayList);
                    t0 t0Var = this.C;
                    if (t0Var != null) {
                        t0Var.a(this.v, this.w, null, arrayList);
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
                }
                this.x = this.w;
                return;
            }
            p0 c2 = this.B.c(i2);
            if (c2 != null) {
                this.z = true;
                c2.g(this.v, this.w, this.y);
                return;
            }
            FrsViewData frsViewData = this.f16208f;
            if (frsViewData != null && frsViewData.getThreadList() != null) {
                this.f16208f.getThreadList().clear();
            }
            this.C.a(this.v, this.w, null, null);
            return;
        }
        z0 z0Var3 = this.y;
        if (z0Var3 != null) {
            z0Var3.f60870c++;
        }
        i2 = this.v;
        if (i2 != 1) {
        }
    }

    public final void v0(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (d.b.i0.m0.k.d().g()) {
            long currentTimeMillis = System.currentTimeMillis();
            FrsFragment frsFragment = this.f16207e;
            this.E = currentTimeMillis - frsFragment.F;
            long currentTimeMillis2 = System.currentTimeMillis();
            FrsFragment frsFragment2 = this.f16207e;
            frsFragment.H = currentTimeMillis2 - frsFragment2.G;
            d.b.i0.m0.h hVar = new d.b.i0.m0.h(i, z, responsedMessage, frsFragment2.I, frsFragment2.J, frsFragment2.H, false, frsFragment2.K, frsFragment2.L, this.E);
            FrsFragment frsFragment3 = this.f16207e;
            frsFragment3.J = 0L;
            frsFragment3.I = 0L;
            d.b.j0.q0.n2.l.f(this, frsFragment3.F);
            this.f16207e.F = -1L;
            hVar.c();
        }
    }

    public void w0(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, m> mvcHttpMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        long j;
        FrsRequestData frsRequestData;
        if (mvcHttpMessage != null) {
            j = mvcHttpMessage.getClientLogID();
            frsRequestData = mvcHttpMessage.getRequestData();
        } else {
            j = 0;
            frsRequestData = null;
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            frsRequestData = mvcNetMessage.getRequestData();
        }
        long j2 = j;
        int error = mvcHttpResponsedMessage.getError();
        String errorString = mvcHttpResponsedMessage.getErrorString();
        if (error != 0) {
            int cmd = mvcHttpResponsedMessage.getCmd();
            Object[] objArr = new Object[2];
            objArr[0] = TiebaStatic.Params.H5_FORUM_NAME;
            objArr[1] = frsRequestData != null ? frsRequestData.v() : null;
            d.b.i0.r.z.a.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
        }
        if (!this.F) {
            this.F = true;
            v0(1000, true, mvcHttpResponsedMessage);
            return;
        }
        x0(true, mvcHttpResponsedMessage);
    }

    public final void x0(boolean z, ResponsedMessage<?> responsedMessage) {
        if (d.b.i0.m0.k.d().g()) {
            long currentTimeMillis = System.currentTimeMillis();
            FrsFragment frsFragment = this.f16207e;
            this.E = currentTimeMillis - frsFragment.M;
            long currentTimeMillis2 = System.currentTimeMillis();
            FrsFragment frsFragment2 = this.f16207e;
            frsFragment.H = currentTimeMillis2 - frsFragment2.G;
            d.b.i0.m0.h hVar = new d.b.i0.m0.h(1000, z, responsedMessage, frsFragment2.I, frsFragment2.J, frsFragment2.H, false, frsFragment2.K, frsFragment2.L, this.E);
            int i = this.l;
            if (i == 4) {
                hVar.B = this.E;
                hVar.e(true);
            } else if (i == 3) {
                hVar.C = this.E;
                hVar.e(false);
            }
        }
    }

    public void y0(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, m> mvcSocketMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (!this.F) {
            this.F = true;
            v0(1000, false, mvcSocketResponsedMessage);
        } else {
            x0(false, mvcSocketResponsedMessage);
        }
        long j = 0;
        if (mvcSocketMessage != null) {
            j = mvcSocketMessage.getClientLogID();
            frsRequestData = mvcSocketMessage.getRequestData();
        } else {
            frsRequestData = null;
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            frsRequestData = mvcNetMessage.getRequestData();
        }
        long j2 = j;
        int error = mvcSocketResponsedMessage.getError();
        String errorString = mvcSocketResponsedMessage.getErrorString();
        if (error != 0) {
            int cmd = mvcSocketResponsedMessage.getCmd();
            Object[] objArr = new Object[4];
            objArr[0] = TiebaStatic.Params.H5_FORUM_NAME;
            objArr[1] = frsRequestData != null ? frsRequestData.v() : null;
            objArr[2] = "seq_id";
            objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
            d.b.i0.r.z.a.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    public void z0() {
        Looper.myQueue().removeIdleHandler(this.P);
        Looper.myQueue().removeIdleHandler(this.Q);
        this.i.cancelLoadData();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }
}
