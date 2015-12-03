package com.baidu.tieba.discover;

import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.a;
import com.baidu.tieba.discover.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements a.InterfaceC0054a<com.baidu.tieba.discover.data.a> {
    final /* synthetic */ t aOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.aOn = tVar;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(ReadCacheRespMsg<List<com.baidu.tieba.discover.data.a>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.discover.data.a> readCacheMessage) {
        t.a aVar;
        t.a aVar2;
        w wVar;
        t.a aVar3;
        com.baidu.tieba.discover.data.b bVar;
        t.a aVar4;
        if (readCacheRespMsg == null || readCacheRespMsg.getData() == null || readCacheRespMsg.getData().size() <= 0 || readCacheRespMsg.getData().get(0) == null) {
            aVar = this.aOn.aOm;
            if (aVar != null) {
                aVar2 = this.aOn.aOm;
                aVar2.a(false, this.aOn.IT(), true);
            }
        } else {
            com.baidu.tieba.discover.data.a aVar5 = readCacheRespMsg.getData().get(0);
            aVar3 = this.aOn.aOm;
            if (aVar3 != null) {
                aVar4 = this.aOn.aOm;
                aVar4.a(false, aVar5, true);
            }
            bVar = this.aOn.aOl;
            bVar.ap(aVar5.IU());
        }
        wVar = this.aOn.aOk;
        wVar.DJ();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(WriteCacheRespMsg<List<com.baidu.tieba.discover.data.a>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.discover.data.a> writeCacheMessage) {
    }
}
