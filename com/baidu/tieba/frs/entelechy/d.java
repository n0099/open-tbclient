package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bUP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bUP = aVar;
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
            frsActivity2 = this.bUP.bRi;
            com.baidu.adp.lib.util.k.showToast(frsActivity2.getPageContext().getPageActivity(), r.j.book_plugin_not_install_tip);
            return;
        }
        qVar = this.bUP.bUJ;
        int py = qVar.py();
        if (py == 1 || py == 2) {
            qVar2 = this.bUP.bUJ;
            String bookId = qVar2.getBookId();
            int id = view.getId();
            viewGroup = this.bUP.bUH;
            if (id != viewGroup.getId()) {
                frsActivity = this.bUP.bRi;
                if (!frsActivity.checkUpIsLogin()) {
                    return;
                }
                this.bUP.O(bookId, -1);
                TiebaStatic.log(new ax("C11579").s("obj_param2", 2).ab("obj_param1", bookId));
                return;
            }
            qVar3 = this.bUP.bUJ;
            int g = com.baidu.adp.lib.h.b.g(qVar3.pE(), -1);
            if (g <= 0) {
                return;
            }
            this.bUP.O(bookId, g);
            TiebaStatic.log(new ax("C11580").s("obj_param2", 2).ab("obj_param1", bookId));
        }
    }
}
