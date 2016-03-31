package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {
    final /* synthetic */ bs bmN;
    private final /* synthetic */ com.baidu.tbadk.core.data.c bmu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bs bsVar, com.baidu.tbadk.core.data.c cVar) {
        this.bmN = bsVar;
        this.bmu = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10827");
        awVar.ac("obj_id", new StringBuilder(String.valueOf(this.bmu.getFid())).toString());
        TiebaStatic.log(awVar);
        com.baidu.tbadk.browser.f.a(this.bmN.bix.getPageContext().getPageActivity(), true, this.bmu.Sq);
    }
}
