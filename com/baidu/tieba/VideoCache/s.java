package com.baidu.tieba.VideoCache;

import android.content.Context;
import java.net.ServerSocket;
import java.net.Socket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ r aNv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.aNv = rVar;
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
        str = r.TAG;
        m.log(str, "run ...");
        this.aNv.JJ();
        int i = 9000;
        while (serverSocket == null && i < 10000) {
            try {
                this.aNv.aNu = new ServerSocket(i);
            } catch (Exception e) {
                e.printStackTrace();
                this.aNv.aNu = null;
                i++;
            }
        }
        str2 = r.TAG;
        m.log(str2, "service port " + i);
        this.aNv.fH(i);
        g.Jy();
        n.JG();
        while (true) {
            try {
                serverSocket2 = this.aNv.aNu;
                if (serverSocket2.isClosed()) {
                    str4 = r.TAG;
                    m.log(str4, "视频服务已退出");
                    return;
                }
                str5 = r.TAG;
                m.log(str5, "accept start");
                serverSocket3 = this.aNv.aNu;
                Socket accept = serverSocket3.accept();
                str6 = r.TAG;
                m.log(str6, "accept end");
                if (accept != null) {
                    str7 = r.TAG;
                    m.log(str7, "连接视频服务的client:" + accept);
                    j b = h.b(accept);
                    String JC = b.JC();
                    if (JC == null || !JC.contains("?file_access=1")) {
                        if (JC == null || !JC.contains("?stop_cache=1")) {
                            if (JC == null || !JC.contains("delete_expired_files")) {
                                if (JC == null || !JC.contains("clear_cache")) {
                                    context = this.aNv.mContext;
                                    h hVar = new h(context);
                                    hVar.a(accept);
                                    hVar.a(b);
                                    p.JH().g(hVar);
                                } else {
                                    this.aNv.d(b, accept);
                                }
                            } else {
                                this.aNv.c(b, accept);
                            }
                        } else {
                            this.aNv.a(b, accept);
                        }
                    } else {
                        this.aNv.b(b, accept);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                str3 = r.TAG;
                m.log(str3, "视频服务已退出");
                return;
            }
        }
    }
}
