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
public class bo implements View.OnClickListener {
    final /* synthetic */ bl bey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bl blVar) {
        this.bey = blVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        TbPageContext tbPageContext;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        TbPageContext tbPageContext2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        if (this.bey.getOnSubCardOnClickListenner() != null) {
            bz<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.bey.getOnSubCardOnClickListenner();
            cardPersonDynamicThreadData3 = this.bey.bej;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData3);
        }
        cardPersonDynamicThreadData = this.bey.bej;
        if (cardPersonDynamicThreadData.bfJ == 33) {
            TiebaStatic.log("c10254");
            tbPageContext = this.bey.GO;
            Activity pageActivity = tbPageContext.getPageActivity();
            cardPersonDynamicThreadData2 = this.bey.bej;
            PhotoLiveActivityConfig oZ = new PhotoLiveActivityConfig.a(pageActivity, cardPersonDynamicThreadData2.threadId).cl(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bF(23014).oZ();
            tbPageContext2 = this.bey.GO;
            tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, oZ));
            return;
        }
        this.bey.Ph();
    }
}
