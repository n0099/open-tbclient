package com.baidu.tieba.hottopic.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ h bJL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bJL = hVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        List list;
        RelateTopicForumActivity relateTopicForumActivity;
        if (i >= 0) {
            list = this.bJL.bJJ;
            RelateForumItemData relateForumItemData = (RelateForumItemData) list.get(i);
            if (relateForumItemData != null && ax.aR(relateForumItemData.forumName)) {
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new av("c10371").aa(ImageViewerConfig.FORUM_ID, String.valueOf(relateForumItemData.forumId)).r("obj_type", com.baidu.tieba.hottopic.data.f.bHF));
                }
                MessageManager messageManager = MessageManager.getInstance();
                relateTopicForumActivity = this.bJL.bJH;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(relateTopicForumActivity.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
            }
        }
    }
}
