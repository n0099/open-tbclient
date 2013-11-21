package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.db.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1768a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(String str) {
        this.f1768a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        x.a().a(new k(this));
    }
}
