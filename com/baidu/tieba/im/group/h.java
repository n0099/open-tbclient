package com.baidu.tieba.im.group;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements u {
    final /* synthetic */ g aYw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aYw = gVar;
    }

    @Override // com.baidu.tbadk.core.view.u
    public void aa(boolean z) {
        BdListView bdListView;
        if (z) {
            bdListView = this.aYw.vl;
            bdListView.hO();
        }
    }
}
