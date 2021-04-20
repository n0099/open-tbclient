package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.h0.b.d;
import d.b.h0.r.q.a2;
import d.b.i0.d3.f;
import d.b.i0.d3.m;
import d.b.i0.d3.n0.e;
import d.b.i0.s2.a;
/* loaded from: classes4.dex */
public class FrsNewAreaModelController extends BdBaseModel implements NetModel.k<FrsRequestData, m> {

    /* renamed from: e  reason: collision with root package name */
    public FrsNewAreaFragment f16230e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f16231f;

    /* renamed from: g  reason: collision with root package name */
    public FrsNetModel<FrsNewAreaFragment> f16232g;

    /* renamed from: h  reason: collision with root package name */
    public FrsRequestData f16233h;
    public f i;
    public String j;
    public int k;
    public int l;
    public String m;
    public int n;
    public String o;
    public String p;
    public int q;
    public long r;
    public long s;
    public long t;
    public long u;

    public FrsNewAreaModelController(FrsNewAreaFragment frsNewAreaFragment) {
        super(frsNewAreaFragment.getPageContext());
        this.j = null;
        this.k = 3;
        this.l = 1;
        this.m = null;
        this.n = 0;
        this.o = null;
        this.p = null;
        this.q = -1;
        this.r = 0L;
        this.s = 0L;
        this.t = 0L;
        this.u = 0L;
        this.f16230e = frsNewAreaFragment;
    }

    public boolean A() {
        return true;
    }

