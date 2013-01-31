package com.baidu.tieba.c;

import com.baidu.zeus.NotificationProxy;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public class q {
    public static void a(InputStream inputStream, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
        byte[] bArr = new byte[NotificationProxy.MAX_URL_LENGTH];
        while (true) {
            int read = gZIPInputStream.read(bArr, 0, NotificationProxy.MAX_URL_LENGTH);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                gZIPInputStream.close();
                return;
            }
        }
    }

    public static void b(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[NotificationProxy.MAX_URL_LENGTH];
        while (true) {
            int read = inputStream.read(bArr, 0, NotificationProxy.MAX_URL_LENGTH);
            if (read != -1) {
                gZIPOutputStream.write(bArr, 0, read);
            } else {
                gZIPOutputStream.flush();
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                return;
            }
        }
    }
}
