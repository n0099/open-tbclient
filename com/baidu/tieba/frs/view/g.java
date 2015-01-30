package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView aIT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsHeaderView frsHeaderView) {
        this.aIT = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext<?> tbPageContext2;
        tbPageContext = this.aIT.mContext;
        TiebaStatic.eventStat(tbPageContext.getPageActivity(), "star_new", "click", 1, new Object[0]);
        bm pV = bm.pV();
        tbPageContext2 = this.aIT.mContext;
        pV.b(tbPageContext2, new String[]{(String) view.getTag()});
    }
}
