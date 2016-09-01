package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ j bVn;
    private final /* synthetic */ com.baidu.tbadk.core.data.l bVo;
    private final /* synthetic */ String bVp;
    private final /* synthetic */ String bVq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, com.baidu.tbadk.core.data.l lVar, String str, String str2) {
        this.bVn = jVar;
        this.bVo = lVar;
        this.bVp = str;
        this.bVq = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", this.bVo.ps(), this.bVp, this.bVq, null);
        a.bS("obj_url", this.bVo.getUrl());
        a.save();
        bi vx = bi.vx();
        frsActivity = this.bVn.bRp;
        vx.c(frsActivity.getPageContext(), new String[]{this.bVo.getUrl()});
    }
}
