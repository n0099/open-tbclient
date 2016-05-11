package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.FeedForumData;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
class cb implements Runnable {
    final /* synthetic */ ca biN;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.y biO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(ca caVar, com.baidu.tieba.tbadkCore.y yVar) {
        this.biN = caVar;
        this.biO = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        by byVar;
        List list;
        by byVar2;
        List list2;
        by byVar3;
        by byVar4;
        by byVar5;
        List list3;
        byVar = this.biN.biM;
        list = byVar.biJ;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            FeedForumData feedForumData = (FeedForumData) it.next();
            if (feedForumData.getForumId().equals(this.biO.getFid())) {
                byVar5 = this.biN.biM;
                list3 = byVar5.biJ;
                list3.remove(feedForumData);
                break;
            }
        }
        byVar2 = this.biN.biM;
        list2 = byVar2.biJ;
        if (list2.size() > 0) {
            byVar4 = this.biN.biM;
            byVar4.uP();
            return;
        }
        byVar3 = this.biN.biM;
        byVar3.hide();
    }
}
