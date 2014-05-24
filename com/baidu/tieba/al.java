package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    final /* synthetic */ ai a;
    private final /* synthetic */ int[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ai aiVar, int[] iArr) {
        this.a = aiVar;
        this.b = iArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2007004, new com.baidu.tbadk.core.atomData.aa(TbadkApplication.m252getInst(), this.b)));
    }
}
