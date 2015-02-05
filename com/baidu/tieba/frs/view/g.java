package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView aIQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsHeaderView frsHeaderView) {
        this.aIQ = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext<?> tbPageContext2;
        tbPageContext = this.aIQ.mContext;
        TiebaStatic.eventStat(tbPageContext.getPageActivity(), "star_new", "click", 1, new Object[0]);
        bm pO = bm.pO();
        tbPageContext2 = this.aIQ.mContext;
        pO.b(tbPageContext2, new String[]{(String) view.getTag()});
    }
}
