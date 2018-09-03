package com.baidu.tieba.frs.dynamic;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.tbadkCore.d;
/* loaded from: classes2.dex */
public class FrsDynamicModelController extends BdBaseModel implements NetModel.b<FrsDynamicRequestData, b> {
    private b dsJ;
    private FrsDynamicFragment dsN;
    private FrsDynamicRequestData dsO;
    private FrsDynamicModel<FrsDynamicFragment> dsP;
    private d.a dsQ;
    private long mForumId;
    private int mType;

    public FrsDynamicModelController(FrsDynamicFragment frsDynamicFragment) {
        super(frsDynamicFragment.getPageContext());
        this.mType = 3;
        this.dsN = frsDynamicFragment;
        this.dsO = new FrsDynamicRequestData();
        this.dsJ = new b();
        this.dsP = new FrsDynamicModel<>(this.dsN.getPageContext(), this.dsO);
        this.dsP.a(this);
        this.dsP.setUniqueId(getUniqueId());
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean awv() {
        this.dsJ = new b();
        this.dsO.lastThreadId = 0L;
        a(this.dsO, 3);
        return true;
    }

    public void bI(long j) {
        if (!this.dsP.AB()) {
            this.dsO.lastThreadId = j;
            a(this.dsO, 4);
        }
    }

    private void a(FrsDynamicRequestData frsDynamicRequestData, int i) {
        if (this.dsN != null && this.dsN.isAdded() && this.dsN.getPageContext() != null) {
            this.dsN.dnv.kt(i);
            this.dsP.a(frsDynamicRequestData);
            this.mType = i;
            int ah = l.ah(this.dsN.getPageContext().getPageActivity());
            int aj = l.aj(this.dsN.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = 1;
            if (ar.zu().zw()) {
                i2 = 2;
            }
            frsDynamicRequestData.scrW = ah;
            frsDynamicRequestData.scrH = aj;
            frsDynamicRequestData.scrDip = f;
            frsDynamicRequestData.qType = i2;
            frsDynamicRequestData.forumId = this.mForumId;
            this.dsP.JV();
        }
    }

    public boolean AB() {
        return this.dsP.AB();
    }

    private boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        if (!bVar.userMap.isEmpty()) {
            this.dsJ.userMap.putAll(bVar.userMap);
        }
        if (!w.z(bVar.threadList)) {
            this.dsJ.threadList.addAll(bVar.threadList);
        }
        this.dsJ.hasMore = bVar.hasMore;
        this.dsN.dnv.a(this.mType, false, this.dsQ);
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
            if (this.dsQ == null) {
                this.dsQ = new d.a();
            }
            this.dsQ.gKD = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            this.dsQ.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            this.dsQ.errorCode = mvcHttpResponsedMessage.getError();
            this.dsQ.errorMsg = mvcHttpResponsedMessage.getErrorString();
            this.dsQ.gKE = mvcHttpResponsedMessage.getDownSize();
            a(mvcHttpResponsedMessage.getData());
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<b, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsDynamicRequestData, b> mvcSocketMessage, MvcNetMessage<FrsDynamicRequestData, b> mvcNetMessage) {
        if (mvcSocketResponsedMessage != null) {
            if (this.dsQ == null) {
                this.dsQ = new d.a();
            }
            this.dsQ.gKD = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            this.dsQ.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            this.dsQ.errorCode = mvcSocketResponsedMessage.getError();
            this.dsQ.errorMsg = mvcSocketResponsedMessage.getErrorString();
            this.dsQ.gKE = mvcSocketResponsedMessage.getDownSize();
            a(mvcSocketResponsedMessage.getData());
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
        }
    }

    public int getType() {
        return this.mType;
    }

    public b aww() {
        return this.dsJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.dsP.cancelLoadData();
    }
}
