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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ u bZu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.bZu = uVar;
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
        blVar = this.bZu.ahM;
        if (blVar != null) {
            blVar2 = this.bZu.ahM;
            if (blVar2.getAuthor() != null) {
                blVar3 = this.bZu.ahM;
                if (!StringUtils.isNull(blVar3.getAuthor().getName_show())) {
                    blVar4 = this.bZu.ahM;
                    if (!StringUtils.isNull(blVar4.getAuthor().getUserId())) {
                        blVar5 = this.bZu.ahM;
                        if (blVar5.rz() != null) {
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bZu.ajh;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            blVar6 = this.bZu.ahM;
                            String userId = blVar6.getAuthor().getUserId();
                            blVar7 = this.bZu.ahM;
                            String name_show = blVar7.getAuthor().getName_show();
                            blVar8 = this.bZu.ahM;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, blVar8.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
