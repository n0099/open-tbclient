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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bRq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bRq = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.s sVar;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        com.baidu.tbadk.core.data.s sVar2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        FrsActivity frsActivity7;
        TbPageContext tbPageContext;
        FrsActivity frsActivity8;
        FrsActivity frsActivity9;
        sVar = this.bRq.bRk;
        int pM = sVar.pM();
        if (pM == 3) {
            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                frsActivity6 = this.bRq.bOq;
                if (frsActivity6 != null) {
                    frsActivity7 = this.bRq.bOq;
                    long c = com.baidu.adp.lib.g.b.c(frsActivity7.getForumId(), 0L);
                    tbPageContext = this.bRq.aaI;
                    MangaCoverActivityConfig mangaCoverActivityConfig = new MangaCoverActivityConfig(tbPageContext.getPageActivity(), c);
                    mangaCoverActivityConfig.setFrom(5);
                    frsActivity8 = this.bRq.bOq;
                    frsActivity8.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, mangaCoverActivityConfig));
                    as s = new as("C11578").s("obj_param1", 2);
                    frsActivity9 = this.bRq.bOq;
                    TiebaStatic.log(s.Z(ImageViewerConfig.FORUM_NAME, frsActivity9.getForumName()));
                    return;
                }
                return;
            }
            frsActivity5 = this.bRq.bOq;
            com.baidu.adp.lib.util.k.showToast(frsActivity5.getPageContext().getPageActivity(), w.l.manga_plugin_not_install_tip);
        } else if (pM == 1 || pM == 2) {
            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                frsActivity2 = this.bRq.bOq;
                Activity pageActivity = frsActivity2.getPageContext().getPageActivity();
                sVar2 = this.bRq.bRk;
                BookCoverActivityConfig bookCoverActivityConfig = new BookCoverActivityConfig(pageActivity, sVar2.getBookId());
                frsActivity3 = this.bRq.bOq;
                frsActivity3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, bookCoverActivityConfig));
                as s2 = new as("C11578").s("obj_param1", 2);
                frsActivity4 = this.bRq.bOq;
                TiebaStatic.log(s2.Z(ImageViewerConfig.FORUM_NAME, frsActivity4.getForumName()));
                return;
            }
            frsActivity = this.bRq.bOq;
            com.baidu.adp.lib.util.k.showToast(frsActivity.getPageContext().getPageActivity(), w.l.book_plugin_not_install_tip);
        }
    }
}
