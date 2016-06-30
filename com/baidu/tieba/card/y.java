package com.baidu.tieba.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ x aSX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.aSX = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.l lVar;
        com.baidu.tieba.card.a.l lVar2;
        com.baidu.tieba.card.a.l lVar3;
        com.baidu.tieba.card.a.l lVar4;
        Context context;
        com.baidu.tieba.card.a.l lVar5;
        com.baidu.tieba.card.a.l lVar6;
        lVar = this.aSX.aSW;
        if (lVar != null) {
            lVar2 = this.aSX.aSW;
            if (lVar2.author != null) {
                lVar3 = this.aSX.aSW;
                if (!StringUtils.isNull(lVar3.author.getName_show())) {
                    lVar4 = this.aSX.aSW;
                    if (!StringUtils.isNull(lVar4.author.getUserId())) {
                        if (this.aSX.akb != null) {
                            this.aSX.akb.onClick(view);
                        }
                        MessageManager messageManager = MessageManager.getInstance();
                        context = this.aSX.mContext;
                        lVar5 = this.aSX.aSW;
                        String userId = lVar5.author.getUserId();
                        lVar6 = this.aSX.aSW;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, lVar6.author.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                }
            }
        }
    }
}
