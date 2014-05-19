package com.baidu.tbadk.tbplugin;

import com.baidu.tbadk.tbplugin.PluginsConfig;
/* loaded from: classes.dex */
public class z extends x {
    public z(PluginsConfig pluginsConfig) {
        super(pluginsConfig);
    }

    @Override // com.baidu.tbadk.tbplugin.x
    public boolean a(s sVar) {
        if (this.a == null || this.a.plugin_config == null) {
            return false;
        }
        for (PluginsConfig.PluginConfig pluginConfig : this.a.plugin_config) {
            if (pluginConfig.name != null && pluginConfig.name.equals(sVar.a()) && pluginConfig.versions != null && pluginConfig.versions.length > 0 && pluginConfig.newest.version > sVar.c()) {
                return true;
            }
        }
        return false;
    }
}
