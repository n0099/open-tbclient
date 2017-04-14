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
class i implements View.OnClickListener {
    final /* synthetic */ g cAA;
    private final /* synthetic */ com.baidu.tieba.homepage.recommendfrs.data.e cAv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        this.cAA = gVar;
        this.cAv = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String forumName = this.cAv.getForumName();
        if (au.aB(forumName)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cAA.getActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            TiebaStatic.log(new as("c10509").aa("obj_name", this.cAv.Uu).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.cAv.cAh).aa("abtest", this.cAv.abtest));
        }
    }
}
