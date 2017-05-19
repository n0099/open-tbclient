package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c bRN;
    private final /* synthetic */ m bRO;
    private final /* synthetic */ String bRP;
    private final /* synthetic */ String bRQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, m mVar, String str, String str2) {
        this.bRN = cVar;
        this.bRO = mVar;
        this.bRP = str;
        this.bRQ = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        a.C0080a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", this.bRO.pF(), this.bRP, this.bRQ, null);
        a.cb("obj_url", this.bRO.getUrl());
        a.save();
        bb vB = bb.vB();
        rVar = this.bRN.bPw;
        vB.c(rVar.getPageContext(), new String[]{this.bRO.getUrl()});
    }
}
