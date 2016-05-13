package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ d bnY;
    private final /* synthetic */ com.baidu.tbadk.core.data.b bnZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, com.baidu.tbadk.core.data.b bVar) {
        this.bnY = dVar;
        this.bnZ = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.o oVar;
        FrsActivity frsActivity;
        aw awVar = new aw("c10826");
        oVar = this.bnY.bpp;
        awVar.ac("obj_id", oVar.avD().getId());
        TiebaStatic.log(awVar);
        frsActivity = this.bnY.bjB;
        com.baidu.tbadk.browser.f.a(frsActivity.getPageContext().getPageActivity(), true, this.bnZ.oA());
    }
}
