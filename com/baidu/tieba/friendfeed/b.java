package com.baidu.tieba.friendfeed;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FriendFeedActivity ayU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FriendFeedActivity friendFeedActivity) {
        this.ayU = friendFeedActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.location.i iVar;
        y yVar;
        com.baidu.tieba.location.d dVar;
        y yVar2;
        y yVar3;
        if (UtilHelper.isNetOk()) {
            yVar = this.ayU.ayz;
            if (yVar.EQ() != null) {
                yVar2 = this.ayU.ayz;
                yVar2.EQ().setLocationInfoViewState(1);
                yVar3 = this.ayU.ayz;
                yVar3.EQ().setLocationViewVisibility(0);
            }
            dVar = this.ayU.ayB;
            dVar.Sz();
        } else {
            iVar = this.ayU.ayM;
            iVar.EI();
        }
        aVar.dismiss();
    }
}
