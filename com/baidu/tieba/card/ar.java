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
public class ar implements View.OnClickListener {
    final /* synthetic */ ap bBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ap apVar) {
        this.bBk = apVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.bl blVar;
        com.baidu.tbadk.core.data.bl blVar2;
        com.baidu.tbadk.core.data.bl blVar3;
        com.baidu.tbadk.core.data.bl blVar4;
        com.baidu.tbadk.core.data.bl blVar5;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.bl blVar6;
        com.baidu.tbadk.core.data.bl blVar7;
        com.baidu.tbadk.core.data.bl blVar8;
        com.baidu.tieba.card.data.l lVar;
        blVar = this.bBk.ahM;
        if (blVar != null) {
            blVar2 = this.bBk.ahM;
            if (blVar2.getAuthor() != null) {
                blVar3 = this.bBk.ahM;
                if (!StringUtils.isNull(blVar3.getAuthor().getName_show())) {
                    blVar4 = this.bBk.ahM;
                    if (!StringUtils.isNull(blVar4.getAuthor().getUserId())) {
                        blVar5 = this.bBk.ahM;
                        if (blVar5.rz() != null) {
                            if (this.bBk.Ud() != null) {
                                ci<com.baidu.tieba.card.data.l> Ud = this.bBk.Ud();
                                lVar = this.bBk.bBi;
                                Ud.a(view, lVar);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bBk.ajh;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            blVar6 = this.bBk.ahM;
                            String userId = blVar6.getAuthor().getUserId();
                            blVar7 = this.bBk.ahM;
                            String name_show = blVar7.getAuthor().getName_show();
                            blVar8 = this.bBk.ahM;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, blVar8.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
