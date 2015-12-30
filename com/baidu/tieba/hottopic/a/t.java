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
    final /* synthetic */ s bGx;
    private final /* synthetic */ com.baidu.tieba.hottopic.data.j bGy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tieba.hottopic.data.j jVar) {
        this.bGx = sVar;
        this.bGy = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HotTopicActivity hotTopicActivity;
        HotTopicActivity hotTopicActivity2;
        HotTopicActivity hotTopicActivity3;
        if (this.bGy != null && this.bGy.bIa != null) {
            hotTopicActivity = this.bGx.bFY;
            RelateTopicForumActivityConfig relateTopicForumActivityConfig = new RelateTopicForumActivityConfig(hotTopicActivity.getPageContext().getPageActivity(), this.bGy.bIa);
            hotTopicActivity2 = this.bGx.bFY;
            hotTopicActivity2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, relateTopicForumActivityConfig));
            av aa = new av("c10365").aa("obj_type", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
            hotTopicActivity3 = this.bGx.bFY;
            TiebaStatic.log(aa.aa("obj_id", hotTopicActivity3.Vo()));
        }
    }
}
