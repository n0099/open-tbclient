package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ j bRF;
    private final /* synthetic */ com.baidu.tbadk.core.data.m bRG;
    private final /* synthetic */ String bRH;
    private final /* synthetic */ String bRI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, com.baidu.tbadk.core.data.m mVar, String str, String str2) {
        this.bRF = jVar;
        this.bRG = mVar;
        this.bRH = str;
        this.bRI = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        a.C0075a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", this.bRG.pD(), this.bRH, this.bRI, null);
        a.cb("obj_url", this.bRG.getUrl());
        a.save();
        bb vQ = bb.vQ();
        frsActivity = this.bRF.bOq;
        vQ.c(frsActivity.getPageContext(), new String[]{this.bRG.getUrl()});
    }
}
