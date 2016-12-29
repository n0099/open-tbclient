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
public class p {
    private static final String TAG = p.class.getSimpleName();
    private ServerSocket aQa;
    private Context mContext;
    private Runnable mRunnable = new q(this);

    public p(Context context) {
        this.mContext = context;
        n.Kq().g(this.mRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ks() {
        File file = new File(j.aPN);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(j.aPO);
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
        File file4 = new File(j.aPP);
        if (!file4.exists()) {
            file4.mkdir();
        }
        File file5 = new File(j.aPR);
        if (!file5.exists()) {
            file5.mkdir();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fK(int i) {
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(j.aPT)));
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
            if (this.aQa != null) {
                this.aQa.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar, Socket socket) {
        k.log(TAG, "handleStopCache in");
        String Kl = iVar.Kl();
        if (Kl != null) {
            Kl = Kl.replace("?stop_cache=1", "");
        }
        f.Kh().gS(Kl);
        d(socket);
        k.log(TAG, "handleStopCache out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(i iVar, Socket socket) {
        k.log(TAG, "handleFileAccess in");
        String Kl = iVar.Kl();
        if (Kl != null) {
            Kl = Kl.replace("?file_access=1", "");
        }
        l.Kp().gM(Kl);
        d(socket);
        k.log(TAG, "handleFileAccess out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(i iVar, Socket socket) {
        k.log(TAG, "handleDeleteExpiredFiles in");
        l.Kp().Kd();
        d(socket);
        k.log(TAG, "handleDeleteExpiredFiles out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(i iVar, Socket socket) {
        k.log(TAG, "handleClearCache in");
        l.Kp().clearCache();
        d(socket);
        k.log(TAG, "handleClearCache out");
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
