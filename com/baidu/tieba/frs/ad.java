package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements a.b {
    final /* synthetic */ FrsActivity blk;
    private final /* synthetic */ String blp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FrsActivity frsActivity, String str) {
        this.blk = frsActivity;
        this.blp = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        if (StringUtils.isNull(this.blp)) {
            this.blk.showToast(t.j.error_tid);
            return;
        }
        aVar.dismiss();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.blk.getPageContext().getPageActivity(), this.blp).qT()));
    }
}
