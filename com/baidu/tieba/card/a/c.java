package com.baidu.tieba.card.a;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a bnT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bnT = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        j jVar;
        TbPageContext<?> tbPageContext3;
        int id = view.getId();
        view2 = this.bnT.mView;
        if (id == view2.getId()) {
            if (!com.baidu.adp.lib.util.i.gk()) {
                tbPageContext = this.bnT.Fp;
                Activity pageActivity = tbPageContext.getPageActivity();
                tbPageContext2 = this.bnT.Fp;
                com.baidu.adp.lib.util.k.m(pageActivity, tbPageContext2.getString(r.l.neterror));
                return;
            }
            jVar = this.bnT.bnP;
            tbPageContext3 = this.bnT.Fp;
            jVar.j(tbPageContext3);
        }
    }
}
