package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ds extends HttpMessageListener {
    final /* synthetic */ dr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ds(dr drVar, int i) {
        super(i);
        this.a = drVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        dt dtVar;
        dt dtVar2;
        dt dtVar3;
        dt dtVar4;
        dt dtVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001600) {
            if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                dtVar = this.a.a;
                if (dtVar != null) {
                    dtVar2 = this.a.a;
                    dtVar2.b(null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                dtVar5 = this.a.a;
                dtVar5.a(praiseResponseMessage.getErrMsg());
                return;
            }
            dtVar3 = this.a.a;
            if (dtVar3 != null) {
                dtVar4 = this.a.a;
                dtVar4.b(praiseResponseMessage.getErrMsg());
            }
        }
    }
}
