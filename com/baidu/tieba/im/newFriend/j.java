package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ long bjb;
    final /* synthetic */ NewFriendDbManagerStatic bla;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
        this.bla = newFriendDbManagerStatic;
        this.bjb = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.bjb, "", "", "", ""));
    }
}
