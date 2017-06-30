package com.baidu.tbadk.plugin;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ PluginErrorTipView aIX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(PluginErrorTipView pluginErrorTipView, int i) {
        super(i);
        this.aIX = pluginErrorTipView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        LinkedList linkedList;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PluginStatus)) {
            linkedList = this.aIX.aIU;
            linkedList.add((PluginStatus) customResponsedMessage.getData());
            this.aIX.update();
        }
    }
}
