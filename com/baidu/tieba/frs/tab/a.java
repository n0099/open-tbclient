package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.db;
import com.baidu.tieba.frs.tab.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements i.a {
    final /* synthetic */ HorizontalTabView baR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.baR = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.i.a
    public void fD(int i) {
        TabItemView tabItemView;
        f fVar;
        f fVar2;
        db dbVar;
        db dbVar2;
        db dbVar3;
        TabItemView tabItemView2;
        tabItemView = this.baR.baJ;
        if (tabItemView != null) {
            dbVar = this.baR.baQ;
            if (dbVar != null) {
                dbVar2 = this.baR.baQ;
                if (dbVar2 != null) {
                    dbVar3 = this.baR.baQ;
                    tabItemView2 = this.baR.baJ;
                    dbVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        fVar = this.baR.baK;
        if (fVar != null) {
            fVar2 = this.baR.baK;
            fVar2.fC(i);
        }
    }
}
