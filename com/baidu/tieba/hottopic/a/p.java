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
public class p implements bb<com.baidu.tieba.card.a.r> {
    final /* synthetic */ o bJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.bJF = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bb
    public void a(View view, com.baidu.tieba.card.a.r rVar) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        if (rVar != null && rVar.Ki() != null && !StringUtils.isNull(rVar.Ki().getTid()) && !StringUtils.isNull(rVar.Kh())) {
            if ("c10814".equals(rVar.Kh())) {
                au aa = new au("c10814").aa("tid", rVar.Ki().getId());
                tbPageContext2 = this.bJF.Nw;
                TiebaStatic.log(aa.aa("obj_name", ((HotTopicActivity) tbPageContext2.getOrignalPage()).getTopicName()));
            } else if ("c10816".equals(rVar.Kh())) {
                au aa2 = new au("c10816").aa("post_id", rVar.Ki().getTid());
                tbPageContext = this.bJF.Nw;
                TiebaStatic.log(aa2.aa("obj_name", ((HotTopicActivity) tbPageContext.getOrignalPage()).getTopicName()));
            }
        }
    }
}
