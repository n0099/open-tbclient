package com.baidu.tieba;

import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ad implements Runnable {
    final /* synthetic */ r a;
    private final /* synthetic */ int[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(r rVar, int[] iArr) {
        this.a = rVar;
        this.b = iArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2005004, new com.baidu.tbadk.core.b.x(TbadkApplication.j(), this.b)));
    }
}
