package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    private final /* synthetic */ tinfo aTB;
    final /* synthetic */ e aTE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, tinfo tinfoVar) {
        this.aTE = eVar;
        this.aTB = tinfoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = this.aTB.forum_name;
        if (aw.aQ(str)) {
            TiebaStatic.eventStat(this.aTE.getActivity(), "kantie_6", null, 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aTE.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
    }
}
