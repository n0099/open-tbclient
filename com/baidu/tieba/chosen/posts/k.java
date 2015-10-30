package com.baidu.tieba.chosen.posts;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements BdListView.f {
    final /* synthetic */ e aJU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.aJU = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void s(BdListView bdListView) {
        com.baidu.tbadk.mvc.h.a aVar;
        com.baidu.tbadk.mvc.h.a aVar2;
        com.baidu.tbadk.mvc.h.a aVar3;
        ChosenPostActivity chosenPostActivity;
        if (com.baidu.adp.lib.util.k.jd()) {
            chosenPostActivity = this.aJU.aJN;
            chosenPostActivity.Hf().Hj();
            return;
        }
        aVar = this.aJU.aJQ;
        if (aVar != null) {
            aVar2 = this.aJU.aJQ;
            aVar2.ow();
            aVar3 = this.aJU.aJQ;
            aVar3.eu(i.h.no_more_msg);
        }
    }
}
