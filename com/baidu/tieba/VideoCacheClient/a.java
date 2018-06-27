package com.baidu.tieba.VideoCacheClient;

import com.baidu.ar.util.IoUtils;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
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
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static a blq;
    private List<String> mUrlList = new ArrayList();
    private Object mLock = new Object();
    private boolean blr = false;
    private byte[] mBuffer = new byte[1024];
    private Runnable aRn = new Runnable() { // from class: com.baidu.tieba.VideoCacheClient.a.1
        @Override // java.lang.Runnable
        public void run() {
            Socket socket;
            OutputStreamWriter outputStreamWriter;
            Exception e;
            BufferedReader bufferedReader;
            int i;
            long j;
            String readLine;
            while (!a.this.blr) {
                synchronized (a.this.mLock) {
                    try {
                        a.this.mLock.wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                if (!a.this.blr) {
                    String Ql = a.this.Ql();
                    if (Ql != null && !Ql.isEmpty()) {
                        File file = new File(c.blf + b.is(Ql) + "/header_downloaded");
                        if (file.exists()) {
                            d.aB(a.TAG, "header exists " + Ql);
                        } else {
                            d.aB(a.TAG, "client preload start: " + Ql);
                            long j2 = 0;
                            int i2 = 0;
                            int i3 = 0;
                            while (i3 < 2) {
                                long j3 = 0;
                                if (i3 == 1) {
                                    long j4 = j2 - i2;
                                    if (j4 == 0) {
                                        break;
                                    } else if (j4 > 0 && j4 < 512000) {
                                        j3 = i2;
                                    } else {
                                        j3 = j2 - 512000;
                                    }
                                }
                                BufferedReader bufferedReader2 = null;
                                InputStream inputStream = null;
                                try {
                                    String str = "/video_cache/pre_load?origin_url=" + URLEncoder.encode(Ql);
                                    int port = b.Qn().getPort();
                                    socket = new Socket();
                                    try {
                                        socket.connect(new InetSocketAddress("127.0.0.1", port), 5000);
                                        socket.setSoTimeout(5000);
                                        outputStreamWriter = new OutputStreamWriter(socket.getOutputStream(), IoUtils.UTF_8);
                                        try {
                                            outputStreamWriter.write("GET " + str + " HTTP/1.1\r\n");
                                            outputStreamWriter.write("Host: 127.0.0.1" + SystemInfoUtil.LINE_END);
                                            if (i3 == 1) {
                                                outputStreamWriter.write("Range: bytes=" + j3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + SystemInfoUtil.LINE_END);
                                            }
                                            outputStreamWriter.write(SystemInfoUtil.LINE_END);
                                            outputStreamWriter.flush();
                                            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                            j = j2;
                                            do {
                                                try {
                                                    try {
                                                        readLine = bufferedReader.readLine();
                                                        if (i3 == 0 && readLine != null && readLine.startsWith(HTTP.CONTENT_LEN)) {
                                                            String[] split = readLine.split(SystemInfoUtil.COLON);
                                                            if (split.length > 1) {
                                                                j = Long.parseLong(split[1].trim());
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
                                                    i = i2;
                                                }
                                            } while (!"".equals(readLine));
                                            inputStream = socket.getInputStream();
                                            d.aB(a.TAG, "client preload check1: " + Ql);
                                            int i4 = i2;
                                            while (true) {
                                                try {
                                                    int read = inputStream.read(a.this.mBuffer);
                                                    if (read == -1) {
                                                        i = i4;
                                                        break;
                                                    }
                                                    i = read + i4;
                                                    if (i3 != 0 || i < 512000) {
                                                        i4 = i;
                                                    }
                                                } catch (Exception e8) {
                                                    i = i4;
                                                    e = e8;
                                                }
                                            }
                                            try {
                                                d.aB(a.TAG, "client preload check2: " + Ql);
                                                if (!file.exists()) {
                                                    if (file.getParentFile() != null && !file.getParentFile().exists()) {
                                                        file.getParentFile().mkdirs();
                                                    }
                                                    file.createNewFile();
                                                }
                                                try {
                                                    outputStreamWriter.close();
                                                } catch (Exception e9) {
                                                    e9.printStackTrace();
                                                }
                                                try {
                                                    bufferedReader.close();
                                                } catch (Exception e10) {
                                                    e10.printStackTrace();
                                                }
                                                try {
                                                    inputStream.close();
                                                } catch (Exception e11) {
                                                    e11.printStackTrace();
                                                }
                                                try {
                                                    socket.close();
                                                } catch (Exception e12) {
                                                    e12.printStackTrace();
                                                }
                                            } catch (Exception e13) {
                                                e = e13;
                                                TiebaStatic.log(new an("c12027").ah("errormsg", "预加载文件失败").ah("error", e.getMessage()).ah("url", Ql));
                                                e.printStackTrace();
                                                try {
                                                    outputStreamWriter.close();
                                                } catch (Exception e14) {
                                                    e14.printStackTrace();
                                                }
                                                try {
                                                    bufferedReader.close();
                                                } catch (Exception e15) {
                                                    e15.printStackTrace();
                                                }
                                                try {
                                                    inputStream.close();
                                                } catch (Exception e16) {
                                                    e16.printStackTrace();
                                                }
                                                try {
                                                    socket.close();
                                                } catch (Exception e17) {
                                                    e17.printStackTrace();
                                                }
                                                i3++;
                                                i2 = i;
                                                j2 = j;
                                            }
                                        } catch (Exception e18) {
                                            e = e18;
                                            bufferedReader = null;
                                            i = i2;
                                            j = j2;
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    } catch (Exception e19) {
                                        e = e19;
                                        outputStreamWriter = null;
                                        bufferedReader = null;
                                        i = i2;
                                        j = j2;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        outputStreamWriter = null;
                                    }
                                } catch (Exception e20) {
                                    e = e20;
                                    socket = null;
                                    outputStreamWriter = null;
                                    bufferedReader = null;
                                    i = i2;
                                    j = j2;
                                } catch (Throwable th4) {
                                    th = th4;
                                    socket = null;
                                    outputStreamWriter = null;
                                }
                                i3++;
                                i2 = i;
                                j2 = j;
                            }
                            d.aB(a.TAG, "client preload end: " + Ql);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    };
    private Thread mThread = new Thread(this.aRn);

    private a() {
        this.mThread.start();
    }

    public static a Qk() {
        if (blq == null) {
            synchronized (a.class) {
                if (blq == null) {
                    blq = new a();
                }
            }
        }
        return blq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String Ql() {
        return this.mUrlList.isEmpty() ? null : this.mUrlList.get(0);
    }

    public synchronized void it(String str) {
        this.mUrlList.clear();
        this.mUrlList.add(str);
        synchronized (this.mLock) {
            this.mLock.notify();
        }
    }
}
