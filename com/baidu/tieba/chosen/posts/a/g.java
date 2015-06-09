package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bb;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    private final /* synthetic */ tinfo aDu;
    final /* synthetic */ e aDx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, tinfo tinfoVar) {
        this.aDx = eVar;
        this.aDu = tinfoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = this.aDu.forum_name;
        if (bb.aT(str)) {
            TiebaStatic.eventStat(this.aDx.getActivity(), "kantie_6", null, 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aDx.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
    }
}
