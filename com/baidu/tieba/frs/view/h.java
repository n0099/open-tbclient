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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ c bXS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.bXS = cVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v9, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.x bgi;
        int pT;
        if (this.bXS.bMf != null && this.bXS.bMf.bgi() != null && (pT = (bgi = this.bXS.bMf.bgi()).pT()) != 0) {
            if (pT == 1) {
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                    if (this.bXS.bHh != null) {
                        long c = com.baidu.adp.lib.g.b.c(this.bXS.bHh.getForumId(), 0L);
                        TiebaStatic.log(new ar("c11200").ab("obj_param1", String.valueOf(c)));
                        MangaCoverActivityConfig mangaCoverActivityConfig = new MangaCoverActivityConfig(this.bXS.Fp.getPageActivity(), c);
                        mangaCoverActivityConfig.setFrom(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, mangaCoverActivityConfig));
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.util.k.showToast(this.bXS.bHh.getPageContext().getPageActivity(), r.l.manga_plugin_not_install_tip);
            } else if (pT == 2) {
                if (!StringUtils.isNull(bgi.pS())) {
                    ba.vt().c(this.bXS.bHh.getPageContext(), new String[]{bgi.pS()});
                }
            } else if (pT == 3) {
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    this.bXS.bHh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(this.bXS.bHh.getPageContext().getPageActivity(), bgi.pS())));
                } else {
                    com.baidu.adp.lib.util.k.showToast(this.bXS.bHh.getPageContext().getPageActivity(), r.l.book_plugin_not_install_tip);
                }
            }
        }
    }
}
