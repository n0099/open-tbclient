package com.baidu.tieba;

import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements Runnable {
    final /* synthetic */ aj aee;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(aj ajVar) {
        this.aee = ajVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PluginCenter.getInstance().installPluginFromAsset(PluginNameList.NAME_LIVE, new ap(this));
    }
}
