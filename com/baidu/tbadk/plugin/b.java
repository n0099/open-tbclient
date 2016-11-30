package com.baidu.tbadk.plugin;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ PluginErrorTipView aDX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(PluginErrorTipView pluginErrorTipView, int i) {
        super(i);
        this.aDX = pluginErrorTipView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        LinkedList linkedList;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.adp.plugin.packageManager.a.a)) {
            linkedList = this.aDX.aDU;
            linkedList.add((com.baidu.adp.plugin.packageManager.a.a) customResponsedMessage.getData());
            this.aDX.update();
        }
    }
}
