package com.baidu.tbadk.plugins;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements a.b {
    private final /* synthetic */ Activity aEm;
    private final /* synthetic */ TbPageContext aEn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Activity activity, TbPageContext tbPageContext) {
        this.aEm = activity;
        this.aEn = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aEn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(this.aEm, "cn.jingling.motu.photowonder.plugin.mv")));
        aVar.dismiss();
    }
}
