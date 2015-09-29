package com.baidu.tieba.hottopic.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements AdapterView.OnItemClickListener {
    final /* synthetic */ e bql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bql = eVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        List list;
        RelateTopicForumActivity relateTopicForumActivity;
        if (i >= 0) {
            list = this.bql.bqj;
            RelateForumItemData relateForumItemData = (RelateForumItemData) list.get(i);
            if (relateForumItemData != null && ar.aP(relateForumItemData.forumName)) {
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new ap("c10371").ae(ImageViewerConfig.FORUM_ID, String.valueOf(relateForumItemData.forumId)).r("obj_type", com.baidu.tieba.hottopic.data.d.boO));
                }
                MessageManager messageManager = MessageManager.getInstance();
                relateTopicForumActivity = this.bql.bqh;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(relateTopicForumActivity.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
            }
        }
    }
}
