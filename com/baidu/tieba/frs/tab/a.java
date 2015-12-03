package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.et;
import com.baidu.tieba.frs.tab.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements i.a {
    final /* synthetic */ HorizontalTabView biq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.biq = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.i.a
    public void gw(int i) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        et etVar;
        et etVar2;
        et etVar3;
        TabItemView tabItemView2;
        tabItemView = this.biq.bii;
        if (tabItemView != null) {
            etVar = this.biq.bio;
            if (etVar != null) {
                etVar2 = this.biq.bio;
                if (etVar2 != null) {
                    etVar3 = this.biq.bio;
                    tabItemView2 = this.biq.bii;
                    etVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        gVar = this.biq.bij;
        if (gVar != null) {
            gVar2 = this.biq.bij;
            gVar2.gv(i);
        }
    }
}
