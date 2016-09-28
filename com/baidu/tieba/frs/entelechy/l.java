package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ j bVg;
    private final /* synthetic */ com.baidu.tbadk.core.data.l bVh;
    private final /* synthetic */ String bVi;
    private final /* synthetic */ String bVj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, com.baidu.tbadk.core.data.l lVar, String str, String str2) {
        this.bVg = jVar;
        this.bVh = lVar;
        this.bVi = str;
        this.bVj = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        a.C0079a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", this.bVh.pt(), this.bVi, this.bVj, null);
        a.bT("obj_url", this.bVh.getUrl());
        a.save();
        bh vL = bh.vL();
        frsActivity = this.bVg.bRi;
        vL.c(frsActivity.getPageContext(), new String[]{this.bVh.getUrl()});
    }
}
