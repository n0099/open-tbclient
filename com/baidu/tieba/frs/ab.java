package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
class ab extends HttpMessageListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(FrsActivity frsActivity, int i) {
        super(i);
        this.a = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        di diVar;
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
            diVar = this.a.ah;
            diVar.a(frsPageHttpResponseMessage.getUpdateType(), false, jVar);
            aVar = this.a.G;
            if (aVar != null) {
                aVar2 = this.a.G;
                aVar2.a(true, jVar.b, jVar.c, jVar.d, jVar.e);
                this.a.G = null;
            }
        }
    }
}
