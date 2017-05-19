package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GodSquareActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i bur;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.bur = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
            tbPageContext2 = this.bur.aat;
            tbPageContext2.showToast(w.l.pluginstatus_tip_timeout_last);
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        tbPageContext = this.bur.aat;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodSquareActivityConfig(tbPageContext.getPageActivity())));
    }
}
