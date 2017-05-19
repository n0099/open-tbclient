package com.baidu.tieba.frs.e;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.frs.e.f;
import tbclient.PopInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ f.a cbd;
    private final /* synthetic */ PopInfo cbe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f.a aVar, PopInfo popInfo) {
        this.cbd = aVar;
        this.cbe = popInfo;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        f fVar;
        bb vB = bb.vB();
        fVar = f.this;
        vB.c(fVar.bPw.getPageContext(), new String[]{this.cbe.ahead_url});
        if (aVar != null) {
            aVar.dismiss();
        }
    }
}
