package com.baidu.tieba.frs.entelechy.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ x bMx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.bMx = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bh bhVar;
        bh bhVar2;
        bh bhVar3;
        bh bhVar4;
        bh bhVar5;
        TbPageContext tbPageContext;
        bh bhVar6;
        bh bhVar7;
        bh bhVar8;
        bhVar = this.bMx.acX;
        if (bhVar != null) {
            bhVar2 = this.bMx.acX;
            if (bhVar2.getAuthor() != null) {
                bhVar3 = this.bMx.acX;
                if (!StringUtils.isNull(bhVar3.getAuthor().getName_show())) {
                    bhVar4 = this.bMx.acX;
                    if (!StringUtils.isNull(bhVar4.getAuthor().getUserId())) {
                        bhVar5 = this.bMx.acX;
                        if (bhVar5.rB() != null) {
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bMx.FY;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            bhVar6 = this.bMx.acX;
                            String userId = bhVar6.getAuthor().getUserId();
                            bhVar7 = this.bMx.acX;
                            String name_show = bhVar7.getAuthor().getName_show();
                            bhVar8 = this.bMx.acX;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, bhVar8.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
