package com.baidu.tieba.VideoCacheClient;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k implements Runnable {
    final /* synthetic */ j aVK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aVK = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c.Ld().aX(TbadkCoreApplication.m9getInst().getContext());
    }
}
