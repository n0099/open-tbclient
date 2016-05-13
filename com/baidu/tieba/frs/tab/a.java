package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.fg;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements j.b {
    final /* synthetic */ HorizontalTabView bsU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.bsU = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.j.b
    public void gM(int i) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        fg fgVar;
        fg fgVar2;
        fg fgVar3;
        TabItemView tabItemView2;
        tabItemView = this.bsU.bsJ;
        if (tabItemView != null) {
            fgVar = this.bsU.bsS;
            if (fgVar != null) {
                fgVar2 = this.bsU.bsS;
                if (fgVar2 != null) {
                    fgVar3 = this.bsU.bsS;
                    tabItemView2 = this.bsU.bsJ;
                    fgVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        gVar = this.bsU.bsK;
        if (gVar != null) {
            gVar2 = this.bsU.bsK;
            gVar2.gK(i);
        }
    }
}
