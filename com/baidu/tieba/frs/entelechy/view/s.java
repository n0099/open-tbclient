package com.baidu.tieba.frs.entelechy.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ q bZt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.bZt = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bl blVar5;
        TbPageContext tbPageContext;
        bl blVar6;
        bl blVar7;
        bl blVar8;
        bl blVar9;
        blVar = this.bZt.ahM;
        if (blVar != null) {
            blVar2 = this.bZt.ahM;
            if (blVar2.getAuthor() != null) {
                blVar3 = this.bZt.ahM;
                if (!StringUtils.isNull(blVar3.getAuthor().getName_show())) {
                    blVar4 = this.bZt.ahM;
                    if (!StringUtils.isNull(blVar4.getAuthor().getUserId())) {
                        blVar5 = this.bZt.ahM;
                        if (blVar5.rz() != null) {
                            if (this.bZt.Ud() != null) {
                                ci<bl> Ud = this.bZt.Ud();
                                blVar9 = this.bZt.ahM;
                                Ud.a(view, blVar9);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bZt.ajh;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            blVar6 = this.bZt.ahM;
                            String userId = blVar6.getAuthor().getUserId();
                            blVar7 = this.bZt.ahM;
                            String name_show = blVar7.getAuthor().getName_show();
                            blVar8 = this.bZt.ahM;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, blVar8.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
