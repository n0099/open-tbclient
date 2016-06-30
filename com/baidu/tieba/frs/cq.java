package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class cq implements View.OnClickListener {
    private final /* synthetic */ TbPageContext azW;
    private final /* synthetic */ String btC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(TbPageContext tbPageContext, String str) {
        this.azW = tbPageContext;
        this.btC = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.azW.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.azW.getPageActivity(), 23003)));
        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10125").ab("fid", this.btC).s("obj_type", 2));
    }
}
