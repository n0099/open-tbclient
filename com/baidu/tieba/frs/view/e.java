package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c bTP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bTP = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.h hVar;
        if ((this.bTP.Dp == null || this.bTP.Dp.getOrignalPage() == null || this.bTP.Dp.getOrignalPage().checkUpIsLogin()) && (hVar = (com.baidu.tieba.tbadkCore.h) view.getTag()) != null) {
            bi.us().c(this.bTP.Dp, new String[]{hVar.getUrl()});
            a.C0077a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", hVar.bai(), this.bTP.bET.getForumId(), this.bTP.bET.getForumName(), null);
            a.bM("obj_url", hVar.getUrl());
            a.save();
        }
    }
}
