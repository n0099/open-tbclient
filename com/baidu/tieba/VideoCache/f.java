package com.baidu.tieba.VideoCache;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
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
/* loaded from: classes6.dex */
class f implements Runnable {
    private static final String TAG = f.class.getSimpleName();
    private Socket Hn;
    private byte[] bwl;
    private h bwm;
    private Context mContext;

    public f(Context context) {
        this.bwl = null;
        this.mContext = context;
        try {
            this.bwl = new byte[1048576];
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }

    public void setSocket(Socket socket) {
        this.Hn = socket;
    }

    public void a(h hVar) {
        this.bwm = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        j.log(TAG, "test run in " + this);
        if (this.bwm == null) {
            j.log(TAG, "test run out 1" + this);
            return;
        }
        try {
            b(this.bwm);
            if (this.bwm.Ug().contains("/video_cache/pre_load?origin_url=")) {
                a(this.bwm, this.Hn, true);
            } else {
                a(this.bwm, this.Hn, false);
            }
            c(this.Hn);
        } catch (Exception e) {
            j.log(TAG, "HTTP服务器错误:" + e.getLocalizedMessage());
        }
        j.log(TAG, "test run out 2" + this);
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
                        hVar.jb(split[1]);
                    }
                    String substring = readLine.substring(readLine.indexOf("origin_url=") + 11);
                    String str = "";
                    if (substring != null && substring.contains(" ")) {
                        str = substring.substring(0, substring.indexOf(" "));
                    }
                    hVar.jc(URLDecoder.decode(str));
                } else if (readLine != null && readLine.startsWith("Range") && readLine.contains(":")) {
                    hVar.m18do(true);
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
                        hVar.aL(Long.parseLong(strArr[0]));
                        if (strArr.length > 1) {
                            hVar.aM(Long.parseLong(strArr[1]));
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
        int iZ = iZ(hVar.Uh());
        if (iZ <= 0) {
            return false;
        }
        hVar.ae(iZ);
        if (hVar.Uj() < 0) {
            hVar.aL(0L);
        }
        if (hVar.Uk() < 0) {
            hVar.aM(iZ - 1);
        }
        long Uj = hVar.Uj();
        long Uk = hVar.Uk();
        j.log(TAG, "range is: " + Uj + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Uk + " " + this);
        if (hVar.Ui()) {
            printStream.println("HTTP/1.1 206 Partial Content");
        } else {
            printStream.println("HTTP/1.1 200 OK");
        }
        printStream.println("Content-Type: video/mp4");
        printStream.println("Accept-Ranges: bytes");
        printStream.println("Content-Length: " + ((Uk - Uj) + 1));
        if (hVar.Ui()) {
            printStream.println("Content-Range: bytes " + Uj + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Uk + "/" + iZ);
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
    private int iZ(String str) {
        FileInputStream fileInputStream;
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        dataInputStream2 = null;
        FileInputStream fileInputStream2 = null;
        String jg = m.jg(str);
        if (jg == null || jg.isEmpty()) {
            return 0;
        }
        File file = new File(i.bwx + jg);
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
            TiebaStatic.log(new am("c12027").ax("errormsg", "网络获取文件大小出现异常").ax(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, e13.getMessage()).ax("url", str));
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
        File file = new File(i.yP);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            cVar = new c(this.mContext);
            try {
                cVar.setVideoUrl(hVar.Uh());
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
                    cVar.ae(hVar.getTotalLength());
                    if (!z) {
                        c Ue = e.Ud().Ue();
                        if (Ue != null && Ue.getVideoUrl() != null && Ue.getVideoUrl().equals(cVar.getVideoUrl())) {
                            Ue.close();
                            e.Ud().v(null);
                        }
                        e.Ud().s(cVar);
                    } else if (e.Ud().u(cVar)) {
                        e.Ud().v(null);
                        com.baidu.adp.lib.g.a.b((OutputStream) printStream);
                        if (cVar != null) {
                            cVar.close();
                            return;
                        }
                        return;
                    } else {
                        c Ue2 = e.Ud().Ue();
                        if (Ue2 != null) {
                            Ue2.close();
                        }
                        j.log(TAG, "server handle preload: " + cVar.getVideoUrl());
                        e.Ud().v(cVar);
                    }
                    cVar.d(hVar.Uj(), hVar.Uk());
                    if (this.bwl != null) {
                        while (cVar.canRead()) {
                            int read = cVar.read(this.bwl, 1048576);
                            if (read > 0) {
                                printStream.write(this.bwl, 0, read);
                                if (printStream.checkError()) {
                                    break;
                                }
                            }
                        }
                    }
                    j.log(TAG, "finished! " + this);
                    printStream.flush();
                    if (z) {
                        e.Ud().v(null);
                    } else {
                        e.Ud().t(cVar);
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
            j.log(TAG, socket + "离开了HTTP服务器 " + this);
        }
    }
}
