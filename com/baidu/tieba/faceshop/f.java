package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.editortool.EmotionGroupData;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.download.a {
    @Override // com.baidu.tbadk.download.a
    public void d(DownloadData downloadData) {
        com.baidu.tbadk.editortool.aa.a().b();
        try {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tbadk.download.a
    public void a(DownloadData downloadData, int i, String str) {
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
    @Override // com.baidu.tbadk.download.a
    public boolean c(DownloadData downloadData) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            if (downloadData == null) {
                return false;
            }
            try {
                fileInputStream = new FileInputStream(downloadData.getPath());
                try {
                    int a = d.a().a(downloadData.getId(), fileInputStream);
                    EmotionGroupData a2 = com.baidu.tbadk.editortool.u.a().a(downloadData.getId());
                    if (a2 == null) {
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
                        a2 = new EmotionGroupData();
                        a2.setBytesLength((int) downloadData.getSize());
                        a2.setBytesReceived((int) downloadData.getLength());
                        a2.setDownloadUrl(downloadData.getUrl());
                        a2.setGroupId(downloadData.getId());
                        a2.setEmotionsCount(a);
                        a2.setHeight(downloadData.getHeight());
                        a2.setWidth(downloadData.getWidth());
                        a2.setDownloadTime(System.currentTimeMillis());
                        a2.setGroupDesc(downloadData.getDescription());
                        a2.setGroupName(downloadData.getName());
                        a2.setStatus(1);
                        com.baidu.tbadk.editortool.u.a().a(a2);
                    }
                    com.baidu.tbadk.editortool.u.a().a(downloadData.getStatusMsg(), a2);
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

    @Override // com.baidu.tbadk.download.a
    public void a(DownloadData downloadData) {
        if (downloadData != null) {
            g.a().a(downloadData);
        }
    }

    @Override // com.baidu.tbadk.download.a
    public boolean b(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        EmotionGroupData a = com.baidu.tbadk.editortool.u.a().a(downloadData.getId());
        if (a != null && e.a(downloadData.getId())) {
            com.baidu.tbadk.editortool.u.a().a(downloadData.getStatusMsg(), a);
            downloadData.setStatusMsg(null);
            return false;
        }
        return true;
    }
}
