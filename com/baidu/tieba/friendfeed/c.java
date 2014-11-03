package com.baidu.tieba.friendfeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FriendFeedActivity ayU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FriendFeedActivity friendFeedActivity) {
        this.ayU = friendFeedActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        y yVar;
        y yVar2;
        yVar = this.ayU.ayz;
        if (yVar.EQ() != null) {
            yVar2 = this.ayU.ayz;
            yVar2.EQ().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
