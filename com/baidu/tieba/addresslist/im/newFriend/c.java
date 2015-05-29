package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ NewFriendDbManagerStatic azN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewFriendDbManagerStatic newFriendDbManagerStatic) {
        this.azN = newFriendDbManagerStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, 0L, "", "", "", ""));
    }
}
