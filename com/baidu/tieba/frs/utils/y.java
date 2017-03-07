package com.baidu.tieba.frs.utils;

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
    private final /* synthetic */ TbPageContext QR;
    private final /* synthetic */ String cbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(String str, TbPageContext tbPageContext) {
        this.cbR = str;
        this.QR = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (StringUtils.isNull(this.cbR)) {
            this.QR.showToast(w.l.error_tid);
            return;
        }
        aVar.dismiss();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.QR.getPageActivity(), this.cbR).pg()));
    }
}
