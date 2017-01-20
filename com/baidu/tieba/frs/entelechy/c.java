package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bKk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bKk = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.r rVar;
        com.baidu.tbadk.core.data.r rVar2;
        com.baidu.tbadk.core.data.r rVar3;
        ViewGroup viewGroup;
        FrsActivity frsActivity;
        int i;
        com.baidu.tbadk.core.data.r rVar4;
        FrsActivity frsActivity2;
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
            frsActivity2 = this.bKk.bHh;
            com.baidu.adp.lib.util.k.showToast(frsActivity2.getPageContext().getPageActivity(), r.l.manga_plugin_not_install_tip);
            return;
        }
        rVar = this.bKk.bKe;
        if (rVar != null) {
            rVar2 = this.bKk.bKe;
            if (rVar2.pu() == 3) {
                rVar3 = this.bKk.bKe;
                long g = com.baidu.adp.lib.g.b.g(rVar3.getBookId(), -1);
                if (g > 0) {
                    int id = view.getId();
                    viewGroup = this.bKk.bKc;
                    if (id != viewGroup.getId()) {
                        frsActivity = this.bKk.bHh;
                        if (frsActivity.checkUpIsLogin()) {
                            a aVar = this.bKk;
                            i = this.bKk.bKf;
                            aVar.a(g, i);
                            TiebaStatic.log(new ar("C11579").s("obj_param2", 2).g("obj_param1", g));
                            return;
                        }
                        return;
                    }
                    rVar4 = this.bKk.bKe;
                    int g2 = com.baidu.adp.lib.g.b.g(rVar4.pz(), -1);
                    if (g2 <= 0) {
                        return;
                    }
                    this.bKk.a(g, g2);
                    TiebaStatic.log(new ar("C11580").s("obj_param2", 2).g("obj_param1", g));
                }
            }
        }
    }
}
