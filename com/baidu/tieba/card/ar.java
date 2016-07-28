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
    final /* synthetic */ ap aUB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ap apVar) {
        this.aUB = apVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.be beVar;
        com.baidu.tbadk.core.data.be beVar2;
        com.baidu.tbadk.core.data.be beVar3;
        com.baidu.tbadk.core.data.be beVar4;
        com.baidu.tbadk.core.data.be beVar5;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.be beVar6;
        com.baidu.tbadk.core.data.be beVar7;
        com.baidu.tbadk.core.data.be beVar8;
        com.baidu.tieba.card.a.m mVar;
        beVar = this.aUB.abb;
        if (beVar != null) {
            beVar2 = this.aUB.abb;
            if (beVar2.getAuthor() != null) {
                beVar3 = this.aUB.abb;
                if (!StringUtils.isNull(beVar3.getAuthor().getName_show())) {
                    beVar4 = this.aUB.abb;
                    if (!StringUtils.isNull(beVar4.getAuthor().getUserId())) {
                        beVar5 = this.aUB.abb;
                        if (beVar5.getForum_name() != null) {
                            if (this.aUB.KN() != null) {
                                bx<com.baidu.tieba.card.a.m> KN = this.aUB.KN();
                                mVar = this.aUB.aUA;
                                KN.a(view, mVar);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.aUB.EA;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            beVar6 = this.aUB.abb;
                            String userId = beVar6.getAuthor().getUserId();
                            beVar7 = this.aUB.abb;
                            String name_show = beVar7.getAuthor().getName_show();
                            beVar8 = this.aUB.abb;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, beVar8.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
