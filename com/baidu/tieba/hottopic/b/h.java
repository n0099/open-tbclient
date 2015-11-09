package com.baidu.tieba.hottopic.b;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.RelateTopicForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ e bqF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.bqF = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.hottopic.data.g gVar;
        com.baidu.tieba.hottopic.data.g gVar2;
        HotTopicActivity hotTopicActivity;
        com.baidu.tieba.hottopic.data.g gVar3;
        HotTopicActivity hotTopicActivity2;
        HotTopicActivity hotTopicActivity3;
        gVar = this.bqF.bqD;
        if (gVar != null) {
            gVar2 = this.bqF.bqD;
            if (gVar2.bpU != null) {
                hotTopicActivity = this.bqF.bqC;
                Activity pageActivity = hotTopicActivity.getPageContext().getPageActivity();
                gVar3 = this.bqF.bqD;
                RelateTopicForumActivityConfig relateTopicForumActivityConfig = new RelateTopicForumActivityConfig(pageActivity, gVar3.bpU);
                hotTopicActivity2 = this.bqF.bqC;
                hotTopicActivity2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, relateTopicForumActivityConfig));
                aq ae = new aq("c10365").ae("obj_type", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                hotTopicActivity3 = this.bqF.bqC;
                TiebaStatic.log(ae.ae("obj_id", hotTopicActivity3.Rh()));
            }
        }
    }
}
