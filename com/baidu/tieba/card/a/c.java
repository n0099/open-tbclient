package com.baidu.tieba.card.a;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a bwW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bwW = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        j jVar;
        TbPageContext<?> tbPageContext3;
        int id = view.getId();
        view2 = this.bwW.mView;
        if (id == view2.getId()) {
            if (!com.baidu.adp.lib.util.i.hk()) {
                tbPageContext = this.bwW.aat;
                Activity pageActivity = tbPageContext.getPageActivity();
                tbPageContext2 = this.bwW.aat;
                com.baidu.adp.lib.util.k.E(pageActivity, tbPageContext2.getString(w.l.no_network_guide));
                return;
            }
            jVar = this.bwW.bwT;
            tbPageContext3 = this.bwW.aat;
            jVar.j(tbPageContext3);
        }
    }
}
