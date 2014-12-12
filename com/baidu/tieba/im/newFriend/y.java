package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class y implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ String aQU;
    private final /* synthetic */ long bhG;
    final /* synthetic */ w bjK;
    private final /* synthetic */ String bjL;
    private final /* synthetic */ String val$key;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar, long j, String str, String str2, String str3, String str4) {
        this.bjK = wVar;
        this.bhG = j;
        this.aQU = str;
        this.val$name = str2;
        this.val$key = str3;
        this.bjL = str4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.bhG, this.aQU, this.val$name, this.val$key, this.bjL));
    }
}
