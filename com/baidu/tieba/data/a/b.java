package com.baidu.tieba.data.a;

import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f985a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f985a = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            DatabaseService.a().delete("chat_msgs", "serverTime < ?", new String[]{String.valueOf(System.currentTimeMillis() - (-1702967296))});
        } catch (Throwable th) {
            av.b("DatabaseService", "cleanExpiredMessagesOnAppStart", th.getMessage());
        }
    }
}
