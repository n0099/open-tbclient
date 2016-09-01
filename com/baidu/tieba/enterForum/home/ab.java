package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ z bHg;
    private final /* synthetic */ String bHi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, String str) {
        this.bHg = zVar;
        this.bHi = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        bi vx = bi.vx();
        lVar = this.bHg.bHc;
        vx.a(lVar.aTi.getPageContext(), new String[]{this.bHi}, true);
    }
}
