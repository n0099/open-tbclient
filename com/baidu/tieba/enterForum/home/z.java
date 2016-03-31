package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ x bbA;
    private final /* synthetic */ String bbC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, String str) {
        this.bbA = xVar;
        this.bbC = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i iVar;
        bg wM = bg.wM();
        iVar = this.bbA.bbw;
        wM.a(iVar.aNm.getPageContext(), new String[]{this.bbC}, true);
    }
}
