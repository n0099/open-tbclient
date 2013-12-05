package com.baidu.tieba;

import com.baidu.tieba.data.chat.RecentChatFriendData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bc implements com.baidu.tieba.im.a<Void> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r4) {
        com.baidu.tieba.im.pushNotify.a.h().f();
        com.baidu.tieba.im.pushNotify.a.h().b((RecentChatFriendData) null);
        com.baidu.tieba.im.pushNotify.a.h().c((RecentChatFriendData) null);
        com.baidu.tieba.im.pushNotify.a.h().b(false, (com.baidu.tieba.im.a<Void>) null);
    }
}
