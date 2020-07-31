package com.baidu.tieba.ala.alaar.sticker.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private static File avc = h.getPrivateCaptureRootChildDir("duFaceFile");
    private static List<String> fmQ = Collections.synchronizedList(new ArrayList());
    public static String fmR = "";

    /* loaded from: classes4.dex */
    public interface a {
        void onCompleted(String str);

        void onFailed(int i, int i2, String str);

        void onProgress(long j, long j2, int i);

        void onStarted();
    }

    public static String BK(String str) {
        File BN;
        if (TextUtils.isEmpty(str) || (BN = BN(Md5.toMd5(str))) == null || !BN.exists()) {
            return null;
        }
        Log.d("ArUpdate", "hasDownload url: " + str);
        Log.d("ArUpdate", "hasDownload file.getAbsolutePath(): " + BN.getAbsolutePath());
        return BN.getAbsolutePath();
    }

    public static boolean BL(String str) {
        return !TextUtils.isEmpty(BK(str));
    }

    public static void a(final String str, final a aVar) {
        if (!TextUtils.isEmpty(str)) {
            String BK = BK(str);
            if (!TextUtils.isEmpty(BK)) {
                if (aVar != null) {
                    Log.d("ArUpdate", "onCompleted 0");
                    aVar.onCompleted(BO(BK));
                    return;
                }
                return;
            }
            final String md5 = Md5.toMd5(str);
            fmQ.add(str);
            com.baidu.tieba.ala.alaar.sticker.download.b.bvx().a(str, avc, md5 + ".tmp", new com.baidu.tieba.ala.alaar.sticker.download.a.a() { // from class: com.baidu.tieba.ala.alaar.sticker.a.d.1
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
                    d.fmQ.remove(str);
                    if (!TextUtils.isEmpty(str2) && a.this != null) {
                        File file = new File(str2);
                        File BM = d.BM(md5);
                        if (file.exists() && file.renameTo(BM) && BM != null) {
                            if (d.g(BM, md5)) {
                                String BK2 = d.BK(str);
                                if (!TextUtils.isEmpty(BK2)) {
                                    Log.d("ArUpdate", "onCompleted 1");
                                    a.this.onCompleted(d.BO(BK2));
                                    return;
                                }
                                return;
                            }
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
                    d.fmQ.remove(str);
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
    public static File BM(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(avc, str + ".zip");
    }

    private static File BN(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(avc, str);
    }

    public static boolean g(File file, String str) {
        boolean z;
        Exception e;
        try {
            Log.d("ArUpdate", "onResLoaded file: " + file + ", fileName:" + str);
            File file2 = new File(avc, str + ".tmp");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(file2);
                try {
                    file2.delete();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            Log.d("ArUpdate", "unzipFile--> loadedFile: " + file + ", unzipingFile:" + file2);
            com.baidu.tieba.ala.alaar.sticker.b.c.l(file, file2);
            Log.d("ArUpdate", "onUnzipFile: " + file2);
            z = com.baidu.minivideo.arface.a.gr(file2.getAbsolutePath());
            if (!z) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(file2);
            }
            file2.renameTo(BN(str));
            Log.d("ArUpdate", "unzipingFile.renameTo: " + BN(str));
            try {
                Log.d("ArUpdate", "result: " + z);
            } catch (Exception e3) {
                e = e3;
                Log.e("ArUpdate", "onResLoaded: " + e.getMessage());
                e.printStackTrace();
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(BN(str));
                return z;
            }
        } catch (Exception e4) {
            z = false;
            e = e4;
            Log.e("ArUpdate", "onResLoaded: " + e.getMessage());
            e.printStackTrace();
            com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(BN(str));
            return z;
        }
        return z;
    }

    public static String BO(String str) {
        U(new File(str));
        Log.d("ArUpdate", "getTxtPathFromFolder mFaceFile: " + fmR);
        return fmR;
    }

    public static String U(File file) {
        File[] listFiles;
        Log.d("ArUpdate", "func file:" + file);
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                U(file2);
            }
            if (file2.isFile() && BP(file2.getName())) {
                fmR = file2.getPath();
                return file2.getPath();
            }
        }
        return null;
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean BP(String str) {
        boolean z;
        Log.d("ArUpdate", "checkIsTxtFile fName: " + str);
        String lowerCase = str.substring(str.lastIndexOf(".") + 1, str.length()).toLowerCase();
        Log.d("ArUpdate", "checkIsTxtFile fileEnd: " + lowerCase);
        if (!str.startsWith(".") && (lowerCase.equals(DocumentOpenUtil.TXT) || lowerCase.equals("json"))) {
            z = true;
        } else {
            z = false;
        }
        Log.d("ArUpdate", "isTxtFile: " + z);
        return z;
    }
}
