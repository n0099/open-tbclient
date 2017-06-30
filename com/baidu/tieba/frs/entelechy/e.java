package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c cfN;
    private final /* synthetic */ n cfO;
    private final /* synthetic */ String cfP;
    private final /* synthetic */ String cfQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, n nVar, String str, String str2) {
        this.cfN = cVar;
        this.cfO = nVar;
        this.cfP = str;
        this.cfQ = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        a.C0085a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", this.cfO.pu(), this.cfP, this.cfQ, null);
        a.cf("obj_url", this.cfO.getUrl());
        a.save();
        be vP = be.vP();
        rVar = this.cfN.cdv;
        vP.c(rVar.getPageContext(), new String[]{this.cfO.getUrl()});
    }
}
