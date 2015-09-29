package com.baidu.tieba.frs.tab;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class n implements PopupWindow.OnDismissListener {
    final /* synthetic */ i bbq;
    private final /* synthetic */ TabItemView bbr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar, TabItemView tabItemView) {
        this.bbq = iVar;
        this.bbr = tabItemView;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.bbr.setState(TabItemView.bbj);
    }
}
