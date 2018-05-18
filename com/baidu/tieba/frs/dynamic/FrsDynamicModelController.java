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
    private FrsDynamicFragment ddE;
    private FrsDynamicRequestData ddF;
    private FrsDynamicModel<FrsDynamicFragment> ddG;
    private d.a ddH;
    private b ddz;
    private long mForumId;
    private int mType;

    public FrsDynamicModelController(FrsDynamicFragment frsDynamicFragment) {
        super(frsDynamicFragment.getPageContext());
        this.mType = 3;
        this.ddE = frsDynamicFragment;
        this.ddF = new FrsDynamicRequestData();
        this.ddz = new b();
        this.ddG = new FrsDynamicModel<>(this.ddE.getPageContext(), this.ddF);
        this.ddG.a(this);
        this.ddG.setUniqueId(getUniqueId());
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean ari() {
        this.ddz = new b();
        this.ddF.lastThreadId = 0L;
        a(this.ddF, 3);
        return true;
    }

    public void bD(long j) {
        if (!this.ddG.wW()) {
            this.ddF.lastThreadId = j;
            a(this.ddF, 4);
        }
    }

    private void a(FrsDynamicRequestData frsDynamicRequestData, int i) {
        if (this.ddE != null && this.ddE.isAdded() && this.ddE.getPageContext() != null) {
            this.ddE.cZo.kc(i);
            this.ddG.a(frsDynamicRequestData);
            this.mType = i;
            int af = l.af(this.ddE.getPageContext().getPageActivity());
            int ah = l.ah(this.ddE.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = 1;
            if (ap.vP().vR()) {
                i2 = 2;
            }
            frsDynamicRequestData.scrW = af;
            frsDynamicRequestData.scrH = ah;
            frsDynamicRequestData.scrDip = f;
            frsDynamicRequestData.qType = i2;
            frsDynamicRequestData.forumId = this.mForumId;
            this.ddG.FW();
        }
    }

    public boolean wW() {
        return this.ddG.wW();
    }

    private boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        if (!bVar.userMap.isEmpty()) {
            this.ddz.userMap.putAll(bVar.userMap);
        }
        if (!v.w(bVar.threadList)) {
            this.ddz.threadList.addAll(bVar.threadList);
        }
        this.ddz.hasMore = bVar.hasMore;
        this.ddE.cZo.a(this.mType, false, this.ddH);
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
            if (this.ddH == null) {
                this.ddH = new d.a();
            }
            this.ddH.guo = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            this.ddH.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            this.ddH.errorCode = mvcHttpResponsedMessage.getError();
            this.ddH.errorMsg = mvcHttpResponsedMessage.getErrorString();
            this.ddH.gup = mvcHttpResponsedMessage.getDownSize();
            a(mvcHttpResponsedMessage.getData());
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<b, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsDynamicRequestData, b> mvcSocketMessage, MvcNetMessage<FrsDynamicRequestData, b> mvcNetMessage) {
        if (mvcSocketResponsedMessage != null) {
            if (this.ddH == null) {
                this.ddH = new d.a();
            }
            this.ddH.guo = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            this.ddH.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            this.ddH.errorCode = mvcSocketResponsedMessage.getError();
            this.ddH.errorMsg = mvcSocketResponsedMessage.getErrorString();
            this.ddH.gup = mvcSocketResponsedMessage.getDownSize();
            a(mvcSocketResponsedMessage.getData());
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
        }
    }

    public int getType() {
        return this.mType;
    }

    public b arj() {
        return this.ddz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.ddG.cancelLoadData();
    }
}
