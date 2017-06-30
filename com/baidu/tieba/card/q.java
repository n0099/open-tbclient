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
    final /* synthetic */ p bBf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.bBf = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.i iVar;
        com.baidu.tieba.card.data.i iVar2;
        com.baidu.tieba.card.data.i iVar3;
        com.baidu.tieba.card.data.i iVar4;
        TbPageContext tbPageContext;
        com.baidu.tieba.card.data.i iVar5;
        com.baidu.tieba.card.data.i iVar6;
        iVar = this.bBf.bBe;
        if (iVar != null) {
            iVar2 = this.bBf.bBe;
            if (iVar2.author != null) {
                iVar3 = this.bBf.bBe;
                if (!StringUtils.isNull(iVar3.author.getName_show())) {
                    iVar4 = this.bBf.bBe;
                    if (!StringUtils.isNull(iVar4.author.getUserId())) {
                        if (this.bBf.atM != null) {
                            this.bBf.atM.onClick(view);
                        }
                        MessageManager messageManager = MessageManager.getInstance();
                        tbPageContext = this.bBf.aat;
                        Activity pageActivity = tbPageContext.getPageActivity();
                        iVar5 = this.bBf.bBe;
                        String userId = iVar5.author.getUserId();
                        iVar6 = this.bBf.bBe;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, iVar6.author.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                }
            }
        }
    }
}
