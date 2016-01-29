package com.baidu.tbadk.plugins;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.b {
    private final /* synthetic */ Activity aCm;
    private final /* synthetic */ TbPageContext aCn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Activity activity, TbPageContext tbPageContext) {
        this.aCm = activity;
        this.aCn = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.aCn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(this.aCm, "cn.jingling.motu.photowonder.plugin.mv")));
        aVar.dismiss();
    }
}
