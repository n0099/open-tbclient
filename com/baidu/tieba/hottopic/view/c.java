package com.baidu.tieba.hottopic.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private final /* synthetic */ String ayZ;
    final /* synthetic */ b bqr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str) {
        this.bqr = bVar;
        this.ayZ = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HotTopicActivity hotTopicActivity;
        HotTopicActivity hotTopicActivity2;
        if (as.aP(this.ayZ)) {
            MessageManager messageManager = MessageManager.getInstance();
            hotTopicActivity = this.bqr.bod;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(hotTopicActivity.getPageContext().getPageActivity()).createNormalCfg(this.ayZ, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
            aq ae = new aq("c10365").ae("obj_type", "1");
            hotTopicActivity2 = this.bqr.bod;
            TiebaStatic.log(ae.ae("obj_id", hotTopicActivity2.QL()));
        }
    }
}
