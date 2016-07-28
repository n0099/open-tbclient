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
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ c bVP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.bVP = cVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v9, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.t bdW;
        int oI;
        if (this.bVP.bLD != null && this.bVP.bLD.bdW() != null && (oI = (bdW = this.bVP.bLD.bdW()).oI()) != 0) {
            if (oI == 1) {
                if (TbadkCoreApplication.m10getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                    if (this.bVP.bGh != null) {
                        long c = com.baidu.adp.lib.h.b.c(this.bVP.bGh.getForumId(), 0L);
                        TiebaStatic.log(new ay("c11200").ab("obj_param1", String.valueOf(c)));
                        MangaCoverActivityConfig mangaCoverActivityConfig = new MangaCoverActivityConfig(this.bVP.DQ.getPageActivity(), c);
                        mangaCoverActivityConfig.setFrom(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, mangaCoverActivityConfig));
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.util.k.showToast(this.bVP.bGh.getPageContext().getPageActivity(), u.j.manga_plugin_not_install_tip);
            } else if (oI == 2) {
                if (!StringUtils.isNull(bdW.oH())) {
                    bi.us().c(this.bVP.bGh.getPageContext(), new String[]{bdW.oH()});
                }
            } else if (oI == 3) {
                if (TbadkCoreApplication.m10getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    this.bVP.bGh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(this.bVP.bGh.getPageContext().getPageActivity(), bdW.oH())));
                } else {
                    com.baidu.adp.lib.util.k.showToast(this.bVP.bGh.getPageContext().getPageActivity(), u.j.book_plugin_not_install_tip);
                }
            }
        }
    }
}
