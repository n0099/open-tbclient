package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class ap implements Runnable {
    final /* synthetic */ ao adZ;
    private final /* synthetic */ CustomMessage aea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar, CustomMessage customMessage) {
        this.adZ = aoVar;
        this.aea = customMessage;
    }

    @Override // java.lang.Runnable
    public void run() {
        aj.a((AccountData) this.aea.getData(), TbadkApplication.m251getInst());
    }
}
