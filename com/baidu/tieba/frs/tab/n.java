package com.baidu.tieba.frs.tab;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class n implements PopupWindow.OnDismissListener {
    final /* synthetic */ i bbc;
    private final /* synthetic */ TabItemView bbd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar, TabItemView tabItemView) {
        this.bbc = iVar;
        this.bbd = tabItemView;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.bbd.setState(TabItemView.baW);
    }
}
