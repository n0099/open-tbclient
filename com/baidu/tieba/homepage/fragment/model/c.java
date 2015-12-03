package com.baidu.tieba.homepage.fragment.model;

import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.a;
import com.baidu.tieba.homepage.fragment.model.b;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.InterfaceC0054a<com.baidu.tieba.homepage.fragment.data.b> {
    final /* synthetic */ b byA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.byA = bVar;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(ReadCacheRespMsg<List<com.baidu.tieba.homepage.fragment.data.b>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.homepage.fragment.data.b> readCacheMessage) {
        b.a aVar;
        b.a aVar2;
        b.a aVar3;
        b.a aVar4;
        String cacheKey = (readCacheMessage == null || readCacheMessage.getRequestData() == null || !(readCacheMessage.getRequestData() instanceof com.baidu.tieba.homepage.fragment.data.a)) ? null : ((com.baidu.tieba.homepage.fragment.data.a) readCacheMessage.getRequestData()).getCacheKey();
        if (cacheKey != null) {
            if (readCacheRespMsg == null || readCacheRespMsg.getData() == null || readCacheRespMsg.getData().size() <= 0 || readCacheRespMsg.getData().get(0) == null) {
                aVar = this.byA.byu;
                if (aVar != null) {
                    aVar2 = this.byA.byu;
                    aVar2.a(false, cacheKey, null);
                }
            } else {
                com.baidu.tieba.homepage.fragment.data.b bVar = readCacheRespMsg.getData().get(0);
                aVar3 = this.byA.byu;
                if (aVar3 != null) {
                    aVar4 = this.byA.byu;
                    aVar4.a(false, cacheKey, bVar);
                }
            }
            this.byA.Hx();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(WriteCacheRespMsg<List<com.baidu.tieba.homepage.fragment.data.b>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.homepage.fragment.data.b> writeCacheMessage) {
    }
}
