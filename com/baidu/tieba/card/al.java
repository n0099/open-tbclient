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
    final /* synthetic */ aj bdl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aj ajVar) {
        this.bdl = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.bk bkVar;
        com.baidu.tbadk.core.data.bk bkVar2;
        com.baidu.tbadk.core.data.bk bkVar3;
        com.baidu.tbadk.core.data.bk bkVar4;
        com.baidu.tbadk.core.data.bk bkVar5;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.bk bkVar6;
        com.baidu.tbadk.core.data.bk bkVar7;
        com.baidu.tbadk.core.data.bk bkVar8;
        com.baidu.tieba.card.data.m mVar;
        bkVar = this.bdl.aeu;
        if (bkVar != null) {
            bkVar2 = this.bdl.aeu;
            if (bkVar2.getAuthor() != null) {
                bkVar3 = this.bdl.aeu;
                if (!StringUtils.isNull(bkVar3.getAuthor().getName_show())) {
                    bkVar4 = this.bdl.aeu;
                    if (!StringUtils.isNull(bkVar4.getAuthor().getUserId())) {
                        bkVar5 = this.bdl.aeu;
                        if (bkVar5.getForum_name() != null) {
                            if (this.bdl.getOnSubCardOnClickListenner() != null) {
                                bz<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bdl.getOnSubCardOnClickListenner();
                                mVar = this.bdl.bdk;
                                onSubCardOnClickListenner.a(view, mVar);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bdl.GO;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            bkVar6 = this.bdl.aeu;
                            String userId = bkVar6.getAuthor().getUserId();
                            bkVar7 = this.bdl.aeu;
                            String name_show = bkVar7.getAuthor().getName_show();
                            bkVar8 = this.bdl.aeu;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, bkVar8.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
