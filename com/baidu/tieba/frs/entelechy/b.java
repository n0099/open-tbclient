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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bKk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bKk = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.r rVar;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        com.baidu.tbadk.core.data.r rVar2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        FrsActivity frsActivity7;
        TbPageContext tbPageContext;
        FrsActivity frsActivity8;
        FrsActivity frsActivity9;
        rVar = this.bKk.bKe;
        int pu = rVar.pu();
        if (pu == 3) {
            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                frsActivity6 = this.bKk.bHh;
                if (frsActivity6 != null) {
                    frsActivity7 = this.bKk.bHh;
                    long c = com.baidu.adp.lib.g.b.c(frsActivity7.getForumId(), 0L);
                    tbPageContext = this.bKk.Fp;
                    MangaCoverActivityConfig mangaCoverActivityConfig = new MangaCoverActivityConfig(tbPageContext.getPageActivity(), c);
                    mangaCoverActivityConfig.setFrom(5);
                    frsActivity8 = this.bKk.bHh;
                    frsActivity8.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, mangaCoverActivityConfig));
                    ar s = new ar("C11578").s("obj_param1", 2);
                    frsActivity9 = this.bKk.bHh;
                    TiebaStatic.log(s.ab(ImageViewerConfig.FORUM_NAME, frsActivity9.getForumName()));
                    return;
                }
                return;
            }
            frsActivity5 = this.bKk.bHh;
            com.baidu.adp.lib.util.k.showToast(frsActivity5.getPageContext().getPageActivity(), r.l.manga_plugin_not_install_tip);
        } else if (pu == 1 || pu == 2) {
            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                frsActivity2 = this.bKk.bHh;
                Activity pageActivity = frsActivity2.getPageContext().getPageActivity();
                rVar2 = this.bKk.bKe;
                BookCoverActivityConfig bookCoverActivityConfig = new BookCoverActivityConfig(pageActivity, rVar2.getBookId());
                frsActivity3 = this.bKk.bHh;
                frsActivity3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, bookCoverActivityConfig));
                ar s2 = new ar("C11578").s("obj_param1", 2);
                frsActivity4 = this.bKk.bHh;
                TiebaStatic.log(s2.ab(ImageViewerConfig.FORUM_NAME, frsActivity4.getForumName()));
                return;
            }
            frsActivity = this.bKk.bHh;
            com.baidu.adp.lib.util.k.showToast(frsActivity.getPageContext().getPageActivity(), r.l.book_plugin_not_install_tip);
        }
    }
}
