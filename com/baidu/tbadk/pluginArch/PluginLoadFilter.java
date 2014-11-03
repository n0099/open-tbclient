package com.baidu.tbadk.pluginArch;

import java.util.HashMap;
/* loaded from: classes.dex */
public class PluginLoadFilter {
    private static PluginLoadFilter g_filter;
    private HashMap<String, Integer> s_mimimumAvaliableVersion = new HashMap<>();

    public static PluginLoadFilter getInstance() {
        if (g_filter == null) {
            g_filter = new PluginLoadFilter();
        }
        return g_filter;
    }

    public PluginLoadFilter() {
        this.s_mimimumAvaliableVersion.put(PluginNameList.NAME_HAO123, 2);
        this.s_mimimumAvaliableVersion.put(PluginNameList.NAME_LIGHT_APP, 2);
        this.s_mimimumAvaliableVersion.put(PluginNameList.NAME_LIVE, 2);
        this.s_mimimumAvaliableVersion.put(PluginNameList.NAME_NIGHT_RESOURCE, 2);
        this.s_mimimumAvaliableVersion.put(PluginNameList.NAME_BAOBAO, 2);
    }

    public boolean canLoadPlugin(PluginInstalledConfigItem pluginInstalledConfigItem) {
        if (pluginInstalledConfigItem == null) {
            return false;
        }
        Integer num = this.s_mimimumAvaliableVersion.get(pluginInstalledConfigItem.mPluginName);
        return num == null || num.intValue() <= pluginInstalledConfigItem.mPluginVersion;
    }
}
