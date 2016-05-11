package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class bs implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.c bhR;
    final /* synthetic */ br bim;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(br brVar, com.baidu.tbadk.core.data.c cVar) {
        this.bim = brVar;
        this.bhR = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10827");
        awVar.ac("obj_id", new StringBuilder(String.valueOf(this.bhR.getFid())).toString());
        TiebaStatic.log(awVar);
        com.baidu.tbadk.browser.f.a(this.bim.bek.getPageContext().getPageActivity(), true, this.bhR.Ne);
    }
}
