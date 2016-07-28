package com.baidu.tbadk.plugins;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.b {
    private final /* synthetic */ Activity aAK;
    private final /* synthetic */ TbPageContext aAL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Activity activity, TbPageContext tbPageContext) {
        this.aAK = activity;
        this.aAL = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.aAL.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(this.aAK, "com.baidu.tieba.pluginTogetherHi")));
        aVar.dismiss();
    }
}
