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
        dh dhVar;
        if (httpResponsedMessage instanceof FrsPageHttpResponseMessage) {
            FrsPageHttpResponseMessage frsPageHttpResponseMessage = (FrsPageHttpResponseMessage) httpResponsedMessage;
            j jVar = new j();
            jVar.a = true;
            jVar.b = frsPageHttpResponseMessage.hasNetworkError() ? false : true;
            jVar.c = frsPageHttpResponseMessage.getError();
            jVar.d = frsPageHttpResponseMessage.getErrorString();
            jVar.e = frsPageHttpResponseMessage.getDownSize();
            dhVar = this.a.ad;
            dhVar.a(frsPageHttpResponseMessage.getUpdateType(), false, jVar);
        }
    }
}
