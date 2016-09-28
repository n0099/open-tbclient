package com.baidu.tieba.card;

import android.text.TextPaint;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq extends com.baidu.tieba.view.q {
    final /* synthetic */ bp bbs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar) {
        this.bbs = bpVar;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        cardPersonDynamicThreadData = this.bbs.bbe;
        if (cardPersonDynamicThreadData != null) {
            cardPersonDynamicThreadData2 = this.bbs.bbe;
            if (!StringUtils.isNull(cardPersonDynamicThreadData2.forumName)) {
                MessageManager messageManager = MessageManager.getInstance();
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.bbs.mContext);
                cardPersonDynamicThreadData3 = this.bbs.bbe;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createNormalCfg(cardPersonDynamicThreadData3.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
            }
        }
    }

    @Override // com.baidu.tieba.view.q
    public void a(TextPaint textPaint, boolean z) {
        textPaint.setColor(z ? this.bbs.mContext.getResources().getColor(r.d.cp_link_tip_c) : this.bbs.mContext.getResources().getColor(r.d.cp_link_tip_a));
    }
}
