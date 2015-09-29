package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements v {
    final /* synthetic */ a bnV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bnV = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        HotTopicActivity hotTopicActivity;
        HotTopicActivity hotTopicActivity2;
        HotTopicActivity hotTopicActivity3;
        if (uVar != null) {
            hotTopicActivity = this.bnV.bnS;
            if (hotTopicActivity != null && (uVar instanceof com.baidu.tbadk.core.data.v) && !(uVar instanceof com.baidu.tieba.hottopic.data.a)) {
                MessageManager messageManager = MessageManager.getInstance();
                hotTopicActivity2 = this.bnV.bnS;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(hotTopicActivity2.getPageContext().getPageActivity()).createNormalCfg(((com.baidu.tbadk.core.data.v) uVar).getTid(), null, HotTopicActivityConfig.ST_TYPE)));
                ap ae = new ap("c10368").ae("tid", ((com.baidu.tbadk.core.data.v) uVar).getTid());
                hotTopicActivity3 = this.bnV.bnS;
                TiebaStatic.log(ae.ae("obj_id", hotTopicActivity3.QP()));
            }
        }
    }
}
