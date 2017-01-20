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
    final /* synthetic */ br bnD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(br brVar) {
        this.bnD = brVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        TbPageContext tbPageContext;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        TbPageContext tbPageContext2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        if (this.bnD.getOnSubCardOnClickListenner() != null) {
            cf<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.bnD.getOnSubCardOnClickListenner();
            cardPersonDynamicThreadData3 = this.bnD.bnq;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData3);
        }
        cardPersonDynamicThreadData = this.bnD.bnq;
        if (cardPersonDynamicThreadData.boT == 33) {
            TiebaStatic.log("c10254");
            tbPageContext = this.bnD.FY;
            Activity pageActivity = tbPageContext.getPageActivity();
            cardPersonDynamicThreadData2 = this.bnD.bnq;
            PhotoLiveActivityConfig oS = new PhotoLiveActivityConfig.a(pageActivity, cardPersonDynamicThreadData2.threadId).ck(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bF(23014).oS();
            tbPageContext2 = this.bnD.FY;
            tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, oS));
            return;
        }
        this.bnD.Rt();
    }
}
