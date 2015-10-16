package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.ea;
import com.baidu.tieba.frs.tab.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements i.a {
    final /* synthetic */ HorizontalTabView bbp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.bbp = horizontalTabView;
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
        tabItemView = this.bbp.bbh;
        if (tabItemView != null) {
            eaVar = this.bbp.bbo;
            if (eaVar != null) {
                eaVar2 = this.bbp.bbo;
                if (eaVar2 != null) {
                    eaVar3 = this.bbp.bbo;
                    tabItemView2 = this.bbp.bbh;
                    eaVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        fVar = this.bbp.bbi;
        if (fVar != null) {
            fVar2 = this.bbp.bbi;
            fVar2.fQ(i);
        }
    }
}
