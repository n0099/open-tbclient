package com.baidu.tieba.VideoCacheClient;

import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static a dXo;
    private List<String> mUrlList = new ArrayList();
    private Object mLock = new Object();
    private boolean dXp = false;
    private byte[] mBuffer = new byte[1024];
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.VideoCacheClient.a.1
        /* JADX WARN: Code restructure failed: missing block: B:100:0x02d4, code lost:
            r3.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:130:0x031f, code lost:
            r3 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x021d, code lost:
            com.baidu.tieba.VideoCacheClient.d.z(com.baidu.tieba.VideoCacheClient.a.TAG, "client preload check2: " + r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x023c, code lost:
            if (r15.exists() != false) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0242, code lost:
            if (r15.getParentFile() == null) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x024c, code lost:
            if (r15.getParentFile().exists() != false) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x024e, code lost:
            r15.getParentFile().mkdirs();
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0255, code lost:
            r15.createNewFile();
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0258, code lost:
            r9.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0272, code lost:
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x0273, code lost:
            r3.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x028d, code lost:
            com.baidu.tbadk.core.util.TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12027").cy("errormsg", "预加载文件失败").cy(com.baidu.live.adp.lib.stats.BdStatsConstant.StatsType.ERROR, r3.getMessage()).cy("url", r14));
            r3.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x02b7, code lost:
            r9.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x02ba, code lost:
            r8.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x02bd, code lost:
            r7.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x02c0, code lost:
            r6.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x02c4, code lost:
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x02c5, code lost:
            r3.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x02c9, code lost:
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x02ca, code lost:
            r3.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x02ce, code lost:
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x02cf, code lost:
            r3.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x02d3, code lost:
            r3 = move-exception;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            long j;
            int i;
            int i2;
            InputStream inputStream;
            Socket socket;
            OutputStreamWriter outputStreamWriter;
            Exception e;
            BufferedReader bufferedReader;
            int i3;
            long j2;
            String readLine;
            while (!a.this.dXp) {
                synchronized (a.this.mLock) {
                    try {
                        a.this.mLock.wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                if (!a.this.dXp) {
                    String aXq = a.this.aXq();
                    if (aXq != null && !aXq.isEmpty()) {
                        File file = new File(c.dXe + b.wC(aXq) + "/header_downloaded");
                        if (file.exists()) {
                            d.z(a.TAG, "header exists " + aXq);
                        } else {
                            d.z(a.TAG, "client preload start: " + aXq);
                            j = 0;
                            i = 0;
                            i2 = 0;
                            while (i2 < 2) {
                                long j3 = 0;
                                if (i2 == 1) {
                                    long j4 = j - i;
                                    if (j4 == 0) {
                                        break;
                                    } else if (j4 > 0 && j4 < 512000) {
                                        j3 = i;
                                    } else {
                                        j3 = j - 512000;
                                    }
                                }
                                BufferedReader bufferedReader2 = null;
                                inputStream = null;
                                try {
                                    String str = "/video_cache/pre_load?origin_url=" + URLEncoder.encode(aXq);
                                    int port = b.aXr().getPort();
                                    socket = new Socket();
                                    try {
                                        socket.connect(new InetSocketAddress("127.0.0.1", port), 5000);
                                        socket.setSoTimeout(5000);
                                        outputStreamWriter = new OutputStreamWriter(socket.getOutputStream(), "utf-8");
                                        try {
                                            outputStreamWriter.write("GET " + str + " HTTP/1.1\r\n");
                                            outputStreamWriter.write("Host: 127.0.0.1\r\n");
                                            if (i2 == 1) {
                                                outputStreamWriter.write("Range: bytes=" + j3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "\r\n");
                                            }
                                            outputStreamWriter.write("\r\n");
                                            outputStreamWriter.flush();
                                            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                            j2 = j;
                                            do {
                                                try {
                                                    try {
                                                        readLine = bufferedReader.readLine();
                                                        if (i2 == 0 && readLine != null && readLine.startsWith("Content-Length")) {
                                                            String[] split = readLine.split(":");
                                                            if (split.length > 1) {
                                                                j2 = Long.parseLong(split[1].trim());
                                                            }
                                                        }
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        bufferedReader2 = bufferedReader;
                                                        try {
                                                            outputStreamWriter.close();
                                                        } catch (Exception e3) {
                                                            e3.printStackTrace();
                                                        }
                                                        try {
                                                            bufferedReader2.close();
                                                        } catch (Exception e4) {
                                                            e4.printStackTrace();
                                                        }
                                                        try {
                                                            inputStream.close();
                                                        } catch (Exception e5) {
                                                            e5.printStackTrace();
                                                        }
                                                        try {
                                                            socket.close();
                                                        } catch (Exception e6) {
                                                            e6.printStackTrace();
                                                        }
                                                        throw th;
                                                    }
                                                } catch (Exception e7) {
                                                    e = e7;
                                                    i3 = i;
                                                }
                                            } while (!"".equals(readLine));
                                            inputStream = socket.getInputStream();
                                            d.z(a.TAG, "client preload check1: " + aXq);
                                            int i4 = i;
                                            while (true) {
                                                try {
                                                    int read = inputStream.read(a.this.mBuffer);
                                                    if (read == -1) {
                                                        i3 = i4;
                                                        break;
                                                    }
                                                    i3 = read + i4;
                                                    if (i2 != 0 || i3 < 512000) {
                                                        i4 = i3;
                                                    }
                                                } catch (Exception e8) {
                                                    i3 = i4;
                                                    e = e8;
                                                }
                                            }
                                        } catch (Exception e9) {
                                            e = e9;
                                            bufferedReader = null;
                                            i3 = i;
                                            j2 = j;
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    } catch (Exception e10) {
                                        e = e10;
                                        outputStreamWriter = null;
                                        bufferedReader = null;
                                        i3 = i;
                                        j2 = j;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        outputStreamWriter = null;
                                    }
                                } catch (Exception e11) {
                                    e = e11;
                                    socket = null;
                                    outputStreamWriter = null;
                                    bufferedReader = null;
                                    i3 = i;
                                    j2 = j;
                                } catch (Throwable th4) {
                                    th = th4;
                                    socket = null;
                                    outputStreamWriter = null;
                                }
                                i2++;
                                i = i3;
                                j = j2;
                            }
                            d.z(a.TAG, "client preload end: " + aXq);
                        }
                    }
                } else {
                    return;
                }
            }
            return;
            try {
                socket.close();
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            i2++;
            i = i3;
            j = j2;
            try {
                bufferedReader.close();
            } catch (Exception e13) {
                e13.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (Exception e14) {
                e14.printStackTrace();
            }
            socket.close();
            i2++;
            i = i3;
            j = j2;
            inputStream.close();
            socket.close();
            i2++;
            i = i3;
            j = j2;
        }
    };
    private Thread mThread = new Thread(this.runnable);

    private a() {
        this.mThread.start();
    }

    public static a aXp() {
        if (dXo == null) {
            synchronized (a.class) {
                if (dXo == null) {
                    dXo = new a();
                }
            }
        }
        return dXo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String aXq() {
        return this.mUrlList.isEmpty() ? null : this.mUrlList.get(0);
    }

    public synchronized void wD(String str) {
        this.mUrlList.clear();
        this.mUrlList.add(str);
        synchronized (this.mLock) {
            this.mLock.notify();
        }
    }
}
