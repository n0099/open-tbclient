package com.baidu.tieba.frs.utils;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class c implements a.b {
    private final /* synthetic */ TbPageContext Kq;
    private final /* synthetic */ String aJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, TbPageContext tbPageContext) {
        this.aJF = str;
        this.Kq = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        if (StringUtils.isNull(this.aJF)) {
            this.Kq.showToast(u.j.error_tid);
            return;
        }
        aVar.dismiss();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.Kq.getPageActivity(), this.aJF).ol()));
    }
}
