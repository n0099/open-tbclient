package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class bo implements View.OnClickListener {
    final /* synthetic */ bn bbd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bn bnVar) {
        this.bbd = bnVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tbadk.plugins.e.f(this.bbd.getTbPageContext())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(this.bbd.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
        }
    }
}
