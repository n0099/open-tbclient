package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bb;
import tbclient.HotThread.tinfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a aDn;
    private final /* synthetic */ tinfo aDo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, tinfo tinfoVar) {
        this.aDn = aVar;
        this.aDo = tinfoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = this.aDo.forum_name;
        if (bb.aT(str)) {
            TiebaStatic.eventStat(this.aDn.getActivity(), "kantie_6", null, 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aDn.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
    }
}
