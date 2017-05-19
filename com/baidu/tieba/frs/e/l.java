package com.baidu.tieba.frs.e;

import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.b {
    final /* synthetic */ i cbx;
    private final /* synthetic */ BlockPopInfoData cby;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar, BlockPopInfoData blockPopInfoData) {
        this.cbx = iVar;
        this.cby = blockPopInfoData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.frs.r rVar;
        bb vB = bb.vB();
        rVar = this.cbx.bPw;
        vB.c(rVar.getPageContext(), new String[]{this.cby.ahead_url});
        if (aVar != null) {
            aVar.dismiss();
        }
    }
}
