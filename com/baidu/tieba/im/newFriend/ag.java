package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ NewFriendDbManagerStatic bla;
    private final /* synthetic */ com.baidu.tieba.im.data.b blb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.b bVar) {
        this.bla = newFriendDbManagerStatic;
        this.blb = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KK */
    public Void doInBackground() {
        com.baidu.tieba.im.db.m.Ne().b(this.blb);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(com.baidu.tieba.im.db.m.Ne().Nf(), true));
        return null;
    }
}
