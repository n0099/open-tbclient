package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ x bxZ;
    private final /* synthetic */ String byb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, String str) {
        this.bxZ = xVar;
        this.byb = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        ba vt = ba.vt();
        lVar = this.bxZ.bxV;
        vt.a(lVar.aQU.getPageContext(), new String[]{this.byb}, true);
    }
}
