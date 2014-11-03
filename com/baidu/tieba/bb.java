package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.pluginArch.InstallCallback;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.pluginArch.PluginResourcesManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements InstallCallback {
    final /* synthetic */ aj aee;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(aj ajVar) {
        this.aee = ajVar;
    }

    @Override // com.baidu.tbadk.pluginArch.InstallCallback
    public void onFinish(int i, String str) {
        PluginResourcesManager.getInstance().resetPluginResource(PluginNameList.NAME_NIGHT_RESOURCE);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005017));
    }
}
