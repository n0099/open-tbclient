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
    final /* synthetic */ ap bms;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ap apVar) {
        this.bms = apVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.bh bhVar;
        com.baidu.tbadk.core.data.bh bhVar2;
        com.baidu.tbadk.core.data.bh bhVar3;
        com.baidu.tbadk.core.data.bh bhVar4;
        com.baidu.tbadk.core.data.bh bhVar5;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.bh bhVar6;
        com.baidu.tbadk.core.data.bh bhVar7;
        com.baidu.tbadk.core.data.bh bhVar8;
        com.baidu.tieba.card.data.n nVar;
        bhVar = this.bms.acX;
        if (bhVar != null) {
            bhVar2 = this.bms.acX;
            if (bhVar2.getAuthor() != null) {
                bhVar3 = this.bms.acX;
                if (!StringUtils.isNull(bhVar3.getAuthor().getName_show())) {
                    bhVar4 = this.bms.acX;
                    if (!StringUtils.isNull(bhVar4.getAuthor().getUserId())) {
                        bhVar5 = this.bms.acX;
                        if (bhVar5.rB() != null) {
                            if (this.bms.getOnSubCardOnClickListenner() != null) {
                                cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.bms.getOnSubCardOnClickListenner();
                                nVar = this.bms.bmr;
                                onSubCardOnClickListenner.a(view, nVar);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bms.FY;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            bhVar6 = this.bms.acX;
                            String userId = bhVar6.getAuthor().getUserId();
                            bhVar7 = this.bms.acX;
                            String name_show = bhVar7.getAuthor().getName_show();
                            bhVar8 = this.bms.acX;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, bhVar8.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
