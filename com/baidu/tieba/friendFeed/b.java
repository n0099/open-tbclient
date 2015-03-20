package com.baidu.tieba.friendFeed;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FriendFeedActivity aHM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FriendFeedActivity friendFeedActivity) {
        this.aHM = friendFeedActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.j jVar;
        y yVar;
        com.baidu.tieba.tbadkCore.location.e eVar;
        y yVar2;
        y yVar3;
        if (UtilHelper.isNetOk()) {
            yVar = this.aHM.aHt;
            if (yVar.IY() != null) {
                yVar2 = this.aHM.aHt;
                yVar2.IY().setLocationInfoViewState(1);
                yVar3 = this.aHM.aHt;
                yVar3.IY().setLocationViewVisibility(0);
            }
            eVar = this.aHM.aHv;
            eVar.anj();
        } else {
            jVar = this.aHM.aHH;
            jVar.IQ();
        }
        aVar.dismiss();
    }
}
