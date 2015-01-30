package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class au implements Runnable {
    final /* synthetic */ at amq;
    private final /* synthetic */ CustomMessage amr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar, CustomMessage customMessage) {
        this.amq = atVar;
        this.amr = customMessage;
    }

    @Override // java.lang.Runnable
    public void run() {
        ao.a((AccountData) this.amr.getData(), TbadkApplication.getInst().getApp());
    }
}
