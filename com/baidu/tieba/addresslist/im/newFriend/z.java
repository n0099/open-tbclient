package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class z implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ long axX;
    final /* synthetic */ x ayd;
    private final /* synthetic */ String aye;
    private final /* synthetic */ String ayf;
    private final /* synthetic */ String val$key;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, long j, String str, String str2, String str3, String str4) {
        this.ayd = xVar;
        this.axX = j;
        this.aye = str;
        this.val$name = str2;
        this.val$key = str3;
        this.ayf = str4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.axX, this.aye, this.val$name, this.val$key, this.ayf));
    }
}
