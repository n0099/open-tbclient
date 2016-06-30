package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d bIu;
    private final /* synthetic */ com.baidu.tbadk.core.data.k bIv;
    private final /* synthetic */ String bIw;
    private final /* synthetic */ String bIx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tbadk.core.data.k kVar, String str, String str2) {
        this.bIu = dVar;
        this.bIv = kVar;
        this.bIw = str;
        this.bIx = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        a.C0077a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", this.bIv.oH(), this.bIw, this.bIx, null);
        a.bM("obj_url", this.bIv.getUrl());
        a.save();
        bi us = bi.us();
        frsActivity = this.bIu.bET;
        us.c(frsActivity.getPageContext(), new String[]{this.bIv.getUrl()});
    }
}
