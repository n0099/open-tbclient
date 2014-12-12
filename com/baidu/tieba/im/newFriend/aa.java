package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class aa implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ long aQT;
    final /* synthetic */ w bjK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar, long j) {
        this.bjK = wVar;
        this.aQT = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.aQT, "", "", "", ""));
    }
}
