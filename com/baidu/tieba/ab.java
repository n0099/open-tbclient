package com.baidu.tieba;

import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab implements Runnable {
    final /* synthetic */ p a;
    private final /* synthetic */ int[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(p pVar, int[] iArr) {
        this.a = pVar;
        this.b = iArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2005004, new com.baidu.tbadk.core.b.x(TbadkApplication.j(), this.b)));
    }
}
