package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.ea;
import com.baidu.tieba.frs.tab.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements i.a {
    final /* synthetic */ HorizontalTabView bbe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.bbe = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.i.a
    public void fR(int i) {
        TabItemView tabItemView;
        f fVar;
        f fVar2;
        ea eaVar;
        ea eaVar2;
        ea eaVar3;
        TabItemView tabItemView2;
        tabItemView = this.bbe.baW;
        if (tabItemView != null) {
            eaVar = this.bbe.bbd;
            if (eaVar != null) {
                eaVar2 = this.bbe.bbd;
                if (eaVar2 != null) {
                    eaVar3 = this.bbe.bbd;
                    tabItemView2 = this.bbe.baW;
                    eaVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        fVar = this.bbe.baX;
        if (fVar != null) {
            fVar2 = this.bbe.baX;
            fVar2.fQ(i);
        }
    }
}
