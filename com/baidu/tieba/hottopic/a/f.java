package com.baidu.tieba.hottopic.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ d bJm;
    private final /* synthetic */ com.baidu.tieba.hottopic.data.c bJn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, com.baidu.tieba.hottopic.data.c cVar) {
        this.bJm = dVar;
        this.bJn = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(this.bJn.getId()), this.bJn.getName(), "")));
        TiebaStatic.log(new au("c10812").aa("obj_name", this.bJn.getName()));
    }
}
