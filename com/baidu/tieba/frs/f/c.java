package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bh;
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
        HashMap<Integer, bh> all;
        if (iVar != null && iVar.ajN() != null && (all = iVar.ajN().all()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bh> entry : all.entrySet()) {
                bh value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tieba.recapp.c.a.bjf().o(arrayList);
        }
    }

    public static void a(ResponsedMessage<?> responsedMessage, final com.baidu.tieba.frs.i iVar, com.baidu.tieba.tbadkCore.j jVar) {
        List<DownloadData> data;
        boolean z;
        if (jVar != null && iVar != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.f.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.frs.i.this.ajD();
                    }
                }, TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }
}
