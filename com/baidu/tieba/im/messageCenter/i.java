package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.im.a<Integer> {
    final /* synthetic */ g a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, boolean z) {
        this.a = gVar;
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Integer num) {
        com.baidu.tieba.im.b.e.a.set(true);
        com.baidu.tieba.im.c.b.b().a();
        com.baidu.tieba.im.live.d.b().a();
        if (!this.b) {
            com.baidu.tieba.im.e.a(null, null);
            com.baidu.tieba.im.i.b();
            com.baidu.tieba.im.db.p.d().c();
            com.baidu.tieba.im.db.o.d().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2005014));
        }
    }
}
