package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    private final /* synthetic */ String bDo;
    final /* synthetic */ j bEc;
    private final /* synthetic */ com.baidu.tbadk.core.data.m bEd;
    private final /* synthetic */ String bEe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, com.baidu.tbadk.core.data.m mVar, String str, String str2) {
        this.bEc = jVar;
        this.bEd = mVar;
        this.bDo = str;
        this.bEe = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        a.C0074a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", this.bEd.pw(), this.bDo, this.bEe, null);
        a.bY("obj_url", this.bEd.getUrl());
        a.save();
        bc vz = bc.vz();
        frsActivity = this.bEc.bzH;
        vz.c(frsActivity.getPageContext(), new String[]{this.bEd.getUrl()});
    }
}
