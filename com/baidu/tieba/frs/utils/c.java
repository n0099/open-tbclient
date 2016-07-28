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
    private final /* synthetic */ TbPageContext Kp;
    private final /* synthetic */ String aKy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, TbPageContext tbPageContext) {
        this.aKy = str;
        this.Kp = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        if (StringUtils.isNull(this.aKy)) {
            this.Kp.showToast(u.j.error_tid);
            return;
        }
        aVar.dismiss();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.Kp.getPageActivity(), this.aKy).oa()));
    }
}
