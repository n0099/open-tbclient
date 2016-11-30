package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ x bKi;
    private final /* synthetic */ String bKk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, String str) {
        this.bKi = xVar;
        this.bKk = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        bf vP = bf.vP();
        lVar = this.bKi.bKe;
        vP.a(lVar.aWd.getPageContext(), new String[]{this.bKk}, true);
    }
}
