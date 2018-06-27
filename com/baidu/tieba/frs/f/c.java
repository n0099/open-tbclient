package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class c {
    public static void w(k kVar) {
        HashMap<Integer, bc> awu;
        if (kVar != null && kVar.auQ() != null && (awu = kVar.auQ().awu()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bc> entry : awu.entrySet()) {
                bc value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tieba.recapp.download.d.boQ().s(arrayList);
        }
    }

    public static void a(ResponsedMessage<?> responsedMessage, final k kVar, l lVar) {
        List<DownloadData> data;
        boolean z;
        if (lVar != null && kVar != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.f.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        k.this.auG();
                    }
                }, TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }
}
