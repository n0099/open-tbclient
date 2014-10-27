package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ NewFriendDbManagerStatic bgx;
    private final /* synthetic */ com.baidu.tieba.im.data.e bgy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.e eVar) {
        this.bgx = newFriendDbManagerStatic;
        this.bgy = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kb */
    public Void doInBackground() {
        com.baidu.tieba.im.db.m.MK().a(this.bgy);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(com.baidu.tieba.im.db.m.MK().ML()));
        return null;
    }
}
