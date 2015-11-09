package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.model.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ a aug;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.aug = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        a.InterfaceC0052a interfaceC0052a;
        a.InterfaceC0052a interfaceC0052a2;
        this.aug.Eg = false;
        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
            ReadCacheMessage readCacheMessage = null;
            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
            }
            interfaceC0052a = this.aug.aua;
            if (interfaceC0052a != null) {
                interfaceC0052a2 = this.aug.aua;
                interfaceC0052a2.a(readCacheRespMsg, readCacheMessage);
            }
        }
    }
}
