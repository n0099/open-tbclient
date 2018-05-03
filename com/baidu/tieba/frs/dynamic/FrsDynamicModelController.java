package com.baidu.tieba.frs.dynamic;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.tbadkCore.d;
/* loaded from: classes2.dex */
public class FrsDynamicModelController extends BdBaseModel implements NetModel.b<FrsDynamicRequestData, b> {
    private b dcq;
    private FrsDynamicFragment dcw;
    private FrsDynamicRequestData dcx;
    private FrsDynamicModel<FrsDynamicFragment> dcy;
    private d.a dcz;
    private long mForumId;
    private int mType;

    public FrsDynamicModelController(FrsDynamicFragment frsDynamicFragment) {
        super(frsDynamicFragment.getPageContext());
        this.mType = 3;
        this.dcw = frsDynamicFragment;
        this.dcx = new FrsDynamicRequestData();
        this.dcq = new b();
        this.dcy = new FrsDynamicModel<>(this.dcw.getPageContext(), this.dcx);
        this.dcy.a(this);
        this.dcy.setUniqueId(getUniqueId());
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean arj() {
        this.dcq = new b();
        this.dcx.lastThreadId = 0L;
        a(this.dcx, 3);
        return true;
    }

    public void bD(long j) {
        if (!this.dcy.wX()) {
            this.dcx.lastThreadId = j;
            a(this.dcx, 4);
        }
    }

    private void a(FrsDynamicRequestData frsDynamicRequestData, int i) {
        if (this.dcw != null && this.dcw.isAdded() && this.dcw.getPageContext() != null) {
            this.dcw.cYh.kd(i);
            this.dcy.a(frsDynamicRequestData);
            this.mType = i;
            int af = l.af(this.dcw.getPageContext().getPageActivity());
            int ah = l.ah(this.dcw.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = 1;
            if (ap.vQ().vS()) {
                i2 = 2;
            }
            frsDynamicRequestData.scrW = af;
            frsDynamicRequestData.scrH = ah;
            frsDynamicRequestData.scrDip = f;
            frsDynamicRequestData.qType = i2;
            frsDynamicRequestData.forumId = this.mForumId;
            this.dcy.FY();
        }
    }

    public boolean wX() {
        return this.dcy.wX();
    }

    private boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        if (!bVar.userMap.isEmpty()) {
            this.dcq.userMap.putAll(bVar.userMap);
        }
        if (!v.w(bVar.threadList)) {
            this.dcq.threadList.addAll(bVar.threadList);
        }
        this.dcq.hasMore = bVar.hasMore;
        this.dcw.cYh.a(this.mType, false, this.dcz);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<b> mvcHttpResponsedMessage, MvcHttpMessage<FrsDynamicRequestData, b> mvcHttpMessage, MvcNetMessage<FrsDynamicRequestData, b> mvcNetMessage) {
        if (mvcHttpResponsedMessage != null) {
            if (this.dcz == null) {
                this.dcz = new d.a();
            }
            this.dcz.gtk = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            this.dcz.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            this.dcz.errorCode = mvcHttpResponsedMessage.getError();
            this.dcz.errorMsg = mvcHttpResponsedMessage.getErrorString();
            this.dcz.gtl = mvcHttpResponsedMessage.getDownSize();
            a(mvcHttpResponsedMessage.getData());
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<b, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsDynamicRequestData, b> mvcSocketMessage, MvcNetMessage<FrsDynamicRequestData, b> mvcNetMessage) {
        if (mvcSocketResponsedMessage != null) {
            if (this.dcz == null) {
                this.dcz = new d.a();
            }
            this.dcz.gtk = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            this.dcz.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            this.dcz.errorCode = mvcSocketResponsedMessage.getError();
            this.dcz.errorMsg = mvcSocketResponsedMessage.getErrorString();
            this.dcz.gtl = mvcSocketResponsedMessage.getDownSize();
            a(mvcSocketResponsedMessage.getData());
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
        }
    }

    public int getType() {
        return this.mType;
    }

    public b ark() {
        return this.dcq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.dcy.cancelLoadData();
    }
}
