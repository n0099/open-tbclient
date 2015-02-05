package com.baidu.tieba.friendfeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FriendFeedActivity aBS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FriendFeedActivity friendFeedActivity) {
        this.aBS = friendFeedActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        x xVar;
        x xVar2;
        xVar = this.aBS.aBA;
        if (xVar.Fz() != null) {
            xVar2 = this.aBS.aBA;
            xVar2.Fz().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
