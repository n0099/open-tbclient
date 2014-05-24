package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class ap implements Runnable {
    final /* synthetic */ ao a;
    private final /* synthetic */ CustomMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar, CustomMessage customMessage) {
        this.a = aoVar;
        this.b = customMessage;
    }

    @Override // java.lang.Runnable
    public void run() {
        ai.a((AccountData) this.b.getData(), TbadkApplication.m252getInst());
    }
}
