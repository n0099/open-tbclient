package com.baidu.tieba.card.a;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a buP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.buP = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        j jVar;
        TbPageContext<?> tbPageContext3;
        int id = view.getId();
        view2 = this.buP.mView;
        if (id == view2.getId()) {
            if (!com.baidu.adp.lib.util.i.he()) {
                tbPageContext = this.buP.aaI;
                Activity pageActivity = tbPageContext.getPageActivity();
                tbPageContext2 = this.buP.aaI;
                com.baidu.adp.lib.util.k.G(pageActivity, tbPageContext2.getString(w.l.neterror));
                return;
            }
            jVar = this.buP.buL;
            tbPageContext3 = this.buP.aaI;
            jVar.j(tbPageContext3);
        }
    }
}
