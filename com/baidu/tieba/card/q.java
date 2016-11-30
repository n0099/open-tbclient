package com.baidu.tieba.card;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ p bcE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.bcE = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.l lVar;
        com.baidu.tieba.card.data.l lVar2;
        com.baidu.tieba.card.data.l lVar3;
        com.baidu.tieba.card.data.l lVar4;
        TbPageContext tbPageContext;
        com.baidu.tieba.card.data.l lVar5;
        com.baidu.tieba.card.data.l lVar6;
        lVar = this.bcE.bcD;
        if (lVar != null) {
            lVar2 = this.bcE.bcD;
            if (lVar2.author != null) {
                lVar3 = this.bcE.bcD;
                if (!StringUtils.isNull(lVar3.author.getName_show())) {
                    lVar4 = this.bcE.bcD;
                    if (!StringUtils.isNull(lVar4.author.getUserId())) {
                        if (this.bcE.aoz != null) {
                            this.bcE.aoz.onClick(view);
                        }
                        MessageManager messageManager = MessageManager.getInstance();
                        tbPageContext = this.bcE.Gf;
                        Activity pageActivity = tbPageContext.getPageActivity();
                        lVar5 = this.bcE.bcD;
                        String userId = lVar5.author.getUserId();
                        lVar6 = this.bcE.bcD;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, lVar6.author.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                }
            }
        }
    }
}
