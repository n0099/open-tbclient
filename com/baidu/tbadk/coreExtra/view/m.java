package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.pluginArch.PluginNameList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ j NT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.NT = jVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.NT.mContext;
        messageManager.sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(context, PluginNameList.NAME_MOTUSDK)));
        aVar.dismiss();
    }
}
