package com.baidu.tieba.frs.good;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.i0.c3.f;
import d.b.i0.c3.m;
import d.b.i0.r2.a;
/* loaded from: classes4.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.k<FrsRequestData, m> {

    /* renamed from: e  reason: collision with root package name */
    public FrsGoodFragment f16518e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f16519f;

    /* renamed from: g  reason: collision with root package name */
    public FrsNetModel<FrsGoodFragment> f16520g;

    /* renamed from: h  reason: collision with root package name */
    public FrsRequestData f16521h;
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

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.j = null;
        this.k = 3;
        this.l = 1;
        this.m = null;
        this.n = 0;
        this.o = null;
        this.p = null;
        this.q = 0;
        this.r = 0L;
        this.s = 0L;
        this.t = 0L;
        this.u = 0L;
        this.f16518e = frsGoodFragment;
    }

    public boolean A() {
        return this.f16520g.M();
    }

    public void B(int i) {
        this.q = i;
        F();
    }

    public void C(int i, String str) {
        if (this.f16520g.M()) {
            return;
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f16521h), FrsRequestData.class);
        frsRequestData.setPn(i);
        frsRequestData.y(str);
        s(frsRequestData, 4);
    }

    public void D() {
        this.f16520g.cancelLoadData();
    }

    public final boolean E(FrsRequestData frsRequestData, m mVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.q) {
            this.f16519f.receiveData(mVar);
            this.f16519f.frsCurrentTabId = 301;
            if (frsRequestData != null) {
                this.f16521h = frsRequestData;
                this.l = frsRequestData.getPn();
                String v = this.f16521h.v();
                this.j = v;
                this.f16518e.v1(v);
                this.f16518e.setFrom(this.m);
                this.f16518e.w1(this.l);
                this.f16518e.u1(this.n);
            }
            this.f16518e.J.a(this.k, false, this.i);
            this.o = null;
            return true;
        }
        return false;
    }

    public boolean F() {
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f16521h), FrsRequestData.class);
        frsRequestData.setPn(1);
        FrsViewData frsViewData = this.f16519f;
        frsRequestData.y(a.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
        s(frsRequestData, 3);
        return true;
    }

    public final void G() {
        this.r = System.currentTimeMillis();
        this.f16520g.N();
    }

    public void H() {
        FrsViewData frsViewData = this.f16519f;
        if (frsViewData == null || frsViewData.getForum() == null || this.f16519f.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.f16519f.getForum().getBannerListData().getLastIds();
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
        fVar.f53338a = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        fVar.f53339b = !mvcHttpResponsedMessage.hasError();
        fVar.f53340c = mvcHttpResponsedMessage.getError();
        fVar.f53341d = mvcHttpResponsedMessage.getErrorString();
        fVar.f53342e = mvcHttpResponsedMessage.getDownSize();
        this.i = fVar;
        m data = mvcHttpResponsedMessage.getData();
        FrsRequestData requestData = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
        if (mvcNetMessage != null) {
            requestData = mvcNetMessage.getRequestData();
        }
        E(requestData, data);
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
        fVar.f53338a = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        fVar.f53339b = !mvcSocketResponsedMessage.hasError();
        fVar.f53340c = mvcSocketResponsedMessage.getError();
        fVar.f53341d = mvcSocketResponsedMessage.getErrorString();
        fVar.f53342e = mvcSocketResponsedMessage.getDownSize();
        this.i = fVar;
        m data = mvcSocketResponsedMessage.getData();
        FrsRequestData requestData = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
        if (mvcNetMessage != null) {
            requestData = mvcNetMessage.getRequestData();
        }
        E(requestData, data);
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

    public final void s(FrsRequestData frsRequestData, int i) {
        FrsGoodFragment frsGoodFragment = this.f16518e;
        if (frsGoodFragment == null || !frsGoodFragment.isAdded() || this.f16518e.getPageContext() == null) {
            return;
        }
        this.f16518e.J.b(i);
        this.f16520g.a0(frsRequestData);
        this.k = i;
        frsRequestData.I(this.j);
        frsRequestData.V(1);
        frsRequestData.G(1);
        frsRequestData.H(0);
        frsRequestData.A(this.q);
        int k = l.k(this.f16518e.getPageContext().getPageActivity());
        int i2 = l.i(this.f16518e.getPageContext().getPageActivity());
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
        G();
    }

    public FrsViewData t() {
        return this.f16519f;
    }

    public long u() {
        return this.u;
    }

    public long v() {
        return this.r;
    }

    public long w() {
        return this.t;
    }

    public long x() {
        return this.s;
    }

    public boolean y() {
        return this.q < 100;
    }

    public void z(Bundle bundle) {
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
        this.f16521h = new FrsRequestData();
        this.f16519f = new FrsViewData();
        this.f16521h.s("forum_name", k.getUrlEncode(this.j));
        this.f16521h.s("client_type", "2");
        FrsNetModel<FrsGoodFragment> frsNetModel = new FrsNetModel<>(this.f16518e.getPageContext(), this.f16521h);
        this.f16520g = frsNetModel;
        frsNetModel.V(this);
        this.f16520g.setUniqueId(this.f16518e.getUniqueId());
        String str = this.j;
        if (str == null || str.length() <= 0) {
            return;
        }
        String str2 = this.m;
        if (str2 == null || str2.length() <= 0) {
            this.m = "tb_forumlist";
        }
    }
}
