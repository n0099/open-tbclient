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
import d.a.m0.b.d;
import d.a.m0.r.q.a2;
import d.a.n0.e3.f;
import d.a.n0.e3.m;
import d.a.n0.e3.n0.e;
import d.a.n0.t2.a;
/* loaded from: classes4.dex */
public class FrsNewAreaModelController extends BdBaseModel implements NetModel.k<FrsRequestData, m> {

    /* renamed from: e  reason: collision with root package name */
    public FrsNewAreaFragment f15732e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f15733f;

    /* renamed from: g  reason: collision with root package name */
    public FrsNetModel<FrsNewAreaFragment> f15734g;

    /* renamed from: h  reason: collision with root package name */
    public FrsRequestData f15735h;

    /* renamed from: i  reason: collision with root package name */
    public f f15736i;
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
        this.f15732e = frsNewAreaFragment;
    }

    public long A() {
        return this.u;
    }

    public long B() {
        return this.r;
    }

    public long C() {
        return this.t;
    }

    public long D() {
        return this.s;
    }

    public boolean E() {
        return true;
    }

    public void F(Bundle bundle) {
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
        this.f15735h = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.o)) {
            M(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.o)) {
            M(6);
        } else {
            M(2);
        }
        this.f15733f = new FrsViewData();
        this.f15735h.w("forum_name", k.getUrlEncode(this.j));
        this.f15735h.w("client_type", "2");
        FrsRequestData frsRequestData = this.f15735h;
        FrsViewData frsViewData = this.f15733f;
        frsRequestData.C(a.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
        FrsNetModel<FrsNewAreaFragment> frsNetModel = new FrsNetModel<>(this.f15732e.getPageContext(), this.f15735h);
        this.f15734g = frsNetModel;
        frsNetModel.Z(this);
        this.f15734g.setUniqueId(this.f15732e.getUniqueId());
        String str = this.j;
        if (str == null || str.length() <= 0) {
            return;
        }
        String str2 = this.m;
        if (str2 == null || str2.length() <= 0) {
            this.m = "tb_forumlist";
        }
    }

    public boolean G() {
        return this.f15734g.Q();
    }

    public void H() {
        L();
    }

    public void I(int i2) {
        if (this.f15734g.Q()) {
            return;
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f15735h), FrsRequestData.class);
        frsRequestData.setPn(i2);
        FrsRequestData frsRequestData2 = this.f15735h;
        FrsViewData frsViewData = this.f15733f;
        frsRequestData2.C(a.e(frsViewData == null ? null : frsViewData.getThreadList(), false));
        x(frsRequestData, 4);
    }

    public void J() {
        this.f15734g.cancelLoadData();
    }

    public final boolean K(FrsRequestData frsRequestData, m mVar) {
        this.f15733f.receiveData(mVar);
        this.f15733f.frsCurrentTabId = 503;
        if (frsRequestData != null) {
            this.f15735h = frsRequestData;
            this.l = frsRequestData.getPn();
            String z = this.f15735h.z();
            this.j = z;
            this.f15732e.C1(z);
            this.f15732e.setFrom(this.m);
            this.f15732e.D1(this.l);
            this.f15732e.B1(this.n);
        }
        this.f15732e.F.d(this.k, false, this.f15736i);
        this.o = null;
        return true;
    }

    public boolean L() {
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f15735h), FrsRequestData.class);
        frsRequestData.setPn(1);
        FrsRequestData frsRequestData2 = this.f15735h;
        FrsViewData frsViewData = this.f15733f;
        frsRequestData2.C(a.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
        x(frsRequestData, 3);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void M(int i2) {
        this.q = i2;
        if (7 == i2) {
            e.b();
        } else {
            e.a();
        }
    }

    public final void N() {
        this.r = System.currentTimeMillis();
        this.f15734g.R();
    }

    public void O() {
        FrsViewData frsViewData = this.f15733f;
        if (frsViewData == null || frsViewData.getForum() == null || this.f15733f.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.f15733f.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.p = lastIds;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public int getType() {
        return this.k;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, m> mvcSocketMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        if (mvcSocketResponsedMessage == null) {
            return;
        }
        f fVar = new f();
        fVar.f57647a = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        fVar.f57648b = !mvcSocketResponsedMessage.hasError();
        fVar.f57649c = mvcSocketResponsedMessage.getError();
        fVar.f57650d = mvcSocketResponsedMessage.getErrorString();
        fVar.f57651e = mvcSocketResponsedMessage.getDownSize();
        this.f15736i = fVar;
        m data = mvcSocketResponsedMessage.getData();
        FrsRequestData requestData = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
        if (mvcNetMessage != null) {
            requestData = mvcNetMessage.getRequestData();
        }
        K(requestData, data);
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
        objArr[1] = requestData != null ? requestData.z() : null;
        objArr[2] = "seq_id";
        objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
        d.a.m0.r.z.a.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.j);
        bundle.putString("from", this.m);
        bundle.putInt("flag", this.n);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, m> mvcHttpMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        if (mvcHttpResponsedMessage == null) {
            return;
        }
        f fVar = new f();
        fVar.f57647a = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        fVar.f57648b = !mvcHttpResponsedMessage.hasError();
        fVar.f57649c = mvcHttpResponsedMessage.getError();
        fVar.f57650d = mvcHttpResponsedMessage.getErrorString();
        fVar.f57651e = mvcHttpResponsedMessage.getDownSize();
        this.f15736i = fVar;
        m data = mvcHttpResponsedMessage.getData();
        FrsRequestData requestData = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
        if (mvcNetMessage != null) {
            requestData = mvcNetMessage.getRequestData();
        }
        K(requestData, data);
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
        objArr[1] = requestData != null ? requestData.z() : null;
        d.a.m0.r.z.a.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
    }

    public void w(a2 a2Var) {
        FrsViewData frsViewData;
        if (a2Var == null || (frsViewData = this.f15733f) == null || frsViewData.getThreadList() == null) {
            return;
        }
        if (ListUtils.isEmpty(this.f15733f.getThreadList())) {
            this.f15733f.getThreadList().add(a2Var);
        } else {
            this.f15733f.getThreadList().add(0, a2Var);
        }
        this.f15732e.v1(this.f15733f);
    }

    public final void x(FrsRequestData frsRequestData, int i2) {
        FrsNewAreaFragment frsNewAreaFragment = this.f15732e;
        if (frsNewAreaFragment == null || !frsNewAreaFragment.isAdded() || this.f15732e.getPageContext() == null) {
            return;
        }
        this.f15732e.F.a(i2);
        this.f15734g.e0(frsRequestData);
        this.k = i2;
        frsRequestData.M(this.j);
        frsRequestData.Z(1);
        frsRequestData.K(0);
        frsRequestData.E(0);
        d.a.n0.r0.n2.k.e(this.q, frsRequestData);
        if (d.n()) {
            d.a.n0.r0.n2.k.e(d.a.m0.b.g.a.d(), frsRequestData);
            frsRequestData.H(d.a.n0.r0.n2.k.d(d.a.m0.b.g.a.d()));
        }
        int k = l.k(this.f15732e.getPageContext().getPageActivity());
        int i3 = l.i(this.f15732e.getPageContext().getPageActivity());
        float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
        frsRequestData.Y(k);
        frsRequestData.X(i3);
        frsRequestData.W(f2);
        frsRequestData.b0(i4);
        frsRequestData.O(this.p);
        String str = this.o;
        if (str != null) {
            frsRequestData.setStType(str);
        }
        if (FrsFragment.W1 != 0) {
            frsRequestData.F((int) FrsFragment.W1);
        }
        if (FrsFragment.X1 != 0) {
            frsRequestData.G((int) FrsFragment.X1);
        }
        if (FrsFragment.Y1 != 0) {
            frsRequestData.R(FrsFragment.Y1);
        }
        frsRequestData.setUpdateType(this.k);
        frsRequestData.setNeedCache(false);
        N();
    }

    public int y() {
        return this.q;
    }

    public FrsViewData z() {
        return this.f15733f;
    }
}
