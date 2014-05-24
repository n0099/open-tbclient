package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.tieba.frs.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo extends HttpMessageListener {
    final /* synthetic */ dn a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cdo(dn dnVar, int i) {
        super(i);
        this.a = dnVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        dp dpVar;
        dp dpVar2;
        dp dpVar3;
        dp dpVar4;
        dp dpVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1015000) {
            if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                dpVar = this.a.a;
                if (dpVar != null) {
                    dpVar2 = this.a.a;
                    dpVar2.b(null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                dpVar5 = this.a.a;
                dpVar5.a(praiseResponseMessage.getErrMsg());
                return;
            }
            dpVar3 = this.a.a;
            if (dpVar3 != null) {
                dpVar4 = this.a.a;
                dpVar4.b(praiseResponseMessage.getErrMsg());
            }
        }
    }
}
