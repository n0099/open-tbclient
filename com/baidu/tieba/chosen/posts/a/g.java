package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    private final /* synthetic */ tinfo aNC;
    final /* synthetic */ e aNF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, tinfo tinfoVar) {
        this.aNF = eVar;
        this.aNC = tinfoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = this.aNC.forum_name;
        if (ax.aR(str)) {
            TiebaStatic.eventStat(this.aNF.getActivity(), "kantie_6", null, 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aNF.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
    }
}
