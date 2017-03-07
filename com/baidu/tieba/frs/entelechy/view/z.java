package com.baidu.tieba.frs.entelechy.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ x bTF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.bTF = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        bj bjVar4;
        bj bjVar5;
        TbPageContext tbPageContext;
        bj bjVar6;
        bj bjVar7;
        bj bjVar8;
        bjVar = this.bTF.ain;
        if (bjVar != null) {
            bjVar2 = this.bTF.ain;
            if (bjVar2.getAuthor() != null) {
                bjVar3 = this.bTF.ain;
                if (!StringUtils.isNull(bjVar3.getAuthor().getName_show())) {
                    bjVar4 = this.bTF.ain;
                    if (!StringUtils.isNull(bjVar4.getAuthor().getUserId())) {
                        bjVar5 = this.bTF.ain;
                        if (bjVar5.rV() != null) {
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bTF.ajF;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            bjVar6 = this.bTF.ain;
                            String userId = bjVar6.getAuthor().getUserId();
                            bjVar7 = this.bTF.ain;
                            String name_show = bjVar7.getAuthor().getName_show();
                            bjVar8 = this.bTF.ain;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, bjVar8.rV(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
