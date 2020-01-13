package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class c {
    public static void y(l lVar) {
        HashMap<Integer, bj> bFw;
        if (lVar != null && lVar.bDA() != null && (bFw = lVar.bDA().bFw()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bj> entry : bFw.entrySet()) {
                bj value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tieba.recapp.download.e.cBb().C(arrayList);
        }
    }

    public static void a(ResponsedMessage<?> responsedMessage, final l lVar, FrsViewData frsViewData) {
        List<DownloadData> data;
        boolean z;
        if (frsViewData != null && lVar != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.f.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        l.this.bDo();
                    }
                }, TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }
}
