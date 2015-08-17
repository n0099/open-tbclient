package com.baidu.tieba.chosen.posts;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements BdListView.f {
    final /* synthetic */ e aKD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.aKD = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void s(BdListView bdListView) {
        com.baidu.tbadk.mvc.h.a aVar;
        com.baidu.tbadk.mvc.h.a aVar2;
        com.baidu.tbadk.mvc.h.a aVar3;
        ChosenPostActivity chosenPostActivity;
        if (com.baidu.adp.lib.util.k.jf()) {
            chosenPostActivity = this.aKD.aKw;
            chosenPostActivity.HB().HF();
            return;
        }
        aVar = this.aKD.aKz;
        if (aVar != null) {
            aVar2 = this.aKD.aKz;
            aVar2.oy();
            aVar3 = this.aKD.aKz;
            aVar3.el(i.C0057i.no_more_msg);
        }
    }
}
