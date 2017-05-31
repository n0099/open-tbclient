package com.baidu.tieba.VideoCache;

import android.content.Context;
import java.net.ServerSocket;
import java.net.Socket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class q implements Runnable {
    final /* synthetic */ p aTc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.aTc = pVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0016 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        String str;
        ServerSocket serverSocket;
        String str2;
        String str3;
        ServerSocket serverSocket2;
        String str4;
        String str5;
        ServerSocket serverSocket3;
        String str6;
        String str7;
        Context context;
        str = p.TAG;
        k.log(str, "run ...");
        this.aTc.JV();
        int i = 9000;
        while (serverSocket == null && i < 10000) {
            try {
                this.aTc.aTb = new ServerSocket(i);
            } catch (Exception e) {
                e.printStackTrace();
                this.aTc.aTb = null;
                i++;
            }
        }
        str2 = p.TAG;
        k.log(str2, "service port " + i);
        this.aTc.fI(i);
        f.JK();
        l.JS();
        while (true) {
            try {
                serverSocket2 = this.aTc.aTb;
                if (serverSocket2.isClosed()) {
                    str4 = p.TAG;
                    k.log(str4, "视频服务已退出");
                    return;
                }
                str5 = p.TAG;
                k.log(str5, "accept start");
                serverSocket3 = this.aTc.aTb;
                Socket accept = serverSocket3.accept();
                str6 = p.TAG;
                k.log(str6, "accept end");
                if (accept != null) {
                    str7 = p.TAG;
                    k.log(str7, "连接视频服务的client:" + accept);
                    i b = g.b(accept);
                    String JO = b.JO();
                    if (JO == null || !JO.contains("?file_access=1")) {
                        if (JO == null || !JO.contains("?stop_cache=1")) {
                            if (JO == null || !JO.contains("delete_expired_files")) {
                                if (JO == null || !JO.contains("clear_cache")) {
                                    context = this.aTc.mContext;
                                    g gVar = new g(context);
                                    gVar.a(accept);
                                    gVar.a(b);
                                    n.JT().g(gVar);
                                } else {
                                    this.aTc.d(b, accept);
                                }
                            } else {
                                this.aTc.c(b, accept);
                            }
                        } else {
                            this.aTc.a(b, accept);
                        }
                    } else {
                        this.aTc.b(b, accept);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                str3 = p.TAG;
                k.log(str3, "视频服务已退出");
                return;
            }
        }
    }
}
