package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.frs.f.f;
import tbclient.PopInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ f.a bVg;
    private final /* synthetic */ PopInfo bVh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f.a aVar, PopInfo popInfo) {
        this.bVg = aVar;
        this.bVh = popInfo;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        f fVar;
        ba vt = ba.vt();
        fVar = f.this;
        vt.c(fVar.bMj.getPageContext(), new String[]{this.bVh.ahead_url});
        if (aVar != null) {
            aVar.dismiss();
        }
    }
}
