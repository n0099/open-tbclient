package com.baidu.tieba.card;

import android.text.TextPaint;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv extends com.baidu.tieba.view.v {
    final /* synthetic */ bu bDl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bu buVar) {
        this.bDl = buVar;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        cardPersonDynamicThreadData = this.bDl.bDa;
        if (cardPersonDynamicThreadData != null) {
            cardPersonDynamicThreadData2 = this.bDl.bDa;
            if (!StringUtils.isNull(cardPersonDynamicThreadData2.forumName)) {
                MessageManager messageManager = MessageManager.getInstance();
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.bDl.mContext);
                cardPersonDynamicThreadData3 = this.bDl.bDa;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createNormalCfg(cardPersonDynamicThreadData3.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
            }
        }
    }

    @Override // com.baidu.tieba.view.v
    public void a(TextPaint textPaint, boolean z) {
        textPaint.setColor(z ? this.bDl.mContext.getResources().getColor(w.e.cp_link_tip_c) : this.bDl.mContext.getResources().getColor(w.e.cp_link_tip_a));
    }
}
