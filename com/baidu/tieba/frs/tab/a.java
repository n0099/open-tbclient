package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.tab.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements i.a {
    final /* synthetic */ HorizontalTabView bbL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.bbL = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.i.a
    public void ga(int i) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        ec ecVar;
        ec ecVar2;
        ec ecVar3;
        TabItemView tabItemView2;
        tabItemView = this.bbL.bbD;
        if (tabItemView != null) {
            ecVar = this.bbL.bbJ;
            if (ecVar != null) {
                ecVar2 = this.bbL.bbJ;
                if (ecVar2 != null) {
                    ecVar3 = this.bbL.bbJ;
                    tabItemView2 = this.bbL.bbD;
                    ecVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        gVar = this.bbL.bbE;
        if (gVar != null) {
            gVar2 = this.bbL.bbE;
            gVar2.fZ(i);
        }
    }
}
