package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ long bja;
    final /* synthetic */ NewFriendDbManagerStatic bkZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
        this.bkZ = newFriendDbManagerStatic;
        this.bja = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.bja, "", "", "", ""));
    }
}
