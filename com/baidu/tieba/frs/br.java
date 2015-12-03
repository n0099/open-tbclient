package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.FeedForumData;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
class br implements Runnable {
    final /* synthetic */ bq bbS;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.y bbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bq bqVar, com.baidu.tieba.tbadkCore.y yVar) {
        this.bbS = bqVar;
        this.bbT = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bo boVar;
        List list;
        bo boVar2;
        List list2;
        bo boVar3;
        bo boVar4;
        bo boVar5;
        List list3;
        boVar = this.bbS.bbR;
        list = boVar.bbP;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            FeedForumData feedForumData = (FeedForumData) it.next();
            if (feedForumData.getForumId().equals(this.bbT.getFid())) {
                boVar5 = this.bbS.bbR;
                list3 = boVar5.bbP;
                list3.remove(feedForumData);
                break;
            }
        }
        boVar2 = this.bbS.bbR;
        list2 = boVar2.bbP;
        if (list2.size() > 0) {
            boVar4 = this.bbS.bbR;
            boVar4.Np();
            return;
        }
        boVar3 = this.bbS.bbR;
        boVar3.hide();
    }
}
