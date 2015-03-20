package com.baidu.tieba.friendFeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FriendFeedActivity aHM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FriendFeedActivity friendFeedActivity) {
        this.aHM = friendFeedActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        y yVar;
        y yVar2;
        yVar = this.aHM.aHt;
        if (yVar.IY() != null) {
            yVar2 = this.aHM.aHt;
            yVar2.IY().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
