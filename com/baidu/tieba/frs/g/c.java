package com.baidu.tieba.frs.g;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class c {
    public static void j(com.baidu.tieba.frs.i iVar) {
        HashMap<Integer, bj> aiZ;
        if (iVar != null && iVar.ahR() != null && (aiZ = iVar.ahR().aiZ()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bj> entry : aiZ.entrySet()) {
                bj value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tieba.recapp.c.a.bht().o(arrayList);
        }
    }

    public static void a(ResponsedMessage<?> responsedMessage, final com.baidu.tieba.frs.i iVar, com.baidu.tieba.tbadkCore.i iVar2) {
        List<DownloadData> data;
        boolean z;
        if (iVar2 != null && iVar != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
            Iterator<DownloadData> it = data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().getStatus() == 0) {
                    z = true;
                    break;
                }
            }
            if (z) {
                com.baidu.adp.lib.g.e.fQ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.g.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.frs.i.this.ahH();
                    }
                }, TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }
}
