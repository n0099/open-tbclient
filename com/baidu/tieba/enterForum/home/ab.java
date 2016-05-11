package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ z aXJ;
    private final /* synthetic */ String aXL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, String str) {
        this.aXJ = zVar;
        this.aXL = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k kVar;
        bg us = bg.us();
        kVar = this.aXJ.aXF;
        us.a(kVar.aJw.getPageContext(), new String[]{this.aXL}, true);
    }
}
