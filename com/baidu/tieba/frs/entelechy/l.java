package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.n bKA;
    private final /* synthetic */ String bKB;
    private final /* synthetic */ String bKC;
    final /* synthetic */ j bKz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, com.baidu.tbadk.core.data.n nVar, String str, String str2) {
        this.bKz = jVar;
        this.bKA = nVar;
        this.bKB = str;
        this.bKC = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", this.bKA.pp(), this.bKB, this.bKC, null);
        a.ch("obj_url", this.bKA.getUrl());
        a.save();
        ba vt = ba.vt();
        frsActivity = this.bKz.bHh;
        vt.c(frsActivity.getPageContext(), new String[]{this.bKA.getUrl()});
    }
}
