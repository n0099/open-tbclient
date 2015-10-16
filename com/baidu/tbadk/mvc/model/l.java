package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    private final /* synthetic */ CustomMessageListener avH;
    final /* synthetic */ NetModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(NetModel netModel, CustomMessageListener customMessageListener) {
        this.this$0 = netModel;
        this.avH = customMessageListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.registerListener(this.avH);
    }
}
