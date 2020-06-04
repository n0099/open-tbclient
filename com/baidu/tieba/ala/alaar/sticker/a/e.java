package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    private static File ate = h.getPrivateCaptureRootChildDir("duFilter");
    private static List<String> eXm = Collections.synchronizedList(new ArrayList());

    /* loaded from: classes3.dex */
    public interface a {
        void onCompleted(String str);

        void onFailed(int i, int i2, String str);

        void onProgress(long j, long j2, int i);

        void onStarted();
    }

    public static String AG(String str) {
        File AI;
        if (TextUtils.isEmpty(str) || (AI = AI(Md5.toMd5(str))) == null || !AI.exists()) {
            return null;
        }
        return AI.getAbsolutePath();
    }

    public static boolean AH(String str) {
        return !TextUtils.isEmpty(AG(str));
    }

    public static boolean cz(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.tieba.ala.alaar.sticker.download.b.bpE().isRunning(str);
    }

    public static void a(final String str, final a aVar) {
        if (!TextUtils.isEmpty(str)) {
            String AG = AG(str);
            if (!TextUtils.isEmpty(AG)) {
                if (aVar != null) {
                    aVar.onCompleted(AG);
                    return;
                }
                return;
            }
            final String md5 = Md5.toMd5(str);
            eXm.add(str);
            com.baidu.tieba.ala.alaar.sticker.download.b.bpE().a(str, ate, md5 + ".tmp", new com.baidu.tieba.ala.alaar.sticker.download.a.a() { // from class: com.baidu.tieba.ala.alaar.sticker.a.e.1
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
                    e.eXm.remove(str);
                    if (!TextUtils.isEmpty(str2) && a.this != null) {
                        File file = new File(str2);
                        File AI = e.AI(md5);
                        if (file.exists() && file.renameTo(AI) && AI != null) {
                            a.this.onCompleted(AI.getAbsolutePath());
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
                    e.eXm.remove(str);
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
    public static File AI(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(ate, str + ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX);
    }
}
