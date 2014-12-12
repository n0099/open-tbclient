package com.baidu.tieba.discover;

import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.mvc.model.d<com.baidu.tieba.discover.data.a> {
    final /* synthetic */ p atd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.atd = pVar;
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
            sVar = this.atd.atc;
            if (sVar != null) {
                sVar2 = this.atd.atc;
                sVar2.a(false, this.atd.CM(), true);
            }
        } else {
            com.baidu.tieba.discover.data.a aVar = readCacheRespMsg.getData().get(0);
            sVar3 = this.atd.atc;
            if (sVar3 != null) {
                sVar4 = this.atd.atc;
                sVar4.a(false, aVar, true);
            }
            bVar = this.atd.atb;
            bVar.H(aVar.CN());
        }
        tVar = this.atd.ata;
        tVar.xv();
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<com.baidu.tieba.discover.data.a>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.discover.data.a> writeCacheMessage) {
    }
}
