package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView bZt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.bZt = horizontalTabView;
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
        z = this.bZt.bZn;
        if (z) {
            if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                aVar = this.bZt.bZo;
                if (aVar != null) {
                    aVar2 = this.bZt.bZo;
                    aVar2.a(this.bZt.ir(1));
                }
                this.bZt.acu();
                return;
            }
            return;
        }
        if (view instanceof TabItemView) {
            this.bZt.a((TabItemView) view, false);
        }
        hVar = this.bZt.bZh;
        if (hVar != null) {
            if (!(view instanceof TabItemView) || !HorizontalTabView.iw(((TabItemView) view).getTabId())) {
                tabItemView = this.bZt.bZg;
                if (tabItemView != null) {
                    hVar2 = this.bZt.bZh;
                    tabItemView2 = this.bZt.bZg;
                    hVar2.iu(tabItemView2.getTabId());
                    return;
                }
                return;
            }
            hVar3 = this.bZt.bZh;
            hVar3.iu(((TabItemView) view).getTabId());
        }
    }
}
