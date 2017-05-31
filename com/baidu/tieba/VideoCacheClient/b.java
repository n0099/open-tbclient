package com.baidu.tieba.VideoCacheClient;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URLEncoder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b implements Runnable {
    final /* synthetic */ a aTg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aTg = aVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0008 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z;
        Object obj;
        boolean z2;
        String JX;
        String str;
        String str2;
        String str3;
        Socket socket;
        OutputStreamWriter outputStreamWriter;
        BufferedReader bufferedReader;
        long j;
        InputStream inputStream;
        Exception e;
        int i;
        String readLine;
        String str4;
        byte[] bArr;
        String str5;
        Object obj2;
        while (!z) {
            obj = this.aTg.mLock;
            synchronized (obj) {
                try {
                    obj2 = this.aTg.mLock;
                    obj2.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            z2 = this.aTg.aTf;
            if (z2) {
                return;
            }
            JX = this.aTg.JX();
            if (JX != null && !JX.isEmpty()) {
                File file = new File(String.valueOf(d.aST) + c.gN(JX) + "/header_downloaded");
                if (file.exists()) {
                    str = a.TAG;
                    e.log(str, "header exists " + JX);
                } else {
                    str2 = a.TAG;
                    e.log(str2, "client preload start: " + JX);
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
                        InputStream inputStream2 = null;
                        try {
                            String str6 = "/video_cache/pre_load?origin_url=" + URLEncoder.encode(JX);
                            int port = c.JY().getPort();
                            socket = new Socket();
                            try {
                                socket.connect(new InetSocketAddress("127.0.0.1", port), 5000);
                                socket.setSoTimeout(5000);
                                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream(), "utf-8");
                                try {
                                    outputStreamWriter.write("GET " + str6 + " HTTP/1.1\r\n");
                                    outputStreamWriter.write("Host: 127.0.0.1\r\n");
                                    if (i3 == 1) {
                                        outputStreamWriter.write("Range: bytes=" + j3 + "-\r\n");
                                    }
                                    outputStreamWriter.write("\r\n");
                                    outputStreamWriter.flush();
                                    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                    j = j2;
                                    do {
                                        try {
                                            readLine = bufferedReader.readLine();
                                            if (i3 == 0 && readLine != null && readLine.startsWith("Content-Length")) {
                                                String[] split = readLine.split(":");
                                                if (split.length > 1) {
                                                    j = Long.parseLong(split[1].trim());
                                                }
                                            }
                                            System.out.print(readLine);
                                        } catch (Exception e3) {
                                            inputStream = null;
                                            e = e3;
                                            i = i2;
                                        } catch (Throwable th) {
                                            th = th;
                                            bufferedReader2 = bufferedReader;
                                        }
                                    } while (!readLine.equals(""));
                                    inputStream = socket.getInputStream();
                                    try {
                                        try {
                                            str4 = a.TAG;
                                            e.log(str4, "client preload check1: " + JX);
                                            int i4 = i2;
                                            while (true) {
                                                try {
                                                    bArr = this.aTg.mBuffer;
                                                    int read = inputStream.read(bArr);
                                                    if (read == -1) {
                                                        i = i4;
                                                        break;
                                                    }
                                                    i = read + i4;
                                                    if (i3 != 0 || i < 512000) {
                                                        i4 = i;
                                                    }
                                                } catch (Exception e4) {
                                                    i = i4;
                                                    e = e4;
                                                }
                                            }
                                        } catch (Exception e5) {
                                            e = e5;
                                            i = i2;
                                        }
                                        try {
                                            str5 = a.TAG;
                                            e.log(str5, "client preload check2: " + JX);
                                            try {
                                                outputStreamWriter.close();
                                            } catch (Exception e6) {
                                                e6.printStackTrace();
                                            }
                                            try {
                                                bufferedReader.close();
                                            } catch (Exception e7) {
                                                e7.printStackTrace();
                                            }
                                            try {
                                                inputStream.close();
                                            } catch (Exception e8) {
                                                e8.printStackTrace();
                                            }
                                            try {
                                                socket.close();
                                                break;
                                            } catch (Exception e9) {
                                                e9.printStackTrace();
                                            }
                                        } catch (Exception e10) {
                                            e = e10;
                                            TiebaStatic.log(new as("c12027").Z("errormsg", "预加载文件失败").Z("error", e.getMessage()).Z("url", JX));
                                            e.printStackTrace();
                                            try {
                                                outputStreamWriter.close();
                                            } catch (Exception e11) {
                                                e11.printStackTrace();
                                            }
                                            try {
                                                bufferedReader.close();
                                            } catch (Exception e12) {
                                                e12.printStackTrace();
                                            }
                                            try {
                                                inputStream.close();
                                            } catch (Exception e13) {
                                                e13.printStackTrace();
                                            }
                                            try {
                                                socket.close();
                                            } catch (Exception e14) {
                                                e14.printStackTrace();
                                            }
                                            i3++;
                                            i2 = i;
                                            j2 = j;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        inputStream2 = inputStream;
                                        bufferedReader2 = bufferedReader;
                                        try {
                                            outputStreamWriter.close();
                                        } catch (Exception e15) {
                                            e15.printStackTrace();
                                        }
                                        try {
                                            bufferedReader2.close();
                                        } catch (Exception e16) {
                                            e16.printStackTrace();
                                        }
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e17) {
                                            e17.printStackTrace();
                                        }
                                        try {
                                            socket.close();
                                        } catch (Exception e18) {
                                            e18.printStackTrace();
                                        }
                                        throw th;
                                    }
                                } catch (Exception e19) {
                                    bufferedReader = null;
                                    j = j2;
                                    inputStream = null;
                                    e = e19;
                                    i = i2;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } catch (Exception e20) {
                                outputStreamWriter = null;
                                j = j2;
                                bufferedReader = null;
                                inputStream = null;
                                e = e20;
                                i = i2;
                            } catch (Throwable th4) {
                                th = th4;
                                outputStreamWriter = null;
                            }
                        } catch (Exception e21) {
                            socket = null;
                            outputStreamWriter = null;
                            bufferedReader = null;
                            j = j2;
                            inputStream = null;
                            e = e21;
                            i = i2;
                        } catch (Throwable th5) {
                            th = th5;
                            socket = null;
                            outputStreamWriter = null;
                        }
                        i3++;
                        i2 = i;
                        j2 = j;
                    }
                    if (!file.exists()) {
                        try {
                            file.createNewFile();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                    str3 = a.TAG;
                    e.log(str3, "client preload end: " + JX);
                }
            }
        }
    }
}
