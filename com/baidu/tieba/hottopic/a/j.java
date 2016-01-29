package com.baidu.tieba.hottopic.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ h bJw;
    private final /* synthetic */ com.baidu.tieba.hottopic.data.f bJy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, com.baidu.tieba.hottopic.data.f fVar) {
        this.bJw = hVar;
        this.bJy = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hottopic", "all")));
        TiebaStatic.log(new au("c10813").aa("obj_name", this.bJy.Wm));
    }
}
