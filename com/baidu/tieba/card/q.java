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
    final /* synthetic */ p bbL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.bbL = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.k kVar;
        com.baidu.tieba.card.data.k kVar2;
        com.baidu.tieba.card.data.k kVar3;
        com.baidu.tieba.card.data.k kVar4;
        TbPageContext tbPageContext;
        com.baidu.tieba.card.data.k kVar5;
        com.baidu.tieba.card.data.k kVar6;
        kVar = this.bbL.bbK;
        if (kVar != null) {
            kVar2 = this.bbL.bbK;
            if (kVar2.author != null) {
                kVar3 = this.bbL.bbK;
                if (!StringUtils.isNull(kVar3.author.getName_show())) {
                    kVar4 = this.bbL.bbK;
                    if (!StringUtils.isNull(kVar4.author.getUserId())) {
                        if (this.bbL.aob != null) {
                            this.bbL.aob.onClick(view);
                        }
                        MessageManager messageManager = MessageManager.getInstance();
                        tbPageContext = this.bbL.Gf;
                        Activity pageActivity = tbPageContext.getPageActivity();
                        kVar5 = this.bbL.bbK;
                        String userId = kVar5.author.getUserId();
                        kVar6 = this.bbL.bbK;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, kVar6.author.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                }
            }
        }
    }
}
