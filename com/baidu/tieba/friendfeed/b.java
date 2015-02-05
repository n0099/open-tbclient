package com.baidu.tieba.friendfeed;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FriendFeedActivity aBS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FriendFeedActivity friendFeedActivity) {
        this.aBS = friendFeedActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.i iVar;
        x xVar;
        com.baidu.tieba.tbadkCore.location.d dVar;
        x xVar2;
        x xVar3;
        if (UtilHelper.isNetOk()) {
            xVar = this.aBS.aBA;
            if (xVar.Fz() != null) {
                xVar2 = this.aBS.aBA;
                xVar2.Fz().setLocationInfoViewState(1);
                xVar3 = this.aBS.aBA;
                xVar3.Fz().setLocationViewVisibility(0);
            }
            dVar = this.aBS.aBC;
            dVar.aif();
        } else {
            iVar = this.aBS.aBN;
            iVar.Fr();
        }
        aVar.dismiss();
    }
}
