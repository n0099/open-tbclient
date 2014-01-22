package com.baidu.tieba.im.c;

import com.baidu.tieba.im.db.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements Runnable {
    final /* synthetic */ String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str) {
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        ae.a().a(new i(this));
    }
}
