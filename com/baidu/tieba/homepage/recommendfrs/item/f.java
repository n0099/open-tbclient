package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ c cJa;
    private final /* synthetic */ com.baidu.tieba.homepage.recommendfrs.data.e cJb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        this.cJa = cVar;
        this.cJb = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String forumName = this.cJb.getForumName();
        if (az.aN(forumName)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cJa.getActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            TiebaStatic.log(new ax("c10509").ab("obj_name", this.cJb.PC).ab("obj_source", this.cJb.cIN).ab("abtest", this.cJb.abtest));
        }
    }
}
