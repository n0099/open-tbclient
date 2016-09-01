package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bUW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bUW = aVar;
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
            frsActivity2 = this.bUW.bRp;
            com.baidu.adp.lib.util.k.showToast(frsActivity2.getPageContext().getPageActivity(), t.j.book_plugin_not_install_tip);
            return;
        }
        qVar = this.bUW.bUQ;
        int px = qVar.px();
        if (px == 1 || px == 2) {
            qVar2 = this.bUW.bUQ;
            String bookId = qVar2.getBookId();
            int id = view.getId();
            viewGroup = this.bUW.bUO;
            if (id != viewGroup.getId()) {
                frsActivity = this.bUW.bRp;
                if (!frsActivity.checkUpIsLogin()) {
                    return;
                }
                this.bUW.O(bookId, -1);
                TiebaStatic.log(new ay("C11579").s("obj_param2", 2).ab("obj_param1", bookId));
                return;
            }
            qVar3 = this.bUW.bUQ;
            int g = com.baidu.adp.lib.h.b.g(qVar3.pD(), -1);
            if (g <= 0) {
                return;
            }
            this.bUW.O(bookId, g);
            TiebaStatic.log(new ay("C11580").s("obj_param2", 2).ab("obj_param1", bookId));
        }
    }
}
