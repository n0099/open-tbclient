package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c bXE;
    private final /* synthetic */ m bXF;
    private final /* synthetic */ String bXG;
    private final /* synthetic */ String bXH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, m mVar, String str, String str2) {
        this.bXE = cVar;
        this.bXF = mVar;
        this.bXG = str;
        this.bXH = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        a.C0082a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", this.bXF.px(), this.bXG, this.bXH, null);
        a.cb("obj_url", this.bXF.getUrl());
        a.save();
        bb vy = bb.vy();
        rVar = this.bXE.bVm;
        vy.c(rVar.getPageContext(), new String[]{this.bXF.getUrl()});
    }
}
