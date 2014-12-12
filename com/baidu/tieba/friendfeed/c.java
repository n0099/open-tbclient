package com.baidu.tieba.friendfeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FriendFeedActivity aAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FriendFeedActivity friendFeedActivity) {
        this.aAU = friendFeedActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        y yVar;
        y yVar2;
        yVar = this.aAU.aAB;
        if (yVar.Fh() != null) {
            yVar2 = this.aAU.aAB;
            yVar2.Fh().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
