package com.baidu.tbadk;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r implements Runnable {
    final /* synthetic */ TbadkApplication a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(TbadkApplication tbadkApplication, boolean z) {
        this.a = tbadkApplication;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.adp.framework.c.a().a(new CustomResponsedMessage(2007004, new com.baidu.tbadk.mainTab.a(this.b)));
    }
}
