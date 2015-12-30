package com.baidu.tieba.chosen.posts;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements BdListView.f {
    final /* synthetic */ e aRi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.aRi = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void s(BdListView bdListView) {
        com.baidu.tbadk.mvc.h.a aVar;
        com.baidu.tbadk.mvc.h.a aVar2;
        com.baidu.tbadk.mvc.h.a aVar3;
        ChosenPostActivity chosenPostActivity;
        if (com.baidu.adp.lib.util.k.jh()) {
            chosenPostActivity = this.aRi.aRb;
            chosenPostActivity.IN().IR();
            return;
        }
        aVar = this.aRi.aRe;
        if (aVar != null) {
            aVar2 = this.aRi.aRe;
            aVar2.ob();
            aVar3 = this.aRi.aRe;
            aVar3.eA(n.j.no_more_msg);
        }
    }
}
