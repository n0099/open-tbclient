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
    private byte[] aMY = new byte[AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START];
    private j aMZ;
    private Context mContext;
    private Socket ti;

    public h(Context context) {
        this.mContext = context;
    }

    public void a(Socket socket) {
        this.ti = socket;
    }

    public void a(j jVar) {
        this.aMZ = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        m.log(TAG, "test run in " + this);
        if (this.aMZ == null) {
            m.log(TAG, "test run out 1" + this);
            return;
        }
        try {
            b(this.aMZ);
            if (this.aMZ.JB().contains("/video_cache/pre_load?origin_url=")) {
                a(this.aMZ, this.ti, true);
            } else {
                a(this.aMZ, this.ti, false);
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
                        jVar.gS(split[1]);
                    }
                    String substring = readLine.substring(readLine.indexOf("origin_url=") + 11);
                    String str = "";
                    if (substring != null && substring.contains(" ")) {
                        str = substring.substring(0, substring.indexOf(" "));
                    }
                    jVar.gT(URLDecoder.decode(str));
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
                        jVar.as(Long.parseLong(strArr[0]));
                        if (strArr.length > 1) {
                            jVar.at(Long.parseLong(strArr[1]));
                        }
                    }
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
        int gQ = gQ(jVar.JC());
        if (gQ <= 0) {
            return false;
        }
        jVar.N(gQ);
        if (jVar.JE() < 0) {
            jVar.as(0L);
        }
        if (jVar.JF() < 0) {
            jVar.at(gQ - 1);
        }
        long JE = jVar.JE();
        long JF = jVar.JF();
        m.log(TAG, "range is: " + JE + "-" + JF + " " + this);
        if (jVar.JD()) {
            printStream.println("HTTP/1.1 206 Partial Content");
        } else {
            printStream.println("HTTP/1.1 200 OK");
        }
        printStream.println("Content-Type: video/mp4");
        printStream.println("Accept-Ranges: bytes");
        printStream.println("Content-Length: " + ((JF - JE) + 1));
        if (jVar.JD()) {
            printStream.println("Content-Range: bytes " + JE + "-" + JF + "/" + gQ);
        }
        printStream.println("Content-Transfer-Encoding: binary");
        printStream.println();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [206=4, 207=4, 208=4, 211=4, 212=4, 213=4] */
    private int gQ(String str) {
        FileInputStream fileInputStream;
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        dataInputStream2 = null;
        FileInputStream fileInputStream2 = null;
        String gX = q.gX(str);
        if (gX == null || gX.isEmpty()) {
            return 0;
        }
        File file = new File(String.valueOf(l.aNl) + gX);
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
                    try {
                        int parseInt = Integer.parseInt(dataInputStream.readLine());
                        if (parseInt > 0) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                dataInputStream.close();
                                return parseInt;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                return parseInt;
                            }
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        try {
                            dataInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    } catch (Exception e5) {
                        e = e5;
                        fileInputStream2 = fileInputStream;
                        try {
                            e.printStackTrace();
                            try {
                                fileInputStream2.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                            try {
                                dataInputStream.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                            int contentLength = ((HttpURLConnection) new URL(str).openConnection()).getContentLength();
                            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
                            bufferedWriter.write(new StringBuilder(String.valueOf(contentLength)).toString());
                            bufferedWriter.flush();
                            bufferedWriter.close();
                            return contentLength;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            dataInputStream2 = dataInputStream;
                            try {
                                fileInputStream.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                            try {
                                dataInputStream2.close();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        dataInputStream2 = dataInputStream;
                        fileInputStream.close();
                        dataInputStream2.close();
                        throw th;
                    }
                } catch (Exception e10) {
                    e = e10;
                    dataInputStream = null;
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th3) {
                    th = th3;
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
            File file = new File(l.aNi);
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                d dVar = new d(this.mContext);
                dVar.setVideoUrl(jVar.JC());
                PrintStream printStream = new PrintStream(socket.getOutputStream(), true);
                if (!a(jVar, printStream)) {
                    printStream.close();
                    dVar.close();
                    return;
                }
                dVar.N(jVar.getTotalLength());
                if (z) {
                    if (g.Jy().p(dVar)) {
                        printStream.close();
                        dVar.close();
                        g.Jy().q(null);
                        return;
                    }
                    d Jz = g.Jy().Jz();
                    if (Jz != null) {
                        Jz.close();
                    }
                    m.log(TAG, "server handle preload: " + dVar.getVideoUrl());
                    g.Jy().q(dVar);
                } else {
                    d Jz2 = g.Jy().Jz();
                    if (Jz2 != null && Jz2.getVideoUrl() != null && Jz2.getVideoUrl().equals(dVar.getVideoUrl())) {
                        Jz2.close();
                        g.Jy().q(null);
                    }
                    g.Jy().n(dVar);
                }
                dVar.b(jVar.JE(), jVar.JF());
                while (dVar.canRead()) {
                    int e = dVar.e(this.aMY, AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START);
                    if (e > 0) {
                        printStream.write(this.aMY, 0, e);
                    }
                }
                m.log(TAG, "finished! " + this);
                printStream.flush();
                printStream.close();
                dVar.close();
                if (z) {
                    g.Jy().q(null);
                } else {
                    g.Jy().o(dVar);
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
