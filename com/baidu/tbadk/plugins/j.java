package com.baidu.tbadk.plugins;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements a.b {
    private final /* synthetic */ Activity aIh;
    private final /* synthetic */ TbPageContext aIi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Activity activity, TbPageContext tbPageContext) {
        this.aIh = activity;
        this.aIi = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aIi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(this.aIh, XiaoyingUtil.PKG_NAME_VIDEO)));
        aVar.dismiss();
    }
}
