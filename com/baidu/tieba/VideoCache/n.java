package com.baidu.tieba.VideoCache;

import android.content.Context;
import com.baidu.ar.base.MsgField;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
/* loaded from: classes6.dex */
public class n {
    private static final String TAG = n.class.getSimpleName();
    private ServerSocket bvV;
    private Context mContext;
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.VideoCache.n.1
        @Override // java.lang.Runnable
        public void run() {
            long j;
            j.log(n.TAG, "run ...");
            n.this.Ug();
            int i = MsgField.MSG_STAT_FIRST_LOAD_START_FILE_MANAGE;
            while (n.this.bvV == null && i < 10000) {
                try {
                    n.this.bvV = new ServerSocket(i);
                } catch (Exception e) {
                    e.printStackTrace();
                    n.this.bvV = null;
                    i++;
                }
            }
            j.log(n.TAG, "service port " + i);
            n.this.gX(i);
            e.TU();
            k.Ud();
            while (!n.this.bvV.isClosed()) {
                try {
                    j.log(n.TAG, "accept start");
                    Socket accept = n.this.bvV.accept();
                    j.log(n.TAG, "accept end");
                    if (accept != null) {
                        j.log(n.TAG, "连接视频服务的client:" + accept);
                        h b = f.b(accept);
                        String TY = b.TY();
                        if (TY != null && TY.contains("?file_access=1")) {
                            n.this.c(b, accept);
                        } else if (TY != null && TY.contains("?stop_cache=1")) {
                            n.this.a(b, accept);
                        } else if (TY != null && TY.contains("delete_expired_files")) {
                            n.this.d(b, accept);
                        } else if (TY != null && TY.contains("clear_cache")) {
                            n.this.e(b, accept);
                        } else if (TY != null && TY.contains("?segment_postion=")) {
                            try {
                                int indexOf = TY.indexOf("?segment_postion=", 0);
                                b.ja(TY.substring(0, indexOf));
                                j = com.baidu.adp.lib.g.b.d(TY.substring(indexOf + i.bvO), 0L);
                            } catch (Exception e2) {
                                j = 0;
                            }
                            b.aL(j);
                            n.this.b(b, accept);
                        } else {
                            j.log(n.TAG, "HandleSocketRunnable new request b=" + b.Ua() + " e=" + b.Ub());
                            f fVar = new f(n.this.mContext);
                            fVar.setSocket(accept);
                            fVar.a(b);
                            l.Ue().e(fVar);
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    j.log(n.TAG, "视频服务已退出");
                    return;
                }
            }
            j.log(n.TAG, "视频服务已退出");
        }
    };

    public n(Context context) {
        this.mContext = context;
        l.Ue().e(this.mRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ug() {
        File file = new File(i.bvI);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(i.bvJ);
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
        File file5 = new File(i.bvL);
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
    public void gX(int i) {
        BufferedWriter bufferedWriter = i.bvN;
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
            if (this.bvV != null) {
                this.bvV.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar, Socket socket) {
        j.log(TAG, "handleStopCache in");
        String TY = hVar.TY();
        if (TY != null) {
            TY = TY.replace("?stop_cache=1", "");
        }
        e.TU().iW(TY);
        d(socket);
        j.log(TAG, "handleStopCache out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(h hVar, Socket socket) {
        j.log(TAG, "handleNotifyDownLoadNextSegment in");
        String TY = hVar.TY();
        if (TY != null) {
            e.TU().k(TY, hVar.Uc());
        }
        d(socket);
        j.log(TAG, "handleNotifyDownLoadNextSegment out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(h hVar, Socket socket) {
        j.log(TAG, "handleFileAccess in");
        String TY = hVar.TY();
        if (TY != null) {
            TY = TY.replace("?file_access=1", "");
        }
        k.Ud().iQ(TY);
        d(socket);
        j.log(TAG, "handleFileAccess out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(h hVar, Socket socket) {
        j.log(TAG, "handleDeleteExpiredFiles in");
        k.Ud().TO();
        d(socket);
        j.log(TAG, "handleDeleteExpiredFiles out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(h hVar, Socket socket) {
        j.log(TAG, "handleClearCache in");
        k.Ud().clearCache();
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
