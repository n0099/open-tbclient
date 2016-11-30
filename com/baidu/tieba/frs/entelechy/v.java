package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ u bYy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.bYy = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.t tVar;
        TbPageContext<?> tbPageContext;
        com.baidu.tbadk.core.data.t tVar2;
        com.baidu.tbadk.core.data.t tVar3;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        tVar = this.bYy.bYt;
        if (tVar != null) {
            bf vP = bf.vP();
            tbPageContext = this.bYy.Gf;
            tVar2 = this.bYy.bYt;
            boolean c = vP.c(tbPageContext, new String[]{tVar2.pS()});
            String str = "c11675";
            tVar3 = this.bYy.bYt;
            if (!tVar3.pM()) {
                str = "c11676";
            }
            frsActivity = this.bYy.bTA;
            if (frsActivity != null && c) {
                av avVar = new av(str);
                frsActivity2 = this.bYy.bTA;
                TiebaStatic.log(avVar.ab("fid", frsActivity2.getForumId()));
            }
        }
    }
}
