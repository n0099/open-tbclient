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
    final /* synthetic */ bu bCs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bu buVar) {
        this.bCs = buVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        TbPageContext tbPageContext;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        TbPageContext tbPageContext2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        if (this.bCs.Ud() != null) {
            ci<CardPersonDynamicThreadData> Ud = this.bCs.Ud();
            cardPersonDynamicThreadData3 = this.bCs.bCh;
            Ud.a(view, cardPersonDynamicThreadData3);
        }
        cardPersonDynamicThreadData = this.bCs.bCh;
        if (cardPersonDynamicThreadData.bDS == 33) {
            TiebaStatic.log("c10254");
            tbPageContext = this.bCs.ajh;
            Activity pageActivity = tbPageContext.getPageActivity();
            cardPersonDynamicThreadData2 = this.bCs.bCh;
            PhotoLiveActivityConfig pd = new PhotoLiveActivityConfig.a(pageActivity, cardPersonDynamicThreadData2.threadId).ck(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bA(23014).pd();
            tbPageContext2 = this.bCs.ajh;
            tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pd));
            return;
        }
        this.bCs.Ur();
    }
}
