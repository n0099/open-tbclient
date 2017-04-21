package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ x bHp;
    private final /* synthetic */ String bHr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, String str) {
        this.bHp = xVar;
        this.bHr = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        bb wn = bb.wn();
        lVar = this.bHp.bHl;
        wn.a(lVar.aXw.getPageContext(), new String[]{this.bHr}, true);
    }
}
