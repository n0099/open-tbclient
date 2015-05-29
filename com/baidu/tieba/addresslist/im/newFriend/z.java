package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class z implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ long azQ;
    final /* synthetic */ x azW;
    private final /* synthetic */ String azX;
    private final /* synthetic */ String azY;
    private final /* synthetic */ String val$key;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, long j, String str, String str2, String str3, String str4) {
        this.azW = xVar;
        this.azQ = j;
        this.azX = str;
        this.val$name = str2;
        this.val$key = str3;
        this.azY = str4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.azQ, this.azX, this.val$name, this.val$key, this.azY));
    }
}
