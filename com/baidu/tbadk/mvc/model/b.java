package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.model.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ a awg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.awg = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        a.InterfaceC0046a interfaceC0046a;
        a.InterfaceC0046a interfaceC0046a2;
        this.awg.vx = false;
        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
            ReadCacheMessage readCacheMessage = null;
            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
            }
            interfaceC0046a = this.awg.awa;
            if (interfaceC0046a != null) {
                interfaceC0046a2 = this.awg.awa;
                interfaceC0046a2.a(readCacheRespMsg, readCacheMessage);
            }
        }
    }
}
