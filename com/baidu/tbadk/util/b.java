package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import okhttp3.Response;
/* loaded from: classes.dex */
public class b {
    private static b fjN = null;

    private b() {
    }

    public static synchronized b byN() {
        b bVar;
        synchronized (b.class) {
            if (fjN == null) {
                fjN = new b();
            }
            bVar = fjN;
        }
        return bVar;
    }

    public void byO() {
        String byP = byP();
        if (!TextUtils.isEmpty(byP)) {
            com.baidu.adp.lib.e.c.mS().a(byP, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String byP() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [190=4] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.io.OutputStream, java.io.FileOutputStream] */
    public long f(File file, String str) {
        InputStream inputStream;
        Closeable closeable;
        long j;
        ?? fileOutputStream;
        InputStream inputStream2 = null;
        if (TextUtils.isEmpty(str) || file == null) {
            return 0L;
        }
        try {
            Response executeSync = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(str).build().executeSync();
            if (executeSync == null || executeSync.code() != 200) {
                closeable = null;
                j = 0;
            } else {
                inputStream = executeSync.body().byteStream();
                if (inputStream != null) {
                    try {
                        try {
                            fileOutputStream = new FileOutputStream(file);
                        } catch (Exception e) {
                            e = e;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        inputStream2 = inputStream;
                        j = FileUtils.copyStream(inputStream, fileOutputStream);
                        closeable = fileOutputStream;
                    } catch (Exception e2) {
                        inputStream2 = fileOutputStream;
                        e = e2;
                        TiebaStatic.log(e.toString());
                        Closeables.closeSafely(inputStream);
                        Closeables.closeSafely(inputStream2);
                        return 0L;
                    } catch (Throwable th2) {
                        inputStream2 = fileOutputStream;
                        th = th2;
                        Closeables.closeSafely(inputStream);
                        Closeables.closeSafely(inputStream2);
                        throw th;
                    }
                } else {
                    closeable = null;
                    inputStream2 = inputStream;
                    j = 0;
                }
            }
            Closeables.closeSafely(inputStream2);
            Closeables.closeSafely(closeable);
            return j;
        } catch (Exception e3) {
            e = e3;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }
}
