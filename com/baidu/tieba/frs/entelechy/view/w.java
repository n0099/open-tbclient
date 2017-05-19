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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ u bTC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.bTC = uVar;
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
        bkVar = this.bTC.ahV;
        if (bkVar != null) {
            bkVar2 = this.bTC.ahV;
            if (bkVar2.getAuthor() != null) {
                bkVar3 = this.bTC.ahV;
                if (!StringUtils.isNull(bkVar3.getAuthor().getName_show())) {
                    bkVar4 = this.bTC.ahV;
                    if (!StringUtils.isNull(bkVar4.getAuthor().getUserId())) {
                        bkVar5 = this.bTC.ahV;
                        if (bkVar5.rD() != null) {
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bTC.ajr;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            bkVar6 = this.bTC.ahV;
                            String userId = bkVar6.getAuthor().getUserId();
                            bkVar7 = this.bTC.ahV;
                            String name_show = bkVar7.getAuthor().getName_show();
                            bkVar8 = this.bTC.ahV;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, bkVar8.rD(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
