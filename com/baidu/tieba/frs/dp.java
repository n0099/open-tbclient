package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dp extends HttpMessageListener {
    final /* synthetic */ Cdo a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dp(Cdo cdo, int i) {
        super(i);
        this.a = cdo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        dq dqVar;
        dq dqVar2;
        dq dqVar3;
        dq dqVar4;
        dq dqVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001600) {
            if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                dqVar = this.a.a;
                if (dqVar != null) {
                    dqVar2 = this.a.a;
                    dqVar2.b(null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                dqVar5 = this.a.a;
                dqVar5.a(praiseResponseMessage.getErrMsg());
                return;
            }
            dqVar3 = this.a.a;
            if (dqVar3 != null) {
                dqVar4 = this.a.a;
                dqVar4.b(praiseResponseMessage.getErrMsg());
            }
        }
    }
}
