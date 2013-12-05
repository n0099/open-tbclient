package com.baidu.tieba.data.chat;

import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1241a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f1241a = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            DatabaseService.a();
        } catch (Throwable th) {
            bd.b("DatabaseService", "cleanExpiredMessagesOnAppStart", th.getMessage());
        }
    }
}
