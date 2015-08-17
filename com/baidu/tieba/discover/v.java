package com.baidu.tieba.discover;

import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.a;
import com.baidu.tieba.discover.u;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements a.InterfaceC0052a<com.baidu.tieba.discover.data.a> {
    final /* synthetic */ u aLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.aLC = uVar;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(ReadCacheRespMsg<List<com.baidu.tieba.discover.data.a>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.discover.data.a> readCacheMessage) {
        u.a aVar;
        u.a aVar2;
        x xVar;
        u.a aVar3;
        com.baidu.tieba.discover.data.b bVar;
        u.a aVar4;
        if (readCacheRespMsg == null || readCacheRespMsg.getData() == null || readCacheRespMsg.getData().size() <= 0 || readCacheRespMsg.getData().get(0) == null) {
            aVar = this.aLC.aLB;
            if (aVar != null) {
                aVar2 = this.aLC.aLB;
                aVar2.a(false, this.aLC.HZ(), true);
            }
        } else {
            com.baidu.tieba.discover.data.a aVar5 = readCacheRespMsg.getData().get(0);
            aVar3 = this.aLC.aLB;
            if (aVar3 != null) {
                aVar4 = this.aLC.aLB;
                aVar4.a(false, aVar5, true);
            }
            bVar = this.aLC.aLA;
            bVar.P(aVar5.Ia());
        }
        xVar = this.aLC.aLz;
        xVar.CV();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(WriteCacheRespMsg<List<com.baidu.tieba.discover.data.a>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.discover.data.a> writeCacheMessage) {
    }
}
