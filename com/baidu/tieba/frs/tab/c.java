package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView cnV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.cnV = horizontalTabView;
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
        z = this.cnV.cnO;
        if (z) {
            if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                aVar = this.cnV.cnP;
                if (aVar != null) {
                    aVar2 = this.cnV.cnP;
                    aVar2.a(this.cnV.jb(1));
                }
                this.cnV.ahq();
                return;
            }
            return;
        }
        if (view instanceof TabItemView) {
            this.cnV.a((TabItemView) view, false);
        }
        hVar = this.cnV.cnI;
        if (hVar != null) {
            if (!(view instanceof TabItemView) || !HorizontalTabView.jg(((TabItemView) view).getTabId())) {
                tabItemView = this.cnV.cnH;
                if (tabItemView != null) {
                    hVar2 = this.cnV.cnI;
                    tabItemView2 = this.cnV.cnH;
                    hVar2.je(tabItemView2.getTabId());
                    return;
                }
                return;
            }
            hVar3 = this.cnV.cnI;
            hVar3.je(((TabItemView) view).getTabId());
        }
    }
}
