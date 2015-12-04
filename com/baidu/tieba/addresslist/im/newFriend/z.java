package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class z implements com.baidu.tbadk.util.d<Void> {
    final /* synthetic */ x aIA;
    private final /* synthetic */ String aIB;
    private final /* synthetic */ String aIC;
    private final /* synthetic */ long aIu;
    private final /* synthetic */ String tA;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, long j, String str, String str2, String str3, String str4) {
        this.aIA = xVar;
        this.aIu = j;
        this.aIB = str;
        this.val$name = str2;
        this.tA = str3;
        this.aIC = str4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.aIu, this.aIB, this.val$name, this.tA, this.aIC));
    }
}
