package com.baidu.tieba.friendfeed;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FriendFeedActivity aBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FriendFeedActivity friendFeedActivity) {
        this.aBV = friendFeedActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.i iVar;
        x xVar;
        com.baidu.tieba.tbadkCore.location.d dVar;
        x xVar2;
        x xVar3;
        if (UtilHelper.isNetOk()) {
            xVar = this.aBV.aBD;
            if (xVar.FF() != null) {
                xVar2 = this.aBV.aBD;
                xVar2.FF().setLocationInfoViewState(1);
                xVar3 = this.aBV.aBD;
                xVar3.FF().setLocationViewVisibility(0);
            }
            dVar = this.aBV.aBF;
            dVar.aik();
        } else {
            iVar = this.aBV.aBQ;
            iVar.Fx();
        }
        aVar.dismiss();
    }
}
