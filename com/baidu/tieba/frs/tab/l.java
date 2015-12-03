package com.baidu.tieba.frs.tab;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class l implements PopupWindow.OnDismissListener {
    final /* synthetic */ i biC;
    private final /* synthetic */ TabItemView biD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar, TabItemView tabItemView) {
        this.biC = iVar;
        this.biD = tabItemView;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.biD.setState(TabItemView.biv);
    }
}
