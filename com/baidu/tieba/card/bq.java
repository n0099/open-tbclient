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
public class bq implements View.OnClickListener {
    final /* synthetic */ bn bdP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bn bnVar) {
        this.bdP = bnVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        TbPageContext tbPageContext;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        TbPageContext tbPageContext2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        if (this.bdP.getOnSubCardOnClickListenner() != null) {
            cb<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.bdP.getOnSubCardOnClickListenner();
            cardPersonDynamicThreadData3 = this.bdP.bdB;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData3);
        }
        cardPersonDynamicThreadData = this.bdP.bdB;
        if (cardPersonDynamicThreadData.beY == 33) {
            TiebaStatic.log("c10254");
            tbPageContext = this.bdP.GO;
            Activity pageActivity = tbPageContext.getPageActivity();
            cardPersonDynamicThreadData2 = this.bdP.bdB;
            PhotoLiveActivityConfig oZ = new PhotoLiveActivityConfig.a(pageActivity, cardPersonDynamicThreadData2.threadId).cm(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bG(23014).oZ();
            tbPageContext2 = this.bdP.GO;
            tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, oZ));
            return;
        }
        this.bdP.OD();
    }
}
