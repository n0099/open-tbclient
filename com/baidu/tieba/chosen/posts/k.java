package com.baidu.tieba.chosen.posts;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements BdListView.f {
    final /* synthetic */ e aKQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.aKQ = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void s(BdListView bdListView) {
        com.baidu.tbadk.mvc.h.a aVar;
        com.baidu.tbadk.mvc.h.a aVar2;
        com.baidu.tbadk.mvc.h.a aVar3;
        ChosenPostActivity chosenPostActivity;
        if (com.baidu.adp.lib.util.k.jc()) {
            chosenPostActivity = this.aKQ.aKJ;
            chosenPostActivity.Hp().Ht();
            return;
        }
        aVar = this.aKQ.aKM;
        if (aVar != null) {
            aVar2 = this.aKQ.aKM;
            aVar2.ov();
            aVar3 = this.aKQ.aKM;
            aVar3.et(i.h.no_more_msg);
        }
    }
}
