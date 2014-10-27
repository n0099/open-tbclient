package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class y implements com.baidu.tieba.im.a<Void> {
    private final /* synthetic */ String aOV;
    private final /* synthetic */ long bea;
    final /* synthetic */ w bgE;
    private final /* synthetic */ String bgF;
    private final /* synthetic */ String fR;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar, long j, String str, String str2, String str3, String str4) {
        this.bgE = wVar;
        this.bea = j;
        this.aOV = str;
        this.val$name = str2;
        this.fR = str3;
        this.bgF = str4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: b */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.bea, this.aOV, this.val$name, this.fR, this.bgF));
    }
}
