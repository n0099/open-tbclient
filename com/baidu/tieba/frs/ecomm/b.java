package com.baidu.tieba.frs.ecomm;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.frs.ecomm.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ a bIn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, boolean z) {
        super(i, z);
        this.bIn = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        a.InterfaceC0055a interfaceC0055a;
        a.InterfaceC0055a interfaceC0055a2;
        interfaceC0055a = this.bIn.bIm;
        if (interfaceC0055a != null) {
            interfaceC0055a2 = this.bIn.bIm;
            interfaceC0055a2.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), (EcommCanSendThreadResponseMessage) httpResponsedMessage);
        }
    }
}
