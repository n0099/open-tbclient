package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ c cgX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.cgX = cVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v9, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.v bij;
        int pW;
        if (this.cgX.bWN != null && this.cgX.bWN.bij() != null && (pW = (bij = this.cgX.bWN.bij()).pW()) != 0) {
            if (pW == 1) {
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                    if (this.cgX.bRi != null) {
                        long c = com.baidu.adp.lib.h.b.c(this.cgX.bRi.getForumId(), 0L);
                        TiebaStatic.log(new ax("c11200").ab("obj_param1", String.valueOf(c)));
                        MangaCoverActivityConfig mangaCoverActivityConfig = new MangaCoverActivityConfig(this.cgX.Gd.getPageActivity(), c);
                        mangaCoverActivityConfig.setFrom(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, mangaCoverActivityConfig));
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.util.k.showToast(this.cgX.bRi.getPageContext().getPageActivity(), r.j.manga_plugin_not_install_tip);
            } else if (pW == 2) {
                if (!StringUtils.isNull(bij.pV())) {
                    bh.vL().c(this.cgX.bRi.getPageContext(), new String[]{bij.pV()});
                }
            } else if (pW == 3) {
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    this.cgX.bRi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(this.cgX.bRi.getPageContext().getPageActivity(), bij.pV())));
                } else {
                    com.baidu.adp.lib.util.k.showToast(this.cgX.bRi.getPageContext().getPageActivity(), r.j.book_plugin_not_install_tip);
                }
            }
        }
    }
}
