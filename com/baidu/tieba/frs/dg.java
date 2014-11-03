package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dg extends HttpMessageListener {
    final /* synthetic */ df aEB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dg(df dfVar, int i) {
        super(i);
        this.aEB = dfVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        dh dhVar;
        dh dhVar2;
        dh dhVar3;
        dh dhVar4;
        dh dhVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001600) {
            if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                dhVar = this.aEB.aEx;
                if (dhVar != null) {
                    dhVar2 = this.aEB.aEx;
                    dhVar2.fb(null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                dhVar5 = this.aEB.aEx;
                dhVar5.fa(praiseResponseMessage.getErrMsg());
                return;
            }
            dhVar3 = this.aEB.aEx;
            if (dhVar3 != null) {
                dhVar4 = this.aEB.aEx;
                dhVar4.fb(praiseResponseMessage.getErrMsg());
            }
        }
    }
}
