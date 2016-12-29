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
public class an implements View.OnClickListener {
    final /* synthetic */ al bcD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar) {
        this.bcD = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.bg bgVar;
        com.baidu.tbadk.core.data.bg bgVar2;
        com.baidu.tbadk.core.data.bg bgVar3;
        com.baidu.tbadk.core.data.bg bgVar4;
        com.baidu.tbadk.core.data.bg bgVar5;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.bg bgVar6;
        com.baidu.tbadk.core.data.bg bgVar7;
        com.baidu.tbadk.core.data.bg bgVar8;
        com.baidu.tieba.card.data.m mVar;
        bgVar = this.bcD.adN;
        if (bgVar != null) {
            bgVar2 = this.bcD.adN;
            if (bgVar2.getAuthor() != null) {
                bgVar3 = this.bcD.adN;
                if (!StringUtils.isNull(bgVar3.getAuthor().getName_show())) {
                    bgVar4 = this.bcD.adN;
                    if (!StringUtils.isNull(bgVar4.getAuthor().getUserId())) {
                        bgVar5 = this.bcD.adN;
                        if (bgVar5.rK() != null) {
                            if (this.bcD.getOnSubCardOnClickListenner() != null) {
                                cb<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bcD.getOnSubCardOnClickListenner();
                                mVar = this.bcD.bcC;
                                onSubCardOnClickListenner.a(view, mVar);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bcD.GO;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            bgVar6 = this.bcD.adN;
                            String userId = bgVar6.getAuthor().getUserId();
                            bgVar7 = this.bcD.adN;
                            String name_show = bgVar7.getAuthor().getName_show();
                            bgVar8 = this.bcD.adN;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, bgVar8.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
