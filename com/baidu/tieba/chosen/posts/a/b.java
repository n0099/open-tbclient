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
class b implements View.OnClickListener {
    final /* synthetic */ a aKL;
    private final /* synthetic */ tinfo aKM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, tinfo tinfoVar) {
        this.aKL = aVar;
        this.aKM = tinfoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = this.aKM.forum_name;
        if (aq.aP(str)) {
            TiebaStatic.eventStat(this.aKL.getActivity(), "kantie_6", null, 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aKL.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
    }
}
