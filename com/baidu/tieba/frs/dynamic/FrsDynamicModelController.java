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
    private b dpZ;
    private FrsDynamicFragment dqd;
    private FrsDynamicRequestData dqe;
    private FrsDynamicModel<FrsDynamicFragment> dqf;
    private d.a dqg;
    private long mForumId;
    private int mType;

    public FrsDynamicModelController(FrsDynamicFragment frsDynamicFragment) {
        super(frsDynamicFragment.getPageContext());
        this.mType = 3;
        this.dqd = frsDynamicFragment;
        this.dqe = new FrsDynamicRequestData();
        this.dpZ = new b();
        this.dqf = new FrsDynamicModel<>(this.dqd.getPageContext(), this.dqe);
        this.dqf.a(this);
        this.dqf.setUniqueId(getUniqueId());
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean avR() {
        this.dpZ = new b();
        this.dqe.lastThreadId = 0L;
        a(this.dqe, 3);
        return true;
    }

    public void bD(long j) {
        if (!this.dqf.AO()) {
            this.dqe.lastThreadId = j;
            a(this.dqe, 4);
        }
    }

    private void a(FrsDynamicRequestData frsDynamicRequestData, int i) {
        if (this.dqd != null && this.dqd.isAdded() && this.dqd.getPageContext() != null) {
            this.dqd.dkH.kj(i);
            this.dqf.a(frsDynamicRequestData);
            this.mType = i;
            int ah = l.ah(this.dqd.getPageContext().getPageActivity());
            int aj = l.aj(this.dqd.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = 1;
            if (ar.zF().zH()) {
                i2 = 2;
            }
            frsDynamicRequestData.scrW = ah;
            frsDynamicRequestData.scrH = aj;
            frsDynamicRequestData.scrDip = f;
            frsDynamicRequestData.qType = i2;
            frsDynamicRequestData.forumId = this.mForumId;
            this.dqf.JW();
        }
    }

    public boolean AO() {
        return this.dqf.AO();
    }

    private boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        if (!bVar.userMap.isEmpty()) {
            this.dpZ.userMap.putAll(bVar.userMap);
        }
        if (!w.A(bVar.threadList)) {
            this.dpZ.threadList.addAll(bVar.threadList);
        }
        this.dpZ.hasMore = bVar.hasMore;
        this.dqd.dkH.a(this.mType, false, this.dqg);
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
            if (this.dqg == null) {
                this.dqg = new d.a();
            }
            this.dqg.gJF = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            this.dqg.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            this.dqg.errorCode = mvcHttpResponsedMessage.getError();
            this.dqg.errorMsg = mvcHttpResponsedMessage.getErrorString();
            this.dqg.gJG = mvcHttpResponsedMessage.getDownSize();
            a(mvcHttpResponsedMessage.getData());
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<b, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsDynamicRequestData, b> mvcSocketMessage, MvcNetMessage<FrsDynamicRequestData, b> mvcNetMessage) {
        if (mvcSocketResponsedMessage != null) {
            if (this.dqg == null) {
                this.dqg = new d.a();
            }
            this.dqg.gJF = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            this.dqg.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            this.dqg.errorCode = mvcSocketResponsedMessage.getError();
            this.dqg.errorMsg = mvcSocketResponsedMessage.getErrorString();
            this.dqg.gJG = mvcSocketResponsedMessage.getDownSize();
            a(mvcSocketResponsedMessage.getData());
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
        }
    }

    public int getType() {
        return this.mType;
    }

    public b avS() {
        return this.dpZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.dqf.cancelLoadData();
    }
}
