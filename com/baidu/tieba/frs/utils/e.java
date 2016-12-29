package com.baidu.tieba.frs.utils;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.bg;
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
    public static void p(ax axVar) {
        HashMap<Integer, bg> YS;
        if (axVar != null && axVar.Xu() != null && (YS = axVar.Xu().YS()) != null) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bg> entry : YS.entrySet()) {
                bg value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.c)) {
                    arrayList.add((com.baidu.tbadk.core.data.c) value);
                }
            }
            com.baidu.tieba.recapp.b.a.aYh().p(arrayList);
        }
    }

    public static void a(ResponsedMessage<?> responsedMessage, ax axVar, com.baidu.tieba.tbadkCore.o oVar) {
        List<DownloadData> data;
        boolean z;
        if (oVar != null && axVar != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                com.baidu.adp.lib.h.h.eG().postDelayed(new f(axVar), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }
}
