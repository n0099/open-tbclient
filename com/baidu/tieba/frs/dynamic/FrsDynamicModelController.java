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
    private FrsDynamicRequestData dcA;
    private FrsDynamicModel<FrsDynamicFragment> dcB;
    private d.a dcC;
    private b dct;
    private FrsDynamicFragment dcz;
    private long mForumId;
    private int mType;

    public FrsDynamicModelController(FrsDynamicFragment frsDynamicFragment) {
        super(frsDynamicFragment.getPageContext());
        this.mType = 3;
        this.dcz = frsDynamicFragment;
        this.dcA = new FrsDynamicRequestData();
        this.dct = new b();
        this.dcB = new FrsDynamicModel<>(this.dcz.getPageContext(), this.dcA);
        this.dcB.a(this);
        this.dcB.setUniqueId(getUniqueId());
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean arj() {
        this.dct = new b();
        this.dcA.lastThreadId = 0L;
        a(this.dcA, 3);
        return true;
    }

    public void bD(long j) {
        if (!this.dcB.wX()) {
            this.dcA.lastThreadId = j;
            a(this.dcA, 4);
        }
    }

    private void a(FrsDynamicRequestData frsDynamicRequestData, int i) {
        if (this.dcz != null && this.dcz.isAdded() && this.dcz.getPageContext() != null) {
            this.dcz.cYk.kd(i);
            this.dcB.a(frsDynamicRequestData);
            this.mType = i;
            int af = l.af(this.dcz.getPageContext().getPageActivity());
            int ah = l.ah(this.dcz.getPageContext().getPageActivity());
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
            this.dcB.FY();
        }
    }

    public boolean wX() {
        return this.dcB.wX();
    }

    private boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        if (!bVar.userMap.isEmpty()) {
            this.dct.userMap.putAll(bVar.userMap);
        }
        if (!v.w(bVar.threadList)) {
            this.dct.threadList.addAll(bVar.threadList);
        }
        this.dct.hasMore = bVar.hasMore;
        this.dcz.cYk.a(this.mType, false, this.dcC);
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
            if (this.dcC == null) {
                this.dcC = new d.a();
            }
            this.dcC.gtn = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            this.dcC.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            this.dcC.errorCode = mvcHttpResponsedMessage.getError();
            this.dcC.errorMsg = mvcHttpResponsedMessage.getErrorString();
            this.dcC.gto = mvcHttpResponsedMessage.getDownSize();
            a(mvcHttpResponsedMessage.getData());
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<b, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsDynamicRequestData, b> mvcSocketMessage, MvcNetMessage<FrsDynamicRequestData, b> mvcNetMessage) {
        if (mvcSocketResponsedMessage != null) {
            if (this.dcC == null) {
                this.dcC = new d.a();
            }
            this.dcC.gtn = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            this.dcC.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            this.dcC.errorCode = mvcSocketResponsedMessage.getError();
            this.dcC.errorMsg = mvcSocketResponsedMessage.getErrorString();
            this.dcC.gto = mvcSocketResponsedMessage.getDownSize();
            a(mvcSocketResponsedMessage.getData());
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
        }
    }

    public int getType() {
        return this.mType;
    }

    public b ark() {
        return this.dct;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.dcB.cancelLoadData();
    }
}
