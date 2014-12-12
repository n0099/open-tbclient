package com.baidu.tbadk.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public class d {
    public static void c(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream;
        try {
            gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read != -1) {
                        gZIPOutputStream.write(bArr, 0, read);
                    } else {
                        gZIPOutputStream.flush();
                        try {
                            gZIPOutputStream.close();
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                try {
                    gZIPOutputStream.close();
                } catch (Exception e2) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream = null;
        }
    }

    public static void b(InputStream inputStream, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream;
        try {
            gZIPInputStream = new GZIPInputStream(inputStream);
        } catch (Throwable th) {
            th = th;
            gZIPInputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    try {
                        gZIPInputStream.close();
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                gZIPInputStream.close();
            } catch (Exception e2) {
            }
            throw th;
        }
    }
}
