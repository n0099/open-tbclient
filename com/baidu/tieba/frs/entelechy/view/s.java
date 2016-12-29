package com.baidu.tieba.frs.entelechy.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ q bGg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.bGg = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        bg bgVar4;
        bg bgVar5;
        TbPageContext tbPageContext;
        bg bgVar6;
        bg bgVar7;
        bg bgVar8;
        bgVar = this.bGg.adN;
        if (bgVar != null) {
            bgVar2 = this.bGg.adN;
            if (bgVar2.getAuthor() != null) {
                bgVar3 = this.bGg.adN;
                if (!StringUtils.isNull(bgVar3.getAuthor().getName_show())) {
                    bgVar4 = this.bGg.adN;
                    if (!StringUtils.isNull(bgVar4.getAuthor().getUserId())) {
                        bgVar5 = this.bGg.adN;
                        if (bgVar5.rK() != null) {
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bGg.GO;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            bgVar6 = this.bGg.adN;
                            String userId = bgVar6.getAuthor().getUserId();
                            bgVar7 = this.bGg.adN;
                            String name_show = bgVar7.getAuthor().getName_show();
                            bgVar8 = this.bGg.adN;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, bgVar8.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
