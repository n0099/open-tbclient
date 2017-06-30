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
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ q chC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.chC = qVar;
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
        bm bmVar9;
        bmVar = this.chC.aiu;
        if (bmVar != null) {
            bmVar2 = this.chC.aiu;
            if (bmVar2.getAuthor() != null) {
                bmVar3 = this.chC.aiu;
                if (!StringUtils.isNull(bmVar3.getAuthor().getName_show())) {
                    bmVar4 = this.chC.aiu;
                    if (!StringUtils.isNull(bmVar4.getAuthor().getUserId())) {
                        bmVar5 = this.chC.aiu;
                        if (bmVar5.rw() != null) {
                            if (this.chC.Vs() != null) {
                                ci<bm> Vs = this.chC.Vs();
                                bmVar9 = this.chC.aiu;
                                Vs.a(view, bmVar9);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.chC.ajP;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            bmVar6 = this.chC.aiu;
                            String userId = bmVar6.getAuthor().getUserId();
                            bmVar7 = this.chC.aiu;
                            String name_show = bmVar7.getAuthor().getName_show();
                            bmVar8 = this.chC.aiu;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, bmVar8.rw(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
