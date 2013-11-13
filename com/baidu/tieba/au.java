package com.baidu.tieba;

import com.baidu.tieba.data.chat.RecentChatFriendData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class au implements com.baidu.tieba.im.a<Void> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r4) {
        com.baidu.tieba.im.pushNotify.a.g().e();
        com.baidu.tieba.im.pushNotify.a.g().b((RecentChatFriendData) null);
        com.baidu.tieba.im.pushNotify.a.g().c((RecentChatFriendData) null);
        com.baidu.tieba.im.pushNotify.a.g().b(false, (com.baidu.tieba.im.a<Void>) null);
    }
}
