package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ c bTP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.bTP = cVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.s baI;
        int oT;
        if (this.bTP.bJX != null && this.bTP.bJX.baI() != null && (oT = (baI = this.bTP.bJX.baI()).oT()) != 0) {
            if (oT == 1) {
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                    if (this.bTP.bET != null) {
                        long c = com.baidu.adp.lib.h.b.c(this.bTP.bET.getForumId(), 0L);
                        TiebaStatic.log(new ay("c11200").ab("obj_param1", String.valueOf(c)));
                        MangaCoverActivityConfig mangaCoverActivityConfig = new MangaCoverActivityConfig(this.bTP.Dp.getPageActivity(), c);
                        mangaCoverActivityConfig.setFrom(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, mangaCoverActivityConfig));
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.util.k.showToast(this.bTP.bET.getPageContext().getPageActivity(), u.j.manga_plugin_not_install_tip);
            } else if (oT == 2 && !StringUtils.isNull(baI.oS())) {
                bi.us().c(this.bTP.bET.getPageContext(), new String[]{baI.oS()});
            }
        }
    }
}
