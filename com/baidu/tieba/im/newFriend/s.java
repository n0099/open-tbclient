package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.im.a<Void> {
    private final /* synthetic */ long aPi;
    final /* synthetic */ o bgP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar, long j) {
        this.bgP = oVar;
        this.aPi = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: b */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.aPi, "", "", "", ""));
    }
}
