package com.baidu.tieba.chosen.posts;

import android.support.v4.app.FragmentTransaction;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.InterfaceC0054a<com.baidu.tieba.chosen.posts.request.d> {
    final /* synthetic */ b aNh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aNh = bVar;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(ReadCacheRespMsg<List<com.baidu.tieba.chosen.posts.request.d>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.chosen.posts.request.d> readCacheMessage) {
        com.baidu.tieba.chosen.posts.request.c cVar;
        com.baidu.tieba.chosen.posts.request.b bVar;
        com.baidu.tieba.chosen.posts.request.d dVar;
        ChosenPostActivity chosenPostActivity;
        List<com.baidu.tieba.chosen.posts.request.d> data = readCacheRespMsg.getData();
        if (data != null && !data.isEmpty() && (dVar = data.get(0)) != null) {
            com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(FragmentTransaction.TRANSIT_FRAGMENT_FADE, dVar, null, null);
            bVar2.setUniqueId(this.aNh.getUniqueId());
            chosenPostActivity = this.aNh.aNa;
            chosenPostActivity.oM().dispatchMvcEvent(bVar2);
        }
        cVar = this.aNh.aNe;
        cVar.ID();
        bVar = this.aNh.aNb;
        bVar.DJ();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(WriteCacheRespMsg<List<com.baidu.tieba.chosen.posts.request.d>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.chosen.posts.request.d> writeCacheMessage) {
    }
}
