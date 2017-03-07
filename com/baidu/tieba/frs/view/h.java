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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ c cfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.cfo = cVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v9, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.y bfV;
        int ql;
        if (this.cfo.bTl != null && this.cfo.bTl.bfV() != null && (ql = (bfV = this.cfo.bTl.bfV()).ql()) != 0) {
            if (ql == 1) {
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                    if (this.cfo.bOq != null) {
                        long c = com.baidu.adp.lib.g.b.c(this.cfo.bOq.getForumId(), 0L);
                        TiebaStatic.log(new as("c11200").Z("obj_param1", String.valueOf(c)));
                        MangaCoverActivityConfig mangaCoverActivityConfig = new MangaCoverActivityConfig(this.cfo.aaI.getPageActivity(), c);
                        mangaCoverActivityConfig.setFrom(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, mangaCoverActivityConfig));
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.util.k.showToast(this.cfo.bOq.getPageContext().getPageActivity(), w.l.manga_plugin_not_install_tip);
            } else if (ql == 2) {
                if (!StringUtils.isNull(bfV.qk())) {
                    bb.vQ().c(this.cfo.bOq.getPageContext(), new String[]{bfV.qk()});
                }
            } else if (ql == 3) {
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    this.cfo.bOq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(this.cfo.bOq.getPageContext().getPageActivity(), bfV.qk())));
                } else {
                    com.baidu.adp.lib.util.k.showToast(this.cfo.bOq.getPageContext().getPageActivity(), w.l.book_plugin_not_install_tip);
                }
            }
        }
    }
}
