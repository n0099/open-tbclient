package com.baidu.tbadk.plugins;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class c implements a.b {
    private final /* synthetic */ Activity axJ;
    private final /* synthetic */ TbPageContext axK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Activity activity, TbPageContext tbPageContext) {
        this.axJ = activity;
        this.axK = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.axK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(this.axJ, XiaoyingUtil.PKG_NAME_XIAOYING)));
        aVar.dismiss();
    }
}
