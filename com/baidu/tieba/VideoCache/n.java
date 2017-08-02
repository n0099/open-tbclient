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
    private ServerSocket aVx;
    private Context mContext;
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.VideoCache.n.1
        @Override // java.lang.Runnable
        public void run() {
            j.log(n.TAG, "run ...");
            n.this.Kz();
            int i = 9000;
            while (n.this.aVx == null && i < 10000) {
                try {
                    n.this.aVx = new ServerSocket(i);
                } catch (Exception e) {
                    e.printStackTrace();
                    n.this.aVx = null;
                    i++;
                }
            }
            j.log(n.TAG, "service port " + i);
            n.this.fN(i);
            e.Ko();
            k.Kw();
            while (!n.this.aVx.isClosed()) {
                try {
                    j.log(n.TAG, "accept start");
                    Socket accept = n.this.aVx.accept();
                    j.log(n.TAG, "accept end");
                    if (accept != null) {
                        j.log(n.TAG, "连接视频服务的client:" + accept);
                        h b = f.b(accept);
                        String Ks = b.Ks();
                        if (Ks != null && Ks.contains("?file_access=1")) {
                            n.this.b(b, accept);
                        } else if (Ks != null && Ks.contains("?stop_cache=1")) {
                            n.this.a(b, accept);
                        } else if (Ks != null && Ks.contains("delete_expired_files")) {
                            n.this.c(b, accept);
                        } else if (Ks != null && Ks.contains("clear_cache")) {
                            n.this.d(b, accept);
                        } else {
                            f fVar = new f(n.this.mContext);
                            fVar.a(accept);
                            fVar.a(b);
                            l.Kx().g(fVar);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    j.log(n.TAG, "视频服务已退出");
                    return;
                }
            }
            j.log(n.TAG, "视频服务已退出");
        }
    };

    public n(Context context) {
        this.mContext = context;
        l.Kx().g(this.mRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kz() {
        File file = new File(i.aVk);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(i.aVl);
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
        File file4 = new File(i.aVm);
        if (!file4.exists()) {
            file4.mkdir();
        }
        File file5 = new File(i.aVo);
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
    public void fN(int i) {
        BufferedWriter bufferedWriter = i.aVq;
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
            if (this.aVx != null) {
                this.aVx.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar, Socket socket) {
        j.log(TAG, "handleStopCache in");
        String Ks = hVar.Ks();
        if (Ks != null) {
            Ks = Ks.replace("?stop_cache=1", "");
        }
        e.Ko().hi(Ks);
        d(socket);
        j.log(TAG, "handleStopCache out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(h hVar, Socket socket) {
        j.log(TAG, "handleFileAccess in");
        String Ks = hVar.Ks();
        if (Ks != null) {
            Ks = Ks.replace("?file_access=1", "");
        }
        k.Kw().hc(Ks);
        d(socket);
        j.log(TAG, "handleFileAccess out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(h hVar, Socket socket) {
        j.log(TAG, "handleDeleteExpiredFiles in");
        k.Kw().Kk();
        d(socket);
        j.log(TAG, "handleDeleteExpiredFiles out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(h hVar, Socket socket) {
        j.log(TAG, "handleClearCache in");
        k.Kw().clearCache();
        d(socket);
        j.log(TAG, "handleClearCache out");
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
