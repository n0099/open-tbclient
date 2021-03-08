package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes8.dex */
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
                    int b = a.cyB().b(downloadData.getId(), fileInputStream);
                    EmotionGroupData JM = i.cyR().JM(downloadData.getId());
                    if (JM == null) {
                        if (b == 0) {
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
                        JM = new EmotionGroupData();
                        JM.setBytesLength((int) downloadData.getSize());
                        JM.setBytesReceived((int) downloadData.getLength());
                        JM.setDownloadUrl(downloadData.getUrl());
                        JM.setGroupId(downloadData.getId());
                        JM.setEmotionsCount(b);
                        JM.setHeight(downloadData.getHeight());
                        JM.setWidth(downloadData.getWidth());
                        JM.setDownloadTime(System.currentTimeMillis());
                        JM.setGroupDesc(downloadData.getDescription());
                        JM.setGroupName(downloadData.getName());
                        JM.setStatus(1);
                        i.cyR().a(JM);
                    }
                    i.cyR().a(downloadData.getStatusMsg(), JM);
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
            f.cyE().b(downloadData);
        }
    }

    @Override // com.baidu.tbadk.download.c
    public boolean onPreDownload(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        EmotionGroupData JM = i.cyR().JM(downloadData.getId());
        if (JM != null && b.JH(downloadData.getId())) {
            i.cyR().a(downloadData.getStatusMsg(), JM);
            downloadData.setStatusMsg(null);
            return false;
        }
        return true;
    }
}
