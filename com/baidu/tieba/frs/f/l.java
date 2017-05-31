package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.b {
    final /* synthetic */ i chJ;
    private final /* synthetic */ BlockPopInfoData chK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar, BlockPopInfoData blockPopInfoData) {
        this.chJ = iVar;
        this.chK = blockPopInfoData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.frs.r rVar;
        bb vy = bb.vy();
        rVar = this.chJ.bVm;
        vy.c(rVar.getPageContext(), new String[]{this.chK.ahead_url});
        if (aVar != null) {
            aVar.dismiss();
        }
    }
}
