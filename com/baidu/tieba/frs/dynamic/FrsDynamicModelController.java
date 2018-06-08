package com.baidu.tieba.frs.dynamic;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
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
    private b dmN;
    private FrsDynamicFragment dmS;
    private FrsDynamicRequestData dmT;
    private FrsDynamicModel<FrsDynamicFragment> dmU;
    private d.a dmV;
    private long mForumId;
    private int mType;

    public FrsDynamicModelController(FrsDynamicFragment frsDynamicFragment) {
        super(frsDynamicFragment.getPageContext());
        this.mType = 3;
        this.dmS = frsDynamicFragment;
        this.dmT = new FrsDynamicRequestData();
        this.dmN = new b();
        this.dmU = new FrsDynamicModel<>(this.dmS.getPageContext(), this.dmT);
        this.dmU.a(this);
        this.dmU.setUniqueId(getUniqueId());
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean avn() {
        this.dmN = new b();
        this.dmT.lastThreadId = 0L;
        a(this.dmT, 3);
        return true;
    }

    public void bH(long j) {
        if (!this.dmU.Ax()) {
            this.dmT.lastThreadId = j;
            a(this.dmT, 4);
        }
    }

    private void a(FrsDynamicRequestData frsDynamicRequestData, int i) {
        if (this.dmS != null && this.dmS.isAdded() && this.dmS.getPageContext() != null) {
            this.dmS.diG.kf(i);
            this.dmU.a(frsDynamicRequestData);
            this.mType = i;
            int ah = l.ah(this.dmS.getPageContext().getPageActivity());
            int aj = l.aj(this.dmS.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = 1;
            if (aq.zq().zs()) {
                i2 = 2;
            }
            frsDynamicRequestData.scrW = ah;
            frsDynamicRequestData.scrH = aj;
            frsDynamicRequestData.scrDip = f;
            frsDynamicRequestData.qType = i2;
            frsDynamicRequestData.forumId = this.mForumId;
            this.dmU.JE();
        }
    }

    public boolean Ax() {
        return this.dmU.Ax();
    }

    private boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        if (!bVar.userMap.isEmpty()) {
            this.dmN.userMap.putAll(bVar.userMap);
        }
        if (!w.z(bVar.threadList)) {
            this.dmN.threadList.addAll(bVar.threadList);
        }
        this.dmN.hasMore = bVar.hasMore;
        this.dmS.diG.a(this.mType, false, this.dmV);
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
            if (this.dmV == null) {
                this.dmV = new d.a();
            }
            this.dmV.gFM = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            this.dmV.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            this.dmV.errorCode = mvcHttpResponsedMessage.getError();
            this.dmV.errorMsg = mvcHttpResponsedMessage.getErrorString();
            this.dmV.gFN = mvcHttpResponsedMessage.getDownSize();
            a(mvcHttpResponsedMessage.getData());
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<b, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsDynamicRequestData, b> mvcSocketMessage, MvcNetMessage<FrsDynamicRequestData, b> mvcNetMessage) {
        if (mvcSocketResponsedMessage != null) {
            if (this.dmV == null) {
                this.dmV = new d.a();
            }
            this.dmV.gFM = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            this.dmV.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            this.dmV.errorCode = mvcSocketResponsedMessage.getError();
            this.dmV.errorMsg = mvcSocketResponsedMessage.getErrorString();
            this.dmV.gFN = mvcSocketResponsedMessage.getDownSize();
            a(mvcSocketResponsedMessage.getData());
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
        }
    }

    public int getType() {
        return this.mType;
    }

    public b avo() {
        return this.dmN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.dmU.cancelLoadData();
    }
}
