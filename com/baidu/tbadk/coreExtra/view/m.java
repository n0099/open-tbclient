package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ j afv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.afv = jVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.afv.mContext;
        messageManager.sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(context, PluginCenter.NAME_MOTUSDK)));
        aVar.dismiss();
    }
}
