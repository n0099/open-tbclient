package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ j bRu;
    private final /* synthetic */ com.baidu.tbadk.core.data.m bRv;
    private final /* synthetic */ String bRw;
    private final /* synthetic */ String bRx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, com.baidu.tbadk.core.data.m mVar, String str, String str2) {
        this.bRu = jVar;
        this.bRv = mVar;
        this.bRw = str;
        this.bRx = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        a.C0074a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", this.bRv.qb(), this.bRw, this.bRx, null);
        a.cc("obj_url", this.bRv.getUrl());
        a.save();
        bb wn = bb.wn();
        frsActivity = this.bRu.bOf;
        wn.c(frsActivity.getPageContext(), new String[]{this.bRv.getUrl()});
    }
}
