package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class e {
    private static File aEO = i.getPrivateCaptureRootChildDir("duFilter");
    private static List<String> gcL = Collections.synchronizedList(new ArrayList());

    /* loaded from: classes4.dex */
    public interface a {
        void onCompleted(String str);

        void onFailed(int i, int i2, String str);

        void onProgress(long j, long j2, int i);

        void onStarted();
    }

    public static String FZ(String str) {
        File Gb;
        if (TextUtils.isEmpty(str) || (Gb = Gb(Md5.toMd5(str))) == null || !Gb.exists()) {
            return null;
        }
        return Gb.getAbsolutePath();
    }

    public static boolean Ga(String str) {
        return !TextUtils.isEmpty(FZ(str));
    }

    public static boolean cG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.tieba.ala.alaar.sticker.download.b.bNs().isRunning(str);
    }

    public static void a(final String str, final a aVar) {
        if (!TextUtils.isEmpty(str)) {
            String FZ = FZ(str);
            if (!TextUtils.isEmpty(FZ)) {
                if (aVar != null) {
                    aVar.onCompleted(FZ);
                    return;
                }
                return;
            }
            final String md5 = Md5.toMd5(str);
            gcL.add(str);
            com.baidu.tieba.ala.alaar.sticker.download.b.bNs().a(str, aEO, md5 + ".tmp", new com.baidu.tieba.ala.alaar.sticker.download.a.a() { // from class: com.baidu.tieba.ala.alaar.sticker.a.e.1
                @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
                public void onStarted() {
                    super.onStarted();
                    if (a.this != null) {
                        a.this.onStarted();
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
                public void onConnecting() {
                    super.onConnecting();
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
                public void onConnected(long j, boolean z) {
                    super.onConnected(j, z);
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
                public void onProgress(long j, long j2, int i) {
                    super.onProgress(j, j2, i);
                    if (a.this != null) {
                        a.this.onProgress(j, j2, i);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
                public void onCompleted(String str2) {
                    super.onCompleted(str2);
                    e.gcL.remove(str);
                    if (!TextUtils.isEmpty(str2) && a.this != null) {
                        File file = new File(str2);
                        File Gb = e.Gb(md5);
                        if (file.exists() && file.renameTo(Gb) && Gb != null) {
                            a.this.onCompleted(Gb.getAbsolutePath());
                            return;
                        }
                    }
                    a(new DownloadException("文件下载失败"));
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
                public void onDownloadPaused() {
                    super.onDownloadPaused();
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
                public void onDownloadCanceled() {
                    super.onDownloadCanceled();
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
                public void a(DownloadException downloadException) {
                    int i;
                    e.gcL.remove(str);
                    super.a(downloadException);
                    if (a.this != null) {
                        String str2 = null;
                        if (downloadException != null) {
                            i = downloadException.getErrorCode();
                            str2 = downloadException.getErrorMessage();
                        } else {
                            i = 0;
                        }
                        a.this.onFailed(i, 0, str2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File Gb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(aEO, str + ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX);
    }
}
