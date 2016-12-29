package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bDL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bDL = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.q qVar;
        com.baidu.tbadk.core.data.q qVar2;
        ViewGroup viewGroup;
        FrsActivity frsActivity;
        com.baidu.tbadk.core.data.q qVar3;
        FrsActivity frsActivity2;
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
            frsActivity2 = this.bDL.bzH;
            com.baidu.adp.lib.util.k.showToast(frsActivity2.getPageContext().getPageActivity(), r.j.book_plugin_not_install_tip);
            return;
        }
        qVar = this.bDL.bDF;
        int pB = qVar.pB();
        if (pB == 1 || pB == 2) {
            qVar2 = this.bDL.bDF;
            String bookId = qVar2.getBookId();
            int id = view.getId();
            viewGroup = this.bDL.bDD;
            if (id != viewGroup.getId()) {
                frsActivity = this.bDL.bzH;
                if (!frsActivity.checkUpIsLogin()) {
                    return;
                }
                this.bDL.M(bookId, -1);
                TiebaStatic.log(new at("C11579").s("obj_param2", 2).ab("obj_param1", bookId));
                return;
            }
            qVar3 = this.bDL.bDF;
            int g = com.baidu.adp.lib.h.b.g(qVar3.pH(), -1);
            if (g <= 0) {
                return;
            }
            this.bDL.M(bookId, g);
            TiebaStatic.log(new at("C11580").s("obj_param2", 2).ab("obj_param1", bookId));
        }
    }
}
