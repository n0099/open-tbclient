package com.baidu.tieba.card.a;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a bwY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bwY = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        j jVar;
        TbPageContext<?> tbPageContext3;
        int id = view.getId();
        view2 = this.bwY.mView;
        if (id == view2.getId()) {
            if (!com.baidu.adp.lib.util.i.hk()) {
                tbPageContext = this.bwY.aaY;
                Activity pageActivity = tbPageContext.getPageActivity();
                tbPageContext2 = this.bwY.aaY;
                com.baidu.adp.lib.util.k.E(pageActivity, tbPageContext2.getString(w.l.no_network_guide));
                return;
            }
            jVar = this.bwY.bwU;
            tbPageContext3 = this.bwY.aaY;
            jVar.j(tbPageContext3);
        }
    }
}
