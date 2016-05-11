package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c bwe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bwe = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.g gVar;
        if ((this.bwe.Do == null || this.bwe.Do.getOrignalPage() == null || this.bwe.Do.getOrignalPage().checkUpIsLogin()) && (gVar = (com.baidu.tieba.tbadkCore.g) view.getTag()) != null) {
            bg.us().c(this.bwe.Do, new String[]{gVar.getUrl()});
            a.C0075a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.aRX(), this.bwe.bjB.getForumId(), this.bwe.bjB.getForumName(), null);
            a.bK("obj_url", gVar.getUrl());
            a.save();
        }
    }
}
