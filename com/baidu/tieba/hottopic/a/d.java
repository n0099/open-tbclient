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
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements v {
    final /* synthetic */ a bog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bog = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        HotTopicActivity hotTopicActivity;
        HotTopicActivity hotTopicActivity2;
        HotTopicActivity hotTopicActivity3;
        if (uVar != null) {
            hotTopicActivity = this.bog.bod;
            if (hotTopicActivity != null && (uVar instanceof w) && !(uVar instanceof com.baidu.tieba.hottopic.data.a)) {
                MessageManager messageManager = MessageManager.getInstance();
                hotTopicActivity2 = this.bog.bod;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(hotTopicActivity2.getPageContext().getPageActivity()).createNormalCfg(((w) uVar).getTid(), null, HotTopicActivityConfig.ST_TYPE)));
                aq ae = new aq("c10368").ae("tid", ((w) uVar).getTid());
                hotTopicActivity3 = this.bog.bod;
                TiebaStatic.log(ae.ae("obj_id", hotTopicActivity3.QP()));
            }
        }
    }
}
