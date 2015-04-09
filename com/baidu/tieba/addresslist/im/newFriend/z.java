package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class z implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ long ayf;
    final /* synthetic */ x ayl;
    private final /* synthetic */ String aym;
    private final /* synthetic */ String ayn;
    private final /* synthetic */ String val$key;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, long j, String str, String str2, String str3, String str4) {
        this.ayl = xVar;
        this.ayf = j;
        this.aym = str;
        this.val$name = str2;
        this.val$key = str3;
        this.ayn = str4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.ayf, this.aym, this.val$name, this.val$key, this.ayn));
    }
}
