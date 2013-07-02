package com.baidu.tieba.data.a;

import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Thread {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            DatabaseService.a().delete("chat_msgs", "serverTime < ?", new String[]{String.valueOf(System.currentTimeMillis() - (-1702967296))});
        } catch (Throwable th) {
            z.b("DatabaseService", "cleanExpiredMessagesOnAppStart", th.getMessage());
        }
    }
}
