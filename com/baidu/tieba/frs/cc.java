package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.FeedForumData;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
class cc implements Runnable {
    final /* synthetic */ cb bnk;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.x bnl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(cb cbVar, com.baidu.tieba.tbadkCore.x xVar) {
        this.bnk = cbVar;
        this.bnl = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bz bzVar;
        List list;
        bz bzVar2;
        List list2;
        bz bzVar3;
        bz bzVar4;
        bz bzVar5;
        List list3;
        bzVar = this.bnk.bnj;
        list = bzVar.bnh;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            FeedForumData feedForumData = (FeedForumData) it.next();
            if (feedForumData.getForumId().equals(this.bnl.getFid())) {
                bzVar5 = this.bnk.bnj;
                list3 = bzVar5.bnh;
                list3.remove(feedForumData);
                break;
            }
        }
        bzVar2 = this.bnk.bnj;
        list2 = bzVar2.bnh;
        if (list2.size() > 0) {
            bzVar4 = this.bnk.bnj;
            bzVar4.xg();
            return;
        }
        bzVar3 = this.bnk.bnj;
        bzVar3.hide();
    }
}
