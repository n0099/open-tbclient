package com.baidu.tieba.hottopic.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b bJk;
    private final /* synthetic */ com.baidu.tieba.hottopic.data.b bJl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.tieba.hottopic.data.b bVar2) {
        this.bJk = bVar;
        this.bJl = bVar2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(this.bJl.getId()), this.bJl.getName(), "")));
        TiebaStatic.log(new au("c10811").aa("obj_name", this.bJl.getName()));
    }
}
