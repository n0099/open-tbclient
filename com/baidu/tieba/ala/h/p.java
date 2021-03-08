package com.baidu.tieba.ala.h;

import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.data.cd;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileDownloadCallBack;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class p {
    private DownloadData aVC;

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(String str, String str2, final String str3, final String str4) {
        this.aVC = new DownloadData();
        this.aVC.setId("pk_rank_task_bg_start");
        this.aVC.setName("pk_rank_task_bg_start");
        this.aVC.setUrl(str);
        this.aVC.setCheck(str2);
        this.aVC.setType(26);
        this.aVC.setPath(str3);
        this.aVC.setCallback(new FileDownloadCallBack() { // from class: com.baidu.tieba.ala.h.p.1
            @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
            public void onFileUpdateProgress(DownloadData downloadData) {
            }

            @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
            public boolean onPreDownload(DownloadData downloadData) {
                return true;
            }

            @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
            public boolean onFileDownloaded(DownloadData downloadData) {
                return true;
            }

            @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
            public void onFileDownloadSucceed(DownloadData downloadData) {
                p.this.z(downloadData.getUrl(), downloadData.getCheck(), str3, str4);
            }

            @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
            public void onFileDownloadFailed(DownloadData downloadData, int i, String str5) {
            }
        });
        FileSerialDownLoader.getInstance().startDownLoadWithoutMax(this.aVC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void release() {
        if (this.aVC != null) {
            this.aVC.setCallback(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final String str, final String str2, final String str3, final String str4) {
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            new BdAsyncTask<Void, Void, List<cd>>() { // from class: com.baidu.tieba.ala.h.p.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public List<cd> doInBackground(Void... voidArr) {
                    List<cd> A = p.this.A(str, str2, str3, str4);
                    if (A == null || A.isEmpty()) {
                        p.this.fN(str3);
                        p.this.fN(str4);
                    }
                    return A;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: B */
                public void onPostExecute(List<cd> list) {
                    super.onPostExecute(list);
                    if (list != null && !list.isEmpty()) {
                        o.cpg().cL(list);
                    }
                }
            }.execute(new Void[0]);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public java.util.List<com.baidu.live.data.cd> A(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            r7 = this;
            r1 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> La6
            r3.<init>(r10)     // Catch: java.lang.Throwable -> La6
            java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> Laa
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> Laa
            r0.<init>(r3)     // Catch: java.lang.Throwable -> Laa
            r2.<init>(r0)     // Catch: java.lang.Throwable -> Laa
            r0 = r1
        L11:
            java.util.zip.ZipEntry r4 = r2.getNextEntry()     // Catch: java.lang.Throwable -> L51
            if (r4 == 0) goto L61
            boolean r5 = r4.isDirectory()     // Catch: java.lang.Throwable -> L51
            if (r5 != 0) goto L11
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Throwable -> L51
            java.io.File r4 = r7.b(r2, r11, r4)     // Catch: java.lang.Throwable -> L51
            if (r4 == 0) goto L11
            java.lang.String r5 = r4.getAbsolutePath()     // Catch: java.lang.Throwable -> L51
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L51
            if (r5 != 0) goto L11
            if (r0 != 0) goto L38
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L51
            r0.<init>()     // Catch: java.lang.Throwable -> L51
        L38:
            com.baidu.live.data.cd r5 = new com.baidu.live.data.cd     // Catch: java.lang.Throwable -> L51
            r5.<init>()     // Catch: java.lang.Throwable -> L51
            r5.downloadUrl = r8     // Catch: java.lang.Throwable -> L51
            r5.aSj = r9     // Catch: java.lang.Throwable -> L51
            java.lang.String r6 = r4.getAbsolutePath()     // Catch: java.lang.Throwable -> L51
            r5.videoPath = r6     // Catch: java.lang.Throwable -> L51
            java.lang.String r4 = com.baidu.live.h.a.getFileMd5(r4)     // Catch: java.lang.Throwable -> L51
            r5.videoMd5 = r4     // Catch: java.lang.Throwable -> L51
            r0.add(r5)     // Catch: java.lang.Throwable -> L51
            goto L11
        L51:
            r0 = move-exception
        L52:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> La4
            if (r2 == 0) goto L5a
            r2.close()     // Catch: java.io.IOException -> L89
        L5a:
            if (r3 == 0) goto L5f
            r3.close()     // Catch: java.io.IOException -> L89
        L5f:
            r0 = r1
        L60:
            return r0
        L61:
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L51
            r4.<init>(r10)     // Catch: java.lang.Throwable -> L51
            com.baidu.live.tbadk.core.util.FileHelper.deleteFile(r4)     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L79
            boolean r4 = r0.isEmpty()     // Catch: java.lang.Throwable -> L51
            if (r4 != 0) goto L79
            com.baidu.tieba.ala.h.p$3 r4 = new com.baidu.tieba.ala.h.p$3     // Catch: java.lang.Throwable -> L51
            r4.<init>()     // Catch: java.lang.Throwable -> L51
            java.util.Collections.sort(r0, r4)     // Catch: java.lang.Throwable -> L51
        L79:
            if (r2 == 0) goto L7e
            r2.close()     // Catch: java.io.IOException -> L84
        L7e:
            if (r3 == 0) goto L60
            r3.close()     // Catch: java.io.IOException -> L84
            goto L60
        L84:
            r1 = move-exception
            r1.printStackTrace()
            goto L60
        L89:
            r0 = move-exception
            r0.printStackTrace()
            goto L5f
        L8e:
            r0 = move-exception
            r2 = r1
            r3 = r1
        L91:
            if (r2 == 0) goto L96
            r2.close()     // Catch: java.io.IOException -> L9c
        L96:
            if (r3 == 0) goto L9b
            r3.close()     // Catch: java.io.IOException -> L9c
        L9b:
            throw r0
        L9c:
            r1 = move-exception
            r1.printStackTrace()
            goto L9b
        La1:
            r0 = move-exception
            r2 = r1
            goto L91
        La4:
            r0 = move-exception
            goto L91
        La6:
            r0 = move-exception
            r2 = r1
            r3 = r1
            goto L52
        Laa:
            r0 = move-exception
            r2 = r1
            goto L52
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.ala.h.p.A(java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [219=5, 220=5, 221=5, 223=5, 224=5] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private File b(InputStream inputStream, String str, String str2) {
        String[] split;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (inputStream == null || TextUtils.isEmpty(str)) {
            return null;
        }
        if (str2.contains("/.")) {
            return null;
        }
        try {
            File file = new File(str + "/" + (str2.split("/").length > 1 ? split[split.length - 1] : split[0]));
            String parent = file.getParent();
            if (!TextUtils.isEmpty(parent)) {
                File file2 = new File(parent);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
            FileOutputStream fileOutputStream3 = null;
            try {
                try {
                    if (file.exists() && !file.delete()) {
                        if (0 != 0) {
                            try {
                                fileOutputStream3.flush();
                                fileOutputStream3.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        return null;
                    } else if (!file.createNewFile()) {
                        if (0 != 0) {
                            try {
                                fileOutputStream3.flush();
                                fileOutputStream3.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return null;
                    } else {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                    return file;
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return file;
                                }
                            }
                            return file;
                        } catch (IOException e4) {
                            e = e4;
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = null;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.live.h.a.cleanDir(new File(str));
        }
    }
}
