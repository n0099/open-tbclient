package com.baidu.tieba.frs.utils;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.bh;
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
        HashMap<Integer, bh> ZU;
        if (axVar != null && axVar.YH() != null && (ZU = axVar.YH().ZU()) != null) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bh> entry : ZU.entrySet()) {
                bh value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.c)) {
                    arrayList.add((com.baidu.tbadk.core.data.c) value);
                }
            }
            com.baidu.tieba.recapp.b.a.aZX().p(arrayList);
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
                com.baidu.adp.lib.g.h.eE().postDelayed(new f(axVar), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }
}
