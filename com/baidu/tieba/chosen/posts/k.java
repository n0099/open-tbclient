package com.baidu.tieba.chosen.posts;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements BdListView.f {
    final /* synthetic */ e aTp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.aTp = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void s(BdListView bdListView) {
        com.baidu.tbadk.mvc.h.a aVar;
        com.baidu.tbadk.mvc.h.a aVar2;
        com.baidu.tbadk.mvc.h.a aVar3;
        ChosenPostActivity chosenPostActivity;
        if (com.baidu.adp.lib.util.k.jq()) {
            chosenPostActivity = this.aTp.aTi;
            chosenPostActivity.KF().KJ();
            return;
        }
        aVar = this.aTp.aTl;
        if (aVar != null) {
            aVar2 = this.aTp.aTl;
            aVar2.ow();
            aVar3 = this.aTp.aTl;
            aVar3.eU(t.j.no_more_msg);
        }
    }
}
