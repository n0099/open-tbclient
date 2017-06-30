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
public class bw implements View.OnClickListener {
    final /* synthetic */ bu bDl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bu buVar) {
        this.bDl = buVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        TbPageContext tbPageContext;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        TbPageContext tbPageContext2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        if (this.bDl.Vs() != null) {
            ci<CardPersonDynamicThreadData> Vs = this.bDl.Vs();
            cardPersonDynamicThreadData3 = this.bDl.bDa;
            Vs.a(view, cardPersonDynamicThreadData3);
        }
        cardPersonDynamicThreadData = this.bDl.bDa;
        if (cardPersonDynamicThreadData.bEK == 33) {
            TiebaStatic.log("c10254");
            tbPageContext = this.bDl.ajP;
            Activity pageActivity = tbPageContext.getPageActivity();
            cardPersonDynamicThreadData2 = this.bDl.bDa;
            PhotoLiveActivityConfig pa = new PhotoLiveActivityConfig.a(pageActivity, cardPersonDynamicThreadData2.threadId).cq(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bA(23014).pa();
            tbPageContext2 = this.bDl.ajP;
            tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pa));
            return;
        }
        this.bDl.VI();
    }
}
