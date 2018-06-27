package com.baidu.tieba.VideoCache;

import android.content.Context;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLDecoder;
/* loaded from: classes2.dex */
class f implements Runnable {
    private static final String TAG = f.class.getSimpleName();
    private Socket Ej;
    private byte[] bkT;
    private h bkU;
    private Context mContext;

    public f(Context context) {
        this.bkT = null;
        this.mContext = context;
        try {
            this.bkT = new byte[1048576];
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }

    public void a(Socket socket) {
        this.Ej = socket;
    }

    public void a(h hVar) {
        this.bkU = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        j.aB(TAG, "test run in " + this);
        if (this.bkU == null) {
            j.aB(TAG, "test run out 1" + this);
            return;
        }
        try {
            b(this.bkU);
            if (this.bkU.Qa().contains("/video_cache/pre_load?origin_url=")) {
                a(this.bkU, this.Ej, true);
            } else {
                a(this.bkU, this.Ej, false);
            }
            c(this.Ej);
        } catch (Exception e) {
            j.aB(TAG, "HTTP服务器错误:" + e.getLocalizedMessage());
        }
        j.aB(TAG, "test run out 2" + this);
    }

    public static h b(Socket socket) {
        String readLine;
        int lastIndexOf;
        h hVar = new h();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            do {
                readLine = bufferedReader.readLine();
                if (readLine != null && readLine.contains("GET") && readLine.contains("origin_url=")) {
                    String[] split = readLine.split(" ");
                    if (split != null && split.length > 1) {
                        hVar.in(split[1]);
                    }
                    String substring = readLine.substring(readLine.indexOf("origin_url=") + 11);
                    String str = "";
                    if (substring != null && substring.contains(" ")) {
                        str = substring.substring(0, substring.indexOf(" "));
                    }
                    hVar.io(URLDecoder.decode(str));
                } else if (readLine != null && readLine.startsWith("Range") && readLine.contains(SystemInfoUtil.COLON)) {
                    hVar.cw(true);
                    String[] split2 = readLine.split(SystemInfoUtil.COLON);
                    String str2 = (split2 == null || split2.length <= 1) ? "" : split2[1];
                    String substring2 = (str2 == null || (lastIndexOf = str2.lastIndexOf("bytes=") + 6) < 0 || lastIndexOf > str2.length()) ? str2 : str2.substring(lastIndexOf);
                    String[] strArr = null;
                    if (substring2 != null) {
                        try {
                            strArr = substring2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        } catch (UnsupportedOperationException e) {
                            e.printStackTrace();
                        }
                    }
                    if (strArr != null && strArr.length >= 1) {
                        hVar.aA(Long.parseLong(strArr[0]));
                        if (strArr.length > 1) {
                            hVar.aB(Long.parseLong(strArr[1]));
                        }
                    }
                }
                if (readLine == null) {
                    break;
                }
            } while (!readLine.equals(""));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return hVar;
    }

    private void b(h hVar) {
        if (hVar != null) {
        }
    }

    private boolean a(h hVar, PrintStream printStream) {
        int il = il(hVar.Qb());
        if (il <= 0) {
            return false;
        }
        hVar.U(il);
        if (hVar.Qd() < 0) {
            hVar.aA(0L);
        }
        if (hVar.Qe() < 0) {
            hVar.aB(il - 1);
        }
        long Qd = hVar.Qd();
        long Qe = hVar.Qe();
        j.aB(TAG, "range is: " + Qd + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Qe + " " + this);
        if (hVar.Qc()) {
            printStream.println("HTTP/1.1 206 Partial Content");
        } else {
            printStream.println("HTTP/1.1 200 OK");
        }
        printStream.println("Content-Type: video/mp4");
        printStream.println("Accept-Ranges: bytes");
        printStream.println("Content-Length: " + ((Qe - Qd) + 1));
        if (hVar.Qc()) {
            printStream.println("Content-Range: bytes " + Qd + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Qe + "/" + il);
        }
        printStream.println("Content-Transfer-Encoding: binary");
        printStream.println();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [225=4, 226=4, 228=4, 229=4, 232=4, 233=4, 235=4, 236=4] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int il(String str) {
        FileInputStream fileInputStream;
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        dataInputStream2 = null;
        FileInputStream fileInputStream2 = null;
        String is = m.is(str);
        if (is == null || is.isEmpty()) {
            return 0;
        }
        File file = new File(i.blf + is);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file.getAbsolutePath() + "/content_length");
        file2.getAbsolutePath();
        if (file2.exists()) {
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    dataInputStream = new DataInputStream(fileInputStream);
                    try {
                        int parseInt = Integer.parseInt(dataInputStream.readLine());
                        if (parseInt > 0) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                    return parseInt;
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    return parseInt;
                                }
                            }
                            return parseInt;
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        fileInputStream2 = fileInputStream;
                        try {
                            e.printStackTrace();
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            int contentLength = ((HttpURLConnection) new URL(str).openConnection()).getContentLength();
                            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
                            bufferedWriter.write(contentLength + "");
                            bufferedWriter.flush();
                            bufferedWriter.close();
                            return contentLength;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            dataInputStream2 = dataInputStream;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                }
                            }
                            if (dataInputStream2 != null) {
                                try {
                                    dataInputStream2.close();
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        dataInputStream2 = dataInputStream;
                        if (fileInputStream != null) {
                        }
                        if (dataInputStream2 != null) {
                        }
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
            bufferedWriter2.write(contentLength2 + "");
            bufferedWriter2.flush();
            bufferedWriter2.close();
            return contentLength2;
        } catch (Exception e13) {
            TiebaStatic.log(new an("c12027").ah("errormsg", "网络获取文件大小出现异常").ah("error", e13.getMessage()).ah("url", str));
            e13.printStackTrace();
            return 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [334=6, 335=5, 336=5] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(h hVar, Socket socket, boolean z) {
        c cVar;
        PrintStream printStream;
        PrintStream printStream2 = null;
        if (hVar == null || socket == null) {
            return;
        }
        File file = new File(i.vO);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            cVar = new c(this.mContext);
            try {
                cVar.setVideoUrl(hVar.Qb());
                printStream = new PrintStream(socket.getOutputStream(), true);
                try {
                    if (!a(hVar, printStream)) {
                        com.baidu.adp.lib.g.a.b((OutputStream) printStream);
                        if (cVar != null) {
                            cVar.close();
                            return;
                        }
                        return;
                    }
                    cVar.U(hVar.getTotalLength());
                    if (!z) {
                        c PY = e.PX().PY();
                        if (PY != null && PY.getVideoUrl() != null && PY.getVideoUrl().equals(cVar.getVideoUrl())) {
                            PY.close();
                            e.PX().v(null);
                        }
                        e.PX().s(cVar);
                    } else if (e.PX().u(cVar)) {
                        e.PX().v(null);
                        com.baidu.adp.lib.g.a.b((OutputStream) printStream);
                        if (cVar != null) {
                            cVar.close();
                            return;
                        }
                        return;
                    } else {
                        c PY2 = e.PX().PY();
                        if (PY2 != null) {
                            PY2.close();
                        }
                        j.aB(TAG, "server handle preload: " + cVar.getVideoUrl());
                        e.PX().v(cVar);
                    }
                    cVar.c(hVar.Qd(), hVar.Qe());
                    if (this.bkT != null) {
                        while (cVar.canRead()) {
                            int read = cVar.read(this.bkT, 1048576);
                            if (read > 0) {
                                printStream.write(this.bkT, 0, read);
                                if (printStream.checkError()) {
                                    break;
                                }
                            }
                        }
                    }
                    j.aB(TAG, "finished! " + this);
                    printStream.flush();
                    if (z) {
                        e.PX().v(null);
                    } else {
                        e.PX().t(cVar);
                    }
                    com.baidu.adp.lib.g.a.b((OutputStream) printStream);
                    if (cVar != null) {
                        cVar.close();
                    }
                } catch (Exception e) {
                    e = e;
                    printStream2 = printStream;
                    try {
                        e.printStackTrace();
                        com.baidu.adp.lib.g.a.b((OutputStream) printStream2);
                        if (cVar != null) {
                            cVar.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        printStream = printStream2;
                        com.baidu.adp.lib.g.a.b((OutputStream) printStream);
                        if (cVar != null) {
                            cVar.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.g.a.b((OutputStream) printStream);
                    if (cVar != null) {
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            } catch (Throwable th3) {
                th = th3;
                printStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            cVar = null;
        } catch (Throwable th4) {
            th = th4;
            cVar = null;
            printStream = null;
        }
    }

    private void c(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            j.aB(TAG, socket + "离开了HTTP服务器 " + this);
        }
    }
}
