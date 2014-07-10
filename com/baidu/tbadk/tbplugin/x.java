package com.baidu.tbadk.tbplugin;

import com.baidu.tbadk.tbplugin.PluginsConfig;
/* loaded from: classes.dex */
public class x implements w {
    protected PluginsConfig a;

    public x(PluginsConfig pluginsConfig) {
        this.a = pluginsConfig;
    }

    public boolean a(s sVar) {
        if (this.a == null || this.a.plugin_config == null) {
            return false;
        }
        for (PluginsConfig.PluginConfig pluginConfig : this.a.plugin_config) {
            if (pluginConfig.name != null && pluginConfig.name.equals(sVar.a()) && pluginConfig.versions != null && pluginConfig.versions.length > 0) {
                int[] iArr = pluginConfig.versions;
                for (int i : iArr) {
                    if (i == sVar.c()) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }
}
