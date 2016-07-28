package com.baidu.tieba.frs.tab;

import android.widget.PopupWindow;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements PopupWindow.OnDismissListener {
    final /* synthetic */ j bSH;
    private final /* synthetic */ TabItemView bSI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar, TabItemView tabItemView) {
        this.bSH = jVar;
        this.bSI = tabItemView;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        j.a aVar;
        j.a aVar2;
        aVar = this.bSH.bSt;
        if (aVar != null) {
            aVar2 = this.bSH.bSt;
            aVar2.a(this.bSI);
        }
    }
}
