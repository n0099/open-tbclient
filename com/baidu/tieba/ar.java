package com.baidu.tieba;

import com.baidu.tbadk.pluginArch.InstallCallback;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.RandChatPlugin;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements InstallCallback {
    final /* synthetic */ aj adY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aj ajVar) {
        this.adY = ajVar;
    }

    @Override // com.baidu.tbadk.pluginArch.InstallCallback
    public void onFinish(int i, String str) {
        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_RANDCHAT);
        if (pluginByName != null) {
            pluginByName.getClassInstance(RandChatPlugin.class);
        }
    }
}
