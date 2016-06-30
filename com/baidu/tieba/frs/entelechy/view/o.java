package com.baidu.tieba.frs.entelechy.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ m bKo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.bKo = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        az azVar;
        az azVar2;
        az azVar3;
        az azVar4;
        az azVar5;
        TbPageContext tbPageContext;
        az azVar6;
        az azVar7;
        az azVar8;
        azVar = this.bKo.aas;
        if (azVar != null) {
            azVar2 = this.bKo.aas;
            if (azVar2.getAuthor() != null) {
                azVar3 = this.bKo.aas;
                if (!StringUtils.isNull(azVar3.getAuthor().getName_show())) {
                    azVar4 = this.bKo.aas;
                    if (!StringUtils.isNull(azVar4.getAuthor().getUserId())) {
                        azVar5 = this.bKo.aas;
                        if (azVar5.getForum_name() != null) {
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bKo.Ea;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            azVar6 = this.bKo.aas;
                            String userId = azVar6.getAuthor().getUserId();
                            azVar7 = this.bKo.aas;
                            String name_show = azVar7.getAuthor().getName_show();
                            azVar8 = this.bKo.aas;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, azVar8.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
