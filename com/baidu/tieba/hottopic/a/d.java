package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.v {
    final /* synthetic */ a bCx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bCx = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        HotTopicActivity hotTopicActivity;
        HotTopicActivity hotTopicActivity2;
        HotTopicActivity hotTopicActivity3;
        if (uVar != null) {
            hotTopicActivity = this.bCx.bCu;
            if (hotTopicActivity != null && (uVar instanceof z) && !(uVar instanceof com.baidu.tieba.hottopic.data.b)) {
                MessageManager messageManager = MessageManager.getInstance();
                hotTopicActivity2 = this.bCx.bCu;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(hotTopicActivity2.getPageContext().getPageActivity()).createNormalCfg(((z) uVar).getTid(), null, HotTopicActivityConfig.ST_TYPE)));
                av ab = new av("c10368").ab("tid", ((z) uVar).getTid());
                hotTopicActivity3 = this.bCx.bCu;
                TiebaStatic.log(ab.ab("obj_id", hotTopicActivity3.Ul()));
            }
        }
    }
}
