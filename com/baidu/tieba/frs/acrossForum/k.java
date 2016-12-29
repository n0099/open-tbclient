package com.baidu.tieba.frs.acrossForum;

import android.view.View;
import android.widget.Toast;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j bDe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bDe = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.frs.h.s sVar;
        com.baidu.tieba.frs.h.s sVar2;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        TbPageContext tbPageContext;
        if (!com.baidu.tbadk.util.d.isFastDoubleClick()) {
            if (!com.baidu.adp.lib.util.i.fZ()) {
                tbPageContext = this.bDe.Gf;
                Toast.makeText(tbPageContext.getPageActivity(), r.j.neterror, 0).show();
                return;
            }
            oVar = this.bDe.bCX;
            if (oVar != null) {
                oVar2 = this.bDe.bCX;
                if (oVar2.aIk() != null) {
                    at atVar = new at("c11730");
                    oVar3 = this.bDe.bCX;
                    TiebaStatic.log(atVar.ab("fid", oVar3.aIk().getId()));
                }
            }
            sVar = this.bDe.bCV;
            if (sVar != null) {
                sVar2 = this.bDe.bCV;
                sVar2.eg(false);
            }
        }
    }
}
