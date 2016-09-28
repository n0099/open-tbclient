package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bUP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bUP = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.q qVar;
        com.baidu.tbadk.core.data.q qVar2;
        com.baidu.tbadk.core.data.q qVar3;
        ViewGroup viewGroup;
        FrsActivity frsActivity;
        int i;
        com.baidu.tbadk.core.data.q qVar4;
        FrsActivity frsActivity2;
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
            frsActivity2 = this.bUP.bRi;
            com.baidu.adp.lib.util.k.showToast(frsActivity2.getPageContext().getPageActivity(), r.j.manga_plugin_not_install_tip);
            return;
        }
        qVar = this.bUP.bUJ;
        if (qVar != null) {
            qVar2 = this.bUP.bUJ;
            if (qVar2.py() == 3) {
                qVar3 = this.bUP.bUJ;
                long g = com.baidu.adp.lib.h.b.g(qVar3.getBookId(), -1);
                if (g > 0) {
                    int id = view.getId();
                    viewGroup = this.bUP.bUH;
                    if (id != viewGroup.getId()) {
                        frsActivity = this.bUP.bRi;
                        if (frsActivity.checkUpIsLogin()) {
                            a aVar = this.bUP;
                            i = this.bUP.bUK;
                            aVar.b(g, i);
                            TiebaStatic.log(new ax("C11579").s("obj_param2", 2).g("obj_param1", g));
                            return;
                        }
                        return;
                    }
                    qVar4 = this.bUP.bUJ;
                    int g2 = com.baidu.adp.lib.h.b.g(qVar4.pD(), -1);
                    if (g2 <= 0) {
                        return;
                    }
                    this.bUP.b(g, g2);
                    TiebaStatic.log(new ax("C11580").s("obj_param2", 2).g("obj_param1", g));
                }
            }
        }
    }
}
