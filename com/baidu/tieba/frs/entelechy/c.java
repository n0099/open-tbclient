package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bRq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bRq = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.s sVar;
        com.baidu.tbadk.core.data.s sVar2;
        com.baidu.tbadk.core.data.s sVar3;
        ViewGroup viewGroup;
        FrsActivity frsActivity;
        int i;
        com.baidu.tbadk.core.data.s sVar4;
        FrsActivity frsActivity2;
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
            frsActivity2 = this.bRq.bOq;
            com.baidu.adp.lib.util.k.showToast(frsActivity2.getPageContext().getPageActivity(), w.l.manga_plugin_not_install_tip);
            return;
        }
        sVar = this.bRq.bRk;
        if (sVar != null) {
            sVar2 = this.bRq.bRk;
            if (sVar2.pM() == 3) {
                sVar3 = this.bRq.bRk;
                long g = com.baidu.adp.lib.g.b.g(sVar3.getBookId(), -1);
                if (g > 0) {
                    int id = view.getId();
                    viewGroup = this.bRq.bRi;
                    if (id != viewGroup.getId()) {
                        frsActivity = this.bRq.bOq;
                        if (frsActivity.checkUpIsLogin()) {
                            a aVar = this.bRq;
                            i = this.bRq.bRl;
                            aVar.a(g, i);
                            TiebaStatic.log(new as("C11579").s("obj_param2", 2).g("obj_param1", g));
                            return;
                        }
                        return;
                    }
                    sVar4 = this.bRq.bRk;
                    int g2 = com.baidu.adp.lib.g.b.g(sVar4.pR(), -1);
                    if (g2 <= 0) {
                        return;
                    }
                    this.bRq.a(g, g2);
                    TiebaStatic.log(new as("C11580").s("obj_param2", 2).g("obj_param1", g));
                }
            }
        }
    }
}
