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
    private final /* synthetic */ tinfo aDt;
    final /* synthetic */ e aDw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, tinfo tinfoVar) {
        this.aDw = eVar;
        this.aDt = tinfoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = this.aDt.forum_name;
        if (bb.aT(str)) {
            TiebaStatic.eventStat(this.aDw.getActivity(), "kantie_6", null, 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aDw.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
    }
}
