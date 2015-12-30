package com.baidu.tieba.hottopic.a;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.viewpager.g;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements g.a<RelateForumItemData, com.baidu.tieba.hottopic.b.f> {
    final /* synthetic */ p bGt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.bGt = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.viewpager.g.a
    public void c(com.baidu.tieba.hottopic.b.f fVar, RelateForumItemData relateForumItemData) {
        HotTopicActivity hotTopicActivity;
        Context context;
        if (relateForumItemData != null) {
            av aa = new av("c10365").aa("obj_type", "1");
            hotTopicActivity = this.bGt.bGr;
            TiebaStatic.log(aa.aa("obj_id", hotTopicActivity.Vo()));
            if (ax.aR(relateForumItemData.forumName)) {
                MessageManager messageManager = MessageManager.getInstance();
                context = this.bGt.mContext;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
            }
        }
    }
}
