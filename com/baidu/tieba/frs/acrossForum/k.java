package com.baidu.tieba.frs.acrossForum;

import android.view.View;
import android.widget.Toast;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j bWU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bWU = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.p pVar;
        com.baidu.tieba.frs.j.n nVar;
        com.baidu.tieba.frs.j.n nVar2;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.tbadkCore.p pVar3;
        TbPageContext tbPageContext;
        if (!com.baidu.tbadk.util.d.isFastDoubleClick()) {
            if (!com.baidu.adp.lib.util.i.fZ()) {
                tbPageContext = this.bWU.Gf;
                Toast.makeText(tbPageContext.getPageActivity(), r.j.neterror, 0).show();
                return;
            }
            pVar = this.bWU.bWN;
            if (pVar != null) {
                pVar2 = this.bWU.bWN;
                if (pVar2.aOk() != null) {
                    av avVar = new av("c11730");
                    pVar3 = this.bWU.bWN;
                    TiebaStatic.log(avVar.ab("fid", pVar3.aOk().getId()));
                }
            }
            nVar = this.bWU.bWL;
            if (nVar != null) {
                nVar2 = this.bWU.bWL;
                nVar2.ew(false);
            }
        }
    }
}
