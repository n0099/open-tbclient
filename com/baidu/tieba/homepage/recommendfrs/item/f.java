package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ c ctO;
    private final /* synthetic */ com.baidu.tieba.homepage.recommendfrs.data.e ctP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        this.ctO = cVar;
        this.ctP = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String forumName = this.ctP.getForumName();
        if (ba.aL(forumName)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ctO.getActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            TiebaStatic.log(new ay("c10509").ab("obj_name", this.ctP.csz).ab("obj_source", this.ctP.ctB).ab("abtest", this.ctP.abtest));
        }
    }
}
