package com.baidu.tieba.frs.tab;

import android.widget.PopupWindow;
import com.baidu.tieba.frs.tab.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements PopupWindow.OnDismissListener {
    final /* synthetic */ k cfT;
    private final /* synthetic */ TabItemView cfU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar, TabItemView tabItemView) {
        this.cfT = kVar;
        this.cfU = tabItemView;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        k.a aVar;
        k.a aVar2;
        aVar = this.cfT.cfC;
        if (aVar != null) {
            aVar2 = this.cfT.cfC;
            aVar2.a(this.cfU);
        }
    }
}
