package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.fe;
import com.baidu.tieba.frs.tab.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements i.a {
    final /* synthetic */ HorizontalTabView boV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.boV = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.i.a
    public void gM(int i) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        fe feVar;
        fe feVar2;
        fe feVar3;
        TabItemView tabItemView2;
        tabItemView = this.boV.boN;
        if (tabItemView != null) {
            feVar = this.boV.boT;
            if (feVar != null) {
                feVar2 = this.boV.boT;
                if (feVar2 != null) {
                    feVar3 = this.boV.boT;
                    tabItemView2 = this.boV.boN;
                    feVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        gVar = this.boV.boO;
        if (gVar != null) {
            gVar2 = this.boV.boO;
            gVar2.gL(i);
        }
    }
}
