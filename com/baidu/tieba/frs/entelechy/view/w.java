package com.baidu.tieba.frs.entelechy.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ u chD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.chD = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bm bmVar5;
        TbPageContext tbPageContext;
        bm bmVar6;
        bm bmVar7;
        bm bmVar8;
        bmVar = this.chD.aiu;
        if (bmVar != null) {
            bmVar2 = this.chD.aiu;
            if (bmVar2.getAuthor() != null) {
                bmVar3 = this.chD.aiu;
                if (!StringUtils.isNull(bmVar3.getAuthor().getName_show())) {
                    bmVar4 = this.chD.aiu;
                    if (!StringUtils.isNull(bmVar4.getAuthor().getUserId())) {
                        bmVar5 = this.chD.aiu;
                        if (bmVar5.rw() != null) {
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.chD.ajP;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            bmVar6 = this.chD.aiu;
                            String userId = bmVar6.getAuthor().getUserId();
                            bmVar7 = this.chD.aiu;
                            String name_show = bmVar7.getAuthor().getName_show();
                            bmVar8 = this.chD.aiu;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, bmVar8.rw(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
