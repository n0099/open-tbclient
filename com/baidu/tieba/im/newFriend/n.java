package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tieba.im.a<Void> {
    private final /* synthetic */ long beo;
    final /* synthetic */ NewFriendDbManagerStatic bgL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
        this.bgL = newFriendDbManagerStatic;
        this.beo = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: b */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.beo, "", "", "", ""));
    }
}
