package com.baidu.tieba.frs.entelechy.c;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ o bpH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.bpH = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ax axVar;
        ax axVar2;
        ax axVar3;
        ax axVar4;
        ax axVar5;
        TbPageContext tbPageContext;
        ax axVar6;
        ax axVar7;
        ax axVar8;
        axVar = this.bpH.aab;
        if (axVar != null) {
            axVar2 = this.bpH.aab;
            if (axVar2.getAuthor() != null) {
                axVar3 = this.bpH.aab;
                if (!StringUtils.isNull(axVar3.getAuthor().getName_show())) {
                    axVar4 = this.bpH.aab;
                    if (!StringUtils.isNull(axVar4.getAuthor().getUserId())) {
                        axVar5 = this.bpH.aab;
                        if (axVar5.qQ() != null) {
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bpH.DV;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            axVar6 = this.bpH.aab;
                            String userId = axVar6.getAuthor().getUserId();
                            axVar7 = this.bpH.aab;
                            String name_show = axVar7.getAuthor().getName_show();
                            axVar8 = this.bpH.aab;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, axVar8.qQ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
