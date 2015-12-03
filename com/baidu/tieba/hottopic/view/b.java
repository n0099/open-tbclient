package com.baidu.tieba.hottopic.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bFE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bFE = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        if (!com.baidu.adp.lib.util.i.iP()) {
            tbPageContext4 = this.bFE.bFq;
            ((HotTopicActivity) tbPageContext4.getOrignalPage()).showToast(n.i.topic_share_no_network);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            tbPageContext3 = this.bFE.bFq;
            bj.af(tbPageContext3.getPageActivity());
        } else {
            av avVar = new av("c10521");
            tbPageContext = this.bFE.bFq;
            TiebaStatic.log(avVar.ab("obj_id", ((HotTopicActivity) tbPageContext.getOrignalPage()).Ul()));
            tbPageContext2 = this.bFE.bFq;
            ((HotTopicActivity) tbPageContext2.getOrignalPage()).Um();
        }
    }
}
