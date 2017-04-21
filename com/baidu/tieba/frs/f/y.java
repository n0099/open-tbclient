package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class y implements a.b {
    private final /* synthetic */ TbPageContext Rl;
    private final /* synthetic */ String ccJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(String str, TbPageContext tbPageContext) {
        this.ccJ = str;
        this.Rl = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (StringUtils.isNull(this.ccJ)) {
            this.Rl.showToast(w.l.error_tid);
            return;
        }
        aVar.dismiss();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.Rl.getPageActivity(), this.ccJ).pE()));
    }
}
