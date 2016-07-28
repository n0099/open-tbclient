package com.baidu.tbadk.kuang;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    private final /* synthetic */ CustomResponsedMessage awa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(CustomResponsedMessage customResponsedMessage) {
        this.awa = customResponsedMessage;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(this.awa);
    }
}
