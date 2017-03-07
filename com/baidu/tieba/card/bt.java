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
    final /* synthetic */ br buz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(br brVar) {
        this.buz = brVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        TbPageContext tbPageContext;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        TbPageContext tbPageContext2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        if (this.buz.getOnSubCardOnClickListenner() != null) {
            cf<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.buz.getOnSubCardOnClickListenner();
            cardPersonDynamicThreadData3 = this.buz.bul;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData3);
        }
        cardPersonDynamicThreadData = this.buz.bul;
        if (cardPersonDynamicThreadData.bvO == 33) {
            TiebaStatic.log("c10254");
            tbPageContext = this.buz.ajF;
            Activity pageActivity = tbPageContext.getPageActivity();
            cardPersonDynamicThreadData2 = this.buz.bul;
            PhotoLiveActivityConfig pg = new PhotoLiveActivityConfig.a(pageActivity, cardPersonDynamicThreadData2.threadId).cd(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bz(23014).pg();
            tbPageContext2 = this.buz.ajF;
            tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pg));
            return;
        }
        this.buz.Sr();
    }
}
