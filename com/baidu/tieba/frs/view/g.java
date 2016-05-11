package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ c bwe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.bwe = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int pb;
        if (this.bwe.bpp != null && this.bwe.bpp.aSv() != null && (pb = this.bwe.bpp.aSv().pb()) != 0 && pb == 1) {
            if (TbadkCoreApplication.m11getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                if (this.bwe.bjB != null) {
                    long c = com.baidu.adp.lib.h.b.c(this.bwe.bjB.getForumId(), 0L);
                    TiebaStatic.log(new aw("c11200").ac("obj_param1", String.valueOf(c)));
                    MangaCoverActivityConfig mangaCoverActivityConfig = new MangaCoverActivityConfig(this.bwe.Do.getPageActivity(), c);
                    mangaCoverActivityConfig.setFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, mangaCoverActivityConfig));
                    return;
                }
                return;
            }
            com.baidu.adp.lib.util.k.showToast(this.bwe.bjB.getPageContext().getPageActivity(), t.j.manga_plugin_not_install_tip);
        }
    }
}
