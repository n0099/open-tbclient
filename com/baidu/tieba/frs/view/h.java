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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ c cme;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.cme = cVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v9, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.x bkE;
        int pZ;
        if (this.cme.cae != null && this.cme.cae.bkE() != null && (pZ = (bkE = this.cme.cae.bkE()).pZ()) != 0) {
            if (pZ == 1) {
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                    if (this.cme.bTA != null) {
                        long c = com.baidu.adp.lib.h.b.c(this.cme.bTA.getForumId(), 0L);
                        TiebaStatic.log(new av("c11200").ab("obj_param1", String.valueOf(c)));
                        MangaCoverActivityConfig mangaCoverActivityConfig = new MangaCoverActivityConfig(this.cme.Gf.getPageActivity(), c);
                        mangaCoverActivityConfig.setFrom(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, mangaCoverActivityConfig));
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.util.k.showToast(this.cme.bTA.getPageContext().getPageActivity(), r.j.manga_plugin_not_install_tip);
            } else if (pZ == 2) {
                if (!StringUtils.isNull(bkE.pY())) {
                    bf.vP().c(this.cme.bTA.getPageContext(), new String[]{bkE.pY()});
                }
            } else if (pZ == 3) {
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    this.cme.bTA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(this.cme.bTA.getPageContext().getPageActivity(), bkE.pY())));
                } else {
                    com.baidu.adp.lib.util.k.showToast(this.cme.bTA.getPageContext().getPageActivity(), r.j.book_plugin_not_install_tip);
                }
            }
        }
    }
}
