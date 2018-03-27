package com.baidu.tieba.VideoCache;

import android.content.Context;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
/* loaded from: classes2.dex */
public class n {
    private static final String TAG = n.class.getSimpleName();
    private ServerSocket bRG;
    private Context mContext;
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.VideoCache.n.1
        @Override // java.lang.Runnable
        public void run() {
            long j;
            j.au(n.TAG, "run ...");
            n.this.TT();
            int i = 9000;
            while (n.this.bRG == null && i < 10000) {
                try {
                    n.this.bRG = new ServerSocket(i);
                } catch (Exception e) {
                    e.printStackTrace();
                    n.this.bRG = null;
                    i++;
                }
            }
            j.au(n.TAG, "service port " + i);
            n.this.jk(i);
            e.TH();
            k.TQ();
            while (!n.this.bRG.isClosed()) {
                try {
                    j.au(n.TAG, "accept start");
                    Socket accept = n.this.bRG.accept();
                    j.au(n.TAG, "accept end");
                    if (accept != null) {
                        j.au(n.TAG, "连接视频服务的client:" + accept);
                        h b = f.b(accept);
                        String TL = b.TL();
                        if (TL != null && TL.contains("?file_access=1")) {
                            n.this.c(b, accept);
                        } else if (TL != null && TL.contains("?stop_cache=1")) {
                            n.this.a(b, accept);
                        } else if (TL != null && TL.contains("delete_expired_files")) {
                            n.this.d(b, accept);
                        } else if (TL != null && TL.contains("clear_cache")) {
                            n.this.e(b, accept);
                        } else if (TL != null && TL.contains("?segment_postion=")) {
                            try {
                                int indexOf = TL.indexOf("?segment_postion=", 0);
                                b.hQ(TL.substring(0, indexOf));
                                j = com.baidu.adp.lib.g.b.c(TL.substring(indexOf + i.bRz), 0L);
                            } catch (Exception e2) {
                                j = 0;
                            }
                            b.aG(j);
                            n.this.b(b, accept);
                        } else {
                            j.au(n.TAG, "HandleSocketRunnable new request b=" + b.TN() + " e=" + b.TO());
                            f fVar = new f(n.this.mContext);
                            fVar.a(accept);
                            fVar.a(b);
                            l.TR().f(fVar);
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    j.au(n.TAG, "视频服务已退出");
                    return;
                }
            }
            j.au(n.TAG, "视频服务已退出");
        }
    };

    public n(Context context) {
        this.mContext = context;
        l.TR().f(this.mRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TT() {
        File file = new File(i.bRt);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(i.bRu);
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
        File file4 = new File(i.afd);
        if (!file4.exists()) {
            file4.mkdir();
        }
        File file5 = new File(i.bRw);
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
    public void jk(int i) {
        BufferedWriter bufferedWriter = i.bRy;
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
            if (this.bRG != null) {
                this.bRG.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar, Socket socket) {
        j.au(TAG, "handleStopCache in");
        String TL = hVar.TL();
        if (TL != null) {
            TL = TL.replace("?stop_cache=1", "");
        }
        e.TH().hM(TL);
        d(socket);
        j.au(TAG, "handleStopCache out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(h hVar, Socket socket) {
        j.au(TAG, "handleNotifyDownLoadNextSegment in");
        String TL = hVar.TL();
        if (TL != null) {
            e.TH().h(TL, hVar.TP());
        }
        d(socket);
        j.au(TAG, "handleNotifyDownLoadNextSegment out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(h hVar, Socket socket) {
        j.au(TAG, "handleFileAccess in");
        String TL = hVar.TL();
        if (TL != null) {
            TL = TL.replace("?file_access=1", "");
        }
        k.TQ().hG(TL);
        d(socket);
        j.au(TAG, "handleFileAccess out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(h hVar, Socket socket) {
        j.au(TAG, "handleDeleteExpiredFiles in");
        k.TQ().TB();
        d(socket);
        j.au(TAG, "handleDeleteExpiredFiles out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(h hVar, Socket socket) {
        j.au(TAG, "handleClearCache in");
        k.TQ().clearCache();
        d(socket);
        j.au(TAG, "handleClearCache out");
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
