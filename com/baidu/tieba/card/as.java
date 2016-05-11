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
public class as implements View.OnClickListener {
    final /* synthetic */ aq aQm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(aq aqVar) {
        this.aQm = aqVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.ax axVar;
        com.baidu.tbadk.core.data.ax axVar2;
        com.baidu.tbadk.core.data.ax axVar3;
        com.baidu.tbadk.core.data.ax axVar4;
        com.baidu.tbadk.core.data.ax axVar5;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.ax axVar6;
        com.baidu.tbadk.core.data.ax axVar7;
        com.baidu.tbadk.core.data.ax axVar8;
        com.baidu.tieba.card.a.l lVar;
        axVar = this.aQm.aab;
        if (axVar != null) {
            axVar2 = this.aQm.aab;
            if (axVar2.getAuthor() != null) {
                axVar3 = this.aQm.aab;
                if (!StringUtils.isNull(axVar3.getAuthor().getName_show())) {
                    axVar4 = this.aQm.aab;
                    if (!StringUtils.isNull(axVar4.getAuthor().getUserId())) {
                        axVar5 = this.aQm.aab;
                        if (axVar5.qP() != null) {
                            if (this.aQm.JM() != null) {
                                by<com.baidu.tieba.card.a.l> JM = this.aQm.JM();
                                lVar = this.aQm.aQl;
                                JM.a(view, lVar);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.aQm.DV;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            axVar6 = this.aQm.aab;
                            String userId = axVar6.getAuthor().getUserId();
                            axVar7 = this.aQm.aab;
                            String name_show = axVar7.getAuthor().getName_show();
                            axVar8 = this.aQm.aab;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, axVar8.qP(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
