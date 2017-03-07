package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ x bFf;
    private final /* synthetic */ String bFh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, String str) {
        this.bFf = xVar;
        this.bFh = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        bb vQ = bb.vQ();
        lVar = this.bFf.bFb;
        vQ.a(lVar.aXf.getPageContext(), new String[]{this.bFh}, true);
    }
}
