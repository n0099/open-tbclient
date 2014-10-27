package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.pluginArch.PluginNameList;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ d MV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.MV = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.MV.mContext;
        messageManager.sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(context, PluginNameList.NAME_SOCIAL_SHARE)));
        aVar.dismiss();
    }
}
