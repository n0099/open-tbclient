package com.baidu.tieba.frs.tab;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements PopupWindow.OnDismissListener {
    final /* synthetic */ i bph;
    private final /* synthetic */ TabItemView bpi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar, TabItemView tabItemView) {
        this.bph = iVar;
        this.bpi = tabItemView;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.bpi.setState(TabItemView.bpa);
    }
}
