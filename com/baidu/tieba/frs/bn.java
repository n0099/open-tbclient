package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class bn implements View.OnClickListener {
    final /* synthetic */ bm bhQ;
    private final /* synthetic */ com.baidu.tbadk.core.data.c bhR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar, com.baidu.tbadk.core.data.c cVar) {
        this.bhQ = bmVar;
        this.bhR = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10827");
        awVar.ac("obj_id", new StringBuilder(String.valueOf(this.bhR.getFid())).toString());
        TiebaStatic.log(awVar);
        com.baidu.tbadk.browser.f.a(this.bhQ.bek.getPageContext().getPageActivity(), true, this.bhR.Ne);
    }
}
