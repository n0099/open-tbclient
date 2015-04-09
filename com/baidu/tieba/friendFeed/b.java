package com.baidu.tieba.friendFeed;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FriendFeedActivity aHU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FriendFeedActivity friendFeedActivity) {
        this.aHU = friendFeedActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.j jVar;
        y yVar;
        com.baidu.tieba.tbadkCore.location.e eVar;
        y yVar2;
        y yVar3;
        if (UtilHelper.isNetOk()) {
            yVar = this.aHU.aHB;
            if (yVar.Je() != null) {
                yVar2 = this.aHU.aHB;
                yVar2.Je().setLocationInfoViewState(1);
                yVar3 = this.aHU.aHB;
                yVar3.Je().setLocationViewVisibility(0);
            }
            eVar = this.aHU.aHD;
            eVar.any();
        } else {
            jVar = this.aHU.aHP;
            jVar.IW();
        }
        aVar.dismiss();
    }
}
