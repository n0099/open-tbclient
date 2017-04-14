package com.baidu.tieba.card.a;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a buH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.buH = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        j jVar;
        TbPageContext<?> tbPageContext3;
        int id = view.getId();
        view2 = this.buH.mView;
        if (id == view2.getId()) {
            if (!com.baidu.adp.lib.util.i.hj()) {
                tbPageContext = this.buH.aaX;
                Activity pageActivity = tbPageContext.getPageActivity();
                tbPageContext2 = this.buH.aaX;
                com.baidu.adp.lib.util.k.E(pageActivity, tbPageContext2.getString(w.l.neterror));
                return;
            }
            jVar = this.buH.buD;
            tbPageContext3 = this.buH.aaX;
            jVar.j(tbPageContext3);
        }
    }
}
