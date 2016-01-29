package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView brq;
    private final /* synthetic */ com.baidu.tbadk.core.data.b brr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsHeaderView frsHeaderView, com.baidu.tbadk.core.data.b bVar) {
        this.brq = frsHeaderView;
        this.brr = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        au auVar = new au("c10826");
        auVar.aa("obj_id", this.brq.bqR.aoE().getId());
        TiebaStatic.log(auVar);
        com.baidu.tbadk.browser.f.a(this.brq.bgW.getPageContext().getPageActivity(), true, this.brr.rH());
    }
}
