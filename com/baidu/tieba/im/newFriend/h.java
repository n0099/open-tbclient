package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ long bhG;
    final /* synthetic */ NewFriendDbManagerStatic bjD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
        this.bjD = newFriendDbManagerStatic;
        this.bhG = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.bhG, "", "", "", ""));
    }
}
