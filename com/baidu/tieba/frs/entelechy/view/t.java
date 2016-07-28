package com.baidu.tieba.frs.entelechy.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ r bLX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.bLX = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        be beVar;
        be beVar2;
        be beVar3;
        be beVar4;
        be beVar5;
        TbPageContext tbPageContext;
        be beVar6;
        be beVar7;
        be beVar8;
        be beVar9;
        beVar = this.bLX.abb;
        if (beVar != null) {
            beVar2 = this.bLX.abb;
            if (beVar2.getAuthor() != null) {
                beVar3 = this.bLX.abb;
                if (!StringUtils.isNull(beVar3.getAuthor().getName_show())) {
                    beVar4 = this.bLX.abb;
                    if (!StringUtils.isNull(beVar4.getAuthor().getUserId())) {
                        beVar5 = this.bLX.abb;
                        if (beVar5.getForum_name() != null) {
                            if (this.bLX.KN() != null) {
                                bx<be> KN = this.bLX.KN();
                                beVar9 = this.bLX.abb;
                                KN.a(view, beVar9);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bLX.EA;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            beVar6 = this.bLX.abb;
                            String userId = beVar6.getAuthor().getUserId();
                            beVar7 = this.bLX.abb;
                            String name_show = beVar7.getAuthor().getName_show();
                            beVar8 = this.bLX.abb;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, beVar8.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
