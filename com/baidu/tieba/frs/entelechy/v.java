package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ u bVr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.bVr = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.s sVar;
        TbPageContext<?> tbPageContext;
        com.baidu.tbadk.core.data.s sVar2;
        com.baidu.tbadk.core.data.s sVar3;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        sVar = this.bVr.bVm;
        if (sVar != null) {
            bh vL = bh.vL();
            tbPageContext = this.bVr.Gd;
            sVar2 = this.bVr.bVm;
            boolean c = vL.c(tbPageContext, new String[]{sVar2.pP()});
            String str = "c11675";
            sVar3 = this.bVr.bVm;
            if (!sVar3.pJ()) {
                str = "c11676";
            }
            frsActivity = this.bVr.bRi;
            if (frsActivity != null && c) {
                ax axVar = new ax(str);
                frsActivity2 = this.bVr.bRi;
                TiebaStatic.log(axVar.ab("fid", frsActivity2.getForumId()));
            }
        }
    }
}
