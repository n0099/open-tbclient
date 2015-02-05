package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class s implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ long aSb;
    final /* synthetic */ o bld;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar, long j) {
        this.bld = oVar;
        this.aSb = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.aSb, "", "", "", ""));
    }
}
