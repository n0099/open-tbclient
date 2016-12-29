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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ c bRo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.bRo = cVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v9, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.w beu;
        int qa;
        if (this.bRo.bFO != null && this.bRo.bFO.beu() != null && (qa = (beu = this.bRo.bFO.beu()).qa()) != 0) {
            if (qa == 1) {
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                    if (this.bRo.bzH != null) {
                        long c = com.baidu.adp.lib.h.b.c(this.bRo.bzH.getForumId(), 0L);
                        TiebaStatic.log(new at("c11200").ab("obj_param1", String.valueOf(c)));
                        MangaCoverActivityConfig mangaCoverActivityConfig = new MangaCoverActivityConfig(this.bRo.Gf.getPageActivity(), c);
                        mangaCoverActivityConfig.setFrom(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, mangaCoverActivityConfig));
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.util.k.showToast(this.bRo.bzH.getPageContext().getPageActivity(), r.j.manga_plugin_not_install_tip);
            } else if (qa == 2) {
                if (!StringUtils.isNull(beu.pZ())) {
                    bc.vz().c(this.bRo.bzH.getPageContext(), new String[]{beu.pZ()});
                }
            } else if (qa == 3) {
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    this.bRo.bzH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(this.bRo.bzH.getPageContext().getPageActivity(), beu.pZ())));
                } else {
                    com.baidu.adp.lib.util.k.showToast(this.bRo.bzH.getPageContext().getPageActivity(), r.j.book_plugin_not_install_tip);
                }
            }
        }
    }
}
