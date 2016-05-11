package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements View.OnClickListener {
    final /* synthetic */ bu aRg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bu buVar) {
        this.aRg = buVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tbadk.plugins.a.f(this.aRg.getTbPageContext())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(this.aRg.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
        }
    }
}
