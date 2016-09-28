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
public class bs implements View.OnClickListener {
    final /* synthetic */ bp bbs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bp bpVar) {
        this.bbs = bpVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        TbPageContext tbPageContext;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        TbPageContext tbPageContext2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        if (this.bbs.getOnSubCardOnClickListenner() != null) {
            cd<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.bbs.getOnSubCardOnClickListenner();
            cardPersonDynamicThreadData3 = this.bbs.bbe;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData3);
        }
        cardPersonDynamicThreadData = this.bbs.bbe;
        if (cardPersonDynamicThreadData.bcK == 33) {
            TiebaStatic.log("c10254");
            tbPageContext = this.bbs.GM;
            Activity pageActivity = tbPageContext.getPageActivity();
            cardPersonDynamicThreadData2 = this.bbs.bbe;
            PhotoLiveActivityConfig oX = new PhotoLiveActivityConfig.a(pageActivity, cardPersonDynamicThreadData2.threadId).ck(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bF(23014).oX();
            tbPageContext2 = this.bbs.GM;
            tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, oX));
            return;
        }
        this.bbs.Of();
    }
}
