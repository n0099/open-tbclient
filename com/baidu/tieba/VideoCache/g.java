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
class g implements Runnable {
    private static final String TAG = g.class.getSimpleName();
    private byte[] aOI;
    private i aOJ;
    private Context mContext;
    private Socket sZ;

    public g(Context context) {
        this.aOI = null;
        this.mContext = context;
        try {
            this.aOI = new byte[AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START];
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }

    public void a(Socket socket) {
        this.sZ = socket;
    }

    public void a(i iVar) {
        this.aOJ = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        k.log(TAG, "test run in " + this);
        if (this.aOJ == null) {
            k.log(TAG, "test run out 1" + this);
            return;
        }
        try {
            b(this.aOJ);
            if (this.aOJ.Kz().contains("/video_cache/pre_load?origin_url=")) {
                a(this.aOJ, this.sZ, true);
            } else {
                a(this.aOJ, this.sZ, false);
            }
            c(this.sZ);
        } catch (Exception e) {
            k.log(TAG, "HTTP服务器错误:" + e.getLocalizedMessage());
        }
        k.log(TAG, "test run out 2" + this);
    }

    public static i b(Socket socket) {
        String readLine;
        int lastIndexOf;
        i iVar = new i();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            do {
                readLine = bufferedReader.readLine();
                if (readLine != null && readLine.contains("GET") && readLine.contains("origin_url=")) {
                    String[] split = readLine.split(" ");
                    if (split != null && split.length > 1) {
                        iVar.gW(split[1]);
                    }
                    String substring = readLine.substring(readLine.indexOf("origin_url=") + 11);
                    String str = "";
                    if (substring != null && substring.contains(" ")) {
                        str = substring.substring(0, substring.indexOf(" "));
                    }
                    iVar.gX(URLDecoder.decode(str));
                } else if (readLine != null && readLine.startsWith("Range") && readLine.contains(":")) {
                    iVar.cl(true);
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
                        iVar.ap(Long.parseLong(strArr[0]));
                        if (strArr.length > 1) {
                            iVar.aq(Long.parseLong(strArr[1]));
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
        return iVar;
    }

    private void b(i iVar) {
    }

    private boolean a(i iVar, PrintStream printStream) {
        int gU = gU(iVar.KA());
        if (gU <= 0) {
            return false;
        }
        iVar.L(gU);
        if (iVar.KC() < 0) {
            iVar.ap(0L);
        }
        if (iVar.KD() < 0) {
            iVar.aq(gU - 1);
        }
        long KC = iVar.KC();
        long KD = iVar.KD();
        k.log(TAG, "range is: " + KC + "-" + KD + " " + this);
        if (iVar.KB()) {
            printStream.println("HTTP/1.1 206 Partial Content");
        } else {
            printStream.println("HTTP/1.1 200 OK");
        }
        printStream.println("Content-Type: video/mp4");
        printStream.println("Accept-Ranges: bytes");
        printStream.println("Content-Length: " + ((KD - KC) + 1));
        if (iVar.KB()) {
            printStream.println("Content-Range: bytes " + KC + "-" + KD + "/" + gU);
        }
        printStream.println("Content-Transfer-Encoding: binary");
        printStream.println();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [211=4, 212=4, 214=4, 215=4, 218=4, 219=4, 221=4, 222=4] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int gU(String str) {
        FileInputStream fileInputStream;
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        dataInputStream2 = null;
        FileInputStream fileInputStream2 = null;
        String hb = o.hb(str);
        if (hb == null || hb.isEmpty()) {
            return 0;
        }
        File file = new File(String.valueOf(j.aOV) + hb);
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

    private void a(i iVar, Socket socket, boolean z) {
        if (iVar != null && socket != null) {
            File file = new File(j.aOS);
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                c cVar = new c(this.mContext);
                cVar.setVideoUrl(iVar.KA());
                PrintStream printStream = new PrintStream(socket.getOutputStream(), true);
                if (!a(iVar, printStream)) {
                    printStream.close();
                    cVar.close();
                    return;
                }
                cVar.L(iVar.getTotalLength());
                if (z) {
                    if (f.Kw().p(cVar)) {
                        printStream.close();
                        cVar.close();
                        f.Kw().q(null);
                        return;
                    }
                    c Kx = f.Kw().Kx();
                    if (Kx != null) {
                        Kx.close();
                    }
                    k.log(TAG, "server handle preload: " + cVar.getVideoUrl());
                    f.Kw().q(cVar);
                } else {
                    c Kx2 = f.Kw().Kx();
                    if (Kx2 != null && Kx2.getVideoUrl() != null && Kx2.getVideoUrl().equals(cVar.getVideoUrl())) {
                        Kx2.close();
                        f.Kw().q(null);
                    }
                    f.Kw().n(cVar);
                }
                cVar.b(iVar.KC(), iVar.KD());
                if (this.aOI != null) {
                    while (cVar.canRead()) {
                        int e = cVar.e(this.aOI, AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START);
                        if (e > 0) {
                            printStream.write(this.aOI, 0, e);
                        }
                    }
                }
                k.log(TAG, "finished! " + this);
                printStream.flush();
                printStream.close();
                cVar.close();
                if (z) {
                    f.Kw().q(null);
                } else {
                    f.Kw().o(cVar);
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
            k.log(TAG, socket + "离开了HTTP服务器 " + this);
        }
    }
}
