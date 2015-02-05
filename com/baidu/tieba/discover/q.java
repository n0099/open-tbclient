package com.baidu.tieba.discover;

import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.mvc.model.d<com.baidu.tieba.discover.data.a> {
    final /* synthetic */ p auh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.auh = pVar;
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(ReadCacheRespMsg<List<com.baidu.tieba.discover.data.a>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.discover.data.a> readCacheMessage) {
        s sVar;
        s sVar2;
        t tVar;
        s sVar3;
        com.baidu.tieba.discover.data.b bVar;
        s sVar4;
        if (readCacheRespMsg == null || readCacheRespMsg.getData() == null || readCacheRespMsg.getData().size() <= 0 || readCacheRespMsg.getData().get(0) == null) {
            sVar = this.auh.aug;
            if (sVar != null) {
                sVar2 = this.auh.aug;
                sVar2.a(false, this.auh.Df(), true);
            }
        } else {
            com.baidu.tieba.discover.data.a aVar = readCacheRespMsg.getData().get(0);
            sVar3 = this.auh.aug;
            if (sVar3 != null) {
                sVar4 = this.auh.aug;
                sVar4.a(false, aVar, true);
            }
            bVar = this.auh.auf;
            bVar.H(aVar.Dg());
        }
        tVar = this.auh.aue;
        tVar.xF();
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<com.baidu.tieba.discover.data.a>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.discover.data.a> writeCacheMessage) {
    }
}
