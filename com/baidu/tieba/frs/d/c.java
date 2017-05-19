package com.baidu.tieba.frs.d;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.frs.at;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class c {
    public static void j(at atVar) {
        HashMap<Integer, bk> aaC;
        if (atVar != null && atVar.ZO() != null && (aaC = atVar.ZO().aaC()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bk> entry : aaC.entrySet()) {
                bk value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tieba.recapp.c.a.aYt().o(arrayList);
        }
    }

    public static void a(ResponsedMessage<?> responsedMessage, at atVar, com.baidu.tieba.tbadkCore.n nVar) {
        List<DownloadData> data;
        boolean z;
        if (nVar != null && atVar != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                com.baidu.adp.lib.g.h.fS().postDelayed(new d(atVar), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }
}
