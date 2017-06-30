package com.baidu.tieba.frs.tab;

import android.widget.PopupWindow;
import com.baidu.tieba.frs.tab.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements PopupWindow.OnDismissListener {
    final /* synthetic */ k coj;
    private final /* synthetic */ TabItemView cok;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar, TabItemView tabItemView) {
        this.coj = kVar;
        this.cok = tabItemView;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        k.a aVar;
        k.a aVar2;
        aVar = this.coj.cnS;
        if (aVar != null) {
            aVar2 = this.coj.cnS;
            aVar2.a(this.cok);
        }
    }
}
