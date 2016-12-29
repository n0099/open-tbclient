package com.baidu.tbadk.plugins;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.tbadk.core.data.ExceptionData;
import java.util.List;
/* loaded from: classes.dex */
class g extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        StackTraceElement[] stackTrace;
        Plugin plugin2;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ExceptionData)) {
            boolean z = true;
            ExceptionData exceptionData = (ExceptionData) customResponsedMessage.getData();
            String[] strArr = Static.aDI;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str = strArr[i];
                if (exceptionData == null || exceptionData.info == null || !exceptionData.info.contains(str) || exceptionData.info.contains("java.lang.OutOfMemoryError")) {
                    i++;
                } else {
                    com.baidu.adp.plugin.b.a.io().bh("plugin_crash_inflate");
                    com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("is_plugin_resource_open_local", false);
                    z = false;
                    break;
                }
            }
            if (exceptionData.mExcep != null && exceptionData.mExcep.getCause() != null && exceptionData.mExcep.getCause().getStackTrace() != null && z && exceptionData != null && exceptionData.info != null) {
                try {
                    List<PluginSetting> pluginSettingsSortLoadPriorty = com.baidu.adp.plugin.packageManager.pluginSettings.c.je().jb().getPluginSettingsSortLoadPriorty();
                    if (pluginSettingsSortLoadPriorty != null && !pluginSettingsSortLoadPriorty.isEmpty() && (stackTrace = exceptionData.mExcep.getCause().getStackTrace()) != null && stackTrace.length != 0) {
                        for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
                            if (pluginSetting.isPatch && pluginSetting.enable && (plugin2 = PluginCenter.getInstance().getPlugin(pluginSetting.packageName)) != null && plugin2.getDexClassLoader() != null) {
                                for (StackTraceElement stackTraceElement : stackTrace) {
                                    try {
                                        plugin2.getDexClassLoader().loadClass(stackTraceElement.getClassName());
                                        com.baidu.tbadk.core.sharedPref.b.tW().putInt("plugin_patch_hook_failed_count", com.baidu.tbadk.core.sharedPref.b.tW().getInt("plugin_patch_hook_failed_count", 0) + 1);
                                        break;
                                    } catch (ClassNotFoundException e) {
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    BdLog.e(th.getMessage());
                }
            }
        }
    }
}
