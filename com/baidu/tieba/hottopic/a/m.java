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
public class m implements bb<com.baidu.tieba.card.a.q> {
    final /* synthetic */ l bJB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bJB = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bb
    public void a(View view, com.baidu.tieba.card.a.q qVar) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        if (qVar != null && qVar.Ki() != null && !StringUtils.isNull(qVar.Ki().getTid()) && !StringUtils.isNull(qVar.Kh())) {
            if ("c10814".equals(qVar.Kh())) {
                au aa = new au("c10814").aa("tid", qVar.Ki().getId());
                tbPageContext2 = this.bJB.Nw;
                TiebaStatic.log(aa.aa("obj_name", ((HotTopicActivity) tbPageContext2.getOrignalPage()).getTopicName()));
            } else if ("c10816".equals(qVar.Kh())) {
                au aa2 = new au("c10816").aa("post_id", qVar.Ki().getTid());
                tbPageContext = this.bJB.Nw;
                TiebaStatic.log(aa2.aa("obj_name", ((HotTopicActivity) tbPageContext.getOrignalPage()).getTopicName()));
            }
        }
    }
}
