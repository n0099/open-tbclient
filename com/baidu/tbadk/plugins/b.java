package com.baidu.tbadk.plugins;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
        String[] strArr;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ExceptionData)) {
            ExceptionData exceptionData = (ExceptionData) customResponsedMessage.getData();
            for (String str : Static.ayD) {
                if (exceptionData != null && exceptionData.info != null && exceptionData.info.contains(str) && !exceptionData.info.contains("java.lang.OutOfMemoryError")) {
                    com.baidu.adp.plugin.b.a.lF().bj("plugin_crash_inflate");
                    com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("is_plugin_resource_open_local", false);
                    return;
                }
            }
        }
    }
}
