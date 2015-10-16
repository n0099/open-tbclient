package com.baidu.tbadk.plugins;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class c implements a.b {
    private final /* synthetic */ Activity ayU;
    private final /* synthetic */ TbPageContext ayV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Activity activity, TbPageContext tbPageContext) {
        this.ayU = activity;
        this.ayV = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ayV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(this.ayU, XiaoyingUtil.PKG_NAME_XIAOYING)));
        aVar.dismiss();
    }
}
