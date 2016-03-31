package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class cd implements View.OnClickListener {
    final /* synthetic */ cc aUO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cc ccVar) {
        this.aUO = ccVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(this.aUO.Lb().getPageActivity()).createNormalConfig("homepage", "all")));
    }
}
