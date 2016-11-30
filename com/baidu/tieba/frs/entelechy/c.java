package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bXX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bXX = aVar;
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
            frsActivity2 = this.bXX.bTA;
            com.baidu.adp.lib.util.k.showToast(frsActivity2.getPageContext().getPageActivity(), r.j.manga_plugin_not_install_tip);
            return;
        }
        rVar = this.bXX.bXR;
        if (rVar != null) {
            rVar2 = this.bXX.bXR;
            if (rVar2.pB() == 3) {
                rVar3 = this.bXX.bXR;
                long g = com.baidu.adp.lib.h.b.g(rVar3.getBookId(), -1);
                if (g > 0) {
                    int id = view.getId();
                    viewGroup = this.bXX.bXP;
                    if (id != viewGroup.getId()) {
                        frsActivity = this.bXX.bTA;
                        if (frsActivity.checkUpIsLogin()) {
                            a aVar = this.bXX;
                            i = this.bXX.bXS;
                            aVar.b(g, i);
                            TiebaStatic.log(new av("C11579").s("obj_param2", 2).g("obj_param1", g));
                            return;
                        }
                        return;
                    }
                    rVar4 = this.bXX.bXR;
                    int g2 = com.baidu.adp.lib.h.b.g(rVar4.pG(), -1);
                    if (g2 <= 0) {
                        return;
                    }
                    this.bXX.b(g, g2);
                    TiebaStatic.log(new av("C11580").s("obj_param2", 2).g("obj_param1", g));
                }
            }
        }
    }
}
