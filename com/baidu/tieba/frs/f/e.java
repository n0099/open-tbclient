package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.frs.az;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class e {
    public static void k(az azVar) {
        HashMap<Integer, bi> acq;
        if (azVar != null && azVar.abf() != null && (acq = azVar.abf().acq()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bi> entry : acq.entrySet()) {
                bi value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tieba.recapp.c.a.baU().o(arrayList);
        }
    }

    public static void a(ResponsedMessage<?> responsedMessage, az azVar, com.baidu.tieba.tbadkCore.n nVar) {
        List<DownloadData> data;
        boolean z;
        if (nVar != null && azVar != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                com.baidu.adp.lib.g.h.fS().postDelayed(new f(azVar), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }
}
