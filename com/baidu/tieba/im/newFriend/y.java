package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class y implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ String aSd;
    private final /* synthetic */ long bjb;
    final /* synthetic */ w blh;
    private final /* synthetic */ String bli;
    private final /* synthetic */ String val$key;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar, long j, String str, String str2, String str3, String str4) {
        this.blh = wVar;
        this.bjb = j;
        this.aSd = str;
        this.val$name = str2;
        this.val$key = str3;
        this.bli = str4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.bjb, this.aSd, this.val$name, this.val$key, this.bli));
    }
}
