package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
class ae extends HttpMessageListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(FrsActivity frsActivity, int i) {
        super(i);
        this.a = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        dl dlVar;
        com.baidu.tieba.b.a aVar;
        com.baidu.tieba.b.a aVar2;
        if (httpResponsedMessage instanceof FrsPageHttpResponseMessage) {
            FrsPageHttpResponseMessage frsPageHttpResponseMessage = (FrsPageHttpResponseMessage) httpResponsedMessage;
            j jVar = new j();
            jVar.a = frsPageHttpResponseMessage.getError() < -13 || frsPageHttpResponseMessage.getError() > -10;
            jVar.b = !frsPageHttpResponseMessage.hasNetworkError();
            jVar.c = frsPageHttpResponseMessage.getError();
            jVar.d = frsPageHttpResponseMessage.getErrorString();
            jVar.e = frsPageHttpResponseMessage.getDownSize();
            dlVar = this.a.aj;
            dlVar.a(frsPageHttpResponseMessage.getUpdateType(), false, jVar);
            aVar = this.a.K;
            if (aVar != null) {
                boolean z = frsPageHttpResponseMessage.getError() == 0;
                aVar2 = this.a.K;
                aVar2.a(true, z, frsPageHttpResponseMessage.getError(), frsPageHttpResponseMessage.getErrorString(), frsPageHttpResponseMessage.getDownSize(), frsPageHttpResponseMessage.getCostTime(), 0L);
                this.a.K = null;
            }
        }
    }
}
