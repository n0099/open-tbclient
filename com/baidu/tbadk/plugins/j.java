package com.baidu.tbadk.plugins;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class j implements a.b {
    private final /* synthetic */ Activity aHY;
    private final /* synthetic */ TbPageContext aHZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Activity activity, TbPageContext tbPageContext) {
        this.aHY = activity;
        this.aHZ = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aHZ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(this.aHY, XiaoyingUtil.PKG_NAME_VIDEO)));
        aVar.dismiss();
    }
}
