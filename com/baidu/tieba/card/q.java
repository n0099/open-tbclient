package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GodSquareActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ o aYW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.aYW = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
            tbPageContext2 = this.aYW.Gd;
            tbPageContext2.showToast(t.j.pluginstatus_tip_timeout_last);
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        tbPageContext = this.aYW.Gd;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodSquareActivityConfig(tbPageContext.getPageActivity())));
    }
}
