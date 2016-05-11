package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class bp implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.c bhR;
    final /* synthetic */ bo bhT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar, com.baidu.tbadk.core.data.c cVar) {
        this.bhT = boVar;
        this.bhR = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10827");
        awVar.ac("obj_id", new StringBuilder(String.valueOf(this.bhR.getFid())).toString());
        TiebaStatic.log(awVar);
        com.baidu.tbadk.browser.f.a(this.bhT.bek.getPageContext().getPageActivity(), true, this.bhR.Ne);
    }
}
