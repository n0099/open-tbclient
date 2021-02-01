package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes9.dex */
public class e implements com.baidu.tbadk.download.c {
    @Override // com.baidu.tbadk.download.c
    public void onFileDownloadSucceed(DownloadData downloadData) {
        MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_RELOAD_EMOTION_GROUPS, (Class) null);
        try {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tbadk.download.c
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [86=5, 88=4, 89=4, 90=4] */
    @Override // com.baidu.tbadk.download.c
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
                    int b2 = a.cyo().b(downloadData.getId(), fileInputStream);
                    EmotionGroupData JC = i.cyE().JC(downloadData.getId());
                    if (JC == null) {
                        if (b2 == 0) {
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
                        JC = new EmotionGroupData();
                        JC.setBytesLength((int) downloadData.getSize());
                        JC.setBytesReceived((int) downloadData.getLength());
                        JC.setDownloadUrl(downloadData.getUrl());
                        JC.setGroupId(downloadData.getId());
                        JC.setEmotionsCount(b2);
                        JC.setHeight(downloadData.getHeight());
                        JC.setWidth(downloadData.getWidth());
                        JC.setDownloadTime(System.currentTimeMillis());
                        JC.setGroupDesc(downloadData.getDescription());
                        JC.setGroupName(downloadData.getName());
                        JC.setStatus(1);
                        i.cyE().a(JC);
                    }
                    i.cyE().a(downloadData.getStatusMsg(), JC);
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

    @Override // com.baidu.tbadk.download.c
    public void onFileUpdateProgress(DownloadData downloadData) {
        if (downloadData != null) {
            f.cyr().b(downloadData);
        }
    }

    @Override // com.baidu.tbadk.download.c
    public boolean onPreDownload(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        EmotionGroupData JC = i.cyE().JC(downloadData.getId());
        if (JC != null && b.Jx(downloadData.getId())) {
            i.cyE().a(downloadData.getStatusMsg(), JC);
            downloadData.setStatusMsg(null);
            return false;
        }
        return true;
    }
}
