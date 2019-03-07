package com.baidu.tieba.VideoCache;

import android.content.Context;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
/* loaded from: classes4.dex */
public class n {
    private static final String TAG = n.class.getSimpleName();
    private ServerSocket cMa;
    private Context mContext;
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.VideoCache.n.1
        @Override // java.lang.Runnable
        public void run() {
            long j;
            j.as(n.TAG, "run ...");
            n.this.avT();
            int i = 9000;
            while (n.this.cMa == null && i < 10000) {
                try {
                    n.this.cMa = new ServerSocket(i);
                } catch (Exception e) {
                    e.printStackTrace();
                    n.this.cMa = null;
                    i++;
                }
            }
            j.as(n.TAG, "service port " + i);
            n.this.lp(i);
            e.avH();
            k.avQ();
            while (!n.this.cMa.isClosed()) {
                try {
                    j.as(n.TAG, "accept start");
                    Socket accept = n.this.cMa.accept();
                    j.as(n.TAG, "accept end");
                    if (accept != null) {
                        j.as(n.TAG, "连接视频服务的client:" + accept);
                        h b = f.b(accept);
                        String avL = b.avL();
                        if (avL != null && avL.contains("?file_access=1")) {
                            n.this.c(b, accept);
                        } else if (avL != null && avL.contains("?stop_cache=1")) {
                            n.this.a(b, accept);
                        } else if (avL != null && avL.contains("delete_expired_files")) {
                            n.this.d(b, accept);
                        } else if (avL != null && avL.contains("clear_cache")) {
                            n.this.e(b, accept);
                        } else if (avL != null && avL.contains("?segment_postion=")) {
                            try {
                                int indexOf = avL.indexOf("?segment_postion=", 0);
                                b.qw(avL.substring(0, indexOf));
                                j = com.baidu.adp.lib.g.b.d(avL.substring(indexOf + i.cLT), 0L);
                            } catch (Exception e2) {
                                j = 0;
                            }
                            b.bx(j);
                            n.this.b(b, accept);
                        } else {
                            j.as(n.TAG, "HandleSocketRunnable new request b=" + b.avN() + " e=" + b.avO());
                            f fVar = new f(n.this.mContext);
                            fVar.setSocket(accept);
                            fVar.a(b);
                            l.avR().k(fVar);
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    j.as(n.TAG, "视频服务已退出");
                    return;
                }
            }
            j.as(n.TAG, "视频服务已退出");
        }
    };

    public n(Context context) {
        this.mContext = context;
        l.avR().k(this.mRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avT() {
        File file = new File(i.cLN);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(i.cLO);
        if (!file2.exists()) {
            file2.mkdir();
        }
        File[] listFiles = file2.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file3 : listFiles) {
                if (file3 != null && file3.exists() && file3.getName() != null && !file3.getName().contains("v2")) {
                    file3.delete();
                }
            }
        }
        File file4 = new File(i.yM);
        if (!file4.exists()) {
            file4.mkdir();
        }
        File file5 = new File(i.cLQ);
        if (!file5.exists()) {
            file5.mkdir();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0054 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0056 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0008 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.io.BufferedWriter */
    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.io.BufferedWriter */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.io.BufferedWriter */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.io.BufferedWriter */
    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: java.io.BufferedWriter */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.BufferedWriter] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void lp(int i) {
        BufferedWriter bufferedWriter = i.cLS;
        try {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(new File((String) bufferedWriter)));
                try {
                    bufferedWriter.write(i + "");
                    bufferedWriter.flush();
                    if (bufferedWriter != 0) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (bufferedWriter != 0) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (bufferedWriter != 0) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedWriter = 0;
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter = 0;
            if (bufferedWriter != 0) {
            }
            throw th;
        }
    }

    public void destroy() {
        try {
            if (this.cMa != null) {
                this.cMa.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar, Socket socket) {
        j.as(TAG, "handleStopCache in");
        String avL = hVar.avL();
        if (avL != null) {
            avL = avL.replace("?stop_cache=1", "");
        }
        e.avH().qs(avL);
        d(socket);
        j.as(TAG, "handleStopCache out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(h hVar, Socket socket) {
        j.as(TAG, "handleNotifyDownLoadNextSegment in");
        String avL = hVar.avL();
        if (avL != null) {
            e.avH().n(avL, hVar.avP());
        }
        d(socket);
        j.as(TAG, "handleNotifyDownLoadNextSegment out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(h hVar, Socket socket) {
        j.as(TAG, "handleFileAccess in");
        String avL = hVar.avL();
        if (avL != null) {
            avL = avL.replace("?file_access=1", "");
        }
        k.avQ().qm(avL);
        d(socket);
        j.as(TAG, "handleFileAccess out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(h hVar, Socket socket) {
        j.as(TAG, "handleDeleteExpiredFiles in");
        k.avQ().avB();
        d(socket);
        j.as(TAG, "handleDeleteExpiredFiles out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(h hVar, Socket socket) {
        j.as(TAG, "handleClearCache in");
        k.avQ().clearCache();
        d(socket);
        j.as(TAG, "handleClearCache out");
    }

    private void d(Socket socket) {
        if (socket != null) {
            try {
                PrintStream printStream = new PrintStream(socket.getOutputStream(), true);
                printStream.println("HTTP/1.1 200 OK");
                printStream.println("Content-Type: text/plain");
                printStream.println("Content-Length: 0");
                printStream.println();
                printStream.flush();
                printStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
