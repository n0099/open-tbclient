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
/* loaded from: classes2.dex */
public class FrsDynamicModelController extends BdBaseModel implements NetModel.b<FrsDynamicRequestData, b> {
    private b dzo;
    private FrsDynamicFragment dzt;
    private FrsDynamicRequestData dzu;
    private FrsDynamicModel<FrsDynamicFragment> dzv;
    private d.a dzw;
    private long mForumId;
    private int mType;

    public FrsDynamicModelController(FrsDynamicFragment frsDynamicFragment) {
        super(frsDynamicFragment.getPageContext());
        this.mType = 3;
        this.dzt = frsDynamicFragment;
        this.dzu = new FrsDynamicRequestData();
        this.dzo = new b();
        this.dzv = new FrsDynamicModel<>(this.dzt.getPageContext(), this.dzu);
        this.dzv.a(this);
        this.dzv.setUniqueId(getUniqueId());
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean ayJ() {
        this.dzo = new b();
        this.dzu.lastThreadId = 0L;
        a(this.dzu, 3);
        return true;
    }

    public void bM(long j) {
        if (!this.dzv.BO()) {
            this.dzu.lastThreadId = j;
            a(this.dzu, 4);
        }
    }

    private void a(FrsDynamicRequestData frsDynamicRequestData, int i) {
        if (this.dzt != null && this.dzt.isAdded() && this.dzt.getPageContext() != null) {
            this.dzt.dtt.kS(i);
            this.dzv.a(frsDynamicRequestData);
            this.mType = i;
            int aO = l.aO(this.dzt.getPageContext().getPageActivity());
            int aQ = l.aQ(this.dzt.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = 1;
            if (aq.Az().AB()) {
                i2 = 2;
            }
            frsDynamicRequestData.scrW = aO;
            frsDynamicRequestData.scrH = aQ;
            frsDynamicRequestData.scrDip = f;
            frsDynamicRequestData.qType = i2;
            frsDynamicRequestData.forumId = this.mForumId;
            this.dzv.Ll();
        }
    }

    public boolean BO() {
        return this.dzv.BO();
    }

    private boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        if (!bVar.userMap.isEmpty()) {
            this.dzo.userMap.putAll(bVar.userMap);
        }
        if (!v.z(bVar.threadList)) {
            this.dzo.threadList.addAll(bVar.threadList);
        }
        this.dzo.hasMore = bVar.hasMore;
        this.dzt.dtt.a(this.mType, false, this.dzw);
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
            if (this.dzw == null) {
                this.dzw = new d.a();
            }
            this.dzw.gSe = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            this.dzw.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            this.dzw.errorCode = mvcHttpResponsedMessage.getError();
            this.dzw.errorMsg = mvcHttpResponsedMessage.getErrorString();
            this.dzw.gSf = mvcHttpResponsedMessage.getDownSize();
            a(mvcHttpResponsedMessage.getData());
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<b, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsDynamicRequestData, b> mvcSocketMessage, MvcNetMessage<FrsDynamicRequestData, b> mvcNetMessage) {
        if (mvcSocketResponsedMessage != null) {
            if (this.dzw == null) {
                this.dzw = new d.a();
            }
            this.dzw.gSe = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            this.dzw.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            this.dzw.errorCode = mvcSocketResponsedMessage.getError();
            this.dzw.errorMsg = mvcSocketResponsedMessage.getErrorString();
            this.dzw.gSf = mvcSocketResponsedMessage.getDownSize();
            a(mvcSocketResponsedMessage.getData());
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
        }
    }

    public int getType() {
        return this.mType;
    }

    public b ayK() {
        return this.dzo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.dzv.cancelLoadData();
    }
}
