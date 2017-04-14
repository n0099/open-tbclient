package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    final /* synthetic */ CacheModel aEy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(CacheModel cacheModel, int i) {
        super(i);
        this.aEy = cacheModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        CacheModel.a aVar;
        CacheModel.a aVar2;
        this.aEy.EQ = false;
        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
            ReadCacheMessage readCacheMessage = null;
            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
            }
            aVar = this.aEy.aEs;
            if (aVar != null) {
                aVar2 = this.aEy.aEs;
                aVar2.a(readCacheRespMsg, readCacheMessage);
            }
        }
    }
}
