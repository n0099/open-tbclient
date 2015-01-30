package com.baidu.tieba.friendfeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FriendFeedActivity aBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FriendFeedActivity friendFeedActivity) {
        this.aBV = friendFeedActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        x xVar;
        x xVar2;
        xVar = this.aBV.aBD;
        if (xVar.FF() != null) {
            xVar2 = this.aBV.aBD;
            xVar2.FF().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
