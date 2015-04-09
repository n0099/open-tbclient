package com.baidu.tieba.friendFeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FriendFeedActivity aHU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FriendFeedActivity friendFeedActivity) {
        this.aHU = friendFeedActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        y yVar;
        y yVar2;
        yVar = this.aHU.aHB;
        if (yVar.Je() != null) {
            yVar2 = this.aHU.aHB;
            yVar2.Je().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
