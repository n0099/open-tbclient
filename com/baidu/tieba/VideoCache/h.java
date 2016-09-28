package com.baidu.tieba.VideoCache;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLDecoder;
/* loaded from: classes.dex */
class h implements Runnable {
    private static final String TAG = h.class.getSimpleName();
    private byte[] aOi = new byte[AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START];
    private j aOj;
    private Context mContext;
    private Socket ti;

    public h(Context context) {
        this.mContext = context;
    }

    public void a(Socket socket) {
        this.ti = socket;
    }

    public void a(j jVar) {
        this.aOj = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        m.log(TAG, "test run in " + this);
        if (this.aOj == null) {
            m.log(TAG, "test run out 1" + this);
            return;
        }
        try {
            b(this.aOj);
            if (this.aOj.Kn().contains("/video_cache/pre_load?origin_url=")) {
                a(this.aOj, this.ti, true);
            } else {
                a(this.aOj, this.ti, false);
            }
            c(this.ti);
        } catch (Exception e) {
            m.log(TAG, "HTTP服务器错误:" + e.getLocalizedMessage());
        }
        m.log(TAG, "test run out 2" + this);
    }

    public static j b(Socket socket) {
        String readLine;
        int lastIndexOf;
        j jVar = new j();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            do {
                readLine = bufferedReader.readLine();
                if (readLine != null && readLine.contains("GET") && readLine.contains("origin_url=")) {
                    String[] split = readLine.split(" ");
                    if (split != null && split.length > 1) {
                        jVar.gZ(split[1]);
                    }
                    String substring = readLine.substring(readLine.indexOf("origin_url=") + 11);
                    String str = "";
                    if (substring != null && substring.contains(" ")) {
                        str = substring.substring(0, substring.indexOf(" "));
                    }
                    jVar.ha(URLDecoder.decode(str));
                } else if (readLine != null && readLine.startsWith("Range") && readLine.contains(":")) {
                    jVar.cd(true);
                    String[] split2 = readLine.split(":");
                    String str2 = (split2 == null || split2.length <= 1) ? "" : split2[1];
                    String substring2 = (str2 == null || (lastIndexOf = str2.lastIndexOf("bytes=") + 6) < 0 || lastIndexOf > str2.length()) ? str2 : str2.substring(lastIndexOf);
                    String[] strArr = null;
                    if (substring2 != null) {
                        try {
                            strArr = substring2.split("-");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (strArr != null && strArr.length >= 1) {
                        jVar.at(Long.parseLong(strArr[0]));
                        if (strArr.length > 1) {
                            jVar.au(Long.parseLong(strArr[1]));
                        }
                    }
                }
                if (readLine == null) {
                    break;
                }
            } while (!readLine.equals(""));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jVar;
    }

    private void b(j jVar) {
    }

    private boolean a(j jVar, PrintStream printStream) {
        int gX = gX(jVar.Ko());
        if (gX <= 0) {
            return false;
        }
        jVar.O(gX);
        if (jVar.Kq() < 0) {
            jVar.at(0L);
        }
        if (jVar.Kr() < 0) {
            jVar.au(gX - 1);
        }
        long Kq = jVar.Kq();
        long Kr = jVar.Kr();
        m.log(TAG, "range is: " + Kq + "-" + Kr + " " + this);
        if (jVar.Kp()) {
            printStream.println("HTTP/1.1 206 Partial Content");
        } else {
            printStream.println("HTTP/1.1 200 OK");
        }
        printStream.println("Content-Type: video/mp4");
        printStream.println("Accept-Ranges: bytes");
        printStream.println("Content-Length: " + ((Kr - Kq) + 1));
        if (jVar.Kp()) {
            printStream.println("Content-Range: bytes " + Kq + "-" + Kr + "/" + gX);
        }
        printStream.println("Content-Transfer-Encoding: binary");
        printStream.println();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [206=4, 207=4, 209=4, 210=4, 213=4, 214=4, 216=4, 217=4] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int gX(String str) {
        FileInputStream fileInputStream;
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        dataInputStream2 = null;
        FileInputStream fileInputStream2 = null;
        String he = q.he(str);
        if (he == null || he.isEmpty()) {
            return 0;
        }
        File file = new File(String.valueOf(l.aOv) + he);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(String.valueOf(file.getAbsolutePath()) + "/content_length");
        file2.getAbsolutePath();
        if (file2.exists()) {
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    dataInputStream = new DataInputStream(fileInputStream);
                } catch (Exception e) {
                    e = e;
                    dataInputStream = null;
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    int parseInt = Integer.parseInt(dataInputStream.readLine());
                    if (parseInt > 0) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                                return parseInt;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return parseInt;
                            }
                        }
                        return parseInt;
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                    fileInputStream2 = fileInputStream;
                    try {
                        e.printStackTrace();
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        int contentLength = ((HttpURLConnection) new URL(str).openConnection()).getContentLength();
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
                        bufferedWriter.write(new StringBuilder(String.valueOf(contentLength)).toString());
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        return contentLength;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        dataInputStream2 = dataInputStream;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        if (dataInputStream2 != null) {
                            try {
                                dataInputStream2.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream2 = dataInputStream;
                    if (fileInputStream != null) {
                    }
                    if (dataInputStream2 != null) {
                    }
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
                dataInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
            }
        } else {
            try {
                file2.createNewFile();
            } catch (IOException e12) {
                e12.printStackTrace();
            }
        }
        try {
            int contentLength2 = ((HttpURLConnection) new URL(str).openConnection()).getContentLength();
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2));
            bufferedWriter2.write(new StringBuilder(String.valueOf(contentLength2)).toString());
            bufferedWriter2.flush();
            bufferedWriter2.close();
            return contentLength2;
        } catch (Exception e13) {
            e13.printStackTrace();
            return 0;
        }
    }

    private void a(j jVar, Socket socket, boolean z) {
        if (jVar != null && socket != null) {
            File file = new File(l.aOs);
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                d dVar = new d(this.mContext);
                dVar.setVideoUrl(jVar.Ko());
                PrintStream printStream = new PrintStream(socket.getOutputStream(), true);
                if (!a(jVar, printStream)) {
                    printStream.close();
                    dVar.close();
                    return;
                }
                dVar.O(jVar.getTotalLength());
                if (z) {
                    if (g.Kk().p(dVar)) {
                        printStream.close();
                        dVar.close();
                        g.Kk().q(null);
                        return;
                    }
                    d Kl = g.Kk().Kl();
                    if (Kl != null) {
                        Kl.close();
                    }
                    m.log(TAG, "server handle preload: " + dVar.getVideoUrl());
                    g.Kk().q(dVar);
                } else {
                    d Kl2 = g.Kk().Kl();
                    if (Kl2 != null && Kl2.getVideoUrl() != null && Kl2.getVideoUrl().equals(dVar.getVideoUrl())) {
                        Kl2.close();
                        g.Kk().q(null);
                    }
                    g.Kk().n(dVar);
                }
                dVar.b(jVar.Kq(), jVar.Kr());
                while (dVar.canRead()) {
                    int e = dVar.e(this.aOi, AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START);
                    if (e > 0) {
                        printStream.write(this.aOi, 0, e);
                    }
                }
                m.log(TAG, "finished! " + this);
                printStream.flush();
                printStream.close();
                dVar.close();
                if (z) {
                    g.Kk().q(null);
                } else {
                    g.Kk().o(dVar);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void c(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            m.log(TAG, socket + "离开了HTTP服务器 " + this);
        }
    }
}
