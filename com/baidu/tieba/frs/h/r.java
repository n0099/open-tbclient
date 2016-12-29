package com.baidu.tieba.frs.h;

import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.b {
    final /* synthetic */ i bPb;
    private final /* synthetic */ BlockPopInfoData bPc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(i iVar, BlockPopInfoData blockPopInfoData) {
        this.bPb = iVar;
        this.bPc = blockPopInfoData;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        bc vz = bc.vz();
        frsActivity = this.bPb.bzH;
        vz.c(frsActivity.getPageContext(), new String[]{this.bPc.ahead_url});
        if (aVar != null) {
            aVar.dismiss();
        }
    }
}
