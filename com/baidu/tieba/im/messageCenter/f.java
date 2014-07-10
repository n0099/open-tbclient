package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r4) {
        com.baidu.tieba.im.pushNotify.a.i().g();
        com.baidu.tieba.im.pushNotify.a.i().b((ImMessageCenterShowItemData) null);
        com.baidu.tieba.im.pushNotify.a.i().d((ImMessageCenterShowItemData) null);
        com.baidu.tieba.im.pushNotify.a.i().c((ImMessageCenterShowItemData) null);
        com.baidu.tieba.im.pushNotify.a.i().b(false, (com.baidu.tieba.im.a<Void>) null);
    }
}
