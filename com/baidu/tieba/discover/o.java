package com.baidu.tieba.discover;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ a aKv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.aKv = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aKv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginCenterActivityConfig(this.aKv.getPageContext().getPageActivity(), 1)));
    }
}
