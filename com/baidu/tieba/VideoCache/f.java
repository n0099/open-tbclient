package com.baidu.tieba.VideoCache;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.xiaomi.mipush.sdk.Constants;
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
/* loaded from: classes2.dex */
class f implements Runnable {
    private static final String TAG = f.class.getSimpleName();
    private byte[] aVY;
    private h aVZ;
    private Context mContext;
    private Socket zq;

    public f(Context context) {
        this.aVY = null;
        this.mContext = context;
        try {
            this.aVY = new byte[AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START];
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }

    public void a(Socket socket) {
        this.zq = socket;
    }

    public void a(h hVar) {
        this.aVZ = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        j.aw(TAG, "test run in " + this);
        if (this.aVZ == null) {
            j.aw(TAG, "test run out 1" + this);
            return;
        }
        try {
            b(this.aVZ);
            if (this.aVZ.KG().contains("/video_cache/pre_load?origin_url=")) {
                a(this.aVZ, this.zq, true);
            } else {
                a(this.aVZ, this.zq, false);
            }
            c(this.zq);
        } catch (Exception e) {
            j.aw(TAG, "HTTP服务器错误:" + e.getLocalizedMessage());
        }
        j.aw(TAG, "test run out 2" + this);
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
                        hVar.hp(split[1]);
                    }
                    String substring = readLine.substring(readLine.indexOf("origin_url=") + 11);
                    String str = "";
                    if (substring != null && substring.contains(" ")) {
                        str = substring.substring(0, substring.indexOf(" "));
                    }
                    hVar.hq(URLDecoder.decode(str));
                } else if (readLine != null && readLine.startsWith("Range") && readLine.contains(":")) {
                    hVar.cq(true);
                    String[] split2 = readLine.split(":");
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
                        hVar.ar(Long.parseLong(strArr[0]));
                        if (strArr.length > 1) {
                            hVar.as(Long.parseLong(strArr[1]));
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
        int hn = hn(hVar.KH());
        if (hn <= 0) {
            return false;
        }
        hVar.N(hn);
        if (hVar.KJ() < 0) {
            hVar.ar(0L);
        }
        if (hVar.KK() < 0) {
            hVar.as(hn - 1);
        }
        long KJ = hVar.KJ();
        long KK = hVar.KK();
        j.aw(TAG, "range is: " + KJ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + KK + " " + this);
        if (hVar.KI()) {
            printStream.println("HTTP/1.1 206 Partial Content");
        } else {
            printStream.println("HTTP/1.1 200 OK");
        }
        printStream.println("Content-Type: video/mp4");
        printStream.println("Accept-Ranges: bytes");
        printStream.println("Content-Length: " + ((KK - KJ) + 1));
        if (hVar.KI()) {
            printStream.println("Content-Range: bytes " + KJ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + KK + "/" + hn);
        }
        printStream.println("Content-Transfer-Encoding: binary");
        printStream.println();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [215=4, 216=4, 218=4, 219=4, 222=4, 223=4, 225=4, 226=4] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int hn(String str) {
        FileInputStream fileInputStream;
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        dataInputStream2 = null;
        FileInputStream fileInputStream2 = null;
        String hu = m.hu(str);
        if (hu == null || hu.isEmpty()) {
            return 0;
        }
        File file = new File(i.aWk + hu);
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
            TiebaStatic.log(new ak("c12027").ad("errormsg", "网络获取文件大小出现异常").ad("error", e13.getMessage()).ad("url", str));
            e13.printStackTrace();
            return 0;
        }
    }

    private void a(h hVar, Socket socket, boolean z) {
        if (hVar != null && socket != null) {
            File file = new File(i.aWh);
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                c cVar = new c(this.mContext);
                cVar.setVideoUrl(hVar.KH());
                PrintStream printStream = new PrintStream(socket.getOutputStream(), true);
                if (!a(hVar, printStream)) {
                    printStream.close();
                    cVar.close();
                    return;
                }
                cVar.N(hVar.getTotalLength());
                if (z) {
                    if (e.KD().p(cVar)) {
                        printStream.close();
                        cVar.close();
                        e.KD().q(null);
                        return;
                    }
                    c KE = e.KD().KE();
                    if (KE != null) {
                        KE.close();
                    }
                    j.aw(TAG, "server handle preload: " + cVar.getVideoUrl());
                    e.KD().q(cVar);
                } else {
                    c KE2 = e.KD().KE();
                    if (KE2 != null && KE2.getVideoUrl() != null && KE2.getVideoUrl().equals(cVar.getVideoUrl())) {
                        KE2.close();
                        e.KD().q(null);
                    }
                    e.KD().n(cVar);
                }
                cVar.b(hVar.KJ(), hVar.KK());
                if (this.aVY != null) {
                    while (cVar.canRead()) {
                        int e = cVar.e(this.aVY, AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START);
                        if (e > 0) {
                            printStream.write(this.aVY, 0, e);
                        }
                    }
                }
                j.aw(TAG, "finished! " + this);
                printStream.flush();
                printStream.close();
                cVar.close();
                if (z) {
                    e.KD().q(null);
                } else {
                    e.KD().o(cVar);
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
            j.aw(TAG, socket + "离开了HTTP服务器 " + this);
        }
    }
}
