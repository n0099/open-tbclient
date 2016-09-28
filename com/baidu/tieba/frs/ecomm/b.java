package com.baidu.tieba.frs.ecomm;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.frs.ecomm.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ a bUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, boolean z) {
        super(i, z);
        this.bUE = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        a.InterfaceC0061a interfaceC0061a;
        a.InterfaceC0061a interfaceC0061a2;
        interfaceC0061a = this.bUE.bUD;
        if (interfaceC0061a != null) {
            interfaceC0061a2 = this.bUE.bUD;
            interfaceC0061a2.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), (EcommCanSendThreadResponseMessage) httpResponsedMessage);
        }
    }
}
