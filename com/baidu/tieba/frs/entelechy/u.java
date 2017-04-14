package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t bRF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.bRF = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.u uVar;
        TbPageContext<?> tbPageContext;
        com.baidu.tbadk.core.data.u uVar2;
        com.baidu.tbadk.core.data.u uVar3;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        uVar = this.bRF.bRA;
        if (uVar != null) {
            bb wn = bb.wn();
            tbPageContext = this.bRF.aaX;
            uVar2 = this.bRF.bRA;
            boolean c = wn.c(tbPageContext, new String[]{uVar2.qC()});
            String str = "c11675";
            uVar3 = this.bRF.bRA;
            if (!uVar3.qw()) {
                str = "c11676";
            }
            frsActivity = this.bRF.bOf;
            if (frsActivity != null && c) {
                as asVar = new as(str);
                frsActivity2 = this.bRF.bOf;
                TiebaStatic.log(asVar.aa("fid", frsActivity2.getForumId()));
            }
        }
    }
}
