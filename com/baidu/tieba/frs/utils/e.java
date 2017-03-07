package com.baidu.tieba.frs.utils;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.frs.ax;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class e {
    public static void k(ax axVar) {
        HashMap<Integer, bj> aaR;
        if (axVar != null && axVar.ZG() != null && (aaR = axVar.ZG().aaR()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bj> entry : aaR.entrySet()) {
                bj value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tieba.recapp.b.a.aZF().o(arrayList);
        }
    }

    public static void a(ResponsedMessage<?> responsedMessage, ax axVar, com.baidu.tieba.tbadkCore.n nVar) {
        List<DownloadData> data;
        boolean z;
        if (nVar != null && axVar != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                com.baidu.adp.lib.g.h.fM().postDelayed(new f(axVar), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }
}
