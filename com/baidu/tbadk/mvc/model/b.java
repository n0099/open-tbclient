package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ CacheModel aFG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(CacheModel cacheModel, int i) {
        super(i);
        this.aFG = cacheModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        CacheModel.a aVar;
        CacheModel.a aVar2;
        this.aFG.aFF = false;
        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
            WriteCacheMessage writeCacheMessage = null;
            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
            }
            aVar = this.aFG.aFA;
            if (aVar != null) {
                aVar2 = this.aFG.aFA;
                aVar2.a(writeCacheRespMsg, writeCacheMessage);
            }
        }
    }
}
