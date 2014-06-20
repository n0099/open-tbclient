package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class ao implements Runnable {
    final /* synthetic */ an a;
    private final /* synthetic */ CustomMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, CustomMessage customMessage) {
        this.a = anVar;
        this.b = customMessage;
    }

    @Override // java.lang.Runnable
    public void run() {
        ai.a((AccountData) this.b.getData(), TbadkApplication.m252getInst());
    }
}
