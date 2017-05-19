package com.baidu.tieba.VideoCache;

import android.content.Context;
import java.net.ServerSocket;
import java.net.Socket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class q implements Runnable {
    final /* synthetic */ p aVA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.aVA = pVar;
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
        this.aVA.La();
        int i = 9000;
        while (serverSocket == null && i < 10000) {
            try {
                this.aVA.aVz = new ServerSocket(i);
            } catch (Exception e) {
                e.printStackTrace();
                this.aVA.aVz = null;
                i++;
            }
        }
        str2 = p.TAG;
        k.log(str2, "service port " + i);
        this.aVA.fI(i);
        f.KP();
        l.KX();
        while (true) {
            try {
                serverSocket2 = this.aVA.aVz;
                if (serverSocket2.isClosed()) {
                    str4 = p.TAG;
                    k.log(str4, "视频服务已退出");
                    return;
                }
                str5 = p.TAG;
                k.log(str5, "accept start");
                serverSocket3 = this.aVA.aVz;
                Socket accept = serverSocket3.accept();
                str6 = p.TAG;
                k.log(str6, "accept end");
                if (accept != null) {
                    str7 = p.TAG;
                    k.log(str7, "连接视频服务的client:" + accept);
                    i b = g.b(accept);
                    String KT = b.KT();
                    if (KT == null || !KT.contains("?file_access=1")) {
                        if (KT == null || !KT.contains("?stop_cache=1")) {
                            if (KT == null || !KT.contains("delete_expired_files")) {
                                if (KT == null || !KT.contains("clear_cache")) {
                                    context = this.aVA.mContext;
                                    g gVar = new g(context);
                                    gVar.a(accept);
                                    gVar.a(b);
                                    n.KY().g(gVar);
                                } else {
                                    this.aVA.d(b, accept);
                                }
                            } else {
                                this.aVA.c(b, accept);
                            }
                        } else {
                            this.aVA.a(b, accept);
                        }
                    } else {
                        this.aVA.b(b, accept);
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
