package com.baidu.tieba.frs.entelechy.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ t bVJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.bVJ = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        bi biVar5;
        TbPageContext tbPageContext;
        bi biVar6;
        bi biVar7;
        bi biVar8;
        bi biVar9;
        biVar = this.bVJ.aiC;
        if (biVar != null) {
            biVar2 = this.bVJ.aiC;
            if (biVar2.getAuthor() != null) {
                biVar3 = this.bVJ.aiC;
                if (!StringUtils.isNull(biVar3.getAuthor().getName_show())) {
                    biVar4 = this.bVJ.aiC;
                    if (!StringUtils.isNull(biVar4.getAuthor().getUserId())) {
                        biVar5 = this.bVJ.aiC;
                        if (biVar5.st() != null) {
                            if (this.bVJ.getOnSubCardOnClickListenner() != null) {
                                cf<bi> onSubCardOnClickListenner = this.bVJ.getOnSubCardOnClickListenner();
                                biVar9 = this.bVJ.aiC;
                                onSubCardOnClickListenner.a(view, biVar9);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bVJ.ajU;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            biVar6 = this.bVJ.aiC;
                            String userId = biVar6.getAuthor().getUserId();
                            biVar7 = this.bVJ.aiC;
                            String name_show = biVar7.getAuthor().getName_show();
                            biVar8 = this.bVJ.aiC;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, biVar8.st(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
