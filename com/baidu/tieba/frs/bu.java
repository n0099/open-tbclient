package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.FeedForumData;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
class bu implements Runnable {
    final /* synthetic */ bt bfR;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.y bfS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bt btVar, com.baidu.tieba.tbadkCore.y yVar) {
        this.bfR = btVar;
        this.bfS = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        br brVar;
        List list;
        br brVar2;
        List list2;
        br brVar3;
        br brVar4;
        br brVar5;
        List list3;
        brVar = this.bfR.bfQ;
        list = brVar.bfO;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            FeedForumData feedForumData = (FeedForumData) it.next();
            if (feedForumData.getForumId().equals(this.bfS.getFid())) {
                brVar5 = this.bfR.bfQ;
                list3 = brVar5.bfO;
                list3.remove(feedForumData);
                break;
            }
        }
        brVar2 = this.bfR.bfQ;
        list2 = brVar2.bfO;
        if (list2.size() > 0) {
            brVar4 = this.bfR.bfQ;
            brVar4.NI();
            return;
        }
        brVar3 = this.bfR.bfQ;
        brVar3.hide();
    }
}
