package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e bJY;
    private final /* synthetic */ com.baidu.tbadk.core.data.l bJZ;
    private final /* synthetic */ String bKa;
    private final /* synthetic */ String bKb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, com.baidu.tbadk.core.data.l lVar, String str, String str2) {
        this.bJY = eVar;
        this.bJZ = lVar;
        this.bKa = str;
        this.bKb = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", this.bJZ.ow(), this.bKa, this.bKb, null);
        a.bR("obj_url", this.bJZ.getUrl());
        a.save();
        bi us = bi.us();
        frsActivity = this.bJY.bGh;
        us.c(frsActivity.getPageContext(), new String[]{this.bJZ.getUrl()});
    }
}
