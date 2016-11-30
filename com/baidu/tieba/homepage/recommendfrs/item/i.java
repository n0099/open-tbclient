package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.homepage.recommendfrs.data.e cOq;
    final /* synthetic */ g cOv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        this.cOv = gVar;
        this.cOq = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String forumName = this.cOq.getForumName();
        if (ax.aN(forumName)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cOv.getActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            TiebaStatic.log(new av("c10509").ab("obj_name", this.cOq.PW).ab("obj_source", this.cOq.cOc).ab("abtest", this.cOq.abtest));
        }
    }
}
