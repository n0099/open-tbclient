package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.editortool.EmotionGroupData;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.download.f {
    @Override // com.baidu.tbadk.download.f
    public void onFileDownloadSucceed(DownloadData downloadData) {
        com.baidu.tbadk.editortool.aa.rz().rA();
        try {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tbadk.download.f
    public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
        if (i != 3) {
            try {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [86=4, 88=4, 89=4, 90=4] */
    @Override // com.baidu.tbadk.download.f
    public boolean onFileDownloaded(DownloadData downloadData) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            if (downloadData == null) {
                return false;
            }
            try {
                fileInputStream = new FileInputStream(downloadData.getPath());
                try {
                    int a = d.CG().a(downloadData.getId(), fileInputStream);
                    EmotionGroupData db = com.baidu.tbadk.editortool.u.rw().db(downloadData.getId());
                    if (db == null) {
                        if (a == 0) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    return false;
                                } catch (IOException e) {
                                    BdLog.detailException(e);
                                    return false;
                                }
                            }
                            return false;
                        }
                        db = new EmotionGroupData();
                        db.setBytesLength((int) downloadData.getSize());
                        db.setBytesReceived((int) downloadData.getLength());
                        db.setDownloadUrl(downloadData.getUrl());
                        db.setGroupId(downloadData.getId());
                        db.setEmotionsCount(a);
                        db.setHeight(downloadData.getHeight());
                        db.setWidth(downloadData.getWidth());
                        db.setDownloadTime(System.currentTimeMillis());
                        db.setGroupDesc(downloadData.getDescription());
                        db.setGroupName(downloadData.getName());
                        db.setStatus(1);
                        com.baidu.tbadk.editortool.u.rw().a(db);
                    }
                    com.baidu.tbadk.editortool.u.rw().a(downloadData.getStatusMsg(), db);
                    downloadData.setStatusMsg(null);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            BdLog.detailException(e2);
                        }
                    }
                    return true;
                } catch (Exception e3) {
                    e = e3;
                    BdLog.detailException(e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            return false;
                        } catch (IOException e4) {
                            BdLog.detailException(e4);
                            return false;
                        }
                    }
                    return false;
                }
            } catch (Exception e5) {
                e = e5;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e6) {
                        BdLog.detailException(e6);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.baidu.tbadk.download.f
    public void onFileUpdateProgress(DownloadData downloadData) {
        if (downloadData != null) {
            g.CH().a(downloadData);
        }
    }

    @Override // com.baidu.tbadk.download.f
    public boolean onPreDownload(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        EmotionGroupData db = com.baidu.tbadk.editortool.u.rw().db(downloadData.getId());
        if (db != null && e.eK(downloadData.getId())) {
            com.baidu.tbadk.editortool.u.rw().a(downloadData.getStatusMsg(), db);
            downloadData.setStatusMsg(null);
            return false;
        }
        return true;
    }
}
