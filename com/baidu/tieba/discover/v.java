package com.baidu.tieba.discover;

import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.mvc.model.d<com.baidu.tieba.discover.data.a> {
    final /* synthetic */ u aEd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.aEd = uVar;
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(ReadCacheRespMsg<List<com.baidu.tieba.discover.data.a>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.discover.data.a> readCacheMessage) {
        x xVar;
        x xVar2;
        y yVar;
        x xVar3;
        com.baidu.tieba.discover.data.b bVar;
        x xVar4;
        if (readCacheRespMsg == null || readCacheRespMsg.getData() == null || readCacheRespMsg.getData().size() <= 0 || readCacheRespMsg.getData().get(0) == null) {
            xVar = this.aEd.aEc;
            if (xVar != null) {
                xVar2 = this.aEd.aEc;
                xVar2.a(false, this.aEd.Hk(), true);
            }
        } else {
            com.baidu.tieba.discover.data.a aVar = readCacheRespMsg.getData().get(0);
            xVar3 = this.aEd.aEc;
            if (xVar3 != null) {
                xVar4 = this.aEd.aEc;
                xVar4.a(false, aVar, true);
            }
            bVar = this.aEd.aEb;
            bVar.N(aVar.Hl());
        }
        yVar = this.aEd.aEa;
        yVar.BM();
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<com.baidu.tieba.discover.data.a>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.discover.data.a> writeCacheMessage) {
    }
}
