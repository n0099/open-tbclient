package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c aKg;
    private final /* synthetic */ tinfo aKh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, tinfo tinfoVar) {
        this.aKg = cVar;
        this.aKh = tinfoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = this.aKh.forum_name;
        if (as.aP(str)) {
            TiebaStatic.eventStat(this.aKg.getActivity(), "kantie_6", null, 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aKg.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
    }
}
