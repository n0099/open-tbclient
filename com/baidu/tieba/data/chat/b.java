package com.baidu.tieba.data.chat;

import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1189a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f1189a = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            DatabaseService.a();
        } catch (Throwable th) {
            bg.b("DatabaseService", "cleanExpiredMessagesOnAppStart", th.getMessage());
        }
    }
}
