package com.baidu.tieba.friendfeed;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FriendFeedActivity aAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FriendFeedActivity friendFeedActivity) {
        this.aAU = friendFeedActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.i iVar;
        y yVar;
        com.baidu.tieba.tbadkCore.location.d dVar;
        y yVar2;
        y yVar3;
        if (UtilHelper.isNetOk()) {
            yVar = this.aAU.aAB;
            if (yVar.Fh() != null) {
                yVar2 = this.aAU.aAB;
                yVar2.Fh().setLocationInfoViewState(1);
                yVar3 = this.aAU.aAB;
                yVar3.Fh().setLocationViewVisibility(0);
            }
            dVar = this.aAU.aAD;
            dVar.ahG();
        } else {
            iVar = this.aAU.aAO;
            iVar.EZ();
        }
        aVar.dismiss();
    }
}
