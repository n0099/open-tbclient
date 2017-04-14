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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ q bTr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.bTr = qVar;
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
        biVar = this.bTr.aiB;
        if (biVar != null) {
            biVar2 = this.bTr.aiB;
            if (biVar2.getAuthor() != null) {
                biVar3 = this.bTr.aiB;
                if (!StringUtils.isNull(biVar3.getAuthor().getName_show())) {
                    biVar4 = this.bTr.aiB;
                    if (!StringUtils.isNull(biVar4.getAuthor().getUserId())) {
                        biVar5 = this.bTr.aiB;
                        if (biVar5.st() != null) {
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bTr.ajT;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            biVar6 = this.bTr.aiB;
                            String userId = biVar6.getAuthor().getUserId();
                            biVar7 = this.bTr.aiB;
                            String name_show = biVar7.getAuthor().getName_show();
                            biVar8 = this.bTr.aiB;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, biVar8.st(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
