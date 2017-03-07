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
    final /* synthetic */ ap btm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ap apVar) {
        this.btm = apVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.bj bjVar;
        com.baidu.tbadk.core.data.bj bjVar2;
        com.baidu.tbadk.core.data.bj bjVar3;
        com.baidu.tbadk.core.data.bj bjVar4;
        com.baidu.tbadk.core.data.bj bjVar5;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.bj bjVar6;
        com.baidu.tbadk.core.data.bj bjVar7;
        com.baidu.tbadk.core.data.bj bjVar8;
        com.baidu.tieba.card.data.n nVar;
        bjVar = this.btm.ain;
        if (bjVar != null) {
            bjVar2 = this.btm.ain;
            if (bjVar2.getAuthor() != null) {
                bjVar3 = this.btm.ain;
                if (!StringUtils.isNull(bjVar3.getAuthor().getName_show())) {
                    bjVar4 = this.btm.ain;
                    if (!StringUtils.isNull(bjVar4.getAuthor().getUserId())) {
                        bjVar5 = this.btm.ain;
                        if (bjVar5.rV() != null) {
                            if (this.btm.getOnSubCardOnClickListenner() != null) {
                                cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.btm.getOnSubCardOnClickListenner();
                                nVar = this.btm.btl;
                                onSubCardOnClickListenner.a(view, nVar);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.btm.ajF;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            bjVar6 = this.btm.ain;
                            String userId = bjVar6.getAuthor().getUserId();
                            bjVar7 = this.btm.ain;
                            String name_show = bjVar7.getAuthor().getName_show();
                            bjVar8 = this.btm.ain;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, bjVar8.rV(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
