package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class bk implements View.OnClickListener {
    final /* synthetic */ bj bei;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bj bjVar) {
        this.bei = bjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tbadk.plugins.a.f(this.bei.getTbPageContext())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(this.bei.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
        }
    }
}
