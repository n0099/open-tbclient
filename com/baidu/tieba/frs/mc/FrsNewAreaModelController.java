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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.i0.b.d;
import d.a.i0.r.q.a2;
import d.a.j0.d3.f;
import d.a.j0.d3.m;
import d.a.j0.d3.n0.e;
import d.a.j0.s2.a;
/* loaded from: classes4.dex */
public class FrsNewAreaModelController extends BdBaseModel implements NetModel.k<FrsRequestData, m> {

    /* renamed from: e  reason: collision with root package name */
    public FrsNewAreaFragment f16452e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f16453f;

    /* renamed from: g  reason: collision with root package name */
    public FrsNetModel<FrsNewAreaFragment> f16454g;

    /* renamed from: h  reason: collision with root package name */
    public FrsRequestData f16455h;

    /* renamed from: i  reason: collision with root package name */
    public f f16456i;
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
        this.f16452e = frsNewAreaFragment;
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
        this.f16455h = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.o)) {
            I(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.o)) {
            I(6);
        } else {
            I(2);
        }
        this.f16453f = new FrsViewData();
        this.f16455h.s("forum_name", k.getUrlEncode(this.j));
        this.f16455h.s("client_type", "2");
        FrsRequestData frsRequestData = this.f16455h;
        FrsViewData frsViewData = this.f16453f;
        frsRequestData.y(a.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
        FrsNetModel<FrsNewAreaFragment> frsNetModel = new FrsNetModel<>(this.f16452e.getPageContext(), this.f16455h);
        this.f16454g = frsNetModel;
        frsNetModel.V(this);
        this.f16454g.setUniqueId(this.f16452e.getUniqueId());
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
        return this.f16454g.M();
    }

    public void D() {
        H();
    }

    public void E(int i2) {
        if (this.f16454g.M()) {
            return;
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f16455h), FrsRequestData.class);
        frsRequestData.setPn(i2);
        FrsRequestData frsRequestData2 = this.f16455h;
        FrsViewData frsViewData = this.f16453f;
        frsRequestData2.y(a.e(frsViewData == null ? null : frsViewData.getThreadList(), false));
        t(frsRequestData, 4);
    }

    public void F() {
        this.f16454g.cancelLoadData();
    }

    public final boolean G(FrsRequestData frsRequestData, m mVar) {
        this.f16453f.receiveData(mVar);
        this.f16453f.frsCurrentTabId = 503;
        if (frsRequestData != null) {
            this.f16455h = frsRequestData;
            this.l = frsRequestData.getPn();
            String v = this.f16455h.v();
            this.j = v;
            this.f16452e.A1(v);
            this.f16452e.setFrom(this.m);
            this.f16452e.B1(this.l);
            this.f16452e.z1(this.n);
        }
        this.f16452e.F.d(this.k, false, this.f16456i);
        this.o = null;
        return true;
    }

    public boolean H() {
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f16455h), FrsRequestData.class);
        frsRequestData.setPn(1);
        FrsRequestData frsRequestData2 = this.f16455h;
        FrsViewData frsViewData = this.f16453f;
        frsRequestData2.y(a.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
        t(frsRequestData, 3);
        return true;
    }

    public void I(int i2) {
        this.q = i2;
        if (7 == i2) {
            e.b();
        } else {
            e.a();
        }
    }

    public final void J() {
        this.r = System.currentTimeMillis();
        this.f16454g.N();
    }

    public void K() {
        FrsViewData frsViewData = this.f16453f;
        if (frsViewData == null || frsViewData.getForum() == null || this.f16453f.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.f16453f.getForum().getBannerListData().getLastIds();
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

    public int getType() {
        return this.k;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void h(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, m> mvcSocketMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        if (mvcSocketResponsedMessage == null) {
            return;
        }
        f fVar = new f();
        fVar.f53038a = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        fVar.f53039b = !mvcSocketResponsedMessage.hasError();
        fVar.f53040c = mvcSocketResponsedMessage.getError();
        fVar.f53041d = mvcSocketResponsedMessage.getErrorString();
        fVar.f53042e = mvcSocketResponsedMessage.getDownSize();
        this.f16456i = fVar;
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
        d.a.i0.r.z.a.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void l(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, m> mvcHttpMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        if (mvcHttpResponsedMessage == null) {
            return;
        }
        f fVar = new f();
        fVar.f53038a = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        fVar.f53039b = !mvcHttpResponsedMessage.hasError();
        fVar.f53040c = mvcHttpResponsedMessage.getError();
        fVar.f53041d = mvcHttpResponsedMessage.getErrorString();
        fVar.f53042e = mvcHttpResponsedMessage.getDownSize();
        this.f16456i = fVar;
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
        d.a.i0.r.z.a.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.j);
        bundle.putString("from", this.m);
        bundle.putInt("flag", this.n);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public void s(a2 a2Var) {
        FrsViewData frsViewData;
        if (a2Var == null || (frsViewData = this.f16453f) == null || frsViewData.getThreadList() == null) {
            return;
        }
        if (ListUtils.isEmpty(this.f16453f.getThreadList())) {
            this.f16453f.getThreadList().add(a2Var);
        } else {
            this.f16453f.getThreadList().add(0, a2Var);
        }
        this.f16452e.t1(this.f16453f);
    }

    public final void t(FrsRequestData frsRequestData, int i2) {
        FrsNewAreaFragment frsNewAreaFragment = this.f16452e;
        if (frsNewAreaFragment == null || !frsNewAreaFragment.isAdded() || this.f16452e.getPageContext() == null) {
            return;
        }
        this.f16452e.F.a(i2);
        this.f16454g.a0(frsRequestData);
        this.k = i2;
        frsRequestData.I(this.j);
        frsRequestData.V(1);
        frsRequestData.G(0);
        frsRequestData.A(0);
        d.a.j0.q0.n2.k.e(this.q, frsRequestData);
        if (d.n()) {
            d.a.j0.q0.n2.k.e(d.a.i0.b.g.a.d(), frsRequestData);
            frsRequestData.D(d.a.j0.q0.n2.k.d(d.a.i0.b.g.a.d()));
        }
        int k = l.k(this.f16452e.getPageContext().getPageActivity());
        int i3 = l.i(this.f16452e.getPageContext().getPageActivity());
        float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
        frsRequestData.U(k);
        frsRequestData.T(i3);
        frsRequestData.S(f2);
        frsRequestData.X(i4);
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
        return this.f16453f;
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
