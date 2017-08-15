package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bl;
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
        HashMap<Integer, bl> ahi;
        if (iVar != null && iVar.ago() != null && (ahi = iVar.ago().ahi()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bl> entry : ahi.entrySet()) {
                bl value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tieba.recapp.c.a.bio().o(arrayList);
        }
    }

    public static void a(ResponsedMessage<?> responsedMessage, final com.baidu.tieba.frs.i iVar, com.baidu.tieba.tbadkCore.i iVar2) {
        List<DownloadData> data;
        boolean z;
        if (iVar2 != null && iVar != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                com.baidu.adp.lib.g.e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.f.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.frs.i.this.age();
                    }
                }, TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }
}
