package com.baidu.tieba.homepage.framework;

import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.a;
import com.baidu.tieba.homepage.framework.q;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements a.InterfaceC0047a<com.baidu.tieba.homepage.recommendfrs.data.c> {
    final /* synthetic */ q cHW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.cHW = qVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc  */
    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ReadCacheRespMsg<List<com.baidu.tieba.homepage.recommendfrs.data.c>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.homepage.recommendfrs.data.c> readCacheMessage) {
        int i;
        long j;
        q.a aVar;
        q.a aVar2;
        q.a aVar3;
        q.a aVar4;
        if (readCacheMessage != null) {
            if (readCacheMessage.getRequestData() instanceof com.baidu.tieba.homepage.recommendfrs.data.b) {
                i = 2;
                j = ((com.baidu.tieba.homepage.recommendfrs.data.b) readCacheMessage.getRequestData()).aoo();
            } else if (readCacheMessage.getRequestData() instanceof com.baidu.tieba.homepage.mygod.data.c) {
                i = 3;
                j = ((com.baidu.tieba.homepage.mygod.data.c) readCacheMessage.getRequestData()).aoo();
            }
            if (j < 0 && readCacheMessage != null && readCacheRespMsg != null) {
                com.baidu.tbadk.core.log.b.a("frs", readCacheMessage.getClientLogID(), CmdConfigCustom.CMD_RECOMMEND_FRS_READ_CACHE, "readCache", readCacheRespMsg.getError(), "ReadCacheError ContentTag is Null", "ContentTag", Long.valueOf(j));
            }
            if (readCacheRespMsg != null || readCacheRespMsg.getData() == null || readCacheRespMsg.getData().size() <= 0 || readCacheRespMsg.getData().get(0) == null) {
                aVar = this.cHW.cHn;
                if (aVar != null) {
                    aVar2 = this.cHW.cHn;
                    aVar2.a(false, null, false, j, "", false);
                }
            } else {
                com.baidu.tieba.homepage.recommendfrs.data.c cVar = readCacheRespMsg.getData().get(0);
                aVar3 = this.cHW.cHn;
                if (aVar3 != null) {
                    aVar4 = this.cHW.cHn;
                    aVar4.a(false, cVar, false, j, "", false);
                }
            }
            this.cHW.a(1, j, i, 0L, 0L, "", "");
        }
        i = 0;
        j = -1;
        if (j < 0) {
            com.baidu.tbadk.core.log.b.a("frs", readCacheMessage.getClientLogID(), CmdConfigCustom.CMD_RECOMMEND_FRS_READ_CACHE, "readCache", readCacheRespMsg.getError(), "ReadCacheError ContentTag is Null", "ContentTag", Long.valueOf(j));
        }
        if (readCacheRespMsg != null) {
        }
        aVar = this.cHW.cHn;
        if (aVar != null) {
        }
        this.cHW.a(1, j, i, 0L, 0L, "", "");
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(WriteCacheRespMsg<List<com.baidu.tieba.homepage.recommendfrs.data.c>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.homepage.recommendfrs.data.c> writeCacheMessage) {
    }
}
