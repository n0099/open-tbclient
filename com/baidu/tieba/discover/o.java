package com.baidu.tieba.discover;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ a aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.aDT = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aDT.sendMessage(new CustomMessage(2002001, new PluginCenterActivityConfig(this.aDT.getPageContext().getPageActivity(), 1)));
    }
}
