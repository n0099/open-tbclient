package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
final class e implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.a = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Void r4) {
        com.baidu.tieba.im.pushNotify.a.d().b();
        com.baidu.tieba.im.pushNotify.a.d().a((ImMessageCenterShowItemData) null);
        com.baidu.tieba.im.pushNotify.a.d().b((ImMessageCenterShowItemData) null);
        com.baidu.tieba.im.pushNotify.a.d().b(false, null);
    }
}
