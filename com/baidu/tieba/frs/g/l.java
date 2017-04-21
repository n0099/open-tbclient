package com.baidu.tieba.frs.g;

import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.b {
    final /* synthetic */ i cdM;
    private final /* synthetic */ BlockPopInfoData cdN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar, BlockPopInfoData blockPopInfoData) {
        this.cdM = iVar;
        this.cdN = blockPopInfoData;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        bb wn = bb.wn();
        frsActivity = this.cdM.bQw;
        wn.c(frsActivity.getPageContext(), new String[]{this.cdN.ahead_url});
        if (aVar != null) {
            aVar.dismiss();
        }
    }
}
