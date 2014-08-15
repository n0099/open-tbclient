package com.baidu.tbadk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ TbadkApplication a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TbadkApplication tbadkApplication, boolean z) {
        this.a = tbadkApplication;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007004, new com.baidu.tbadk.mainTab.a(this.b)));
    }
}
