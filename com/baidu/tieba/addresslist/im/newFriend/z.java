package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class z implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ long azR;
    final /* synthetic */ x azX;
    private final /* synthetic */ String azY;
    private final /* synthetic */ String azZ;
    private final /* synthetic */ String val$key;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, long j, String str, String str2, String str3, String str4) {
        this.azX = xVar;
        this.azR = j;
        this.azY = str;
        this.val$name = str2;
        this.val$key = str3;
        this.azZ = str4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.azR, this.azY, this.val$name, this.val$key, this.azZ));
    }
}
