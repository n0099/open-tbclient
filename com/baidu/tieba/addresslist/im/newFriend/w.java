package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.util.d<Void> {
    private final /* synthetic */ long aIu;
    final /* synthetic */ u aIz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, long j) {
        this.aIz = uVar;
        this.aIu = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(1, this.aIu, "", "", "", ""));
    }
}
