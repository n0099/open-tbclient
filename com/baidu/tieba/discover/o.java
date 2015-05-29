package com.baidu.tieba.discover;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ a aDS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.aDS = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aDS.sendMessage(new CustomMessage(2002001, new PluginCenterActivityConfig(this.aDS.getPageContext().getPageActivity(), 1)));
    }
}
