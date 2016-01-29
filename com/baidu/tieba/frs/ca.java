package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.FeedForumData;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
class ca implements Runnable {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.x biA;
    final /* synthetic */ bz biz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar, com.baidu.tieba.tbadkCore.x xVar) {
        this.biz = bzVar;
        this.biA = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bx bxVar;
        List list;
        bx bxVar2;
        List list2;
        bx bxVar3;
        bx bxVar4;
        bx bxVar5;
        List list3;
        bxVar = this.biz.biy;
        list = bxVar.biw;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            FeedForumData feedForumData = (FeedForumData) it.next();
            if (feedForumData.getForumId().equals(this.biA.getFid())) {
                bxVar5 = this.biz.biy;
                list3 = bxVar5.biw;
                list3.remove(feedForumData);
                break;
            }
        }
        bxVar2 = this.biz.biy;
        list2 = bxVar2.biw;
        if (list2.size() > 0) {
            bxVar4 = this.biz.biy;
            bxVar4.wO();
            return;
        }
        bxVar3 = this.biz.biy;
        bxVar3.hide();
    }
}
