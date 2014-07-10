package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ NewFriendDbManagerStatic b;
    private final /* synthetic */ long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
        this.b = newFriendDbManagerStatic;
        this.c = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.db.n.a().a(this.c);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(com.baidu.tieba.im.db.n.a().b()));
        return null;
    }
}
