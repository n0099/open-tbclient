package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ u bRQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.bRQ = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.u uVar;
        TbPageContext<?> tbPageContext;
        com.baidu.tbadk.core.data.u uVar2;
        com.baidu.tbadk.core.data.u uVar3;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        uVar = this.bRQ.bRL;
        if (uVar != null) {
            bb vQ = bb.vQ();
            tbPageContext = this.bRQ.aaI;
            uVar2 = this.bRQ.bRL;
            boolean c = vQ.c(tbPageContext, new String[]{uVar2.qe()});
            String str = "c11675";
            uVar3 = this.bRQ.bRL;
            if (!uVar3.pY()) {
                str = "c11676";
            }
            frsActivity = this.bRQ.bOq;
            if (frsActivity != null && c) {
                as asVar = new as(str);
                frsActivity2 = this.bRQ.bOq;
                TiebaStatic.log(asVar.Z("fid", frsActivity2.getForumId()));
            }
        }
    }
}
