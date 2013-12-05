package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.db.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1863a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str) {
        this.f1863a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        ad.a().a(new i(this));
    }
}
