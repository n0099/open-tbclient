package com.baidu.tieba.frs.tab;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements PopupWindow.OnDismissListener {
    final /* synthetic */ i bmt;
    private final /* synthetic */ TabItemView bmu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar, TabItemView tabItemView) {
        this.bmt = iVar;
        this.bmu = tabItemView;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.bmu.setState(TabItemView.bml);
    }
}
