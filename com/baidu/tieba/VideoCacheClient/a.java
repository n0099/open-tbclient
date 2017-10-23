package com.baidu.tieba.VideoCacheClient;

import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static a aXV;
    private List<String> mUrlList = new ArrayList();
    private Object mLock = new Object();
    private boolean aXW = false;
    private byte[] mBuffer = new byte[1024];
    private Runnable aFQ = new Runnable() { // from class: com.baidu.tieba.VideoCacheClient.a.1
        /* JADX WARN: Code restructure failed: missing block: B:128:0x0314, code lost:
            r3 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x022b, code lost:
            com.baidu.tieba.VideoCacheClient.d.av(com.baidu.tieba.VideoCacheClient.a.TAG, "client preload check2: " + r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0246, code lost:
            r9.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0260, code lost:
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x0261, code lost:
            r3.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x027b, code lost:
            com.baidu.tbadk.core.util.TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12027").ac("errormsg", "预加载文件失败").ac("error", r3.getMessage()).ac("url", r14));
            r3.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x02a5, code lost:
            r9.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x02a8, code lost:
            r8.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x02ab, code lost:
            r7.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x02ae, code lost:
            r6.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x02b2, code lost:
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x02b3, code lost:
            r3.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x02b7, code lost:
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x02b8, code lost:
            r3.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x02bc, code lost:
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x02bd, code lost:
            r3.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x02c1, code lost:
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x02c2, code lost:
            r3.printStackTrace();
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
            while (!a.this.aXW) {
                synchronized (a.this.mLock) {
                    try {
                        a.this.mLock.wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                if (!a.this.aXW) {
                    String Lc = a.this.Lc();
                    if (Lc != null && !Lc.isEmpty()) {
                        File file = new File(c.aXL + b.hq(Lc) + "/header_downloaded");
                        if (file.exists()) {
                            d.av(a.TAG, "header exists " + Lc);
                        } else {
                            d.av(a.TAG, "client preload start: " + Lc);
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
                                    String str = "/video_cache/pre_load?origin_url=" + URLEncoder.encode(Lc);
                                    int port = b.Le().getPort();
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
                                                        System.out.print(readLine);
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
                                            } while (!readLine.equals(""));
                                            inputStream = socket.getInputStream();
                                            d.av(a.TAG, "client preload check1: " + Lc);
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
                            if (!file.exists()) {
                                try {
                                    file.createNewFile();
                                } catch (IOException e12) {
                                    e12.printStackTrace();
                                }
                            }
                            d.av(a.TAG, "client preload end: " + Lc);
                        }
                    }
                } else {
                    return;
                }
            }
            return;
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
            try {
                socket.close();
                break;
            } catch (Exception e15) {
                e15.printStackTrace();
            }
            i2++;
            i = i3;
            j = j2;
            inputStream.close();
            socket.close();
            break;
            i2++;
            i = i3;
            j = j2;
            socket.close();
            break;
            i2++;
            i = i3;
            j = j2;
        }
    };
    private Thread mThread = new Thread(this.aFQ);

    private a() {
        this.mThread.start();
    }

    public static a Lb() {
        if (aXV == null) {
            synchronized (a.class) {
                if (aXV == null) {
                    aXV = new a();
                }
            }
        }
        return aXV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String Lc() {
        return this.mUrlList.isEmpty() ? null : this.mUrlList.get(0);
    }

    public synchronized void hr(String str) {
        this.mUrlList.clear();
        this.mUrlList.add(str);
        synchronized (this.mLock) {
            this.mLock.notify();
        }
    }
}
