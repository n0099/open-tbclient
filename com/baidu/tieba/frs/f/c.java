package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.tbadkCore.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class c {
    public static void j(j jVar) {
        HashMap<Integer, bd> anC;
        if (jVar != null && jVar.amd() != null && (anC = jVar.amd().anC()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bd> entry : anC.entrySet()) {
                bd value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tieba.recapp.c.a.blV().o(arrayList);
        }
    }

    public static void a(ResponsedMessage<?> responsedMessage, final j jVar, k kVar) {
        List<DownloadData> data;
        boolean z;
        if (kVar != null && jVar != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                        j.this.alT();
                    }
                }, TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }
}
