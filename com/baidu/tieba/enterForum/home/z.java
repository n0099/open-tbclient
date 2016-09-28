package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.util.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ x bHo;
    private final /* synthetic */ String bHq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, String str) {
        this.bHo = xVar;
        this.bHq = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        bh vL = bh.vL();
        lVar = this.bHo.bHk;
        vL.a(lVar.aTS.getPageContext(), new String[]{this.bHq}, true);
    }
}
