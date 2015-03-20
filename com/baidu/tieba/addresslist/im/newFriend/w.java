package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ long axX;
    final /* synthetic */ u ayc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, long j) {
        this.ayc = uVar;
        this.axX = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(1, this.axX, "", "", "", ""));
    }
}
