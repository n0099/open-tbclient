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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ c cgZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.cgZ = cVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v9, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.u bhA;
        int pL;
        if (this.cgZ.bWN != null && this.cgZ.bWN.bhA() != null && (pL = (bhA = this.cgZ.bWN.bhA()).pL()) != 0) {
            if (pL == 1) {
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                    if (this.cgZ.bRp != null) {
                        long c = com.baidu.adp.lib.h.b.c(this.cgZ.bRp.getForumId(), 0L);
                        TiebaStatic.log(new ay("c11200").ab("obj_param1", String.valueOf(c)));
                        MangaCoverActivityConfig mangaCoverActivityConfig = new MangaCoverActivityConfig(this.cgZ.Gd.getPageActivity(), c);
                        mangaCoverActivityConfig.setFrom(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, mangaCoverActivityConfig));
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.util.k.showToast(this.cgZ.bRp.getPageContext().getPageActivity(), t.j.manga_plugin_not_install_tip);
            } else if (pL == 2) {
                if (!StringUtils.isNull(bhA.pK())) {
                    bi.vx().c(this.cgZ.bRp.getPageContext(), new String[]{bhA.pK()});
                }
            } else if (pL == 3) {
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    this.cgZ.bRp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(this.cgZ.bRp.getPageContext().getPageActivity(), bhA.pK())));
                } else {
                    com.baidu.adp.lib.util.k.showToast(this.cgZ.bRp.getPageContext().getPageActivity(), t.j.book_plugin_not_install_tip);
                }
            }
        }
    }
}
