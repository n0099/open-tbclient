package com.baidu.tieba.frs.tab;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements PopupWindow.OnDismissListener {
    final /* synthetic */ i bbX;
    private final /* synthetic */ TabItemView bbY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar, TabItemView tabItemView) {
        this.bbX = iVar;
        this.bbY = tabItemView;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.bbY.setState(TabItemView.bbQ);
    }
}
