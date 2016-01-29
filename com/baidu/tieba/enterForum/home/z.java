package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ x aWR;
    private final /* synthetic */ String aWT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, String str) {
        this.aWR = xVar;
        this.aWT = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i iVar;
        be wt = be.wt();
        iVar = this.aWR.aWN;
        wt.a(iVar.aKq.getPageContext(), new String[]{this.aWT}, true);
    }
}
