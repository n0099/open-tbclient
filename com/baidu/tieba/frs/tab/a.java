package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.fo;
import com.baidu.tieba.frs.tab.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements i.b {
    final /* synthetic */ HorizontalTabView btX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.btX = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.i.b
    public void he(int i) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        fo foVar;
        fo foVar2;
        fo foVar3;
        TabItemView tabItemView2;
        tabItemView = this.btX.btO;
        if (tabItemView != null) {
            foVar = this.btX.btV;
            if (foVar != null) {
                foVar2 = this.btX.btV;
                if (foVar2 != null) {
                    foVar3 = this.btX.btV;
                    tabItemView2 = this.btX.btO;
                    foVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        gVar = this.btX.btP;
        if (gVar != null) {
            gVar2 = this.btX.btP;
            gVar2.hc(i);
        }
    }
}
