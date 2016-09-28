package com.baidu.tbadk.plugins;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class g implements a.b {
    private final /* synthetic */ Activity aDu;
    private final /* synthetic */ TbPageContext aDv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Activity activity, TbPageContext tbPageContext) {
        this.aDu = activity;
        this.aDv = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aDv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(this.aDu, "com.baidu.tieba.pluginHotTopic")));
        aVar.dismiss();
    }
}
