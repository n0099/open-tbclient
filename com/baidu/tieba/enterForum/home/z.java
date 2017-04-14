package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ x bEY;
    private final /* synthetic */ String bFa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, String str) {
        this.bEY = xVar;
        this.bFa = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        bb wn = bb.wn();
        lVar = this.bEY.bEU;
        wn.a(lVar.aXt.getPageContext(), new String[]{this.bFa}, true);
    }
}
