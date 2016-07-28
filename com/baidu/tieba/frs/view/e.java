package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c bVP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bVP = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.h hVar;
        if ((this.bVP.DQ == null || this.bVP.DQ.getOrignalPage() == null || this.bVP.DQ.getOrignalPage().checkUpIsLogin()) && (hVar = (com.baidu.tieba.tbadkCore.h) view.getTag()) != null) {
            bi.us().c(this.bVP.DQ, new String[]{hVar.getUrl()});
            a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", hVar.bdw(), this.bVP.bGh.getForumId(), this.bVP.bGh.getForumName(), null);
            a.bR("obj_url", hVar.getUrl());
            a.save();
        }
    }
}
