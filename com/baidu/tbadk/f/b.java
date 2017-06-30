package com.baidu.tbadk.f;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        long j;
        long j2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_clear_resource", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        j = a.QS;
        if (currentTimeMillis - j2 > j) {
            new c(this).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_clear_resource", currentTimeMillis);
        }
    }
}
