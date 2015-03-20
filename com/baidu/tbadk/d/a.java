package com.baidu.tbadk.d;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.o;
import com.baidu.tieba.y;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.plugin.packageManager.pluginFileDownload.b {
    private static a aqg = new a();
    private static BdFileDownloadData aqh = null;
    private static List<BdFileDownloadData> ahK = new LinkedList();
    private c aqi = null;
    private Handler ahS = new b(this);

    private a() {
    }

    public static a CT() {
        return aqg;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void a(BdFileDownloadData bdFileDownloadData, int i) {
        if (bdFileDownloadData != null) {
            if (!o.fj() && i == 2) {
                bdFileDownloadData.setStatusMsg(TbadkCoreApplication.m411getInst().getApp().getString(y.download_fail_no_sd));
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
                if (i3 < ahK.size()) {
                    BdFileDownloadData bdFileDownloadData2 = ahK.get(i3);
                    if (bdFileDownloadData2 == null || !bdFileDownloadData2.getUrl().equals(bdFileDownloadData.getUrl()) || !bdFileDownloadData2.getId().equals(bdFileDownloadData.getId())) {
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                } else {
                    bdFileDownloadData.setStatus(1);
                    ahK.add(bdFileDownloadData);
                    yq();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yq() {
        if (aqh == null && !ahK.isEmpty()) {
            aqh = ahK.get(0);
            if (aqh != null) {
                this.aqi = new c(this);
                this.aqi.execute(aqh);
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void bs(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (aqh != null && aqh.getId().equals(str)) {
                this.aqi.cancel(true);
                return;
            }
            LinkedList<BdFileDownloadData> linkedList = new LinkedList();
            Iterator<BdFileDownloadData> it = ahK.iterator();
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
                ahK.remove(bdFileDownloadData);
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public List<BdFileDownloadData> lG() {
        return ahK;
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
