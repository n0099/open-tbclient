package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.util.bc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ x bqm;
    private final /* synthetic */ String bqo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, String str) {
        this.bqm = xVar;
        this.bqo = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        bc vz = bc.vz();
        lVar = this.bqm.bqi;
        vz.a(lVar.aVu.getPageContext(), new String[]{this.bqo}, true);
    }
}
