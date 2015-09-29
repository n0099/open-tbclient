package com.baidu.tieba.hottopic.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private final /* synthetic */ String ayO;
    final /* synthetic */ b bqg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str) {
        this.bqg = bVar;
        this.ayO = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HotTopicActivity hotTopicActivity;
        HotTopicActivity hotTopicActivity2;
        if (ar.aP(this.ayO)) {
            MessageManager messageManager = MessageManager.getInstance();
            hotTopicActivity = this.bqg.bnS;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(hotTopicActivity.getPageContext().getPageActivity()).createNormalCfg(this.ayO, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
            ap ae = new ap("c10365").ae("obj_type", "1");
            hotTopicActivity2 = this.bqg.bnS;
            TiebaStatic.log(ae.ae("obj_id", hotTopicActivity2.QP()));
        }
    }
}
