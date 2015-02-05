package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class y implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ String aSc;
    private final /* synthetic */ long bja;
    final /* synthetic */ w blg;
    private final /* synthetic */ String blh;
    private final /* synthetic */ String val$key;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar, long j, String str, String str2, String str3, String str4) {
        this.blg = wVar;
        this.bja = j;
        this.aSc = str;
        this.val$name = str2;
        this.val$key = str3;
        this.blh = str4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.bja, this.aSc, this.val$name, this.val$key, this.blh));
    }
}
