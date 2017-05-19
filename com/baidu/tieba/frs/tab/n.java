package com.baidu.tieba.frs.tab;

import android.widget.PopupWindow;
import com.baidu.tieba.frs.tab.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements PopupWindow.OnDismissListener {
    final /* synthetic */ k bZH;
    private final /* synthetic */ TabItemView bZI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar, TabItemView tabItemView) {
        this.bZH = kVar;
        this.bZI = tabItemView;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        k.a aVar;
        k.a aVar2;
        aVar = this.bZH.bZq;
        if (aVar != null) {
            aVar2 = this.bZH.bZq;
            aVar2.a(this.bZI);
        }
    }
}
