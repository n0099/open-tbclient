package com.baidu.tieba.VideoCache;

import android.content.Context;
import java.net.ServerSocket;
import java.net.Socket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ p aPe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.aPe = pVar;
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
        this.aPe.KH();
        int i = 9000;
        while (serverSocket == null && i < 10000) {
            try {
                this.aPe.aPd = new ServerSocket(i);
            } catch (Exception e) {
                e.printStackTrace();
                this.aPe.aPd = null;
                i++;
            }
        }
        str2 = p.TAG;
        k.log(str2, "service port " + i);
        this.aPe.fO(i);
        f.Kw();
        l.KE();
        while (true) {
            try {
                serverSocket2 = this.aPe.aPd;
                if (serverSocket2.isClosed()) {
                    str4 = p.TAG;
                    k.log(str4, "视频服务已退出");
                    return;
                }
                str5 = p.TAG;
                k.log(str5, "accept start");
                serverSocket3 = this.aPe.aPd;
                Socket accept = serverSocket3.accept();
                str6 = p.TAG;
                k.log(str6, "accept end");
                if (accept != null) {
                    str7 = p.TAG;
                    k.log(str7, "连接视频服务的client:" + accept);
                    i b = g.b(accept);
                    String KA = b.KA();
                    if (KA == null || !KA.contains("?file_access=1")) {
                        if (KA == null || !KA.contains("?stop_cache=1")) {
                            if (KA == null || !KA.contains("delete_expired_files")) {
                                if (KA == null || !KA.contains("clear_cache")) {
                                    context = this.aPe.mContext;
                                    g gVar = new g(context);
                                    gVar.a(accept);
                                    gVar.a(b);
                                    n.KF().g(gVar);
                                } else {
                                    this.aPe.d(b, accept);
                                }
                            } else {
                                this.aPe.c(b, accept);
                            }
                        } else {
                            this.aPe.a(b, accept);
                        }
                    } else {
                        this.aPe.b(b, accept);
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
