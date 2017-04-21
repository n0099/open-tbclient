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
    private final /* synthetic */ com.baidu.tieba.homepage.recommendfrs.data.e cCM;
    final /* synthetic */ g cCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        this.cCR = gVar;
        this.cCM = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String forumName = this.cCM.getForumName();
        if (au.aB(forumName)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cCR.getActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            TiebaStatic.log(new as("c10509").aa("obj_name", this.cCM.Uw).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.cCM.cCy).aa("abtest", this.cCM.abtest));
        }
    }
}
