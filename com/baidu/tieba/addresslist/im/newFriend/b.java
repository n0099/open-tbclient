package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ NewFriendDbManagerStatic azN;
    private final /* synthetic */ com.baidu.tieba.im.data.b azO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.b bVar) {
        this.azN = newFriendDbManagerStatic;
        this.azO = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FQ */
    public Void doInBackground() {
        ba.FW().g(this.azO);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(ba.FW().FX(), true));
        return null;
    }
}
