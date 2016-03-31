package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ u bwT;
    private final /* synthetic */ com.baidu.tbadk.core.data.b bwz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, com.baidu.tbadk.core.data.b bVar) {
        this.bwT = uVar;
        this.bwz = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aw awVar = new aw("c10826");
        awVar.ac("obj_id", this.bwT.bvU.avu().getId());
        TiebaStatic.log(awVar);
        com.baidu.tbadk.browser.f.a(this.bwT.blH.getPageContext().getPageActivity(), true, this.bwz.rf());
    }
}
