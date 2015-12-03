package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements FragmentTabWidget.a {
    final /* synthetic */ e aQs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aQs = eVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void c(int i, boolean z) {
        FragmentTabWidget fragmentTabWidget;
        FragmentTabWidget fragmentTabWidget2;
        if (i != 0) {
            if (i != 1) {
                return;
            }
            this.aQs.fw(1);
            fragmentTabWidget = this.aQs.aQn;
            fragmentTabWidget.d(i, true);
            return;
        }
        this.aQs.fw(0);
        fragmentTabWidget2 = this.aQs.aQn;
        fragmentTabWidget2.d(i, true);
    }
}
