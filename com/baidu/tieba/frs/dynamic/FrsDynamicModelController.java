package com.baidu.tieba.frs.dynamic;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.tbadkCore.d;
/* loaded from: classes6.dex */
public class FrsDynamicModelController extends BdBaseModel implements NetModel.b<FrsDynamicRequestData, b> {
    private b dHo;
    private FrsDynamicFragment dHt;
    private FrsDynamicRequestData dHu;
    private FrsDynamicModel<FrsDynamicFragment> dHv;
    private d.a dHw;
    private long mForumId;
    private int mType;

    public FrsDynamicModelController(FrsDynamicFragment frsDynamicFragment) {
        super(frsDynamicFragment.getPageContext());
        this.mType = 3;
        this.dHt = frsDynamicFragment;
        this.dHu = new FrsDynamicRequestData();
        this.dHo = new b();
        this.dHv = new FrsDynamicModel<>(this.dHt.getPageContext(), this.dHu);
        this.dHv.a(this);
        this.dHv.setUniqueId(getUniqueId());
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean aCd() {
        this.dHo = new b();
        this.dHu.lastThreadId = 0L;
        a(this.dHu, 3);
        return true;
    }

    public void bT(long j) {
        if (!this.dHv.DU()) {
            this.dHu.lastThreadId = j;
            a(this.dHu, 4);
        }
    }

    private void a(FrsDynamicRequestData frsDynamicRequestData, int i) {
        if (this.dHt != null && this.dHt.isAdded() && this.dHt.getPageContext() != null) {
            this.dHt.dBu.lq(i);
            this.dHv.a(frsDynamicRequestData);
            this.mType = i;
            int aO = l.aO(this.dHt.getPageContext().getPageActivity());
            int aQ = l.aQ(this.dHt.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = 1;
            if (aq.CG().CI()) {
                i2 = 2;
            }
            frsDynamicRequestData.scrW = aO;
            frsDynamicRequestData.scrH = aQ;
            frsDynamicRequestData.scrDip = f;
            frsDynamicRequestData.qType = i2;
            frsDynamicRequestData.forumId = this.mForumId;
            this.dHv.Nj();
        }
    }

    public boolean DU() {
        return this.dHv.DU();
    }

    private boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        if (!bVar.userMap.isEmpty()) {
            this.dHo.userMap.putAll(bVar.userMap);
        }
        if (!v.J(bVar.threadList)) {
            this.dHo.threadList.addAll(bVar.threadList);
        }
        this.dHo.hasMore = bVar.hasMore;
        this.dHt.dBu.a(this.mType, false, this.dHw);
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
            if (this.dHw == null) {
                this.dHw = new d.a();
            }
            this.dHw.gZA = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            this.dHw.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            this.dHw.errorCode = mvcHttpResponsedMessage.getError();
            this.dHw.errorMsg = mvcHttpResponsedMessage.getErrorString();
            this.dHw.gZB = mvcHttpResponsedMessage.getDownSize();
            a(mvcHttpResponsedMessage.getData());
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<b, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsDynamicRequestData, b> mvcSocketMessage, MvcNetMessage<FrsDynamicRequestData, b> mvcNetMessage) {
        if (mvcSocketResponsedMessage != null) {
            if (this.dHw == null) {
                this.dHw = new d.a();
            }
            this.dHw.gZA = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            this.dHw.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            this.dHw.errorCode = mvcSocketResponsedMessage.getError();
            this.dHw.errorMsg = mvcSocketResponsedMessage.getErrorString();
            this.dHw.gZB = mvcSocketResponsedMessage.getDownSize();
            a(mvcSocketResponsedMessage.getData());
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
        }
    }

    public int getType() {
        return this.mType;
    }

    public b aCe() {
        return this.dHo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.dHv.cancelLoadData();
    }
}
