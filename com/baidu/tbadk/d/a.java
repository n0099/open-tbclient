package com.baidu.tbadk.d;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.o;
import com.baidu.tieba.t;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.plugin.packageManager.pluginFileDownload.b {
    private static a arq = new a();
    private static BdFileDownloadData arr = null;
    private static List<BdFileDownloadData> aiS = new LinkedList();
    private c ars = null;
    private Handler aja = new b(this);

    private a() {
    }

    public static a DK() {
        return arq;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void a(BdFileDownloadData bdFileDownloadData, int i) {
        if (bdFileDownloadData != null) {
            if (!o.fo() && i == 2) {
                bdFileDownloadData.setStatusMsg(TbadkCoreApplication.m411getInst().getApp().getString(t.download_fail_no_sd));
                bdFileDownloadData.setStatus(2);
            }
            if (bdFileDownloadData.getStatus() == 2) {
                if (bdFileDownloadData.getCallback() != null) {
                    bdFileDownloadData.getCallback().e(bdFileDownloadData);
                    return;
                }
                return;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < aiS.size()) {
                    BdFileDownloadData bdFileDownloadData2 = aiS.get(i3);
                    if (bdFileDownloadData2 == null || !bdFileDownloadData2.getUrl().equals(bdFileDownloadData.getUrl()) || !bdFileDownloadData2.getId().equals(bdFileDownloadData.getId())) {
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                } else {
                    bdFileDownloadData.setStatus(1);
                    aiS.add(bdFileDownloadData);
                    zj();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj() {
        if (arr == null && !aiS.isEmpty()) {
            arr = aiS.get(0);
            if (arr != null) {
                this.ars = new c(this);
                this.ars.execute(arr);
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void bC(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (arr != null && arr.getId().equals(str)) {
                this.ars.cancel(true);
                return;
            }
            LinkedList<BdFileDownloadData> linkedList = new LinkedList();
            Iterator<BdFileDownloadData> it = aiS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BdFileDownloadData next = it.next();
                if (next.getId().equals(str)) {
                    next.setStatus(4);
                    next.setStatusMsg(null);
                    if (next.getCallback() != null) {
                        next.getCallback().e(next);
                    }
                    linkedList.add(next);
                }
            }
            for (BdFileDownloadData bdFileDownloadData : linkedList) {
                aiS.remove(bdFileDownloadData);
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public List<BdFileDownloadData> lZ() {
        return aiS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i(BdFileDownloadData bdFileDownloadData) {
        if (bdFileDownloadData == null) {
            return null;
        }
        return String.valueOf(bdFileDownloadData.getPath()) + ".tmp";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(BdFileDownloadData bdFileDownloadData) {
        File file;
        if (bdFileDownloadData == null) {
            return false;
        }
        String path = bdFileDownloadData.getPath();
        return (TextUtils.isEmpty(path) || (file = new File(path)) == null || !file.exists()) ? false : true;
    }
}
