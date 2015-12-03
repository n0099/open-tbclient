package com.baidu.tieba.chosen.posts;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements BdListView.f {
    final /* synthetic */ e aNp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.aNp = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void s(BdListView bdListView) {
        com.baidu.tbadk.mvc.h.a aVar;
        com.baidu.tbadk.mvc.h.a aVar2;
        com.baidu.tbadk.mvc.h.a aVar3;
        ChosenPostActivity chosenPostActivity;
        if (com.baidu.adp.lib.util.k.jg()) {
            chosenPostActivity = this.aNp.aNi;
            chosenPostActivity.Iv().Iz();
            return;
        }
        aVar = this.aNp.aNl;
        if (aVar != null) {
            aVar2 = this.aNp.aNl;
            aVar2.oD();
            aVar3 = this.aNp.aNl;
            aVar3.eG(n.i.no_more_msg);
        }
    }
}
