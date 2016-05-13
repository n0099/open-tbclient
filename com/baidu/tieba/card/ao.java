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
public class ao implements View.OnClickListener {
    final /* synthetic */ am aQk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar) {
        this.aQk = amVar;
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
        com.baidu.tieba.card.a.n nVar;
        axVar = this.aQk.aab;
        if (axVar != null) {
            axVar2 = this.aQk.aab;
            if (axVar2.getAuthor() != null) {
                axVar3 = this.aQk.aab;
                if (!StringUtils.isNull(axVar3.getAuthor().getName_show())) {
                    axVar4 = this.aQk.aab;
                    if (!StringUtils.isNull(axVar4.getAuthor().getUserId())) {
                        axVar5 = this.aQk.aab;
                        if (axVar5.qQ() != null) {
                            if (this.aQk.JO() != null) {
                                by<com.baidu.tieba.card.a.n> JO = this.aQk.JO();
                                nVar = this.aQk.aQg;
                                JO.a(view, nVar);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.aQk.DV;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            axVar6 = this.aQk.aab;
                            String userId = axVar6.getAuthor().getUserId();
                            axVar7 = this.aQk.aab;
                            String name_show = axVar7.getAuthor().getName_show();
                            axVar8 = this.aQk.aab;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, axVar8.qQ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