    public void B(Bundle bundle) {
        if (bundle != null) {
            this.j = bundle.getString("name");
            this.m = bundle.getString("from");
            this.n = bundle.getInt("flag", 0);
        }
        if (TextUtils.isEmpty(this.j)) {
            this.j = "";
        }
        if (TextUtils.isEmpty(this.m)) {
            this.m = "";
        }
        this.o = this.m;
        this.f16233h = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.o)) {
            I(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.o)) {
            I(6);
        } else {
            I(2);
        }
        this.f16231f = new FrsViewData();
        this.f16233h.s("forum_name", k.getUrlEncode(this.j));
        this.f16233h.s("client_type", "2");
        FrsRequestData frsRequestData = this.f16233h;
        FrsViewData frsViewData = this.f16231f;
        frsRequestData.y(a.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
        FrsNetModel<FrsNewAreaFragment> frsNetModel = new FrsNetModel<>(this.f16230e.getPageContext(), this.f16233h);
        this.f16232g = frsNetModel;
        frsNetModel.V(this);
        this.f16232g.setUniqueId(this.f16230e.getUniqueId());
        String str = this.j;
        if (str == null || str.length() <= 0) {
            return;
        }
        String str2 = this.m;
        if (str2 == null || str2.length() <= 0) {
            this.m = "tb_forumlist";
        }
    }

    public boolean C() {
        return this.f16232g.M();
    }

    public void D() {
        H();
    }

    public void E(int i) {
        if (this.f16232g.M()) {
            return;
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f16233h), FrsRequestData.class);
        frsRequestData.setPn(i);
        FrsRequestData frsRequestData2 = this.f16233h;
        FrsViewData frsViewData = this.f16231f;
        frsRequestData2.y(a.e(frsViewData == null ? null : frsViewData.getThreadList(), false));
        t(frsRequestData, 4);
    }

    public void F() {
        this.f16232g.cancelLoadData();
    }

    public final boolean G(FrsRequestData frsRequestData, m mVar) {
        this.f16231f.receiveData(mVar);
        this.f16231f.frsCurrentTabId = 503;
        if (frsRequestData != null) {
            this.f16233h = frsRequestData;
            this.l = frsRequestData.getPn();
            String v = this.f16233h.v();
            this.j = v;
            this.f16230e.A1(v);
            this.f16230e.setFrom(this.m);
            this.f16230e.B1(this.l);
            this.f16230e.z1(this.n);
        }
        this.f16230e.F.a(this.k, false, this.i);
        this.o = null;
        return true;
    }

    public boolean H() {
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f16233h), FrsRequestData.class);
        frsRequestData.setPn(1);
        FrsRequestData frsRequestData2 = this.f16233h;
        FrsViewData frsViewData = this.f16231f;
        frsRequestData2.y(a.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
        t(frsRequestData, 3);
        return true;
    }

    public void I(int i) {
        this.q = i;
        if (7 == i) {
            e.b();
        } else {
            e.a();
        }
    }

    public final void J() {
        this.r = System.currentTimeMillis();
        this.f16232g.N();
    }

    public void K() {
        FrsViewData frsViewData = this.f16231f;
        if (frsViewData == null || frsViewData.getForum() == null || this.f16231f.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.f16231f.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.p = lastIds;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void f(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, m> mvcHttpMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        if (mvcHttpResponsedMessage == null) {
            return;
        }
        f fVar = new f();
        fVar.f54780a = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        fVar.f54781b = !mvcHttpResponsedMessage.hasError();
        fVar.f54782c = mvcHttpResponsedMessage.getError();
        fVar.f54783d = mvcHttpResponsedMessage.getErrorString();
        fVar.f54784e = mvcHttpResponsedMessage.getDownSize();
        this.i = fVar;
        m data = mvcHttpResponsedMessage.getData();
        FrsRequestData requestData = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
        if (mvcNetMessage != null) {
            requestData = mvcNetMessage.getRequestData();
        }
        G(requestData, data);
        this.mErrorCode = mvcHttpResponsedMessage.getError();
        this.mErrorString = mvcHttpResponsedMessage.getErrorString();
        long j = 0;
        if (mvcHttpMessage != null) {
            j = mvcHttpMessage.getClientLogID();
            requestData = mvcHttpMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            requestData = mvcNetMessage.getRequestData();
        }
        long j2 = j;
        int error = mvcHttpResponsedMessage.getError();
        String errorString = mvcHttpResponsedMessage.getErrorString();
        int cmd = mvcHttpResponsedMessage.getCmd();
        Object[] objArr = new Object[2];
        objArr[0] = TiebaStatic.Params.H5_FORUM_NAME;
        objArr[1] = requestData != null ? requestData.v() : null;
        d.b.h0.r.z.a.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
    }

    public int getType() {
        return this.k;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, m> mvcSocketMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        if (mvcSocketResponsedMessage == null) {
            return;
        }
        f fVar = new f();
        fVar.f54780a = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        fVar.f54781b = !mvcSocketResponsedMessage.hasError();
        fVar.f54782c = mvcSocketResponsedMessage.getError();
        fVar.f54783d = mvcSocketResponsedMessage.getErrorString();
        fVar.f54784e = mvcSocketResponsedMessage.getDownSize();
        this.i = fVar;
        m data = mvcSocketResponsedMessage.getData();
        FrsRequestData requestData = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
        if (mvcNetMessage != null) {
            requestData = mvcNetMessage.getRequestData();
        }
        G(requestData, data);
        this.mErrorCode = mvcSocketResponsedMessage.getError();
        this.mErrorString = mvcSocketResponsedMessage.getErrorString();
        long j = 0;
        if (mvcSocketMessage != null) {
            j = mvcSocketMessage.getClientLogID();
            requestData = mvcSocketMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            requestData = mvcNetMessage.getRequestData();
        }
        long j2 = j;
        int error = mvcSocketResponsedMessage.getError();
        String errorString = mvcSocketResponsedMessage.getErrorString();
        int cmd = mvcSocketResponsedMessage.getCmd();
        Object[] objArr = new Object[4];
        objArr[0] = TiebaStatic.Params.H5_FORUM_NAME;
        objArr[1] = requestData != null ? requestData.v() : null;
        objArr[2] = "seq_id";
        objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
        d.b.h0.r.z.a.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.j);
        bundle.putString("from", this.m);
        bundle.putInt("flag", this.n);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public void s(a2 a2Var) {
        FrsViewData frsViewData;
        if (a2Var == null || (frsViewData = this.f16231f) == null || frsViewData.getThreadList() == null) {
            return;
        }
        if (ListUtils.isEmpty(this.f16231f.getThreadList())) {
            this.f16231f.getThreadList().add(a2Var);
        } else {
            this.f16231f.getThreadList().add(0, a2Var);
        }
        this.f16230e.t1(this.f16231f);
    }

    public final void t(FrsRequestData frsRequestData, int i) {
        FrsNewAreaFragment frsNewAreaFragment = this.f16230e;
        if (frsNewAreaFragment == null || !frsNewAreaFragment.isAdded() || this.f16230e.getPageContext() == null) {
            return;
        }
        this.f16230e.F.b(i);
        this.f16232g.a0(frsRequestData);
        this.k = i;
        frsRequestData.I(this.j);
        frsRequestData.V(1);
        frsRequestData.G(0);
        frsRequestData.A(0);
        d.b.i0.q0.n2.k.e(this.q, frsRequestData);
        if (d.n()) {
            d.b.i0.q0.n2.k.e(d.b.h0.b.g.a.d(), frsRequestData);
            frsRequestData.D(d.b.i0.q0.n2.k.d(d.b.h0.b.g.a.d()));
        }
        int k = l.k(this.f16230e.getPageContext().getPageActivity());
        int i2 = l.i(this.f16230e.getPageContext().getPageActivity());
        float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
        frsRequestData.U(k);
        frsRequestData.T(i2);
        frsRequestData.S(f2);
        frsRequestData.X(i3);
        frsRequestData.K(this.p);
        String str = this.o;
        if (str != null) {
            frsRequestData.setStType(str);
        }
        if (FrsFragment.W1 != 0) {
            frsRequestData.B((int) FrsFragment.W1);
        }
        if (FrsFragment.X1 != 0) {
            frsRequestData.C((int) FrsFragment.X1);
        }
        if (FrsFragment.Y1 != 0) {
            frsRequestData.N(FrsFragment.Y1);
        }
        frsRequestData.setUpdateType(this.k);
        frsRequestData.setNeedCache(false);
        J();
    }

    public int u() {
        return this.q;
    }

    public FrsViewData v() {
        return this.f16231f;
    }

    public long w() {
        return this.u;
    }

    public long x() {
        return this.r;
    }

    public long y() {
        return this.t;
    }

    public long z() {
        return this.s;
    }
}
