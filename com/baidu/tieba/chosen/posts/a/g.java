package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    private final /* synthetic */ tinfo aKR;
    final /* synthetic */ e aKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, tinfo tinfoVar) {
        this.aKU = eVar;
        this.aKR = tinfoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = this.aKR.forum_name;
        if (aq.aP(str)) {
            TiebaStatic.eventStat(this.aKU.getActivity(), "kantie_6", null, 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aKU.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
    }
}
