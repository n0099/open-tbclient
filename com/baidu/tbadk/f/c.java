package com.baidu.tbadk.f;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Thread {
    final /* synthetic */ b RT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.RT = bVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        try {
            com.baidu.tbadk.core.util.c.uQ();
            a.m(TbadkCoreApplication.m9getInst().getCacheDir());
        } catch (Exception e) {
        }
    }
}
