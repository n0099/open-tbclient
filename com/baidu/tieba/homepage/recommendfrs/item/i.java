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
class i implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.homepage.recommendfrs.data.e cIj;
    final /* synthetic */ g cIp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        this.cIp = gVar;
        this.cIj = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String forumName = this.cIj.getForumName();
        if (ba.aN(forumName)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cIp.getActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            TiebaStatic.log(new ay("c10509").ab("obj_name", this.cIj.PE).ab("obj_source", this.cIj.cHV).ab("abtest", this.cIj.abtest));
        }
    }
}
