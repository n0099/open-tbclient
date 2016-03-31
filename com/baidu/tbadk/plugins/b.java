package com.baidu.tbadk.plugins;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.data.ExceptionData;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ExceptionData)) {
            boolean z = true;
            ExceptionData exceptionData = (ExceptionData) customResponsedMessage.getData();
            String[] strArr = Static.aDb;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    String str = strArr[i];
                    if (exceptionData == null || exceptionData.info == null || !exceptionData.info.contains(str) || exceptionData.info.contains("java.lang.OutOfMemoryError")) {
                        i++;
                    } else {
                        com.baidu.adp.plugin.b.a.lf().bm("plugin_crash_inflate");
                        com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("is_plugin_resource_open_local", false);
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z && exceptionData != null && exceptionData.info != null && exceptionData.info.contains("java.lang.IllegalAccessError: Class ref in pre-verified class resolved to unexpected implementation") && PluginPackageManager.ls().lw()) {
                com.baidu.tbadk.core.sharedPref.b.vk().putInt("plugin_patch_hook_failed_count", com.baidu.tbadk.core.sharedPref.b.vk().getInt("plugin_patch_hook_failed_count", 0) + 1);
            }
        }
    }
}
