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
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ q bKp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.bKp = qVar;
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
        az azVar9;
        azVar = this.bKp.aas;
        if (azVar != null) {
            azVar2 = this.bKp.aas;
            if (azVar2.getAuthor() != null) {
                azVar3 = this.bKp.aas;
                if (!StringUtils.isNull(azVar3.getAuthor().getName_show())) {
                    azVar4 = this.bKp.aas;
                    if (!StringUtils.isNull(azVar4.getAuthor().getUserId())) {
                        azVar5 = this.bKp.aas;
                        if (azVar5.getForum_name() != null) {
                            if (this.bKp.KO() != null) {
                                bx<az> KO = this.bKp.KO();
                                azVar9 = this.bKp.aas;
                                KO.a(view, azVar9);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bKp.Ea;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            azVar6 = this.bKp.aas;
                            String userId = azVar6.getAuthor().getUserId();
                            azVar7 = this.bKp.aas;
                            String name_show = azVar7.getAuthor().getName_show();
                            azVar8 = this.bKp.aas;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, azVar8.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
