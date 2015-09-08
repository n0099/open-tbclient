package com.baidu.tieba.frs.tab;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class n implements PopupWindow.OnDismissListener {
    final /* synthetic */ i bbw;
    private final /* synthetic */ TabItemView bbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar, TabItemView tabItemView) {
        this.bbw = iVar;
        this.bbx = tabItemView;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.bbx.setState(TabItemView.bbq);
    }
}
