package com.baidu.tbadk.kuang;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    private final /* synthetic */ CustomResponsedMessage aDG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(CustomResponsedMessage customResponsedMessage) {
        this.aDG = customResponsedMessage;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(this.aDG);
    }
}
