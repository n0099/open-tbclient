package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class bu implements View.OnClickListener {
    final /* synthetic */ bt aVy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bt btVar) {
        this.aVy = btVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tbadk.plugins.a.f(this.aVy.KM())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(this.aVy.KM().getPageActivity()).createNormalConfig("homepage", "all")));
        }
    }
}
