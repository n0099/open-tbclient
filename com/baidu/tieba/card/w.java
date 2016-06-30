package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GodSquareActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ u aSS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.aSS = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
            tbPageContext2 = this.aSS.Dp;
            tbPageContext2.showToast(u.j.pluginstatus_tip_timeout_last);
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        tbPageContext = this.aSS.Dp;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodSquareActivityConfig(tbPageContext.getPageActivity())));
    }
}
