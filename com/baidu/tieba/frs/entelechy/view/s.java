package com.baidu.tieba.frs.entelechy.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ q bTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.bTB = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        bk bkVar5;
        TbPageContext tbPageContext;
        bk bkVar6;
        bk bkVar7;
        bk bkVar8;
        bk bkVar9;
        bkVar = this.bTB.ahV;
        if (bkVar != null) {
            bkVar2 = this.bTB.ahV;
            if (bkVar2.getAuthor() != null) {
                bkVar3 = this.bTB.ahV;
                if (!StringUtils.isNull(bkVar3.getAuthor().getName_show())) {
                    bkVar4 = this.bTB.ahV;
                    if (!StringUtils.isNull(bkVar4.getAuthor().getUserId())) {
                        bkVar5 = this.bTB.ahV;
                        if (bkVar5.rD() != null) {
                            if (this.bTB.getOnSubCardOnClickListenner() != null) {
                                cd<bk> onSubCardOnClickListenner = this.bTB.getOnSubCardOnClickListenner();
                                bkVar9 = this.bTB.ahV;
                                onSubCardOnClickListenner.a(view, bkVar9);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bTB.ajr;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            bkVar6 = this.bTB.ahV;
                            String userId = bkVar6.getAuthor().getUserId();
                            bkVar7 = this.bTB.ahV;
                            String name_show = bkVar7.getAuthor().getName_show();
                            bkVar8 = this.bTB.ahV;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, bkVar8.rD(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
