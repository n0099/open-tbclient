package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ y btE;
    private final /* synthetic */ String btG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar, String str) {
        this.btE = yVar;
        this.btG = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k kVar;
        bi us = bi.us();
        kVar = this.btE.btA;
        us.a(kVar.aMU.getPageContext(), new String[]{this.btG}, true);
    }
}
