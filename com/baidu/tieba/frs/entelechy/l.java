package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    private final /* synthetic */ String bXe;
    final /* synthetic */ j bYo;
    private final /* synthetic */ com.baidu.tbadk.core.data.m bYp;
    private final /* synthetic */ String bYq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, com.baidu.tbadk.core.data.m mVar, String str, String str2) {
        this.bYo = jVar;
        this.bYp = mVar;
        this.bXe = str;
        this.bYq = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        a.C0080a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", this.bYp.pw(), this.bXe, this.bYq, null);
        a.bV("obj_url", this.bYp.getUrl());
        a.save();
        bf vP = bf.vP();
        frsActivity = this.bYo.bTA;
        vP.c(frsActivity.getPageContext(), new String[]{this.bYp.getUrl()});
    }
}
