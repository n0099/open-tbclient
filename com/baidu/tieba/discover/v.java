package com.baidu.tieba.discover;

import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.mvc.model.d<com.baidu.tieba.discover.data.a> {
    final /* synthetic */ u aEc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.aEc = uVar;
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
            xVar = this.aEc.aEb;
            if (xVar != null) {
                xVar2 = this.aEc.aEb;
                xVar2.a(false, this.aEc.Hj(), true);
            }
        } else {
            com.baidu.tieba.discover.data.a aVar = readCacheRespMsg.getData().get(0);
            xVar3 = this.aEc.aEb;
            if (xVar3 != null) {
                xVar4 = this.aEc.aEb;
                xVar4.a(false, aVar, true);
            }
            bVar = this.aEc.aEa;
            bVar.N(aVar.Hk());
        }
        yVar = this.aEc.aDZ;
        yVar.BL();
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<com.baidu.tieba.discover.data.a>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.discover.data.a> writeCacheMessage) {
    }
}
