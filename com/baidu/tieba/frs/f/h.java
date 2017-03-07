package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.frs.f.f;
import tbclient.PopInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ f.a ccy;
    private final /* synthetic */ PopInfo ccz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f.a aVar, PopInfo popInfo) {
        this.ccy = aVar;
        this.ccz = popInfo;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        f fVar;
        bb vQ = bb.vQ();
        fVar = f.this;
        vQ.c(fVar.bTp.getPageContext(), new String[]{this.ccz.ahead_url});
        if (aVar != null) {
            aVar.dismiss();
        }
    }
}
