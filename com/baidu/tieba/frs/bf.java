package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.data.b;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnClickListener {
    final /* synthetic */ be bDY;
    private final /* synthetic */ b bDZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(be beVar, b bVar) {
        this.bDY = beVar;
        this.bDZ = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c10827");
        ayVar.ab("obj_id", new StringBuilder(String.valueOf(this.bDZ.getFid())).toString());
        TiebaStatic.log(ayVar);
        com.baidu.tbadk.browser.f.a(this.bDY.bkc.getPageContext().getPageActivity(), true, this.bDZ.MZ);
    }
}
