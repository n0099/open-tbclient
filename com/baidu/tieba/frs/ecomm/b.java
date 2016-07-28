package com.baidu.tieba.frs.ecomm;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.frs.ecomm.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ a bJI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, boolean z) {
        super(i, z);
        this.bJI = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        a.InterfaceC0056a interfaceC0056a;
        a.InterfaceC0056a interfaceC0056a2;
        interfaceC0056a = this.bJI.bJH;
        if (interfaceC0056a != null) {
            interfaceC0056a2 = this.bJI.bJH;
            interfaceC0056a2.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), (EcommCanSendThreadResponseMessage) httpResponsedMessage);
        }
    }
}
