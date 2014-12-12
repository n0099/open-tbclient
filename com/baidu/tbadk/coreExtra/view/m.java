package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ j TF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.TF = jVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.TF.mContext;
        messageManager.sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(context, "com.baidu.tieba.pluginMotu")));
        aVar.dismiss();
    }
}
