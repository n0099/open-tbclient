package com.baidu.tbadk.plugins;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class c implements a.b {
    private final /* synthetic */ Activity aIl;
    private final /* synthetic */ TbPageContext aIm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Activity activity, TbPageContext tbPageContext) {
        this.aIl = activity;
        this.aIm = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aIm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(this.aIl, "com.baidu.tieba.pluginHotTopic")));
        aVar.dismiss();
    }
}
