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
public class aw implements View.OnClickListener {
    final /* synthetic */ au aTQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(au auVar) {
        this.aTQ = auVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.as asVar;
        com.baidu.tbadk.core.data.as asVar2;
        com.baidu.tbadk.core.data.as asVar3;
        com.baidu.tbadk.core.data.as asVar4;
        com.baidu.tbadk.core.data.as asVar5;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.as asVar6;
        com.baidu.tbadk.core.data.as asVar7;
        com.baidu.tbadk.core.data.as asVar8;
        com.baidu.tieba.card.a.v vVar;
        asVar = this.aTQ.aeC;
        if (asVar != null) {
            asVar2 = this.aTQ.aeC;
            if (asVar2.getAuthor() != null) {
                asVar3 = this.aTQ.aeC;
                if (!StringUtils.isNull(asVar3.getAuthor().getName_show())) {
                    asVar4 = this.aTQ.aeC;
                    if (!StringUtils.isNull(asVar4.getAuthor().getUserId())) {
                        asVar5 = this.aTQ.aeC;
                        if (asVar5.tr() != null) {
                            if (this.aTQ.Ld() != null) {
                                cj<com.baidu.tieba.card.a.v> Ld = this.aTQ.Ld();
                                vVar = this.aTQ.aTM;
                                Ld.a(view, vVar);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.aTQ.ND;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            asVar6 = this.aTQ.aeC;
                            String userId = asVar6.getAuthor().getUserId();
                            asVar7 = this.aTQ.aeC;
                            String name_show = asVar7.getAuthor().getName_show();
                            asVar8 = this.aTQ.aeC;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, asVar8.tr(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
