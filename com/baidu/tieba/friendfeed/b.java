package com.baidu.tieba.friendfeed;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FriendFeedActivity ayL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FriendFeedActivity friendFeedActivity) {
        this.ayL = friendFeedActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.location.i iVar;
        y yVar;
        com.baidu.tieba.location.d dVar;
        y yVar2;
        y yVar3;
        if (UtilHelper.isNetOk()) {
            yVar = this.ayL.ayq;
            if (yVar.EO() != null) {
                yVar2 = this.ayL.ayq;
                yVar2.EO().setLocationInfoViewState(1);
                yVar3 = this.ayL.ayq;
                yVar3.EO().setLocationViewVisibility(0);
            }
            dVar = this.ayL.ays;
            dVar.Sw();
        } else {
            iVar = this.ayL.ayD;
            iVar.EG();
        }
        aVar.dismiss();
    }
}
