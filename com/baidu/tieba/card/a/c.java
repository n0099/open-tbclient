package com.baidu.tieba.card.a;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a bCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bCT = aVar;
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
        view2 = this.bCT.mView;
        if (id == view2.getId()) {
            if (!com.baidu.adp.lib.util.i.hk()) {
                tbPageContext = this.bCT.aas;
                Activity pageActivity = tbPageContext.getPageActivity();
                tbPageContext2 = this.bCT.aas;
                com.baidu.adp.lib.util.k.E(pageActivity, tbPageContext2.getString(w.l.no_network_guide));
                return;
            }
            onClickListener = this.bCT.bCQ;
            if (onClickListener != null) {
                onClickListener2 = this.bCT.bCQ;
                onClickListener2.onClick(view);
            }
            jVar = this.bCT.bCD;
            tbPageContext3 = this.bCT.aas;
            jVar.h(tbPageContext3);
        }
    }
}
