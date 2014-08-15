package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ NewFriendDbManagerStatic a;
    private final /* synthetic */ com.baidu.tieba.im.data.k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.k kVar) {
        this.a = newFriendDbManagerStatic;
        this.b = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.db.m.a().a(this.b);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(com.baidu.tieba.im.db.m.a().b()));
        return null;
    }
}
