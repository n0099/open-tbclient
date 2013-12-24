package com.baidu.tieba.im.c;

import com.baidu.tieba.im.db.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements Runnable {
    final /* synthetic */ String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        ad.a().a(new e(this));
    }
}
