package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
class x extends HttpMessageListener {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(FrsActivity frsActivity, int i) {
        super(i);
        this.aBk = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: b */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        dd ddVar;
        com.baidu.tieba.b.a aVar;
        com.baidu.tieba.b.a aVar2;
        if (httpResponsedMessage instanceof FrsPageHttpResponseMessage) {
            FrsPageHttpResponseMessage frsPageHttpResponseMessage = (FrsPageHttpResponseMessage) httpResponsedMessage;
            e eVar = new e();
            eVar.aAc = frsPageHttpResponseMessage.getError() < -13 || frsPageHttpResponseMessage.getError() > -10;
            eVar.isSuccess = !frsPageHttpResponseMessage.hasNetworkError();
            eVar.errorCode = frsPageHttpResponseMessage.getError();
            eVar.errorMsg = frsPageHttpResponseMessage.getErrorString();
            eVar.aAd = frsPageHttpResponseMessage.getDownSize();
            ddVar = this.aBk.aAT;
            ddVar.a(frsPageHttpResponseMessage.getUpdateType(), false, eVar);
            aVar = this.aBk.aAE;
            if (aVar != null) {
                aVar2 = this.aBk.aAE;
                aVar2.a(true, eVar.isSuccess, eVar.errorCode, eVar.errorMsg, eVar.aAd);
                this.aBk.aAE = null;
            }
        }
    }
}
