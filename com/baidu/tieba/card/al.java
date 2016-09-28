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
public class al implements View.OnClickListener {
    final /* synthetic */ aj bad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aj ajVar) {
        this.bad = ajVar;
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
        com.baidu.tieba.card.data.m mVar;
        biVar = this.bad.adW;
        if (biVar != null) {
            biVar2 = this.bad.adW;
            if (biVar2.getAuthor() != null) {
                biVar3 = this.bad.adW;
                if (!StringUtils.isNull(biVar3.getAuthor().getName_show())) {
                    biVar4 = this.bad.adW;
                    if (!StringUtils.isNull(biVar4.getAuthor().getUserId())) {
                        biVar5 = this.bad.adW;
                        if (biVar5.getForum_name() != null) {
                            if (this.bad.getOnSubCardOnClickListenner() != null) {
                                cd<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bad.getOnSubCardOnClickListenner();
                                mVar = this.bad.bac;
                                onSubCardOnClickListenner.a(view, mVar);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bad.GM;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            biVar6 = this.bad.adW;
                            String userId = biVar6.getAuthor().getUserId();
                            biVar7 = this.bad.adW;
                            String name_show = biVar7.getAuthor().getName_show();
                            biVar8 = this.bad.adW;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, biVar8.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
