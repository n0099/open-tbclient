package com.baidu.tieba.c;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public class q {
    public static void a(InputStream inputStream, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = gZIPInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                gZIPInputStream.close();
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static void b(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read == -1) {
                gZIPOutputStream.flush();
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                return;
            }
            gZIPOutputStream.write(bArr, 0, read);
        }
    }
}
