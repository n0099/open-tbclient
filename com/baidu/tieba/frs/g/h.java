package com.baidu.tieba.frs.g;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.frs.g.f;
import tbclient.PopInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ f.a cdq;
    private final /* synthetic */ PopInfo cdr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f.a aVar, PopInfo popInfo) {
        this.cdq = aVar;
        this.cdr = popInfo;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        f fVar;
        bb wn = bb.wn();
        fVar = f.this;
        wn.c(fVar.bVu.getPageContext(), new String[]{this.cdr.ahead_url});
        if (aVar != null) {
            aVar.dismiss();
        }
    }
}
