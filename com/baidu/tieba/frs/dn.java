package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn extends HttpMessageListener {
    final /* synthetic */ dm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dn(dm dmVar, int i) {
        super(i);
        this.a = dmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        Cdo cdo;
        Cdo cdo2;
        Cdo cdo3;
        Cdo cdo4;
        Cdo cdo5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1015000) {
            if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                cdo = this.a.a;
                if (cdo != null) {
                    cdo2 = this.a.a;
                    cdo2.b(null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                cdo5 = this.a.a;
                cdo5.a(praiseResponseMessage.getErrMsg());
                return;
            }
            cdo3 = this.a.a;
            if (cdo3 != null) {
                cdo4 = this.a.a;
                cdo4.b(praiseResponseMessage.getErrMsg());
            }
        }
    }
}
