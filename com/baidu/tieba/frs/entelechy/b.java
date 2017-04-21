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
    final /* synthetic */ a bTw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bTw = aVar;
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
        sVar = this.bTw.bTq;
        int qk = sVar.qk();
        if (qk == 3) {
            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                frsActivity6 = this.bTw.bQw;
                if (frsActivity6 != null) {
                    frsActivity7 = this.bTw.bQw;
                    long c = com.baidu.adp.lib.g.b.c(frsActivity7.getForumId(), 0L);
                    tbPageContext = this.bTw.aaY;
                    MangaCoverActivityConfig mangaCoverActivityConfig = new MangaCoverActivityConfig(tbPageContext.getPageActivity(), c);
                    mangaCoverActivityConfig.setFrom(5);
                    frsActivity8 = this.bTw.bQw;
                    frsActivity8.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, mangaCoverActivityConfig));
                    as s = new as("C11578").s("obj_param1", 2);
                    frsActivity9 = this.bTw.bQw;
                    TiebaStatic.log(s.aa(ImageViewerConfig.FORUM_NAME, frsActivity9.getForumName()));
                    return;
                }
                return;
            }
            frsActivity5 = this.bTw.bQw;
            com.baidu.adp.lib.util.k.showToast(frsActivity5.getPageContext().getPageActivity(), w.l.manga_plugin_not_install_tip);
        } else if (qk == 1 || qk == 2) {
            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                frsActivity2 = this.bTw.bQw;
                Activity pageActivity = frsActivity2.getPageContext().getPageActivity();
                sVar2 = this.bTw.bTq;
                BookCoverActivityConfig bookCoverActivityConfig = new BookCoverActivityConfig(pageActivity, sVar2.getBookId());
                frsActivity3 = this.bTw.bQw;
                frsActivity3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, bookCoverActivityConfig));
                as s2 = new as("C11578").s("obj_param1", 2);
                frsActivity4 = this.bTw.bQw;
                TiebaStatic.log(s2.aa(ImageViewerConfig.FORUM_NAME, frsActivity4.getForumName()));
                return;
            }
            frsActivity = this.bTw.bQw;
            com.baidu.adp.lib.util.k.showToast(frsActivity.getPageContext().getPageActivity(), w.l.book_plugin_not_install_tip);
        }
    }
}
