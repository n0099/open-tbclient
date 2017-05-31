package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.frs.f.f;
import tbclient.PopInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ f.a cho;
    private final /* synthetic */ PopInfo chp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f.a aVar, PopInfo popInfo) {
        this.cho = aVar;
        this.chp = popInfo;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        f fVar;
        bb vy = bb.vy();
        fVar = f.this;
        vy.c(fVar.bVm.getPageContext(), new String[]{this.chp.ahead_url});
        if (aVar != null) {
            aVar.dismiss();
        }
    }
}
