package com.baidu.tbadk.tbplugin;

import com.baidu.tbadk.tbplugin.PluginsConfig;
import java.util.Iterator;
/* loaded from: classes.dex */
public class y implements w {
    protected PluginsConfig a;

    public y(PluginsConfig pluginsConfig) {
        this.a = pluginsConfig;
    }

    public boolean a(s sVar) {
        boolean z;
        if (this.a == null || this.a.plugin_config == null) {
            return true;
        }
        Iterator<PluginsConfig.PluginConfig> it = this.a.plugin_config.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            PluginsConfig.PluginConfig next = it.next();
            if (next.name != null && next.name.equals(sVar.a())) {
                if (next.versions != null && next.versions.length > 0) {
                    int[] iArr = next.versions;
                    for (int i : iArr) {
                        if (i == sVar.c()) {
                            return true;
                        }
                    }
                }
                z = true;
            }
        }
        return !z;
    }
}
