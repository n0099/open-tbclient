package com.baidu.tieba.frs.h;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.frs.h.f;
import tbclient.PopInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ f.a bOJ;
    private final /* synthetic */ PopInfo bOK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f.a aVar, PopInfo popInfo) {
        this.bOJ = aVar;
        this.bOK = popInfo;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        f fVar;
        bc vz = bc.vz();
        fVar = f.this;
        vz.c(fVar.bFS.getPageContext(), new String[]{this.bOK.ahead_url});
        if (aVar != null) {
            aVar.dismiss();
        }
    }
}
