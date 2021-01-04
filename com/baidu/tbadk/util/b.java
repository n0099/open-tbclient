package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import okhttp3.Response;
/* loaded from: classes.dex */
public class b {
    private static b fOM = null;

    private b() {
    }

    public static synchronized b bIu() {
        b bVar;
        synchronized (b.class) {
            if (fOM == null) {
                fOM = new b();
            }
            bVar = fOM;
        }
        return bVar;
    }

    public void bIv() {
        String bIw = bIw();
        if (!TextUtils.isEmpty(bIw)) {
            com.baidu.adp.lib.e.d.mx().a(bIw, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String bIw() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [190=4] */
    public long g(File file, String str) {
        Throwable th;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        Exception exc;
        FileOutputStream fileOutputStream2;
        long j = 0;
        if (!TextUtils.isEmpty(str) && file != null) {
            try {
                Response executeSync = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(str).build().executeSync();
                if (executeSync == null || executeSync.code() != 200) {
                    fileOutputStream2 = null;
                    inputStream = null;
                } else {
                    inputStream = executeSync.body().byteStream();
                    if (inputStream != null) {
                        try {
                            fileOutputStream2 = new FileOutputStream(file);
                        } catch (Exception e) {
                            exc = e;
                            fileOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = null;
                        }
                        try {
                            j = FileUtils.copyStream(inputStream, fileOutputStream2);
                        } catch (Exception e2) {
                            exc = e2;
                            fileOutputStream = fileOutputStream2;
                            try {
                                TiebaStatic.log(exc.toString());
                                Closeables.closeSafely(inputStream);
                                Closeables.closeSafely(fileOutputStream);
                                return j;
                            } catch (Throwable th3) {
                                th = th3;
                                Closeables.closeSafely(inputStream);
                                Closeables.closeSafely(fileOutputStream);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            fileOutputStream = fileOutputStream2;
                            Closeables.closeSafely(inputStream);
                            Closeables.closeSafely(fileOutputStream);
                            throw th;
                        }
                    } else {
                        fileOutputStream2 = null;
                    }
                }
                Closeables.closeSafely(inputStream);
                Closeables.closeSafely(fileOutputStream2);
            } catch (Exception e3) {
                exc = e3;
                fileOutputStream = null;
                inputStream = null;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                inputStream = null;
            }
        }
        return j;
    }
}
