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
public class q implements View.OnClickListener {
    final /* synthetic */ p aZv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.aZv = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.l lVar;
        com.baidu.tieba.card.data.l lVar2;
        com.baidu.tieba.card.data.l lVar3;
        com.baidu.tieba.card.data.l lVar4;
        Context context;
        com.baidu.tieba.card.data.l lVar5;
        com.baidu.tieba.card.data.l lVar6;
        lVar = this.aZv.aZu;
        if (lVar != null) {
            lVar2 = this.aZv.aZu;
            if (lVar2.author != null) {
                lVar3 = this.aZv.aZu;
                if (!StringUtils.isNull(lVar3.author.getName_show())) {
                    lVar4 = this.aZv.aZu;
                    if (!StringUtils.isNull(lVar4.author.getUserId())) {
                        if (this.aZv.anF != null) {
                            this.aZv.anF.onClick(view);
                        }
                        MessageManager messageManager = MessageManager.getInstance();
                        context = this.aZv.mContext;
                        lVar5 = this.aZv.aZu;
                        String userId = lVar5.author.getUserId();
                        lVar6 = this.aZv.aZu;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, lVar6.author.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                }
            }
        }
    }
}
