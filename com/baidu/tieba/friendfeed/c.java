package com.baidu.tieba.friendfeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FriendFeedActivity ayL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FriendFeedActivity friendFeedActivity) {
        this.ayL = friendFeedActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        y yVar;
        y yVar2;
        yVar = this.ayL.ayq;
        if (yVar.EO() != null) {
            yVar2 = this.ayL.ayq;
            yVar2.EO().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
