package com.baidu.tieba.VideoCache;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
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
class g implements Runnable {
    private static final String TAG = g.class.getSimpleName();
    private byte[] aVf;
    private i aVg;
    private Context mContext;
    private Socket zU;

    public g(Context context) {
        this.aVf = null;
        this.mContext = context;
        try {
            this.aVf = new byte[AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START];
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }

    public void a(Socket socket) {
        this.zU = socket;
    }

    public void a(i iVar) {
        this.aVg = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        k.log(TAG, "test run in " + this);
        if (this.aVg == null) {
            k.log(TAG, "test run out 1" + this);
            return;
        }
        try {
            b(this.aVg);
            if (this.aVg.KS().contains("/video_cache/pre_load?origin_url=")) {
                a(this.aVg, this.zU, true);
            } else {
                a(this.aVg, this.zU, false);
            }
            c(this.zU);
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
                        iVar.gN(split[1]);
                    }
                    String substring = readLine.substring(readLine.indexOf("origin_url=") + 11);
                    String str = "";
                    if (substring != null && substring.contains(" ")) {
                        str = substring.substring(0, substring.indexOf(" "));
                    }
                    iVar.gO(URLDecoder.decode(str));
                } else if (readLine != null && readLine.startsWith("Range") && readLine.contains(":")) {
                    iVar.co(true);
                    String[] split2 = readLine.split(":");
                    String str2 = (split2 == null || split2.length <= 1) ? "" : split2[1];
                    String substring2 = (str2 == null || (lastIndexOf = str2.lastIndexOf("bytes=") + 6) < 0 || lastIndexOf > str2.length()) ? str2 : str2.substring(lastIndexOf);
                    String[] strArr = null;
                    if (substring2 != null) {
                        try {
                            strArr = substring2.split("-");
                        } catch (UnsupportedOperationException e) {
                            e.printStackTrace();
                        }
                    }
                    if (strArr != null && strArr.length >= 1) {
                        iVar.aq(Long.parseLong(strArr[0]));
                        if (strArr.length > 1) {
                            iVar.ar(Long.parseLong(strArr[1]));
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
        return iVar;
    }

    private void b(i iVar) {
    }

    private boolean a(i iVar, PrintStream printStream) {
        int gL = gL(iVar.KT());
        if (gL <= 0) {
            return false;
        }
        iVar.M(gL);
        if (iVar.KV() < 0) {
            iVar.aq(0L);
        }
        if (iVar.KW() < 0) {
            iVar.ar(gL - 1);
        }
        long KV = iVar.KV();
        long KW = iVar.KW();
        k.log(TAG, "range is: " + KV + "-" + KW + " " + this);
        if (iVar.KU()) {
            printStream.println("HTTP/1.1 206 Partial Content");
        } else {
            printStream.println("HTTP/1.1 200 OK");
        }
        printStream.println("Content-Type: video/mp4");
        printStream.println("Accept-Ranges: bytes");
        printStream.println("Content-Length: " + ((KW - KV) + 1));
        if (iVar.KU()) {
            printStream.println("Content-Range: bytes " + KV + "-" + KW + "/" + gL);
        }
        printStream.println("Content-Transfer-Encoding: binary");
        printStream.println();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [215=4, 216=4, 218=4, 219=4, 222=4, 223=4, 225=4, 226=4] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int gL(String str) {
        FileInputStream fileInputStream;
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        dataInputStream2 = null;
        FileInputStream fileInputStream2 = null;
        String gS = o.gS(str);
        if (gS == null || gS.isEmpty()) {
            return 0;
        }
        File file = new File(String.valueOf(j.aVr) + gS);
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
                            bufferedWriter.write(new StringBuilder(String.valueOf(contentLength)).toString());
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
            bufferedWriter2.write(new StringBuilder(String.valueOf(contentLength2)).toString());
            bufferedWriter2.flush();
            bufferedWriter2.close();
            return contentLength2;
        } catch (Exception e13) {
            TiebaStatic.log(new as("c12027").aa("errormsg", "网络获取文件大小出现异常").aa("error", e13.getMessage()).aa("url", str));
            e13.printStackTrace();
            return 0;
        }
    }

    private void a(i iVar, Socket socket, boolean z) {
        if (iVar != null && socket != null) {
            File file = new File(j.aVo);
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                c cVar = new c(this.mContext);
                cVar.setVideoUrl(iVar.KT());
                PrintStream printStream = new PrintStream(socket.getOutputStream(), true);
                if (!a(iVar, printStream)) {
                    printStream.close();
                    cVar.close();
                    return;
                }
                cVar.M(iVar.getTotalLength());
                if (z) {
                    if (f.KP().p(cVar)) {
                        printStream.close();
                        cVar.close();
                        f.KP().q(null);
                        return;
                    }
                    c KQ = f.KP().KQ();
                    if (KQ != null) {
                        KQ.close();
                    }
                    k.log(TAG, "server handle preload: " + cVar.getVideoUrl());
                    f.KP().q(cVar);
                } else {
                    c KQ2 = f.KP().KQ();
                    if (KQ2 != null && KQ2.getVideoUrl() != null && KQ2.getVideoUrl().equals(cVar.getVideoUrl())) {
                        KQ2.close();
                        f.KP().q(null);
                    }
                    f.KP().n(cVar);
                }
                cVar.b(iVar.KV(), iVar.KW());
                if (this.aVf != null) {
                    while (cVar.canRead()) {
                        int e = cVar.e(this.aVf, AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START);
                        if (e > 0) {
                            printStream.write(this.aVf, 0, e);
                        }
                    }
                }
                k.log(TAG, "finished! " + this);
                printStream.flush();
                printStream.close();
                cVar.close();
                if (z) {
                    f.KP().q(null);
                } else {
                    f.KP().o(cVar);
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
