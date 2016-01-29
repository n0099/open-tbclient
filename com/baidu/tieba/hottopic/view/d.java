package com.baidu.tieba.hottopic.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c bMS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bMS = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        if (!com.baidu.adp.lib.util.i.iZ()) {
            tbPageContext4 = this.bMS.bME;
            ((HotTopicActivity) tbPageContext4.getOrignalPage()).showToast(t.j.topic_share_no_network);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            tbPageContext3 = this.bMS.bME;
            bi.af(tbPageContext3.getPageActivity());
        } else {
            au auVar = new au("c10521");
            tbPageContext = this.bMS.bME;
            TiebaStatic.log(auVar.aa("obj_id", ((HotTopicActivity) tbPageContext.getOrignalPage()).XB()));
            tbPageContext2 = this.bMS.bME;
            ((HotTopicActivity) tbPageContext2.getOrignalPage()).XC();
        }
    }
}
