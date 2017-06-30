package com.baidu.tieba.frs.e;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.frs.av;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class c {
    public static void j(av avVar) {
        HashMap<Integer, bm> afw;
        if (avVar != null && avVar.aeI() != null && (afw = avVar.aeI().afw()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bm> entry : afw.entrySet()) {
                bm value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tieba.recapp.c.a.bdX().o(arrayList);
        }
    }

    public static void a(ResponsedMessage<?> responsedMessage, av avVar, com.baidu.tieba.tbadkCore.n nVar) {
        List<DownloadData> data;
        boolean z;
        if (nVar != null && avVar != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                com.baidu.adp.lib.g.h.fR().postDelayed(new d(avVar), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }
}
