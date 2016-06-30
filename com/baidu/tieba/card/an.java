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
public class an implements View.OnClickListener {
    final /* synthetic */ al aTD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar) {
        this.aTD = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.az azVar;
        com.baidu.tbadk.core.data.az azVar2;
        com.baidu.tbadk.core.data.az azVar3;
        com.baidu.tbadk.core.data.az azVar4;
        com.baidu.tbadk.core.data.az azVar5;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.az azVar6;
        com.baidu.tbadk.core.data.az azVar7;
        com.baidu.tbadk.core.data.az azVar8;
        com.baidu.tieba.card.a.o oVar;
        azVar = this.aTD.aas;
        if (azVar != null) {
            azVar2 = this.aTD.aas;
            if (azVar2.getAuthor() != null) {
                azVar3 = this.aTD.aas;
                if (!StringUtils.isNull(azVar3.getAuthor().getName_show())) {
                    azVar4 = this.aTD.aas;
                    if (!StringUtils.isNull(azVar4.getAuthor().getUserId())) {
                        azVar5 = this.aTD.aas;
                        if (azVar5.getForum_name() != null) {
                            if (this.aTD.KO() != null) {
                                bx<com.baidu.tieba.card.a.o> KO = this.aTD.KO();
                                oVar = this.aTD.aTA;
                                KO.a(view, oVar);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.aTD.Ea;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            azVar6 = this.aTD.aas;
                            String userId = azVar6.getAuthor().getUserId();
                            azVar7 = this.aTD.aas;
                            String name_show = azVar7.getAuthor().getName_show();
                            azVar8 = this.aTD.aas;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, azVar8.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
