package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.b {
    final /* synthetic */ i cpK;
    private final /* synthetic */ BlockPopInfoData cpL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar, BlockPopInfoData blockPopInfoData) {
        this.cpK = iVar;
        this.cpL = blockPopInfoData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.frs.r rVar;
        be vP = be.vP();
        rVar = this.cpK.cdv;
        vP.c(rVar.getPageContext(), new String[]{this.cpL.ahead_url});
        if (aVar != null) {
            aVar.dismiss();
        }
    }
}
