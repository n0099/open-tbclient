package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.db.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1687a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(String str) {
        this.f1687a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        x.a().a(new g(this));
    }
}
