package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bXX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bXX = aVar;
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
            frsActivity2 = this.bXX.bTA;
            com.baidu.adp.lib.util.k.showToast(frsActivity2.getPageContext().getPageActivity(), r.j.book_plugin_not_install_tip);
            return;
        }
        rVar = this.bXX.bXR;
        int pB = rVar.pB();
        if (pB == 1 || pB == 2) {
            rVar2 = this.bXX.bXR;
            String bookId = rVar2.getBookId();
            int id = view.getId();
            viewGroup = this.bXX.bXP;
            if (id != viewGroup.getId()) {
                frsActivity = this.bXX.bTA;
                if (!frsActivity.checkUpIsLogin()) {
                    return;
                }
                this.bXX.O(bookId, -1);
                TiebaStatic.log(new av("C11579").s("obj_param2", 2).ab("obj_param1", bookId));
                return;
            }
            rVar3 = this.bXX.bXR;
            int g = com.baidu.adp.lib.h.b.g(rVar3.pH(), -1);
            if (g <= 0) {
                return;
            }
            this.bXX.O(bookId, g);
            TiebaStatic.log(new av("C11580").s("obj_param2", 2).ab("obj_param1", bookId));
        }
    }
}
