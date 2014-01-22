package com.baidu.tieba.data.chat;

import com.baidu.adp.lib.g.e;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.by;
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
            DatabaseService.a();
        } catch (Throwable th) {
            by.a(th, "ChatDBManager.cleanExpiredDataOnAppStart", new Object[0]);
            e.b("DatabaseService", "cleanExpiredMessagesOnAppStart", th.getMessage());
        }
    }
}
