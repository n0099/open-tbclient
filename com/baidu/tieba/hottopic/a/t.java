package com.baidu.tieba.hottopic.a;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.RelateTopicForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ s bCT;
    private final /* synthetic */ com.baidu.tieba.hottopic.data.j bCU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tieba.hottopic.data.j jVar) {
        this.bCT = sVar;
        this.bCU = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HotTopicActivity hotTopicActivity;
        HotTopicActivity hotTopicActivity2;
        HotTopicActivity hotTopicActivity3;
        if (this.bCU != null && this.bCU.bEw != null) {
            hotTopicActivity = this.bCT.bCu;
            RelateTopicForumActivityConfig relateTopicForumActivityConfig = new RelateTopicForumActivityConfig(hotTopicActivity.getPageContext().getPageActivity(), this.bCU.bEw);
            hotTopicActivity2 = this.bCT.bCu;
            hotTopicActivity2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, relateTopicForumActivityConfig));
            av ab = new av("c10365").ab("obj_type", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
            hotTopicActivity3 = this.bCT.bCu;
            TiebaStatic.log(ab.ab("obj_id", hotTopicActivity3.Ul()));
        }
    }
}
