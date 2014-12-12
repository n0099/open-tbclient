package com.baidu.tbadk.e;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.z;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.plugin.packageManager.pluginFileDownload.b {
    private static a ahg = new a();
    private static BdFileDownloadData ahh = null;
    private static List<BdFileDownloadData> Xb = new LinkedList();
    private c ahi = null;
    private Handler Xj = new b(this);

    private a() {
    }

    public static a zo() {
        return ahg;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void a(BdFileDownloadData bdFileDownloadData, int i) {
        if (bdFileDownloadData != null) {
            if (!s.bN() && i == 2) {
                bdFileDownloadData.setStatusMsg(TbadkCoreApplication.m255getInst().getApp().getString(z.download_fail_no_sd));
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
                if (i3 < Xb.size()) {
                    BdFileDownloadData bdFileDownloadData2 = Xb.get(i3);
                    if (bdFileDownloadData2 == null || !bdFileDownloadData2.getUrl().equals(bdFileDownloadData.getUrl()) || !bdFileDownloadData2.getId().equals(bdFileDownloadData.getId())) {
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                } else {
                    bdFileDownloadData.setStatus(1);
                    Xb.add(bdFileDownloadData);
                    uP();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uP() {
        if (ahh == null && !Xb.isEmpty()) {
            ahh = Xb.get(0);
            if (ahh != null) {
                this.ahi = new c(this);
                this.ahi.execute(ahh);
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void bn(String str) {
        if (ahh != null && ahh.getUrl().equals(str)) {
            this.ahi.cancel(true);
            return;
        }
        LinkedList<BdFileDownloadData> linkedList = new LinkedList();
        Iterator<BdFileDownloadData> it = Xb.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            BdFileDownloadData next = it.next();
            if (next.getUrl().equals(str)) {
                next.setStatus(4);
                if (next.getCallback() != null) {
                    next.getCallback().e(next);
                }
                linkedList.add(next);
            }
        }
        for (BdFileDownloadData bdFileDownloadData : linkedList) {
            Xb.remove(bdFileDownloadData);
        }
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
