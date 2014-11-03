package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class aa implements com.baidu.tieba.im.a<Void> {
    private final /* synthetic */ long aPi;
    final /* synthetic */ w bgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar, long j) {
        this.bgS = wVar;
        this.aPi = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: b */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.aPi, "", "", "", ""));
    }
}
