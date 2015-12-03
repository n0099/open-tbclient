package com.baidu.tieba.hottopic.a;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.viewpager.g;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements g.a<RelateForumItemData, com.baidu.tieba.hottopic.b.f> {
    final /* synthetic */ p bCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.bCP = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.viewpager.g.a
    public void c(com.baidu.tieba.hottopic.b.f fVar, RelateForumItemData relateForumItemData) {
        Context context;
        if (relateForumItemData != null && ax.aR(relateForumItemData.forumName)) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.bCP.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
        }
    }
}
