package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.im.a<Integer> {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.a = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Integer num) {
        com.baidu.tieba.im.live.b.b().a();
        com.baidu.tieba.im.e.a(null, null);
        com.baidu.tieba.im.i.b();
        com.baidu.tieba.im.db.o.d().c();
        com.baidu.tieba.im.db.n.d().c();
        MessageManager.getInstance().sendMessage(new CustomMessage(2007014));
    }
}
