package com.baidu.tieba.frs.acrossForum;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aDH;
    private final /* synthetic */ String bDo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TbPageContext tbPageContext, String str) {
        this.aDH = tbPageContext;
        this.bDo = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aDH.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.aDH.getPageActivity(), 23007)));
        TiebaStatic.log(new at("c10125").ab("fid", this.bDo).s("obj_type", 1));
    }
}
