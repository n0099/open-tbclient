package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bDL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bDL = aVar;
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
            frsActivity2 = this.bDL.bzH;
            com.baidu.adp.lib.util.k.showToast(frsActivity2.getPageContext().getPageActivity(), r.j.manga_plugin_not_install_tip);
            return;
        }
        qVar = this.bDL.bDF;
        if (qVar != null) {
            qVar2 = this.bDL.bDF;
            if (qVar2.pB() == 3) {
                qVar3 = this.bDL.bDF;
                long g = com.baidu.adp.lib.h.b.g(qVar3.getBookId(), -1);
                if (g > 0) {
                    int id = view.getId();
                    viewGroup = this.bDL.bDD;
                    if (id != viewGroup.getId()) {
                        frsActivity = this.bDL.bzH;
                        if (frsActivity.checkUpIsLogin()) {
                            a aVar = this.bDL;
                            i = this.bDL.bDG;
                            aVar.a(g, i);
                            TiebaStatic.log(new at("C11579").s("obj_param2", 2).g("obj_param1", g));
                            return;
                        }
                        return;
                    }
                    qVar4 = this.bDL.bDF;
                    int g2 = com.baidu.adp.lib.h.b.g(qVar4.pG(), -1);
                    if (g2 <= 0) {
                        return;
                    }
                    this.bDL.a(g, g2);
                    TiebaStatic.log(new at("C11580").s("obj_param2", 2).g("obj_param1", g));
                }
            }
        }
    }
}
