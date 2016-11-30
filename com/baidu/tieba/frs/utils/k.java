package com.baidu.tieba.frs.utils;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aEn;
    private final /* synthetic */ String bKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbPageContext tbPageContext, String str) {
        this.aEn = tbPageContext;
        this.bKg = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aEn.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.aEn.getPageActivity(), 23003)));
        TiebaStatic.log(new av("c10125").ab("fid", this.bKg).s("obj_type", 2));
    }
}
