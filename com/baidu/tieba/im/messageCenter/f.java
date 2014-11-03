package com.baidu.tieba.im.messageCenter;

import com.baidu.tbadk.live.LiveGroupManager;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.LivePlugin;
import com.baidu.tieba.im.db.n;
import com.baidu.tieba.im.db.o;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.im.a<Integer> {
    final /* synthetic */ d beK;
    private final /* synthetic */ boolean beL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, boolean z) {
        this.beK = dVar;
        this.beL = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: b */
    public void onReturnDataInUI(Integer num) {
        LivePlugin livePlugin;
        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_LIVE);
        if (pluginByName != null && (livePlugin = (LivePlugin) pluginByName.getClassInstance(LivePlugin.class)) != null) {
            livePlugin.onAccountChanged();
        }
        LiveGroupManager.getInstance().onAccountChanged();
        if (!this.beL) {
            com.baidu.tieba.im.c.setCurrentAccount(null, null);
            com.baidu.tieba.im.e.Jo();
            o.MU().My();
            n.MT().My();
        }
    }
}
