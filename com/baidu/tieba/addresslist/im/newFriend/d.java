package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.util.m<Void> {
    final /* synthetic */ NewFriendDbManagerStatic aIr;
    private final /* synthetic */ com.baidu.tieba.im.data.b aIs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.b bVar) {
        this.aIr = newFriendDbManagerStatic;
        this.aIs = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Hl */
    public Void doInBackground() {
        aw.Hr().g(this.aIs);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(aw.Hr().Hs(), true));
        return null;
    }
}
