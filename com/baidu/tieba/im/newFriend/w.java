package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ NewFriendDbManagerStatic b;
    private final /* synthetic */ com.baidu.tieba.im.data.k c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.k kVar) {
        this.b = newFriendDbManagerStatic;
        this.c = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        if (this.c != null) {
            com.baidu.tieba.im.db.n.a().b(this.c);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(com.baidu.tieba.im.db.n.a().b()));
        }
        return null;
    }
}
