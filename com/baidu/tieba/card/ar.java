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
public class ar implements View.OnClickListener {
    final /* synthetic */ ap bte;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ap apVar) {
        this.bte = apVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.bi biVar;
        com.baidu.tbadk.core.data.bi biVar2;
        com.baidu.tbadk.core.data.bi biVar3;
        com.baidu.tbadk.core.data.bi biVar4;
        com.baidu.tbadk.core.data.bi biVar5;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.bi biVar6;
        com.baidu.tbadk.core.data.bi biVar7;
        com.baidu.tbadk.core.data.bi biVar8;
        com.baidu.tieba.card.data.n nVar;
        biVar = this.bte.aiB;
        if (biVar != null) {
            biVar2 = this.bte.aiB;
            if (biVar2.getAuthor() != null) {
                biVar3 = this.bte.aiB;
                if (!StringUtils.isNull(biVar3.getAuthor().getName_show())) {
                    biVar4 = this.bte.aiB;
                    if (!StringUtils.isNull(biVar4.getAuthor().getUserId())) {
                        biVar5 = this.bte.aiB;
                        if (biVar5.st() != null) {
                            if (this.bte.getOnSubCardOnClickListenner() != null) {
                                cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.bte.getOnSubCardOnClickListenner();
                                nVar = this.bte.btd;
                                onSubCardOnClickListenner.a(view, nVar);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bte.ajT;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            biVar6 = this.bte.aiB;
                            String userId = biVar6.getAuthor().getUserId();
                            biVar7 = this.bte.aiB;
                            String name_show = biVar7.getAuthor().getName_show();
                            biVar8 = this.bte.aiB;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, biVar8.st(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
