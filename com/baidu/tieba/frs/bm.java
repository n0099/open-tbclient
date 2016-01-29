package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class bm implements View.OnClickListener {
    final /* synthetic */ bl bhG;
    private final /* synthetic */ com.baidu.tbadk.core.data.c bhH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bl blVar, com.baidu.tbadk.core.data.c cVar) {
        this.bhG = blVar;
        this.bhH = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10827");
        auVar.aa("obj_id", new StringBuilder(String.valueOf(this.bhH.getFid())).toString());
        TiebaStatic.log(auVar);
        com.baidu.tbadk.browser.f.a(this.bhG.bdK.getPageContext().getPageActivity(), true, this.bhH.UL);
    }
}
