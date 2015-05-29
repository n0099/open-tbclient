package com.baidu.tbadk.plugins;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.j;
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
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof j)) {
            j jVar = (j) customResponsedMessage.getData();
            for (String str : Static.arz) {
                if (jVar != null && jVar.info != null && jVar.info.contains(str) && !jVar.info.contains("java.lang.OutOfMemoryError")) {
                    com.baidu.adp.plugin.b.a.lB().bo("plugin_crash_inflate");
                    com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("is_plugin_resource_open_local", false);
                    return;
                }
            }
        }
    }
}
