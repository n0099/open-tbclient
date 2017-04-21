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
public class bt implements View.OnClickListener {
    final /* synthetic */ br bwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(br brVar) {
        this.bwI = brVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        TbPageContext tbPageContext;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        TbPageContext tbPageContext2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        if (this.bwI.getOnSubCardOnClickListenner() != null) {
            cf<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.bwI.getOnSubCardOnClickListenner();
            cardPersonDynamicThreadData3 = this.bwI.bwv;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData3);
        }
        cardPersonDynamicThreadData = this.bwI.bwv;
        if (cardPersonDynamicThreadData.bxY == 33) {
            TiebaStatic.log("c10254");
            tbPageContext = this.bwI.ajU;
            Activity pageActivity = tbPageContext.getPageActivity();
            cardPersonDynamicThreadData2 = this.bwI.bwv;
            PhotoLiveActivityConfig pE = new PhotoLiveActivityConfig.a(pageActivity, cardPersonDynamicThreadData2.threadId).ck(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bC(23014).pE();
            tbPageContext2 = this.bwI.ajU;
            tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pE));
            return;
        }
        this.bwI.TR();
    }
}
