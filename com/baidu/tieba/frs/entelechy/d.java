package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bRq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bRq = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.s sVar;
        com.baidu.tbadk.core.data.s sVar2;
        ViewGroup viewGroup;
        FrsActivity frsActivity;
        com.baidu.tbadk.core.data.s sVar3;
        FrsActivity frsActivity2;
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
            frsActivity2 = this.bRq.bOq;
            com.baidu.adp.lib.util.k.showToast(frsActivity2.getPageContext().getPageActivity(), w.l.book_plugin_not_install_tip);
            return;
        }
        sVar = this.bRq.bRk;
        int pM = sVar.pM();
        if (pM == 1 || pM == 2) {
            sVar2 = this.bRq.bRk;
            String bookId = sVar2.getBookId();
            int id = view.getId();
            viewGroup = this.bRq.bRi;
            if (id != viewGroup.getId()) {
                frsActivity = this.bRq.bOq;
                if (!frsActivity.checkUpIsLogin()) {
                    return;
                }
                this.bRq.J(bookId, -1);
                TiebaStatic.log(new as("C11579").s("obj_param2", 2).Z("obj_param1", bookId));
                return;
            }
            sVar3 = this.bRq.bRk;
            int g = com.baidu.adp.lib.g.b.g(sVar3.pS(), -1);
            if (g <= 0) {
                return;
            }
            this.bRq.J(bookId, g);
            TiebaStatic.log(new as("C11580").s("obj_param2", 2).Z("obj_param1", bookId));
        }
    }
}
