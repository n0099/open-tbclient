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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.e3.f;
import d.a.o0.e3.m;
import d.a.o0.t2.a;
/* loaded from: classes4.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.k<FrsRequestData, m> {

    /* renamed from: e  reason: collision with root package name */
    public FrsGoodFragment f15757e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f15758f;

    /* renamed from: g  reason: collision with root package name */
    public FrsNetModel<FrsGoodFragment> f15759g;

    /* renamed from: h  reason: collision with root package name */
    public FrsRequestData f15760h;

    /* renamed from: i  reason: collision with root package name */
    public f f15761i;
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
        this.f15757e = frsGoodFragment;
    }

    public long A() {
        return this.t;
    }

    public long B() {
        return this.s;
    }

    public boolean C() {
        return this.q < 100;
    }

    public void D(Bundle bundle) {
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
        this.f15760h = new FrsRequestData();
        this.f15758f = new FrsViewData();
        this.f15760h.w("forum_name", k.getUrlEncode(this.j));
        this.f15760h.w("client_type", "2");
        FrsNetModel<FrsGoodFragment> frsNetModel = new FrsNetModel<>(this.f15757e.getPageContext(), this.f15760h);
        this.f15759g = frsNetModel;
        frsNetModel.Z(this);
        this.f15759g.setUniqueId(this.f15757e.getUniqueId());
        String str = this.j;
        if (str == null || str.length() <= 0) {
            return;
        }
        String str2 = this.m;
        if (str2 == null || str2.length() <= 0) {
            this.m = "tb_forumlist";
        }
    }

    public boolean E() {
        return this.f15759g.Q();
    }

    public void F(int i2) {
        this.q = i2;
        J();
    }

    public void G(int i2, String str) {
        if (this.f15759g.Q()) {
            return;
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f15760h), FrsRequestData.class);
        frsRequestData.setPn(i2);
        frsRequestData.C(str);
        w(frsRequestData, 4);
    }

    public void H() {
        this.f15759g.cancelLoadData();
    }

    public final boolean I(FrsRequestData frsRequestData, m mVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.q) {
            this.f15758f.receiveData(mVar);
            this.f15758f.frsCurrentTabId = 301;
            if (frsRequestData != null) {
                this.f15760h = frsRequestData;
                this.l = frsRequestData.getPn();
                String z = this.f15760h.z();
                this.j = z;
                this.f15757e.x1(z);
                this.f15757e.setFrom(this.m);
                this.f15757e.y1(this.l);
                this.f15757e.w1(this.n);
            }
            this.f15757e.J.d(this.k, false, this.f15761i);
            this.o = null;
            return true;
        }
        return false;
    }

    public boolean J() {
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f15760h), FrsRequestData.class);
        frsRequestData.setPn(1);
        FrsViewData frsViewData = this.f15758f;
        frsRequestData.C(a.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
        w(frsRequestData, 3);
        return true;
    }

    public final void K() {
        this.r = System.currentTimeMillis();
        this.f15759g.R();
    }

    public void L() {
        FrsViewData frsViewData = this.f15758f;
        if (frsViewData == null || frsViewData.getForum() == null || this.f15758f.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.f15758f.getForum().getBannerListData().getLastIds();
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
    public void k(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, m> mvcSocketMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        if (mvcSocketResponsedMessage == null) {
            return;
        }
        f fVar = new f();
        fVar.f57772a = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        fVar.f57773b = !mvcSocketResponsedMessage.hasError();
        fVar.f57774c = mvcSocketResponsedMessage.getError();
        fVar.f57775d = mvcSocketResponsedMessage.getErrorString();
        fVar.f57776e = mvcSocketResponsedMessage.getDownSize();
        this.f15761i = fVar;
        m data = mvcSocketResponsedMessage.getData();
        FrsRequestData requestData = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
        if (mvcNetMessage != null) {
            requestData = mvcNetMessage.getRequestData();
        }
        I(requestData, data);
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
        d.a.n0.r.z.a.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
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
        fVar.f57772a = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        fVar.f57773b = !mvcHttpResponsedMessage.hasError();
        fVar.f57774c = mvcHttpResponsedMessage.getError();
        fVar.f57775d = mvcHttpResponsedMessage.getErrorString();
        fVar.f57776e = mvcHttpResponsedMessage.getDownSize();
        this.f15761i = fVar;
        m data = mvcHttpResponsedMessage.getData();
        FrsRequestData requestData = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
        if (mvcNetMessage != null) {
            requestData = mvcNetMessage.getRequestData();
        }
        I(requestData, data);
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
        d.a.n0.r.z.a.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
    }

    public final void w(FrsRequestData frsRequestData, int i2) {
        FrsGoodFragment frsGoodFragment = this.f15757e;
        if (frsGoodFragment == null || !frsGoodFragment.isAdded() || this.f15757e.getPageContext() == null) {
            return;
        }
        this.f15757e.J.a(i2);
        this.f15759g.e0(frsRequestData);
        this.k = i2;
        frsRequestData.M(this.j);
        frsRequestData.Z(1);
        frsRequestData.K(1);
        frsRequestData.L(0);
        frsRequestData.E(this.q);
        int k = l.k(this.f15757e.getPageContext().getPageActivity());
        int i3 = l.i(this.f15757e.getPageContext().getPageActivity());
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
        K();
    }

    public FrsViewData x() {
        return this.f15758f;
    }

    public long y() {
        return this.u;
    }

    public long z() {
        return this.r;
    }
}
