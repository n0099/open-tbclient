package com.baidu.tieba.VideoCacheClient;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k implements Runnable {
    final /* synthetic */ j aUF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aUF = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c.Kw().aX(TbadkCoreApplication.m9getInst().getContext());
    }
}
