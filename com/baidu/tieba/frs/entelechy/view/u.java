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
import com.baidu.tieba.card.bz;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ s caz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.caz = sVar;
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
        bkVar = this.caz.aeu;
        if (bkVar != null) {
            bkVar2 = this.caz.aeu;
            if (bkVar2.getAuthor() != null) {
                bkVar3 = this.caz.aeu;
                if (!StringUtils.isNull(bkVar3.getAuthor().getName_show())) {
                    bkVar4 = this.caz.aeu;
                    if (!StringUtils.isNull(bkVar4.getAuthor().getUserId())) {
                        bkVar5 = this.caz.aeu;
                        if (bkVar5.getForum_name() != null) {
                            if (this.caz.getOnSubCardOnClickListenner() != null) {
                                bz<bk> onSubCardOnClickListenner = this.caz.getOnSubCardOnClickListenner();
                                bkVar9 = this.caz.aeu;
                                onSubCardOnClickListenner.a(view, bkVar9);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.caz.GO;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            bkVar6 = this.caz.aeu;
                            String userId = bkVar6.getAuthor().getUserId();
                            bkVar7 = this.caz.aeu;
                            String name_show = bkVar7.getAuthor().getName_show();
                            bkVar8 = this.caz.aeu;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, bkVar8.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
