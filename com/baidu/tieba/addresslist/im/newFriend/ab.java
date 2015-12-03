package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class ab implements com.baidu.tbadk.util.d<Void> {
    final /* synthetic */ x aIA;
    private final /* synthetic */ long aIy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar, long j) {
        this.aIA = xVar;
        this.aIy = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.aIy, "", "", "", ""));
    }
}
