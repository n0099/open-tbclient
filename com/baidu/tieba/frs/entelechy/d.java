package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bKk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bKk = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.r rVar;
        com.baidu.tbadk.core.data.r rVar2;
        ViewGroup viewGroup;
        FrsActivity frsActivity;
        com.baidu.tbadk.core.data.r rVar3;
        FrsActivity frsActivity2;
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
            frsActivity2 = this.bKk.bHh;
            com.baidu.adp.lib.util.k.showToast(frsActivity2.getPageContext().getPageActivity(), r.l.book_plugin_not_install_tip);
            return;
        }
        rVar = this.bKk.bKe;
        int pu = rVar.pu();
        if (pu == 1 || pu == 2) {
            rVar2 = this.bKk.bKe;
            String bookId = rVar2.getBookId();
            int id = view.getId();
            viewGroup = this.bKk.bKc;
            if (id != viewGroup.getId()) {
                frsActivity = this.bKk.bHh;
                if (!frsActivity.checkUpIsLogin()) {
                    return;
                }
                this.bKk.M(bookId, -1);
                TiebaStatic.log(new ar("C11579").s("obj_param2", 2).ab("obj_param1", bookId));
                return;
            }
            rVar3 = this.bKk.bKe;
            int g = com.baidu.adp.lib.g.b.g(rVar3.pA(), -1);
            if (g <= 0) {
                return;
            }
            this.bKk.M(bookId, g);
            TiebaStatic.log(new ar("C11580").s("obj_param2", 2).ab("obj_param1", bookId));
        }
    }
}
