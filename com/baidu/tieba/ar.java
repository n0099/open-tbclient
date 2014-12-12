package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class ar implements Runnable {
    final /* synthetic */ aq alw;
    private final /* synthetic */ CustomMessage alx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar, CustomMessage customMessage) {
        this.alw = aqVar;
        this.alx = customMessage;
    }

    @Override // java.lang.Runnable
    public void run() {
        al.a((AccountData) this.alx.getData(), TbadkApplication.getInst().getApp());
    }
}
