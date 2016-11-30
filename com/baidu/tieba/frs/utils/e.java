package com.baidu.tieba.frs.utils;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.frs.au;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class e {
    public static void p(au auVar) {
        HashMap<Integer, bk> aey;
        if (auVar != null && auVar.ade() != null && (aey = auVar.ade().aey()) != null) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bk> entry : aey.entrySet()) {
                bk value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.c)) {
                    arrayList.add((com.baidu.tbadk.core.data.c) value);
                }
            }
            com.baidu.tieba.recapp.b.a.beu().p(arrayList);
        }
    }

    public static void a(ResponsedMessage<?> responsedMessage, au auVar, com.baidu.tieba.tbadkCore.p pVar) {
        List<DownloadData> data;
        boolean z;
        if (pVar != null && auVar != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                com.baidu.adp.lib.h.h.eG().postDelayed(new f(auVar), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }
}
