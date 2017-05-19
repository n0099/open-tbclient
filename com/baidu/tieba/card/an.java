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
    final /* synthetic */ al bvw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar) {
        this.bvw = alVar;
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
        com.baidu.tieba.card.data.l lVar;
        bkVar = this.bvw.ahV;
        if (bkVar != null) {
            bkVar2 = this.bvw.ahV;
            if (bkVar2.getAuthor() != null) {
                bkVar3 = this.bvw.ahV;
                if (!StringUtils.isNull(bkVar3.getAuthor().getName_show())) {
                    bkVar4 = this.bvw.ahV;
                    if (!StringUtils.isNull(bkVar4.getAuthor().getUserId())) {
                        bkVar5 = this.bvw.ahV;
                        if (bkVar5.rD() != null) {
                            if (this.bvw.getOnSubCardOnClickListenner() != null) {
                                cd<com.baidu.tieba.card.data.l> onSubCardOnClickListenner = this.bvw.getOnSubCardOnClickListenner();
                                lVar = this.bvw.bvu;
                                onSubCardOnClickListenner.a(view, lVar);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bvw.ajr;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            bkVar6 = this.bvw.ahV;
                            String userId = bkVar6.getAuthor().getUserId();
                            bkVar7 = this.bvw.ahV;
                            String name_show = bkVar7.getAuthor().getName_show();
                            bkVar8 = this.bvw.ahV;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, bkVar8.rD(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
