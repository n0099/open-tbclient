package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ c cBV;
    private final /* synthetic */ com.baidu.tieba.homepage.recommendfrs.data.e cBW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        this.cBV = cVar;
        this.cBW = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String forumName = this.cBW.getForumName();
        if (au.aG(forumName)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cBV.getActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            TiebaStatic.log(new as("c10509").Z("obj_name", this.cBW.Uc).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.cBW.cBI).Z("abtest", this.cBW.abtest));
        }
    }
}
