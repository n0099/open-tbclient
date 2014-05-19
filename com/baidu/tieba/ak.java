package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class ak implements Runnable {
    final /* synthetic */ aj a;
    private final /* synthetic */ CustomMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, CustomMessage customMessage) {
        this.a = ajVar;
        this.b = customMessage;
    }

    @Override // java.lang.Runnable
    public void run() {
        ad.a((AccountData) this.b.getData(), TbadkApplication.m252getInst());
    }
}
