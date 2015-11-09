package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a aug;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.aug = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        a.InterfaceC0052a interfaceC0052a;
        a.InterfaceC0052a interfaceC0052a2;
        this.aug.auf = false;
        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
            WriteCacheMessage writeCacheMessage = null;
            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
            }
            interfaceC0052a = this.aug.aua;
            if (interfaceC0052a != null) {
                interfaceC0052a2 = this.aug.aua;
                interfaceC0052a2.a(writeCacheRespMsg, writeCacheMessage);
            }
        }
    }
}
