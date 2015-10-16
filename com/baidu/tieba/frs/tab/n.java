package com.baidu.tieba.frs.tab;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements PopupWindow.OnDismissListener {
    final /* synthetic */ i bbB;
    private final /* synthetic */ TabItemView bbC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar, TabItemView tabItemView) {
        this.bbB = iVar;
        this.bbC = tabItemView;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.bbC.setState(TabItemView.bbu);
    }
}
