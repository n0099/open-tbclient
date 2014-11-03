package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class az implements Runnable {
    final /* synthetic */ ay aeh;
    private final /* synthetic */ CustomMessage aei;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ay ayVar, CustomMessage customMessage) {
        this.aeh = ayVar;
        this.aei = customMessage;
    }

    @Override // java.lang.Runnable
    public void run() {
        aj.a((AccountData) this.aei.getData(), TbadkApplication.m251getInst());
    }
}
