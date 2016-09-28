package com.baidu.tieba.frs.entelechy;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bUP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bUP = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.q qVar;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        com.baidu.tbadk.core.data.q qVar2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        FrsActivity frsActivity7;
        TbPageContext tbPageContext;
        FrsActivity frsActivity8;
        FrsActivity frsActivity9;
        qVar = this.bUP.bUJ;
        int py = qVar.py();
        if (py == 3) {
            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                frsActivity6 = this.bUP.bRi;
                if (frsActivity6 != null) {
                    frsActivity7 = this.bUP.bRi;
                    long c = com.baidu.adp.lib.h.b.c(frsActivity7.getForumId(), 0L);
                    tbPageContext = this.bUP.Gd;
                    MangaCoverActivityConfig mangaCoverActivityConfig = new MangaCoverActivityConfig(tbPageContext.getPageActivity(), c);
                    mangaCoverActivityConfig.setFrom(5);
                    frsActivity8 = this.bUP.bRi;
                    frsActivity8.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, mangaCoverActivityConfig));
                    ax s = new ax("C11578").s("obj_param1", 2);
                    frsActivity9 = this.bUP.bRi;
                    TiebaStatic.log(s.ab(ImageViewerConfig.FORUM_NAME, frsActivity9.getForumName()));
                    return;
                }
                return;
            }
            frsActivity5 = this.bUP.bRi;
            com.baidu.adp.lib.util.k.showToast(frsActivity5.getPageContext().getPageActivity(), r.j.manga_plugin_not_install_tip);
        } else if (py == 1 || py == 2) {
            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                frsActivity2 = this.bUP.bRi;
                Activity pageActivity = frsActivity2.getPageContext().getPageActivity();
                qVar2 = this.bUP.bUJ;
                BookCoverActivityConfig bookCoverActivityConfig = new BookCoverActivityConfig(pageActivity, qVar2.getBookId());
                frsActivity3 = this.bUP.bRi;
                frsActivity3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, bookCoverActivityConfig));
                ax s2 = new ax("C11578").s("obj_param1", 2);
                frsActivity4 = this.bUP.bRi;
                TiebaStatic.log(s2.ab(ImageViewerConfig.FORUM_NAME, frsActivity4.getForumName()));
                return;
            }
            frsActivity = this.bUP.bRi;
            com.baidu.adp.lib.util.k.showToast(frsActivity.getPageContext().getPageActivity(), r.j.book_plugin_not_install_tip);
        }
    }
}
