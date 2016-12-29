package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ u bEm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.bEm = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.s sVar;
        TbPageContext<?> tbPageContext;
        com.baidu.tbadk.core.data.s sVar2;
        com.baidu.tbadk.core.data.s sVar3;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        sVar = this.bEm.bEh;
        if (sVar != null) {
            bc vz = bc.vz();
            tbPageContext = this.bEm.Gf;
            sVar2 = this.bEm.bEh;
            boolean c = vz.c(tbPageContext, new String[]{sVar2.pT()});
            String str = "c11675";
            sVar3 = this.bEm.bEh;
            if (!sVar3.pN()) {
                str = "c11676";
            }
            frsActivity = this.bEm.bzH;
            if (frsActivity != null && c) {
                at atVar = new at(str);
                frsActivity2 = this.bEm.bzH;
                TiebaStatic.log(atVar.ab("fid", frsActivity2.getForumId()));
            }
        }
    }
}
