package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aDH;
    final /* synthetic */ bn bdP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bn bnVar, TbPageContext tbPageContext) {
        this.bdP = bnVar;
        this.aDH = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        VideoListActivityConfig videoListActivityConfig = new VideoListActivityConfig(this.aDH.getPageActivity().getApplicationContext());
        cardPersonDynamicThreadData = this.bdP.bdB;
        String valueOf = String.valueOf(cardPersonDynamicThreadData.forumId);
        cardPersonDynamicThreadData2 = this.bdP.bdB;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoListActivityConfig.createNormalCfg(valueOf, cardPersonDynamicThreadData2.threadId, "")));
    }
}
