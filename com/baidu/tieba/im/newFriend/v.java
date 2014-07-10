package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ NewFriendDbManagerStatic a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NewFriendDbManagerStatic newFriendDbManagerStatic) {
        this.a = newFriendDbManagerStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, 0L, "", "", "", ""));
    }
}
