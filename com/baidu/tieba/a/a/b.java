package com.baidu.tieba.a.a;

import com.baidu.tieba.d.ae;
import com.baidu.tieba.d.k;
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
            k.a().delete("chat_msgs", "serverTime < ?", new String[]{String.valueOf(System.currentTimeMillis() - (-1702967296))});
        } catch (Throwable th) {
            ae.b("DatabaseService", "cleanExpiredMessagesOnAppStart", th.getMessage());
        }
    }
}
