package com.baidu.tieba.VideoCache;

import android.content.Context;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
/* loaded from: classes.dex */
public class r {
    private static final String TAG = r.class.getSimpleName();
    private ServerSocket aQJ;
    private Context mContext;
    private Runnable mRunnable = new s(this);

    public r(Context context) {
        this.mContext = context;
        p.KX().g(this.mRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZ() {
        File file = new File(l.aQw);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(l.aQx);
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
        File file4 = new File(l.aQy);
        if (!file4.exists()) {
            file4.mkdir();
        }
        File file5 = new File(l.aQA);
        if (!file5.exists()) {
            file5.mkdir();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fL(int i) {
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(l.aQC)));
            try {
                try {
                    bufferedWriter.write(new StringBuilder(String.valueOf(i)).toString());
                    bufferedWriter.flush();
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (bufferedWriter != null) {
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
            bufferedWriter = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter = null;
            if (bufferedWriter != null) {
            }
            throw th;
        }
    }

    public void destroy() {
        try {
            if (this.aQJ != null) {
                this.aQJ.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, Socket socket) {
        m.log(TAG, "handleStopCache in");
        String KS = jVar.KS();
        if (KS != null) {
            KS = KS.replace("?stop_cache=1", "");
        }
        g.KO().gX(KS);
        d(socket);
        m.log(TAG, "handleStopCache out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(j jVar, Socket socket) {
        m.log(TAG, "handleFileAccess in");
        String KS = jVar.KS();
        if (KS != null) {
            KS = KS.replace("?file_access=1", "");
        }
        n.KW().gR(KS);
        d(socket);
        m.log(TAG, "handleFileAccess out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar, Socket socket) {
        m.log(TAG, "handleDeleteExpiredFiles in");
        n.KW().KK();
        d(socket);
        m.log(TAG, "handleDeleteExpiredFiles out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(j jVar, Socket socket) {
        m.log(TAG, "handleClearCache in");
        n.KW().clearCache();
        d(socket);
        m.log(TAG, "handleClearCache out");
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
