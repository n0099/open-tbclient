package com.baidu.tbadk.pluginArch;

import android.text.TextUtils;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
/* loaded from: classes.dex */
public class PluginVersionCheck {
    public static boolean checkPluginUpdate(String str) {
        ConfigInfos.PluginConfig netConfigInfo;
        Plugin pluginByName;
        return (TextUtils.isEmpty(str) || (netConfigInfo = PluginCenter.getInstance().getNetConfigInfo(str)) == null || netConfigInfo.newest == null || (pluginByName = PluginCenter.getInstance().getPluginByName(str)) == null || netConfigInfo.newest.version <= pluginByName.getVersion()) ? false : true;
    }

    public static boolean checkHasPluginUpdatePackageXML(PluginInstalledConfigItem pluginInstalledConfigItem) {
        return pluginInstalledConfigItem != null && pluginInstalledConfigItem.mPluginUpdateVersion > pluginInstalledConfigItem.mPluginVersion && PluginFileHelper.updateDir(pluginInstalledConfigItem.mPluginName, pluginInstalledConfigItem.mPluginUpdateVersion).exists();
    }

    public static boolean checkHasPluginUpdatePackage(String str) {
        ConfigInfos.PluginConfig netConfigInfo;
        Plugin pluginByName;
        return (TextUtils.isEmpty(str) || (netConfigInfo = PluginCenter.getInstance().getNetConfigInfo(str)) == null || netConfigInfo.newest == null || netConfigInfo.name == null || (pluginByName = PluginCenter.getInstance().getPluginByName(str)) == null || netConfigInfo.newest.version <= pluginByName.getVersion() || !PluginFileHelper.updateDir(netConfigInfo.name, netConfigInfo.newest.version).exists()) ? false : true;
    }
}
