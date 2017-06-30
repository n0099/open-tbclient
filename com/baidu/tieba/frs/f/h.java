package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.frs.f.f;
import tbclient.PopInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ f.a cpF;
    private final /* synthetic */ PopInfo cpG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f.a aVar, PopInfo popInfo) {
        this.cpF = aVar;
        this.cpG = popInfo;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        f fVar;
        be vP = be.vP();
        fVar = f.this;
        vP.c(fVar.cdv.getPageContext(), new String[]{this.cpG.ahead_url});
        if (aVar != null) {
            aVar.dismiss();
        }
    }
}
