package com.baidu.tieba.frs.entelechy.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ t bTE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.bTE = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        bj bjVar4;
        bj bjVar5;
        TbPageContext tbPageContext;
        bj bjVar6;
        bj bjVar7;
        bj bjVar8;
        bj bjVar9;
        bjVar = this.bTE.ain;
        if (bjVar != null) {
            bjVar2 = this.bTE.ain;
            if (bjVar2.getAuthor() != null) {
                bjVar3 = this.bTE.ain;
                if (!StringUtils.isNull(bjVar3.getAuthor().getName_show())) {
                    bjVar4 = this.bTE.ain;
                    if (!StringUtils.isNull(bjVar4.getAuthor().getUserId())) {
                        bjVar5 = this.bTE.ain;
                        if (bjVar5.rV() != null) {
                            if (this.bTE.getOnSubCardOnClickListenner() != null) {
                                cf<bj> onSubCardOnClickListenner = this.bTE.getOnSubCardOnClickListenner();
                                bjVar9 = this.bTE.ain;
                                onSubCardOnClickListenner.a(view, bjVar9);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bTE.ajF;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            bjVar6 = this.bTE.ain;
                            String userId = bjVar6.getAuthor().getUserId();
                            bjVar7 = this.bTE.ain;
                            String name_show = bjVar7.getAuthor().getName_show();
                            bjVar8 = this.bTE.ain;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, bjVar8.rV(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
