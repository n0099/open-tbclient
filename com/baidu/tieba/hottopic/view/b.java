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
    final /* synthetic */ a bJl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bJl = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        if (!com.baidu.adp.lib.util.i.iQ()) {
            tbPageContext4 = this.bJl.bIX;
            ((HotTopicActivity) tbPageContext4.getOrignalPage()).showToast(n.j.topic_share_no_network);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            tbPageContext3 = this.bJl.bIX;
            bj.af(tbPageContext3.getPageActivity());
        } else {
            av avVar = new av("c10521");
            tbPageContext = this.bJl.bIX;
            TiebaStatic.log(avVar.aa("obj_id", ((HotTopicActivity) tbPageContext.getOrignalPage()).Vo()));
            tbPageContext2 = this.bJl.bIX;
            ((HotTopicActivity) tbPageContext2.getOrignalPage()).Vp();
        }
    }
}
