package com.baidu.tieba.card;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements View.OnClickListener {
    final /* synthetic */ br bbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(br brVar) {
        this.bbb = brVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        TbPageContext tbPageContext;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        TbPageContext tbPageContext2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        if (this.bbb.getOnSubCardOnClickListenner() != null) {
            cf<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.bbb.getOnSubCardOnClickListenner();
            cardPersonDynamicThreadData3 = this.bbb.baN;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData3);
        }
        cardPersonDynamicThreadData = this.bbb.baN;
        if (cardPersonDynamicThreadData.bcq == 33) {
            TiebaStatic.log("c10254");
            tbPageContext = this.bbb.GM;
            Activity pageActivity = tbPageContext.getPageActivity();
            cardPersonDynamicThreadData2 = this.bbb.baN;
            PhotoLiveActivityConfig oW = new PhotoLiveActivityConfig.a(pageActivity, cardPersonDynamicThreadData2.threadId).ck(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bF(23014).oW();
            tbPageContext2 = this.bbb.GM;
            tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, oW));
            return;
        }
        this.bbb.NF();
    }
}
