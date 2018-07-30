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
    private b dsM;
    private FrsDynamicFragment dsQ;
    private FrsDynamicRequestData dsR;
    private FrsDynamicModel<FrsDynamicFragment> dsS;
    private d.a dsT;
    private long mForumId;
    private int mType;

    public FrsDynamicModelController(FrsDynamicFragment frsDynamicFragment) {
        super(frsDynamicFragment.getPageContext());
        this.mType = 3;
        this.dsQ = frsDynamicFragment;
        this.dsR = new FrsDynamicRequestData();
        this.dsM = new b();
        this.dsS = new FrsDynamicModel<>(this.dsQ.getPageContext(), this.dsR);
        this.dsS.a(this);
        this.dsS.setUniqueId(getUniqueId());
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean aww() {
        this.dsM = new b();
        this.dsR.lastThreadId = 0L;
        a(this.dsR, 3);
        return true;
    }

    public void bI(long j) {
        if (!this.dsS.AE()) {
            this.dsR.lastThreadId = j;
            a(this.dsR, 4);
        }
    }

    private void a(FrsDynamicRequestData frsDynamicRequestData, int i) {
        if (this.dsQ != null && this.dsQ.isAdded() && this.dsQ.getPageContext() != null) {
            this.dsQ.dnx.ku(i);
            this.dsS.a(frsDynamicRequestData);
            this.mType = i;
            int ah = l.ah(this.dsQ.getPageContext().getPageActivity());
            int aj = l.aj(this.dsQ.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = 1;
            if (ar.zw().zy()) {
                i2 = 2;
            }
            frsDynamicRequestData.scrW = ah;
            frsDynamicRequestData.scrH = aj;
            frsDynamicRequestData.scrDip = f;
            frsDynamicRequestData.qType = i2;
            frsDynamicRequestData.forumId = this.mForumId;
            this.dsS.JR();
        }
    }

    public boolean AE() {
        return this.dsS.AE();
    }

    private boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        if (!bVar.userMap.isEmpty()) {
            this.dsM.userMap.putAll(bVar.userMap);
        }
        if (!w.z(bVar.threadList)) {
            this.dsM.threadList.addAll(bVar.threadList);
        }
        this.dsM.hasMore = bVar.hasMore;
        this.dsQ.dnx.a(this.mType, false, this.dsT);
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
            if (this.dsT == null) {
                this.dsT = new d.a();
            }
            this.dsT.gKB = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            this.dsT.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            this.dsT.errorCode = mvcHttpResponsedMessage.getError();
            this.dsT.errorMsg = mvcHttpResponsedMessage.getErrorString();
            this.dsT.gKC = mvcHttpResponsedMessage.getDownSize();
            a(mvcHttpResponsedMessage.getData());
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<b, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsDynamicRequestData, b> mvcSocketMessage, MvcNetMessage<FrsDynamicRequestData, b> mvcNetMessage) {
        if (mvcSocketResponsedMessage != null) {
            if (this.dsT == null) {
                this.dsT = new d.a();
            }
            this.dsT.gKB = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            this.dsT.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            this.dsT.errorCode = mvcSocketResponsedMessage.getError();
            this.dsT.errorMsg = mvcSocketResponsedMessage.getErrorString();
            this.dsT.gKC = mvcSocketResponsedMessage.getDownSize();
            a(mvcSocketResponsedMessage.getData());
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
        }
    }

    public int getType() {
        return this.mType;
    }

    public b awx() {
        return this.dsM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.dsS.cancelLoadData();
    }
}
