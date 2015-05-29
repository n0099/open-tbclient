package com.baidu.tieba.chosen.posts;

import com.baidu.adp.lib.util.n;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class j implements y {
    final /* synthetic */ e aDf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.aDf = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.y
    public void s(BdListView bdListView) {
        com.baidu.tbadk.mvc.k.a aVar;
        com.baidu.tbadk.mvc.k.a aVar2;
        com.baidu.tbadk.mvc.k.a aVar3;
        if (n.isNetOk()) {
            this.aDf.bg(false);
            return;
        }
        aVar = this.aDf.aoz;
        if (aVar != null) {
            aVar2 = this.aDf.aoz;
            aVar2.CQ();
            aVar3 = this.aDf.aoz;
            aVar3.ee(t.no_more_msg);
        }
    }
}
