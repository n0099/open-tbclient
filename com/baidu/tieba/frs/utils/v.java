package com.baidu.tieba.frs.utils;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class v implements a.b {
    private final /* synthetic */ TbPageContext LO;
    private final /* synthetic */ String bUB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(String str, TbPageContext tbPageContext) {
        this.bUB = str;
        this.LO = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (StringUtils.isNull(this.bUB)) {
            this.LO.showToast(r.l.error_tid);
            return;
        }
        aVar.dismiss();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.LO.getPageActivity(), this.bUB).oS()));
    }
}
