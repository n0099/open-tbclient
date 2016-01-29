package com.baidu.tieba.hottopic.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.bb;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements bb<com.baidu.tieba.card.a.s> {
    final /* synthetic */ q bJI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.bJI = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bb
    public void a(View view, com.baidu.tieba.card.a.s sVar) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        if (sVar != null && sVar.Ki() != null && !StringUtils.isNull(sVar.Ki().getTid()) && !StringUtils.isNull(sVar.Kh())) {
            if ("c10814".equals(sVar.Kh())) {
                au aa = new au("c10814").aa("tid", sVar.Ki().getId());
                tbPageContext2 = this.bJI.Nw;
                TiebaStatic.log(aa.aa("obj_name", ((HotTopicActivity) tbPageContext2.getOrignalPage()).getTopicName()));
            } else if ("c10816".equals(sVar.Kh())) {
                au aa2 = new au("c10816").aa("post_id", sVar.Ki().getTid());
                tbPageContext = this.bJI.Nw;
                TiebaStatic.log(aa2.aa("obj_name", ((HotTopicActivity) tbPageContext.getOrignalPage()).getTopicName()));
            }
        }
    }
}
