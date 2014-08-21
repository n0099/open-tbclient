package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class du extends HttpMessageListener {
    final /* synthetic */ dt a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public du(dt dtVar, int i) {
        super(i);
        this.a = dtVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        dv dvVar;
        dv dvVar2;
        dv dvVar3;
        dv dvVar4;
        dv dvVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001600) {
            if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                dvVar = this.a.a;
                if (dvVar != null) {
                    dvVar2 = this.a.a;
                    dvVar2.b(null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                dvVar5 = this.a.a;
                dvVar5.a(praiseResponseMessage.getErrMsg());
                return;
            }
            dvVar3 = this.a.a;
            if (dvVar3 != null) {
                dvVar4 = this.a.a;
                dvVar4.b(praiseResponseMessage.getErrMsg());
            }
        }
    }
}
