package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView cfF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.cfF = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        h hVar;
        TabItemView tabItemView;
        h hVar2;
        TabItemView tabItemView2;
        h hVar3;
        HorizontalTabView.a aVar;
        HorizontalTabView.a aVar2;
        z = this.cfF.cfy;
        if (z) {
            if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                aVar = this.cfF.cfz;
                if (aVar != null) {
                    aVar2 = this.cfF.cfz;
                    aVar2.a(this.cfF.iP(1));
                }
                this.cfF.ady();
                return;
            }
            return;
        }
        if (view instanceof TabItemView) {
            this.cfF.a((TabItemView) view, false);
        }
        hVar = this.cfF.cfs;
        if (hVar != null) {
            if (!(view instanceof TabItemView) || !HorizontalTabView.iU(((TabItemView) view).getTabId())) {
                tabItemView = this.cfF.cfr;
                if (tabItemView != null) {
                    hVar2 = this.cfF.cfs;
                    tabItemView2 = this.cfF.cfr;
                    hVar2.iS(tabItemView2.getTabId());
                    return;
                }
                return;
            }
            hVar3 = this.cfF.cfs;
            hVar3.iS(((TabItemView) view).getTabId());
        }
    }
}
