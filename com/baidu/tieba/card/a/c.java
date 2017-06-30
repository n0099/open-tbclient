package com.baidu.tieba.card.a;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a bDM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bDM = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        View.OnClickListener onClickListener;
        j jVar;
        TbPageContext<?> tbPageContext3;
        View.OnClickListener onClickListener2;
        int id = view.getId();
        view2 = this.bDM.mView;
        if (id == view2.getId()) {
            if (!com.baidu.adp.lib.util.i.hj()) {
                tbPageContext = this.bDM.aat;
                Activity pageActivity = tbPageContext.getPageActivity();
                tbPageContext2 = this.bDM.aat;
                com.baidu.adp.lib.util.k.F(pageActivity, tbPageContext2.getString(w.l.no_network_guide));
                return;
            }
            onClickListener = this.bDM.bDJ;
            if (onClickListener != null) {
                onClickListener2 = this.bDM.bDJ;
                onClickListener2.onClick(view);
            }
            jVar = this.bDM.bDw;
            tbPageContext3 = this.bDM.aat;
            jVar.h(tbPageContext3);
        }
    }
}
