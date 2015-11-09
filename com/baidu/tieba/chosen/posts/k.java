package com.baidu.tieba.chosen.posts;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements BdListView.f {
    final /* synthetic */ e aIO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.aIO = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void s(BdListView bdListView) {
        com.baidu.tbadk.mvc.h.a aVar;
        com.baidu.tbadk.mvc.h.a aVar2;
        com.baidu.tbadk.mvc.h.a aVar3;
        ChosenPostActivity chosenPostActivity;
        if (com.baidu.adp.lib.util.k.je()) {
            chosenPostActivity = this.aIO.aIH;
            chosenPostActivity.Hc().Hg();
            return;
        }
        aVar = this.aIO.aIK;
        if (aVar != null) {
            aVar2 = this.aIO.aIK;
            aVar2.ox();
            aVar3 = this.aIO.aIK;
            aVar3.es(i.h.no_more_msg);
        }
    }
}
