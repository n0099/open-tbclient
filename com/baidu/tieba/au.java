package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class au implements Runnable {
    final /* synthetic */ at amn;
    private final /* synthetic */ CustomMessage amo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar, CustomMessage customMessage) {
        this.amn = atVar;
        this.amo = customMessage;
    }

    @Override // java.lang.Runnable
    public void run() {
        ao.a((AccountData) this.amo.getData(), TbadkApplication.getInst().getApp());
    }
}
