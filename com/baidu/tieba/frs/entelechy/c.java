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
    final /* synthetic */ a bRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bRf = aVar;
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
            frsActivity2 = this.bRf.bOf;
            com.baidu.adp.lib.util.k.showToast(frsActivity2.getPageContext().getPageActivity(), w.l.manga_plugin_not_install_tip);
            return;
        }
        sVar = this.bRf.bQZ;
        if (sVar != null) {
            sVar2 = this.bRf.bQZ;
            if (sVar2.qk() == 3) {
                sVar3 = this.bRf.bQZ;
                long g = com.baidu.adp.lib.g.b.g(sVar3.getBookId(), -1);
                if (g > 0) {
                    int id = view.getId();
                    viewGroup = this.bRf.bQX;
                    if (id != viewGroup.getId()) {
                        frsActivity = this.bRf.bOf;
                        if (frsActivity.checkUpIsLogin()) {
                            a aVar = this.bRf;
                            i = this.bRf.bRa;
                            aVar.a(g, i);
                            TiebaStatic.log(new as("C11579").s("obj_param2", 2).g("obj_param1", g));
                            return;
                        }
                        return;
                    }
                    sVar4 = this.bRf.bQZ;
                    int g2 = com.baidu.adp.lib.g.b.g(sVar4.qp(), -1);
                    if (g2 <= 0) {
                        return;
                    }
                    this.bRf.a(g, g2);
                    TiebaStatic.log(new as("C11580").s("obj_param2", 2).g("obj_param1", g));
                }
            }
        }
    }
}
