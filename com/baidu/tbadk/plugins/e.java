package com.baidu.tbadk.plugins;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class e implements a.b {
    private final /* synthetic */ Activity aBx;
    private final /* synthetic */ TbPageContext aBy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Activity activity, TbPageContext tbPageContext) {
        this.aBx = activity;
        this.aBy = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aBy.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(this.aBx, "cn.jingling.motu.photowonder.plugin.mv")));
        aVar.dismiss();
    }
}
