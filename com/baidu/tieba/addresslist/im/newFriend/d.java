package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ NewFriendDbManagerStatic ayc;
    private final /* synthetic */ com.baidu.tieba.im.data.b ayd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.b bVar) {
        this.ayc = newFriendDbManagerStatic;
        this.ayd = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: EX */
    public Void doInBackground() {
        ba.Fd().g(this.ayd);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(ba.Fd().Fe(), true));
        return null;
    }
}
