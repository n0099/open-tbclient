package com.baidu.tieba.frs.ecomm;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.frs.ecomm.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ a bXM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, boolean z) {
        super(i, z);
        this.bXM = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        a.InterfaceC0060a interfaceC0060a;
        a.InterfaceC0060a interfaceC0060a2;
        interfaceC0060a = this.bXM.bXL;
        if (interfaceC0060a != null) {
            interfaceC0060a2 = this.bXM.bXL;
            interfaceC0060a2.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), (EcommCanSendThreadResponseMessage) httpResponsedMessage);
        }
    }
}
